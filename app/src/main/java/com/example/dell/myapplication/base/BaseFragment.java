package com.example.dell.myapplication.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class   BaseFragment extends Fragment {
	public Context mcontext;
	/**
	 * oncreate回调方法
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mcontext=getActivity();
	}
	
	/**
	 * oncreateview回调方法
	 */
     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	return initView();
    	
    }
     
    //初始化视图
	public  abstract View initView();
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initData();
	}
	//初始化数据
	public void initData(){
		
	}
}
