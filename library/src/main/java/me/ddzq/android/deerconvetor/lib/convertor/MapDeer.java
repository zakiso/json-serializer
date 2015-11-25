package me.ddzq.android.deerconvetor.lib.convertor;


import me.ddzq.android.deerconvetor.lib.anno.NotConvert;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dzq on 15/8/25.
 */
public class MapDeer{


    private static MapDeer mapConvertor;

    public static MapDeer getInstance() {
        if (null != mapConvertor){
            return mapConvertor;
        }
        mapConvertor = new MapDeer();
        return mapConvertor;
    }

    /**
     * 转换bean为Map
     *
     * @param sourceBean
     * @param <T>
     * @return
     */
    public <T> Map<String, String> BeanToMap(T sourceBean) {
        Map<String, String> map = new HashMap<String, String>();
        Field[] fieldList = sourceBean.getClass().getDeclaredFields();
        for (Field field : fieldList) {
            if (!field.isAnnotationPresent(NotConvert.class)) {
                parseFieldToMap(field, sourceBean, map);
            }
        }
        return map;
    }

    private <T> void parseFieldToMap(Field field, T sourceBean, Map map) {
        field.setAccessible(true);
        try {
            Object v = field.get(sourceBean);
            if (null != v) {
                parseFieldValue(field, sourceBean, map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private <T> void parseFieldValue(Field field, T sourceBean, Map map) throws Exception{
        field.setAccessible(true);
        if (!field.isAnnotationPresent(NotConvert.class)) {
            String fieldName = field.getName();
            try {
                String value = (field.get(sourceBean)).toString();
                map.put(fieldName, value);
            } catch (Exception e) {
                String value = String.valueOf(field.get(sourceBean));
                map.put(fieldName, value);
            }
        }
    }
}
