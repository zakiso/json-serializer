package me.ddzq.android.deerconvertor.sample.customserialiazer;

import me.ddzq.android.deerconvertor.sample.entity.School;
import me.ddzq.android.deerconvetor.lib.Serializer.Serializer;
import org.json.JSONObject;

/**
 * Created by dzq on 15/11/25.
 */
public class SchoolSerializer implements Serializer<School> {
    @Override
    public String serialization(School o) {
        return o.getName();
    }
    @Override
    public School deserialization(String s) {
        School school = new School();
        school.setName(s);
        return school;
    }
}
