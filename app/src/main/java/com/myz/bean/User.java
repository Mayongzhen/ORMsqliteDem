package com.myz.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by Administrator on 2016/6/3.
 */
@DatabaseTable(tableName = "user_db")
public class User {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @DatabaseField(generatedId = true)
        private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DatabaseField(columnName = "name")
    private String name;

    public String getDesc() {
        return desc;
    }

    public User(String name,String desc) {
        this.name = name;
        this.desc=desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @DatabaseField(columnName="desc")
    private String desc;

    @Override
    public String toString() {
        return "User{" +
                "desc='" + desc + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
