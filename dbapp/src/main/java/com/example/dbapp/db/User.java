package com.example.dbapp.db;

import android.provider.ContactsContract;

import org.litepal.crud.DataSupport;

/**
 * Created by DELL on 2018/8/16.
 */

public class User extends DataSupport {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
