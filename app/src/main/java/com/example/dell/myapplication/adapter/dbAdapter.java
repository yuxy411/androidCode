package com.example.dell.myapplication.adapter;

import android.database.Cursor;
import android.widget.BaseAdapter;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by DELL on 2018/8/14.
 * 获取数据库中比赛信息返回SimpleCursorAdapter对象
 *
 */

public class dbAdapter {
    private Cursor cursor;
    private BaseAdapter baseAdapter;
    public BaseAdapter getData(){

        return baseAdapter;
    }

    public Cursor getCursor() {
        return cursor;
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }


}
