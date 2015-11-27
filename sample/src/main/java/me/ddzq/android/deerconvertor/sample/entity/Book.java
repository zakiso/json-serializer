package me.ddzq.android.deerconvertor.sample.entity;

import me.ddzq.android.deerconvetor.lib.annotation.NickName;
import me.ddzq.android.deerconvetor.lib.annotation.NotConvert;

/**
 * Created by dzq on 15/11/25.
 */
public class Book {

    //when you serialize to JsonObject the name data will be replace to bookName field;
    //when you deserialize from JsonObject the name field data will read from bookName field;
    @NickName("bookName")
    private String name;
    private float price;
    @NotConvert     //the field will not serialized
    private String press;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }


}
