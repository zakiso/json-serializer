### introduction

这是一个超轻量的json序列化工具核心就300多行代码，可以把json反序列化为一个实体bean，也可以把bean转化为json。json的解析使用android系统自带的org.json包,兼容日常json使用。主要代码只有300来行.

### useage
   
   ``` java
    // 把实体对象转换为json
    JSONObject studentJson = JsonDeer.getInstance().beanToJson(student);
    // 把json转换为实体对象
    BookStore bookStore1 = JsonDeer.getInstance().jsonToBean(bookStoreJson,BookStore.class);
   ``` ✅
  
   ``` java
    public class Student {
        private int age;
        @NotConvert             //表示该字段不需要序列化
        private String name;
        private long id;
        @SerializeBy(DateSerializer.class)  //自定义序列化规则,可以轻松的通过实现Serializer接口自定义规则
        private Date birthDay;
        private float score;
        @CollectionInitBy(LinkedList.class)     //反序列化的时候指定集合类型的具体实现类型,如果不指定,所有集合类型默认会使用ArrayList
        private List<Book> books;
        @NickName("university")   //表示序列化和反序列化时的别名,比如服务器返回的字段是university 本地字段是school
        private School school;
    }
   ```

### License
   
MIT: http://mit-license.org/