package me.ddzq.android.deerconvertor.sample.entity;

import me.ddzq.android.deerconvertor.sample.customserialiazer.DateSerializer;
import me.ddzq.android.deerconvertor.sample.customserialiazer.SchoolSerializer;
import me.ddzq.android.deerconvetor.lib.annotation.CollectionInitBy;
import me.ddzq.android.deerconvetor.lib.annotation.SerializeBy;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dzq on 15/11/25.
 */
public class Student {
    private int age;
    private String name;
    private long id;
    @SerializeBy(DateSerializer.class)  //the birthDay will use your provide class serialize
    private Date birthDay;
    private float score;
    //specific a collection implement class,if not the books field will be deserialize by ArrayList
    @CollectionInitBy(LinkedList.class)
    private List<Book> books;
    @SerializeBy(SchoolSerializer.class)
    private School school;


    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

}
