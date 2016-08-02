package me.ddzq.android.deerconvertor.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import me.ddzq.android.deerconvertor.sample.entity.Book;
import me.ddzq.android.deerconvertor.sample.entity.School;
import me.ddzq.android.deerconvertor.sample.entity.Student;
import me.ddzq.android.deerconvetor.lib.convertor.JsonDeer;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private TextView textView1;
    private TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        Student student = getStudent();

        //serialize a Student Object to json object
        JSONObject studentJson = JsonDeer.toJson(student);

        //deserialize a Student Object from json object
        Student student1 = JsonDeer.fromJson(studentJson,Student.class);

        textView1.setText("student json:" + studentJson.toString());
        textView3.setText("student bean:" + student1.toString());

    }

    private Student getStudent(){
        Student student = new Student();
        student.setName("Deer Sika");
        student.setAge(22);
        student.setId(3414326546l);
        student.setScore(99.8f);
        student.setBirthDay(new Date());

        Book book1 = new Book();
        book1.setName("java实战与编程");
        book1.setPress("四川人民出版社");
        book1.setPrice(16.5f);

        Book book2 = new Book();
        book2.setName("android开发基础");
        book2.setPress("邮电出版社");
        book2.setPrice(23.8f);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);

        student.setBooks(bookList);

        School school = new School();
        school.setName("清华大学");
        school.setProvince("北京");

        student.setSchool(school);

        hello greagreagreagrea 

        return student;
    }

    private void initView(){
        textView1 = (TextView)findViewById(R.id.text1);
        textView3 = (TextView)findViewById(R.id.text3);
    }

}
