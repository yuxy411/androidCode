package com.example.dell.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.dell.myapplication.javaBean.information;

import org.litepal.crud.DataSupport;

public class PersonDataActivity extends AppCompatActivity {

    private EditText et_persondata_name;
    private ImageView iv_persondata_top;
    private EditText et_persondata_tel;
    private EditText  et_persondata_age;
 //   private LinearLayout ll_persondata_sex;
    private LinearLayout ll_persondata_identity;
    private LinearLayout ll_persondata_bottom;
    private Button btn_persondata_modify;
    private Button btn_persondata_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_data);
        //获取布局控件
        iv_persondata_top=findViewById(R.id.iv_persondata_top);
        et_persondata_name=findViewById(R.id.et_persondata_name);
        et_persondata_tel=findViewById(R.id.et_persondata_tel);
        et_persondata_age=findViewById(R.id.et_persondata_age);
       // ll_persondata_sex=findViewById(R.id.ll_persondata_sex);
        ll_persondata_identity=findViewById(R.id.ll_persondata_identity);
        ll_persondata_bottom=findViewById(R.id.ll_persondata_bottom);
        btn_persondata_modify=findViewById(R.id.btn_persondata_modify);
         btn_persondata_card = findViewById(R.id.btn_persondata_card);
        //从数据库获取数据显示在个人资料页面
         getDatas();
         //设置修改资料button点击事件
        btn_persondata_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取当前用户的id号
                 ContentValues values = new ContentValues();
                 values.put("name", et_persondata_name.getText().toString());
                 values.put("tel",et_persondata_tel.getText().toString());
                 values.put("age",et_persondata_age.getText().toString());
                 values.put("identity","男");
                DataSupport.update(information.class, values, 1);  //id号的问题
            }
        });

    }

    public void getDatas() {
//获取登陆页面send的信息
        Intent intent = this.getIntent();
        Bundle bundle1 = intent.getExtras();
        String name = bundle1.getString("name");
        String tel=bundle1.getString("tel");
 //     int age=bundle1.getInt("age");
        String identity=bundle1.getString("identity");
        et_persondata_name.setText(name);
        et_persondata_tel.setText(tel);
 //     et_persondata_age.setText(age);



    }
}
