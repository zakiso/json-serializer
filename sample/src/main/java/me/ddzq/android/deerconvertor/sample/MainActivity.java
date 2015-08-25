package me.ddzq.android.deerconvertor.sample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import me.ddzq.android.deerconvetor.lib.ConvertUtil;
import me.ddzq.android.deerconvetor.lib.TestBean;
import me.ddzq.android.deerconvetor.lib.convertor.JsonConvertor;
import org.json.JSONObject;


public class MainActivity extends ActionBarActivity {

    private String jsonStr = "\n" +
            "{\"moments\":[{\"moment_id\":\"55dbdc140442228b5246c6d1\",\"pos\":\"1097803\",\"label_type\":\"1\",\"content\":\"\",\"resource_type\":\"0\",\"images\":[\"9631d157186ae19f8184c755e561576f\"],\"video\":null,\"creator_id\":\"2\",\"creator_display_name\":\"hello world\",\"creator_avatar\":\"fdsafdsafds\",\"creator_role\":\"1\",\"created_at\":\"1440472082352\",\"is_owner\":\"1\",\"already_sent_gift\":\"1\",\"comments\":[],\"already_thumbup\":\"1\",\"thumbups\":[{\"thumbup_id\":\"55dbdc2b0442228b5246c6d2\",\"user_id\":\"2\",\"user_display_name\":\"hello world\",\"user_avatar\":\"url\",\"created_at\":\"1440472104892\"}]},{\"moment_id\":\"55dbdbe10442228b5246c6cf\",\"pos\":\"1097802\",\"label_type\":\"1\",\"content\":\"\",\"resource_type\":\"0\",\"images\":[\"296e7085e4451999bbb7597728dd0e10\",\"b1c769249129ded4fac53553341697f3\"],\"video\":null,\"creator_id\":\"2\",\"creator_display_name\":\"hello world\",\"creator_avatar\":\"fdsafdsafds\",\"creator_role\":\"1\",\"created_at\":\"1440472030994\",\"is_owner\":\"1\",\"already_sent_gift\":\"1\",\"comments\":[],\"already_thumbup\":\"1\",\"thumbups\":[{\"thumbup_id\":\"55dbdbf60442228b5246c6d0\",\"user_id\":\"2\",\"user_display_name\":\"hello world\",\"user_avatar\":\"url\",\"created_at\":\"1440472052090\"}]},{\"moment_id\":\"55dbdb9b0442228b5246c6cd\",\"pos\":\"1097801\",\"label_type\":\"1\",\"content\":\"\",\"resource_type\":\"0\",\"images\":[\"296e7085e4451999bbb7597728dd0e10\",\"ebb23b48f85f286a1803c1058c0e54bc\"],\"video\":null,\"creator_id\":\"2\",\"creator_display_name\":\"hello world\",\"creator_avatar\":\"fdsafdsafds\",\"creator_role\":\"1\",\"created_at\":\"1440471961300\",\"is_owner\":\"1\",\"already_sent_gift\":\"1\",\"comments\":[],\"already_thumbup\":\"1\",\"thumbups\":[{\"thumbup_id\":\"55dbdbbb0442228b5246c6ce\",\"user_id\":\"2\",\"user_display_name\":\"hello world\",\"user_avatar\":\"url\",\"created_at\":\"1440471992763\"}]},{\"moment_id\":\"55dbdb600442228b5246c6cb\",\"pos\":\"1097800\",\"label_type\":\"1\",\"content\":\"\",\"resource_type\":\"0\",\"images\":[\"296e7085e4451999bbb7597728dd0e10\",\"b1c769249129ded4fac53553341697f3\"],\"video\":null,\"creator_id\":\"2\",\"creator_display_name\":\"hello world\",\"creator_avatar\":\"fdsafdsafds\",\"creator_role\":\"1\",\"created_at\":\"1440471902002\",\"is_owner\":\"1\",\"already_sent_gift\":\"1\",\"comments\":[],\"already_thumbup\":\"1\",\"thumbups\":[{\"thumbup_id\":\"55dbdb750442228b5246c6cc\",\"user_id\":\"2\",\"user_display_name\":\"hello world\",\"user_avatar\":\"url\",\"created_at\":\"1440471923291\"}]},{\"moment_id\":\"55dbdb080442228b5246c6c9\",\"pos\":\"1097799\",\"label_type\":\"1\",\"content\":\"\",\"resource_type\":\"0\",\"images\":[\"296e7085e4451999bbb7597728dd0e10\",\"b1c769249129ded4fac53553341697f3\"],\"video\":null,\"creator_id\":\"2\",\"creator_display_name\":\"hello world\",\"creator_avatar\":\"fdsafdsafds\",\"creator_role\":\"1\",\"created_at\":\"1440471813807\",\"is_owner\":\"1\",\"already_sent_gift\":\"1\",\"comments\":[],\"already_thumbup\":\"1\",\"thumbups\":[{\"thumbup_id\":\"55dbdb1f0442228b5246c6ca\",\"user_id\":\"2\",\"user_display_name\":\"hello world\",\"user_avatar\":\"url\",\"created_at\":\"1440471836690\"}]},{\"moment_id\":\"55dbd9b80442228b5246c6c6\",\"pos\":\"1097798\",\"label_type\":\"1\",\"content\":\"\",\"resource_type\":\"0\",\"images\":[\"f9dd6de5ef6410972a660e89505f423c\",\"cf3eeb1da5813d6a7cdc36be45d9bb50\"],\"video\":null,\"creator_id\":\"2\",\"creator_display_name\":\"hello world\",\"creator_avatar\":\"fdsafdsafds\",\"creator_role\":\"1\",\"created_at\":\"1440471478059\",\"is_owner\":\"1\",\"already_sent_gift\":\"1\",\"comments\":[],\"already_thumbup\":\"1\",\"thumbups\":[{\"thumbup_id\":\"55dbd9c50442228b5246c6c7\",\"user_id\":\"2\",\"user_display_name\":\"hello world\",\"user_avatar\":\"url\",\"created_at\":\"1440471490773\"}]},{\"moment_id\":\"55dbd8610442228b5246c6c4\",\"pos\":\"1097797\",\"label_type\":\"0\",\"content\":\"发挥很好\",\"resource_type\":\"0\",\"images\":[\"e8918b3c7452ae6afd9247f702166a0e\",\"a90b56961f6ceb26bba14e26d68fdbcc\"],\"video\":null,\"creator_id\":\"1\",\"creator_display_name\":\"abc\",\"creator_avatar\":\"abc\",\"creator_role\":\"0\",\"created_at\":\"1440471134778\",\"is_owner\":\"0\",\"already_sent_gift\":\"1\",\"comments\":[],\"already_thumbup\":\"1\",\"thumbups\":[{\"thumbup_id\":\"55dbd96f0442228b5246c6c5\",\"user_id\":\"2\",\"user_display_name\":\"abc\",\"user_avatar\":\"url\",\"created_at\":\"1440471405026\"}]},{\"moment_id\":\"55dbd7c00442228b5246c6c3\",\"pos\":\"1097796\",\"label_type\":\"0\",\"content\":\"风格化\",\"resource_type\":\"0\",\"images\":[\"a90b56961f6ceb26bba14e26d68fdbcc\",\"6b34f46567bf7a6d92d6e01131eb9170\"],\"video\":null,\"creator_id\":\"1\",\"creator_display_name\":\"abc\",\"creator_avatar\":\"abc\",\"creator_role\":\"0\",\"created_at\":\"1440470974415\",\"is_owner\":\"0\",\"already_sent_gift\":\"1\",\"comments\":[],\"already_thumbup\":\"1\",\"thumbups\":[{\"thumbup_id\":\"55dbf1690442228b5246c6d3\",\"user_id\":\"2\",\"user_display_name\":\"abc\",\"user_avatar\":\"url\",\"created_at\":\"1440477542563\"}]},{\"moment_id\":\"55dbd7c00442228b5246c6c3\",\"pos\":\"1097796\",\"label_type\":\"0\",\"content\":\"风格化\",\"resource_type\":\"0\",\"images\":[\"a90b56961f6ceb26bba14e26d68fdbcc\",\"6b34f46567bf7a6d92d6e01131eb9170\"],\"video\":null,\"creator_id\":\"1\",\"creator_display_name\":\"abc\",\"creator_avatar\":\"abc\",\"creator_role\":\"0\",\"created_at\":\"1440470974415\",\"is_owner\":\"0\",\"already_sent_gift\":\"1\",\"comments\":[],\"already_thumbup\":\"1\",\"thumbups\":[{\"thumbup_id\":\"55dbf1690442228b5246c6d3\",\"user_id\":\"2\",\"user_display_name\":\"abc\",\"user_avatar\":\"url\",\"created_at\":\"1440477542563\"}]},{\"moment_id\":\"55dbd78d0442228b5246c6c2\",\"pos\":\"1097795\",\"label_type\":\"0\",\"content\":\"法国哈哈\",\"resource_type\":\"0\",\"images\":[\"863936c063af5553300ee67100720350\",\"a90b56961f6ceb26bba14e26d68fdbcc\",\"6b34f46567bf7a6d92d6e01131eb9170\",\"e8918b3c7452ae6afd9247f702166a0e\"],\"video\":null,\"creator_id\":\"1\",\"creator_display_name\":\"abc\",\"creator_avatar\":\"abc\",\"creator_role\":\"0\",\"created_at\":\"1440470923019\",\"is_owner\":\"0\",\"already_sent_gift\":\"1\",\"comments\":[],\"already_thumbup\":\"0\",\"thumbups\":[]}],\"return_code\":0,\"error_msg\":\"\",\"error_code\":0}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            JSONObject jsonObject = new JSONObject(jsonStr);
            ConvertUtil convertUtil = new ConvertUtil();
            TestBean testBean = new TestBean();
            long startTime = System.currentTimeMillis();

            JsonConvertor jsonConvertor = JsonConvertor.build();
            testBean = jsonConvertor.jsonToBean(jsonObject, testBean);

            long endTime = System.currentTimeMillis();
            Log.d("ttttttt", "time:" + (endTime - startTime) + ","
                    + testBean.toString());
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("ttttttt", "eeeeeeeeee");
        }

//        Field[] fields = TestBean.class.getDeclaredFields();
//        for (Field field : fields) {
//            Log.d("test-", field.toString());
//            Type fieldType = field.getType();
//            Log.d("test-type",fieldType.toString());
//            Type fieldGenericType = field.getGenericType();
//            Log.d("test-generic",fieldGenericType.toString());
//            if (fieldType == fieldGenericType) {
//                String fieldName = field.getName();
//            }
//        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
