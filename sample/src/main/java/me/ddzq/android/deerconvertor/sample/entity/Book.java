package me.ddzq.android.deerconvertor.sample.entity;

import me.ddzq.android.deerconvetor.lib.anno.NickName;
import me.ddzq.android.deerconvetor.lib.anno.NotConvert;

/**
 * Created by dzq on 15/11/25.
 */
public class Book {
    @NickName("bookName")
    private String name;
    private float price;
    @NotConvert
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
