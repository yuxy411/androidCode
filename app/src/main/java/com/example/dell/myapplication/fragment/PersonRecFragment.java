package com.example.dell.myapplication.fragment;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dell.myapplication.MainActivity;
import com.example.dell.myapplication.R;
import com.example.dell.myapplication.javaBean.information;

import org.litepal.crud.DataSupport;

/**
 * Created by DELL on 2018/9/11.
 * 个人资料页面
 * 显示一些个人信息
 * 可以修改一个个人信息并提交
 */

public class PersonRecFragment extends Fragment {
    private EditText et_persondata_name;
    private ImageView iv_persondata_top;
    private EditText et_persondata_tel;
    private EditText  et_persondata_age;
    //   private LinearLayout ll_persondata_sex;
    private LinearLayout ll_persondata_identity;
    private LinearLayout ll_persondata_bottom;
    private Button btn_persondata_modify;
    private Button btn_persondata_card;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        /*
        * 实现对于球场当前状态的监听，并设置当前状态的图片在左上方
        * */
        View view=View.inflate(getActivity(), R.layout.activity_person_data,null);
        //从数据库获取数据显示在个人资料页面
        //获取布局控件
        iv_persondata_top = view.findViewById(R.id.iv_persondata_top);
        et_persondata_name=view.findViewById(R.id.et_persondata_name);
        et_persondata_tel=view.findViewById(R.id.et_persondata_tel);
        et_persondata_age=view.findViewById(R.id.et_persondata_age);
        // ll_persondata_sex=findViewById(R.id.ll_persondata_sex);
        ll_persondata_identity=view.findViewById(R.id.ll_persondata_identity);
        ll_persondata_bottom=view.findViewById(R.id.ll_persondata_bottom);
        btn_persondata_modify=view.findViewById(R.id.btn_persondata_modify);
        btn_persondata_card = view.findViewById(R.id.btn_persondata_card);
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
                Toast.makeText(getActivity(),"资料修改成功",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
//                FragmentManager fm=getSupportFragmentManager();
//                FragmentTransaction ft=fm.beginTransaction();
//                PersonFragment fragment=new PersonFragment();
//                ft.replace(R.id.fl_content,fragment);
//                ft.commit();

            }
        });
        return view;
    }
    public void getDatas() {
//获取登陆页面send的信息
//        Intent intent = getActivity().getIntent();
//        Bundle bundle1 = intent.getExtras();
//        String name = bundle1.getString("name");
//        String tel=bundle1.getString("tel");
//        //     int age=bundle1.getInt("age");
//        String identity=bundle1.getString("identity");
        et_persondata_name.setText("张三");
        et_persondata_tel.setText("18854803360");
        et_persondata_age.setText("21");
        //     et_persondata_age.setText(age);



    }
}
