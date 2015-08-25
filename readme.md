### introduction

这是一个简单的转换工具，可以把json反序列化为一个实体bean，也可以把bean转化为json。json的解析依赖于android系统自带的org.json包。还有俩个附带的功能，可以把一个bean的属性复制到另一个bean的相同字段上，还有把bean转化为map，以及map转换为bean。

### useage

1. json转化为bean
   
   ``` java
   TestBean testBean = new TestBean();
   JsonConvertor jsonConvertor = new JsonConvertor();
   testBean = jsonConvertor.jsonToBean(jsonObject, testBean);
   ```
   
   需要注意的地方是：如果Bean中的属性带有集合接口类型则需要指定它具体的事例化类,使用GenericType注解来指定实例化的类比如List，可以用ArrayList来实现，或者LinkedList，如果有集合类型一定要指定它的泛型：
   
   ✅
   
   ``` java
   public class TestBean {
   
       @GenericType(instantiate = ArrayList.class)
       private List<MomentsEntity> moments;
       private String error_msg;
       private int error_code;
       private int return_code;
       private Book book;
   }
   ```
   
   ❌
   
   ``` jav
    public class TestBean {
   	//没有用@GenericType指定具体实例化类
       private List<?> moments; //没有指定具体泛型
       private String error_msg;
       private int error_code;
       private int return_code;
       private Book book;
   }
   ```