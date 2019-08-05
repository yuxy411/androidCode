package com.example.dell.myapplication;


import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;



import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.myapplication.fragment.PersonFragment;
import com.example.dell.myapplication.javaBean.game;
import com.example.dell.myapplication.javaBean.information;
import org.litepal.crud.DataSupport;


import java.util.ArrayList;
import java.util.List;


public class EnterActivity extends FragmentActivity {
private Button btn_enter_enter;
private Button btn_enter_login;
private TextView et_enter_user;
private TextView et_enter_psw;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enter);
		
//		//登录成功后，跳转到主页面（这里假设两秒后自动跳转）
//	    mHandler.sendEmptyMessageDelayed(GOTO_MAIN_ACTIVITY, 2000);
	    //点击登录按钮触发判断用户名和密码是否匹配方法
		//点击注册按钮触发注册事件
		et_enter_user=findViewById(R.id.et_enter_user);
		et_enter_psw=findViewById(R.id.et_enter_psw);
		btn_enter_enter=findViewById(R.id.btn_enter_enter);
		btn_enter_login=findViewById(R.id.btn_enter_login);
		btn_enter_enter.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				isEnter();
			}
		});
		btn_enter_login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				isLogin();
			}
		});

	}



	/**
	 * 判断是否登陆成功
	 * 如果登录成功，跳转到mainActivity页面,同时将登录成功的information信息保存到intent中，以便在后面的个人信息出显处显示
	 * 如果登录不成功，显示登录不成功，并依然回到该页面
	 */
	public void isEnter(){
		//1 获取用户输入的用户名和密码
		String name=et_enter_user.getText().toString();
		String psw=et_enter_psw.getText().toString();
        //首先判断用户名是否为空
		if(name.equals("")){
			Toast.makeText(EnterActivity.this,"用户名不能为空！",Toast.LENGTH_SHORT).show();
		}
		if(psw.equals("")){
			Toast.makeText(EnterActivity.this,"密码不能为空！",Toast.LENGTH_SHORT).show();
		}
		//3 高标~~~~~
		List<information> infos=DataSupport.findAll(information.class);

//		List<information> infos=new ArrayList<information>();
//		information i=new information();
//		i.setName("张三");
//		i.setPsw("123456");
//		i.setIdentity("学生");
//		i.setAge(21);
//        infos.add(i);
//		//操作数据库，将数据全部插入
////		notice1 n1=new notice1();
////		n1.setContent("紧急通知，请参加2018年7月1日下午14：00的篮球联谊赛的同学及时到场！");
////		n1.setNtime("2018-7-1");
////		n1.save();
//
//		information i1=new information();
//		i1.setName("张三");
//		i1.setPsw("123456");
//		i1.setTel("18854803389");
//		i1.setIdentity("教师");
//		i1.save();

//
//	//	game g=new game();
////		g.setGname("院间联谊赛");
////		g.setPname("北篮球场");
////		g.setGtime("2018-8- 30 14：00");
////		g.setName("张三");
////		g.save();
//
////		game g=new game();
////		g.setGname("院间足球联谊赛");
////		g.setPname("足球场一");
////		g.setGtime("2018-8- 30 16：00");
////		g.setName("李斯");
////		g.setKind(2);
////		g.setFlag(1);
////		g.save();
////
////		game g1=new game();
////		g.setGname("院间羽毛球联谊赛");
////		g.setPname("北羽毛球场");
////		g.setGtime("2018-8- 30 17：00");
////		g.setName("李斯");
////		g.setKind(3);
////		g.setFlag(1);
////		g.save();
////
////		game g2=new game();
////		g.setGname("院间乒乓球联谊赛");
////		g.setPname("乒乓球室");
////		g.setGtime("2018-8- 30 17：00");
////		g.setName("李斯");
////		g.setKind(4);
////		g.setFlag(1);
////		g.save();
//
//		PersonFragment pf=new PersonFragment();
//		Bundle bundle1=new Bundle();
//		bundle1.putInt("id",infos.get(0).getId());
//		bundle1.putString("name",infos.get(0).getName());
//		//name中有值  Toast.makeText(this,infos.get(0).getName(),Toast.LENGTH_SHORT).show();
//		bundle1.putString("tel",infos.get(0).getTel());
//		bundle1.putInt("age",infos.get(0).getAge());
//		bundle1.putString("identity",infos.get(0).getIdentity());
//		pf.setArguments(bundle1);
//		FragmentManager fm=getSupportFragmentManager();
//		FragmentTransaction ft = fm.beginTransaction();
//		ft.addToBackStack(null);
//		ft.add(R.id.fl_content, pf);
//		ft.commit();
//
		//判断是否能登录成功
		boolean flag=false;
		int p=0;
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
//		for(information info:infos) {
//		if (info.getName().equals(name) && info.getPsw().equals(psw)) {
//
//				Intent intent = new Intent(this, MainActivity.class);
//				startActivity(intent);
//
//			}
//			else{
//				p++;
//			}
//
//		}
//		 if(p==infos.size()){
//			Toast.makeText(EnterActivity.this,"用户名或者密码错误，请重新输入！",Toast.LENGTH_SHORT).show();
//			Intent intent = new Intent(this, EnterActivity.class);
//			startActivity(intent);
//		}
//		String pws2=infos.get(0).getPsw();
//		if(pws2.equals(pws)){
//			Intent intent=new Intent(this,MainActivity.class);
//			startActivity(intent);
//		}
//		else{
//			Intent intent=new Intent(this,EnterActivity.class);
//			startActivity(intent);
//		}



	}

	/**
	 * 用户注册页面
	 * 导入activity_login.xml布局，然后注册成功后跳转到登录界面
	 * 如果注册不成功，提示哪一项信息导致注册不成功
	 *
	 */
	private void isLogin() {
		Intent intent=new Intent(this,LoginActivity.class);
		startActivity(intent);
	}




}
