package com.example.dell.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class BBSActivity extends AppCompatActivity {
private ListView lv_notice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbs);
//        //获取listview布局
//        lv_notice=findViewById(R.id.lv_notice);
        //从数据库notice中获取当天的公告显示首页

    }

}
