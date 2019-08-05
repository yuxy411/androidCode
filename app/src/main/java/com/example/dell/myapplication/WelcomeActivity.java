package com.example.dell.myapplication;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.litepal.tablemanager.Connector;

public class WelcomeActivity extends Activity {
private ProgressBar pb_welcome_loading;
private TextView tv_welcome_welcome;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//加载布局
		setContentView(R.layout.activity_welcome);

		//获取布局
		pb_welcome_loading=(ProgressBar) findViewById(R.id.pb_welcome_loading);
	    tv_welcome_welcome=(TextView) findViewById(R.id.tv_welcome_welcome);
	  
	    //两秒后自动跳转到登录注册页面    	   
	    mHandler.sendEmptyMessageDelayed(GOTO_MAIN_ACTIVITY, 2000);
	}
	
	/**
	 * 通过欢迎界面直接跳转到登录注册页面
	 */

	private static final int GOTO_MAIN_ACTIVITY = 0;
	@SuppressLint("HandlerLeak")
	private  Handler mHandler =new Handler(){
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
				case GOTO_MAIN_ACTIVITY:
					Intent intent = new Intent();
					intent.setClass(WelcomeActivity.this, EnterActivity.class);
					startActivity(intent);
					finish();
					break;

				default:
					break;
			}
		}
	};

}
/**
 * static class MyHandler extends Handler
 * {
 * //注意下面的“PopupActivity”类是MyHandler类所在的外部类，
 * 即所在的activity
 *
 * WeakReference<PopupActivity> mActivity;
 * MyHandler(PopupActivity activity)
 * {
 *   mActivity = new WeakReference<PopupActivity>(activity);
 * }
 * @Override
 * public void handleMessage(Message msg)
 * {
 * PopupActivity theActivity = mActivity.get();
 * switch (msg.what)
 * {
 *
                                                   //此处可以根据what的值处理多条信息 case 0x0001: //这里可以改变activity中的UI控件的状态
theActivity.textView.setText(R.string.hello_world);
break;
}
case 0x0002:                                      //这里可以改变activity中的UI控件的状态
theActivity.textView.setText(R.string.welcome);
break;                             这里可以有多条要处理信息的操作
} } };
//实例化一个MyHandler对象
MyHandler testHandler = new MyHandler(this);
private void test1() {
//这里发送了一个空消息，空消息的what值是0x0001
testHandler.sendEmptyMessage(0x0001);
}  private void test2() {
//这里发送了一个空消息，空消息的what值是0x0001 t
estHandler.sendEmptyMessage(0x0002); }

*/
