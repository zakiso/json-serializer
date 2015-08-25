package me.ddzq.android.deerconvetor.lib.convertor;

import me.ddzq.android.deerconvetor.lib.anno.NotConvert;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dzq on 15/8/25.
 */
public class MapConvertor {

    public static <T> Map<String, String> beanToMap(T sourceBean) {
        Map<String, String> map = new HashMap<String, String>();
        Field[] fieldList = sourceBean.getClass().getDeclaredFields();
        for (Field field : fieldList) {
        }
        System.out.println(map.toString());
        return map;
    }

    private <T> void parseField(Field field, T sourceBean, Map map) {
        if (!field.isAnnotationPresent(NotConvert.class)) {
            String key = field.getName();
            String methodName = "get" + key.substring(0, 1).toUpperCase() + key.substring(1);
            try {
                Method method = sourceBean.getClass().getMethod(methodName, new Class<?>[]{});
                try {
                    String value = (method.invoke(sourceBean, new Object[]{})).toString();
                    map.put(key, value);
                } catch (Exception e) {
                    String value = String.valueOf(method.invoke(sourceBean, new Object[]{}));
                    map.put(key, value);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
