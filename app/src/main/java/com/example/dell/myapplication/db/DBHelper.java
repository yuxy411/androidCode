package com.example.dell.myapplication.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.dell.myapplication.RaceActivity;

/**
 * Created by DELL on 2018/8/16.
 */

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context, int version) {

        super(context, "gym.db", null, version);
      //  Log.e("TAG","create gym.db");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
      //  Log.e("TAG","create table Race");
       String sql="create table Race(rid integer ,rname varchar,pname varchar,rtime varchar)";
           sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
