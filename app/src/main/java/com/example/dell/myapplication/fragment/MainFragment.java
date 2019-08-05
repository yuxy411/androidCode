package com.example.dell.myapplication.fragment;


import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dell.myapplication.R;
import com.example.dell.myapplication.base.BaseFragment;
import com.example.dell.myapplication.javaBean.information;
import com.example.dell.myapplication.javaBean.notice1;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends BaseFragment {

	private static final String TAG =MainFragment.class.getSimpleName();
	private ListView lv_notice;

		// 重写视图
		@Override
		public View initView() {

			View view=View.inflate(mcontext, R.layout.mainfragment, null);
			lv_notice=view.findViewById(R.id.lv_notice);
			getNotice();
			return view;
		}
	private void getNotice() {

//		List<notice1> notices= DataSupport.findAll(notice1.class);
		List<notice1> notices= new ArrayList<>();
		notice1 n1=new notice1();
		n1.setNtime("2018-8-25");
		n1.setContent("由于场馆装修原因，场馆今天闭馆不对外开放，如带来不便敬请原谅！");
//		//n1.save();
//
		notice1 n2=new notice1();
		n2.setNtime("2018-7-25");
		n2.setContent("紧急通知，请参加2018年7月25日下午14：00的篮球联谊赛的同学及时到场！");
//	//	n2.save();
//
		notice1 n3=new notice1();
		n3.setNtime("2018-6-20");
		n3.setContent("通知：由于体育馆的篮球场地有院间联谊赛，今天篮球场地暂时不对外租借，如带来不便敬请原谅！");
		notices.add(n3);
//	//	n3.save();
//
		notice1 n4=new notice1();
		n4.setNtime("2018-6-1");
		n4.setContent("由于场馆卫生检查原因，场馆今天闭馆时间提前到17：00，如带来不便敬请原谅！");
//	//	n4.save();
		notices.add(n4);
//

		notice1 n5=new notice1();
		n5.setNtime("2018-3-25");
		n5.setContent("通知：体育馆现又添加了一个足球场地，请足球用户体验！");
//	//	n5.save();
		notices.add(n5);
        notices.add(n2);
		notices.add(n1);





		int length=notices.size();
        String[] data=new String[length];

        int k=0;
        while(k<length){
        	data[k]=notices.get(k).getContent()+"\n"+"                       "+notices.get(k).getNtime();
        	k++;
		}


	ArrayAdapter<String> adapter=new ArrayAdapter<String>(mcontext,R.layout.item_notice,data);
	lv_notice.setAdapter(adapter);
		Toast.makeText(mcontext, "Hi你好，登录成功！", Toast.LENGTH_SHORT).show();

	}
		
		//重写数据
		public void initData(){
			//Log.e(TAG, "其他页面数据被初始化..");
			super.initData();

		}

	}
