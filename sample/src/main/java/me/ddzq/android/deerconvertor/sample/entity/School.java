package me.ddzq.android.deerconvertor.sample.entity;

import me.ddzq.android.deerconvertor.sample.customserialiazer.DateSerializer;
import me.ddzq.android.deerconvetor.lib.anno.SerializeBy;

import java.util.Date;

/**
 * Created by dzq on 15/11/25.
 */
public class School {
    private String province;
    private String name;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
