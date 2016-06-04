package bean.bwie.com.ormsqlitedemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.myz.bean.User;
import com.myz.dao.UserDao;

import java.sql.SQLException;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends Activity {


    @ViewInject(R.id.add)
    private Button add;
    @ViewInject(R.id.add)
    private Button query;
    @ViewInject(R.id.add)
    private Button delete;
    @ViewInject(R.id.add)
    private Button update;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtils.inject(this);

    }
/***
 * 设置监听
 */
@OnClick({R.id.add, R.id.query, R.id.delete, R.id.update})
         public void OnClickWay(View v){

            UserDao   ud=new UserDao(this);
            switch (v.getId()){
             case   R.id.add:

             User user=new User("张三","好人");
             try {
                ud.add(user);
             } catch (SQLException e) {
                e.printStackTrace();
            }
                 Toast.makeText(MainActivity.this,"add", Toast.LENGTH_SHORT).show();
            break;
             case  R.id.delete:
             try {
               ud.delete(1);} catch (SQLException e) {
               e.printStackTrace();
         }
                 Toast.makeText(MainActivity.this,"delete", Toast.LENGTH_SHORT).show();
             break;
             case  R.id.update:
               try {
                   User user1=new User("李四","王五");
                   user1.setId(3);
                  ud.update(user1);                } catch (SQLException e) {                    e.printStackTrace();
                }
                 Toast.makeText(MainActivity.this,"update", Toast.LENGTH_SHORT).show();
                 break;
             case  R.id.query:

               List<User> list=ud.userList();
              Log.d("list",list.toString());

                 Toast.makeText(MainActivity.this,"query", Toast.LENGTH_SHORT).show();
                 break;




         }


        }







}
