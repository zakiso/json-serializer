package me.ddzq.android.deerconvertor.sample.customserialiazer;

import me.ddzq.android.deerconvertor.sample.entity.School;
import me.ddzq.android.deerconvetor.lib.serializer.Serializer;

/**
 * Created by dzq on 15/11/25.
 *
 * implement a custom Serializer.Usage in the below.
 *
 * public class Student {
 *      @SerializeBy(SchoolSerializer.class)
 *      private School school;
 * }
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
