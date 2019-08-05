package com.example.dell.myapplication.fragment;
import android.content.Intent;
import android.view.View;
import android.widget.Button;


import com.example.dell.myapplication.R;
import com.example.dell.myapplication.RaceActivity;
import com.example.dell.myapplication.base.BaseFragment;

public class CommunicationFragment extends BaseFragment
{
	private Button btn_comm_center;
	private Button btn_comm_top;
	private Button btn_comm_down;
	private Button btn_comm_left;
	private Button btn_comm_right;
   public View initView() {
   	//设置社交页面
		View view=View.inflate(mcontext,R.layout.activity_comm,null);
        //获取页面中的各个布局
	   btn_comm_center =view.findViewById(R.id.btn_comm_center);
	   btn_comm_top = view.findViewById(R.id.btn_comm_top);
	   btn_comm_down =view.findViewById(R.id.btn_comm_down);
	   btn_comm_left =view.findViewById(R.id.btn_comm_left);
	   btn_comm_right = view.findViewById(R.id.btn_comm_right);

       return view;
	}
	public void initData(){

	}



}
