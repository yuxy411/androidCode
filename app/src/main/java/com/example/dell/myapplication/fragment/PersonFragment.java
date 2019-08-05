package com.example.dell.myapplication.fragment;

import com.example.dell.myapplication.R;
import com.example.dell.myapplication.RaceTotalActivity;
import com.example.dell.myapplication.SettingActivity;
import com.example.dell.myapplication.base.BaseFragment;


import android.content.Intent;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class PersonFragment extends BaseFragment {

	private ListView lv_person_list;
	private ImageView imageView;
	private TextView tv_person_word;

	@Override
	public View initView() {
		//加载一个布局文件
		View view=View.inflate(mcontext, R.layout.personalfragment,null);
		//查找一个控件
		imageView=view.findViewById(R.id.iv_person_tu);

		//从数据库中获取用户名，设置在标题用户显示框中
		tv_person_word=view.findViewById(R.id.tv_person_word);
		//获取数据库中信
		//从根据登陆信息查找显示用户信息
		String name="张三";
		String tel=null;
        if(getArguments()!=null){   //必须需要判断getArguments()是否为空
			name=getArguments().getString("name");
			tel=getArguments().getString("tel");
		}
		tv_person_word.setText(name);
		imageView.setImageDrawable(mcontext.getDrawable(R.drawable.person));

	    lv_person_list=view.findViewById(R.id.lv_person_list);

		return view;
	}
	public void initData(){
	   String[] data={"个人资料","好友列表","比赛情况","设置"};
		ArrayAdapter<String> adapter=new ArrayAdapter(mcontext,R.layout.item,data);
    //   这句话导致闪退
 	  lv_person_list.setAdapter(adapter);
		lv_person_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
				if(i==0){
					FragmentManager fm=getFragmentManager();
					FragmentTransaction ft=fm.beginTransaction();
					PersonRecFragment prf=new PersonRecFragment();
					ft.replace(R.id.fl_content,prf);
					ft.commit();

				}else if(i==1){
					FragmentManager fm=getFragmentManager();
					FragmentTransaction ft=fm.beginTransaction();
					FriendsFragment ff=new FriendsFragment();
					ft.replace(R.id.fl_content,ff);
					ft.commit();
				}else if(i==2){
					FragmentManager fm=getFragmentManager();
					FragmentTransaction ft=fm.beginTransaction();
					RacesFragment rf=new RacesFragment();
					ft.replace(R.id.fl_content,rf);
					ft.commit();
				}else{
					FragmentManager fm=getFragmentManager();
					FragmentTransaction ft=fm.beginTransaction();
					SettingFragment sf=new SettingFragment();
					ft.replace(R.id.fl_content,sf);
					ft.commit();
				}
			}
		});

	}

}
