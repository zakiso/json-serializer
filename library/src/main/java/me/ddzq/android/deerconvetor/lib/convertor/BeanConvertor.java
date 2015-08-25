package me.ddzq.android.deerconvetor.lib.convertor;

import me.ddzq.android.deerconvetor.lib.anno.NotConvert;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by dzq on 15/8/25.
 */
public class BeanConvertor {

    public <R, D> D toAnotherBean(R sourceBean, D destination) {

        Field[] fieldList = sourceBean.getClass().getDeclaredFields();
        for (Field field : fieldList) {
            parseField(field, sourceBean, destination);
        }
        return destination;
    }

    private <R, D> void parseField(Field field, R sourceBean, D destination) {
        if (!field.isAnnotationPresent(NotConvert.class)) {
            String fieldName = field.getName();
            String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            try {
                setData(methodName, fieldName, sourceBean, destination);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private <R, D> void setData(String methodName, String fieldName,
                                R sourceBean, D destination) throws Exception {
        Method method = sourceBean.getClass().getMethod(methodName, new Class<?>[]{});
        Type returnType = method.getReturnType();
        String data = null;
        if (returnType instanceof Date) {
            data = String.valueOf(((Date) method.invoke(sourceBean, new Object[]{})).getTime());
        } else {
            data = String.valueOf(method.invoke(sourceBean, new Object[]{}));
        }
        if (data != null) {
            Field targetField = destination.getClass().getDeclaredField(fieldName);
            targetField.setAccessible(true);
            Type targetType = targetField.getType();
            System.out.println(targetType.toString());
            if (targetType instanceof Date) {
                targetField.set(destination, new Date(Integer.parseInt(data)));
            } else if (targetType instanceof Map) {
                JSONObject jsonObject = new JSONObject(data);
                Map map = new HashMap<String, String>();
                Iterator iterator = jsonObject.keys();
                while (iterator.hasNext()) {
                    String key = iterator.next().toString();
                    String value = jsonObject.getString(key);
                    map.put(key, value);
                }
                targetField.set(destination, map);
            } else if (targetType instanceof List) {
                List list = new ArrayList<String>();
                JSONArray jsonArray = new JSONArray(data);
                for (int i = 0; i < jsonArray.length(); i++) {
                    list.add(jsonArray.get(i).toString());
                }
                targetField.set(destination, list);
            } else if (targetType == returnType) {
                targetField.set(destination, method.invoke(sourceBean, new Object[]{}));
            } else {
                targetField.set(destination, data.toString());
            }
        }
    }
}
