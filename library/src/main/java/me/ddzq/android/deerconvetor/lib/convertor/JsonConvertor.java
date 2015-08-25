package me.ddzq.android.deerconvetor.lib.convertor;

import android.util.Log;
import me.ddzq.android.deerconvetor.lib.anno.GenericType;
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
public class JsonConvertor extends Convertor {

    public JsonConvertor() {
    }

    public static JsonConvertor build() {
        return new JsonConvertor();
    }

    public <T> Collection<T> jsonToBeanCollection(JSONArray array, T t) {
        Collection collection = new ArrayList<>();
        Type type = t.getClass();
        BasicType basicType = isBasicType(type);
        if (basicType != BasicType.OTHER_TYPE) {
            try {
                collection = setCollectionBasicValue(collection, array, type);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                collection = setCollectionCustomValue(collection, array, type);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return collection;
    }

    public <T> T jsonToBean(JSONObject jsonObject, T t) {
        t = parseEntity(jsonObject, t);
        return t;
    }

    private <T> T parseEntity(JSONObject jsonObject, T t) {
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {
            parseField(field, jsonObject, t);
        }
        return t;
    }

    private <T> void parseField(Field field, JSONObject jsonObject, T t) {
        field.setAccessible(true);
        Type fieldType = field.getType();
        Type fieldGenericType = field.getGenericType();
        String fieldName = field.getName();
        Log.d("test-fieldName", fieldName);
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
            Class c = field.getAnnotation(GenericType.class).instantiate();
            Log.d("test-class", c.toString());
            try {
                Collection collection = (Collection) c.newInstance();
                JSONArray jsonArray = jsonObject.getJSONArray(fieldName);
                if (basicType != BasicType.OTHER_TYPE) {
                    collection = setCollectionBasicValue(collection, jsonArray, genericType);
                    field.set(t, collection);
                } else {
                    //表示该字段不是基本类型的字段,为自定义类型字段
                    collection = setCollectionCustomValue(collection, jsonArray, genericType);
                    field.set(t, collection);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.d("generic-type", genericType.toString());
        }

    }

    private Collection setCollectionCustomValue(
            Collection collection, JSONArray jsonArray, Type genericType) throws JSONException {
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Object o = ((Class) genericType).cast(generateInstance(genericType));
            Log.d("test-obj", o.toString());
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
                                    Type fieldType, String fieldName) {
        try {
            JSONObject value = jsonObject.getJSONObject(fieldName);
            Object o = generateInstance(fieldType);
            o = parseEntity(value, o);
            field.set(t, o);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private <T> void setBasicValue(Field field, JSONObject jsonObject,
                                   T t, String fieldName, BasicType basicType) {
        Object value = null;
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        if (type == String.class) {
            return BasicType.STRING;
        } else {
            return BasicType.OTHER_TYPE;
        }
    }

    private enum BasicType {
        INT,
        LONG,
        BOOLEAN,
        DOUBLE,
        STRING,
        OTHER_TYPE
    }


    public <T> JSONObject beanToJson(T t) {
        JSONObject jsonObject = new JSONObject();
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field field : fields) {

        }
        return jsonObject;
    }

    private void parseFieldToJson(Field field) {

    }
}
