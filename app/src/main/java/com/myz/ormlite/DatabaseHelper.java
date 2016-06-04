package com.myz.ormlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.myz.bean.User;

import java.sql.SQLException;

/**
 * Created by Administrator on 2016/6/3.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper{

    private static final String table_name="user_db";

    public DatabaseHelper(Context context) {
        super(context,table_name,null,2);
    }

    /***

     *
     * @param sqLiteDatabase
     * @param userDao 每张表对一个
     */
    private Dao<User,Integer> userDao;
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, User.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {


        try {
            TableUtils.dropTable(connectionSource,User.class,true);

            onCreate(sqLiteDatabase,connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private static DatabaseHelper instance;
    /***
     * 单例获取该helper
     * @param context
     * @return instance
     */
public static synchronized DatabaseHelper getHelper(Context context){

    if(instance==null) synchronized (DatabaseHelper.class) {

        if (instance == null) {
            instance = new DatabaseHelper(context);

        }
    }

 return  instance;

}

/**
 * @param
 *
 *
 *
 */

public Dao<User,Integer> getUserdao ()throws SQLException {

      if(userDao==null){

          userDao=getDao(User.class);

      }
    return userDao;



    }





















    /***
     * @param
     */
    @Override
    public void close(){
        super.close();
        userDao=null;

    }











}
