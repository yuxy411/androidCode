package com.example.dell.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.myapplication.javaBean.information;

public class LoginActivity extends AppCompatActivity {
private EditText et_login_user;
private EditText et_login_psw;
private EditText et_login_tel;
private EditText et_login_age;
private EditText et_login_identity;
private Button btn_login_commit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //获取login注册界面布局控件
        et_login_user= findViewById(R.id.et_login_user);
        et_login_psw= findViewById(R.id.et_login_psw);
        et_login_tel= findViewById(R.id.et_login_tel);
        et_login_age= findViewById(R.id.et_login_age);
        et_login_identity= findViewById(R.id.et_login_identity);
        btn_login_commit= findViewById(R.id.btn_login_commit);
        //设置提交的监听获取注册信息存放到数据库中
        btn_login_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveLogin();
            }
        });

    }

    private void saveLogin() {
        String name=et_login_user.getText().toString();
        String pws=et_login_psw.getText().toString();
        String tel=et_login_tel.getText().toString();
        int age=new Integer(et_login_age.getText().toString());
        String identity=et_login_identity.getText().toString();

            //2 用户名不能重复
        //for()
        information info=new information();
        info.setName(name);
        info.setPsw(pws);
        info.setTel(tel);
        info.setAge(age);
        info.setIdentity(identity);
        info.save();
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,EnterActivity.class);
        startActivity(intent);

    }
}
