package me.ddzq.android.deerconvertor.sample.customserialiazer;

import me.ddzq.android.deerconvetor.lib.serializer.Serializer;

import java.util.Date;

/**
 * Created by dzq on 15/9/8.
 */
public class DateSerializer implements Serializer<Date> {
    @Override
    public String serialization(Date o) {
        return o.getTime() + "";
    }

    @Override
    public Date deserialization(String s) {
        return new Date(Long.parseLong(s));
    }
}
