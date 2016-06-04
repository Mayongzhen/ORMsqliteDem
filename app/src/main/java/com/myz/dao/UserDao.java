package com.myz.dao;

import android.content.Context;

import com.myz.bean.User;
import com.myz.ormlite.DatabaseHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/3.
 */
public class UserDao {

    private Context context;

    public UserDao(Context context) {
        this.context=context;
    }

    /**
     *
     * 添加用户
     */
    public void add(User user) throws SQLException{

        DatabaseHelper.getHelper(context).getUserdao().create(user);


    }

/**
 * 删除用户
 *
 */
    public  void delete(int id) throws SQLException{
        DatabaseHelper.getHelper(context).getUserdao().deleteById(id);


}
    /***
     * 修改用户
     */
public void update(User user) throws SQLException{
    DatabaseHelper.getHelper(context).getUserdao().update(user);

}

/***
 * 查询用户
 */

public List<User> userList() {
        List<User> userList=new ArrayList<User>();

        try {
            userList=DatabaseHelper.getHelper(context).getUserdao().queryForAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;

    }



}
