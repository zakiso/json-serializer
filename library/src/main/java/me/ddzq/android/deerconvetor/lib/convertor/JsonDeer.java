package me.ddzq.android.deerconvetor.lib.convertor;

import me.ddzq.android.deerconvetor.lib.serializer.Serializer;
import me.ddzq.android.deerconvetor.lib.annotation.CollectionInitBy;
import me.ddzq.android.deerconvetor.lib.annotation.NickName;
import me.ddzq.android.deerconvetor.lib.annotation.NotConvert;
import me.ddzq.android.deerconvetor.lib.annotation.SerializeBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by dzq on 15/8/25.
 */
public class JsonDeer {

    private static JsonDeer jsonConvertor;

    private static JsonDeer getInstance() {
        if (null != jsonConvertor) {
            return jsonConvertor;
        }
        jsonConvertor = new JsonDeer();
        return jsonConvertor;
    }

    /**
     * 把json转换为java Bean
     *
     * @param jsonObject
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T fromJson(JSONObject jsonObject, Class type) {
        return JsonDeer.getInstance().jsonToBean(jsonObject, type);
    }

    /**
     * 把JsonArray转换为java Bean
     *
     * @param array  需要转换的Array
     * @param type   class类
     * @param <T>
     * @return
     */
    public static <T> Collection<T> fromJsonArray(JSONArray array, Class type) {
        return JsonDeer.getInstance().jsonArrayToBeanList(array,type);
    }

    /**
     * 把一个实体bean转换为json
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> JSONObject toJson(T t){
        return JsonDeer.getInstance().beanToJson(t);
    }


    private <T> T jsonToBean(JSONObject jsonObject, Class type) {
        T t = null;
        try {
            t = (T) type.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null != t) {
            t = parseEntity(jsonObject, t);
            return t;
        }
        return null;
    }

    private <T> Collection<T> jsonArrayToBeanList(JSONArray array, Class type) {
        Collection collection = new ArrayList<>();
        BasicType basicType = isBasicType(type);
        try {
            if (basicType != BasicType.OTHER_TYPE) {
                collection = setCollectionBasicValue(collection, array, type);
            } else {
                collection = setCollectionCustomValue(collection, array, type);
            }
        } catch (Exception e) {
        }
        return collection;
    }

    private <T> JSONObject beanToJson(T t) {
        JSONObject jsonObject = new JSONObject();
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(NotConvert.class)) {
                continue;
            }
            field.setAccessible(true);
            String name = field.getName();
            if (field.isAnnotationPresent(NickName.class)) {
                name = field.getAnnotation(NickName.class).value();
            }
            try {
                Object value = parseFieldValue(field, t);
                if (null == value || value.equals("null")) {
                    jsonObject.put(name, "");
                } else {
                    jsonObject.put(name, value);
                }
            } catch (Exception e) {
            }
        }
        return jsonObject;
    }


    private <T> T parseEntity(JSONObject jsonObject, T t) {
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAnnotationPresent(NotConvert.class)) {
                parseField(field, jsonObject, t);
            }
        }
        return t;
    }

    private <T> void parseField(Field field, JSONObject jsonObject, T t) {
        field.setAccessible(true);
        Type fieldType = field.getType();
        Type fieldGenericType = field.getGenericType();
        String fieldName = field.getName();
        if (field.isAnnotationPresent(NickName.class)) {
            fieldName = field.getAnnotation(NickName.class).value();
        }
        try {
            if (field.isAnnotationPresent(SerializeBy.class)) {
                Class s = field.getAnnotation(SerializeBy.class).value();
                Serializer serializer = (Serializer) s.newInstance();
                field.set(t, serializer.deserialization(jsonObject.getString(fieldName)));
                return;
            }
            //Log.d("test-fieldName", fieldName);
            //如果fieldType和fieldGenericType类型相同,表示非容器类型
            if (fieldType == fieldGenericType) {
                BasicType basicType = isBasicType(fieldType);
                if (basicType != BasicType.OTHER_TYPE) {
                    setBasicValue(field, jsonObject, t, fieldName, basicType);
                } else {
                    //表示该字段不是基本类型的字段,为自定义类型字段
                    setCustomValue(field, jsonObject, t, fieldType, fieldName);
                }
            } else {
                //表示有集合且集合有泛型
                ParameterizedType integerListType = (ParameterizedType) fieldGenericType;
                Type genericType = integerListType.getActualTypeArguments()[0];
                //判断泛型是否为基本类型
                BasicType basicType = isBasicType(genericType);
                //是基本类型则直接向容器中添加信息,若不是基本类型继续使用parseEntity
                Collection collection = null;
                if (field.isAnnotationPresent(CollectionInitBy.class)) {
                    Class c = field.getAnnotation(CollectionInitBy.class).value();
                    collection = (Collection) c.newInstance();
                }
                if (collection == null){
                    collection = new ArrayList();
                }
                JSONArray jsonArray = jsonObject.getJSONArray(fieldName);
                if (basicType != BasicType.OTHER_TYPE) {
                    collection = setCollectionBasicValue(collection, jsonArray, genericType);
                    field.set(t, collection);
                } else {
                    //表示该字段不是基本类型的字段,为自定义类型字段
                    collection = setCollectionCustomValue(collection, jsonArray, genericType);
                    field.set(t, collection);
                }
            }
        } catch (Exception e) {
            if (e instanceof InstantiationException) {
                throw new RuntimeException(new Exception("@CollectionInitBy must specific a collection implementation subclass "));
            }
        }

    }

    private Collection setCollectionCustomValue(
            Collection collection, JSONArray jsonArray, Type genericType) throws JSONException {
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Object o = ((Class) genericType).cast(generateInstance(genericType));
            o = parseEntity(jsonObject, o);
            collection.add(o);
        }
        return collection;
    }

    private Collection setCollectionBasicValue(
            Collection collection, JSONArray jsonArray, Type genericType) throws JSONException {
        for (int i = 0; i < jsonArray.length(); i++) {
            collection.add(((Class) genericType).cast(jsonArray.get(i)));
        }
        return collection;
    }

    private <T> void setCustomValue(Field field, JSONObject jsonObject, T t,
                                    Type fieldType, String fieldName) throws Exception {
        JSONObject value = jsonObject.getJSONObject(fieldName);
        Object o = generateInstance(fieldType);
        o = parseEntity(value, o);
        field.set(t, o);
    }

    private <T> void setBasicValue(Field field, JSONObject jsonObject,
                                   T t, String fieldName, BasicType basicType) throws Exception {
        Object value = null;
        switch (basicType) {
            case INT:
                value = jsonObject.getInt(fieldName);
                break;
            case LONG:
                value = jsonObject.getLong(fieldName);
                break;
            case DOUBLE:
                value = jsonObject.getDouble(fieldName);
                break;
            case FLOAT:
                value = (float) jsonObject.getDouble(fieldName);
                break;
            case BOOLEAN:
                value = jsonObject.getBoolean(fieldName);
                break;
            case STRING:
                value = jsonObject.getString(fieldName);
                break;
            default:
                value = field.getType()
                        .cast(jsonObject.get(fieldName));
        }
        field.set(t, value);

    }

    //利用type生成对应的实体
    private Object generateInstance(Type type) {
        Class<?> genericsType = null;
        try {
            genericsType = Class.forName(getClassName(type));
            Object o = genericsType.newInstance();
            return o;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    static String CLASS_PREFIX = "class ";
    static String INTERFACE_PREFIX = "interface ";

    private static String getClassName(Type type) {
        String fullName = type.toString();
        if (fullName.startsWith(CLASS_PREFIX))
            return fullName.substring(CLASS_PREFIX.length());
        if (fullName.startsWith(INTERFACE_PREFIX))
            return fullName.substring(INTERFACE_PREFIX.length());
        return fullName;
    }

    private BasicType isBasicType(Type type) {
        if (type == int.class || type == Integer.class) {
            return BasicType.INT;
        }
        if (type == long.class || type == Long.class) {
            return BasicType.LONG;
        }
        if (type == boolean.class || type == Boolean.class) {
            return BasicType.BOOLEAN;
        }
        if (type == double.class || type == Double.class) {
            return BasicType.DOUBLE;
        }
        if (type == float.class || type == Float.class) {
            return BasicType.FLOAT;
        }
        if (type == String.class) {
            return BasicType.STRING;
        } else {
            return BasicType.OTHER_TYPE;
        }
    }

    private enum BasicType {
        INT, LONG, BOOLEAN, DOUBLE,
        FLOAT, STRING, OTHER_TYPE
    }

    private <T> Object parseFieldValue(Field field, T t) throws Exception {
        if (field.isAnnotationPresent(SerializeBy.class)) {
            Class s = field.getAnnotation(SerializeBy.class).value();
            Serializer serializer = (Serializer) s.newInstance();
            return serializer.serialization(field.get(t));
        }
        Type fieldType = field.getType();
        Type fieldGenericType = field.getGenericType();
        //如果fieldType和fieldGenericType类型相同,表示非容器类型
        if (fieldType == fieldGenericType) {
            BasicType basicType = isBasicType(fieldType);
            //如果类型为基本类型
            if (basicType != BasicType.OTHER_TYPE) {
                return field.get(t);
            } else {
                //类型不为基本类型且不是容器类型
                return beanToJson(field.get(t));
            }
        } else {
            //类型为容器类型,且容器必须制定了其泛型
            //表示有集合且集合有泛型
            ParameterizedType integerListType = (ParameterizedType) fieldGenericType;
            Type genericType = integerListType.getActualTypeArguments()[0];
            //判断泛型是否为基本类型
            BasicType basicType = isBasicType(genericType);
            //是基本类型则直接向容器中添加信息,若不是基本类型继续使用parseEntity
            JSONArray jsonArray = new JSONArray();
            if (basicType != BasicType.OTHER_TYPE) {
                List o = (List) field.get(t);
                for (int i = 0; i < o.size(); i++) {
                    jsonArray.put(o.get(i));
                }
            } else {
                List o = (List) field.get(t);
                for (int i = 0; i < o.size(); i++) {
                    jsonArray.put(beanToJson(o.get(i)));
                }
            }
            return jsonArray;
        }
    }

}
