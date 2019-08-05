package com.example.dell.myapplication.fragment;

import com.example.dell.myapplication.R;
import com.example.dell.myapplication.base.BaseFragment;

import android.support.v7.widget.PopupMenu;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class OrderFragment extends BaseFragment {
	protected Button selectOtherLocations;
	protected Button basketballground;
	protected Button footballground;
	protected Button badmintonground;
	protected Listener listener;
	protected LinearLayout select_basketball;
	protected LinearLayout select_football;
	protected LinearLayout select_badminton;
	protected LinearLayout select_all;

	@Override
	public View initView() {
		View view=View.inflate(mcontext, R.layout.fragment_appointment,null);
		init(view);
		setListener();
		return view;
	}
	protected void init(View view){
		selectOtherLocations = (Button) view.findViewById(R.id.select_other_locations);
		basketballground = (Button) view.findViewById(R.id.basketballground);
		footballground = (Button) view.findViewById(R.id.footballground);
		badmintonground = (Button) view.findViewById(R.id.badmintonground);
		select_basketball = (LinearLayout)view.findViewById(R.id.select_basketball);
		select_football = (LinearLayout)view.findViewById(R.id.select_football);
		select_badminton = (LinearLayout)view.findViewById(R.id.select_badminton);
		select_all = (LinearLayout)view.findViewById(R.id.select_all);
	}
	protected void setListener(){
		listener = new Listener();
		selectOtherLocations.setOnClickListener(listener);
		basketballground.setOnClickListener(listener);
		footballground.setOnClickListener(listener);
		badmintonground.setOnClickListener(listener);
		select_basketball.setOnClickListener(listener);
		select_football.setOnClickListener(listener);
		select_badminton.setOnClickListener(listener);
		select_all.setOnClickListener(listener);
	}
	class Listener implements View.OnClickListener{
		//相应球场之后不能偶退回到之前的界面
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
				case R.id.select_basketball:{
					getActivity().findViewById(R.id.basketballground).setVisibility(View.VISIBLE);
					getActivity().findViewById(R.id.footballground).setVisibility(View.INVISIBLE);
					getActivity().findViewById(R.id.badmintonground).setVisibility(View.INVISIBLE);
					break;
				}
				case R.id.select_football:{
					getActivity().findViewById(R.id.basketballground).setVisibility(View.INVISIBLE);
					getActivity().findViewById(R.id.footballground).setVisibility(View.VISIBLE);
					getActivity().findViewById(R.id.badmintonground).setVisibility(View.INVISIBLE);
					break;
				}
				case R.id.select_badminton:{
					getActivity().findViewById(R.id.basketballground).setVisibility(View.INVISIBLE);
					getActivity().findViewById(R.id.footballground).setVisibility(View.INVISIBLE);
					getActivity().findViewById(R.id.badmintonground).setVisibility(View.VISIBLE);
					break;
				}
				case R.id.select_all:{
					getActivity().findViewById(R.id.basketballground).setVisibility(View.VISIBLE);
					getActivity().findViewById(R.id.footballground).setVisibility(View.VISIBLE);
					getActivity().findViewById(R.id.badmintonground).setVisibility(View.VISIBLE);
					break;
				}
				case R.id.select_other_locations: {
					PopupMenu menu = new PopupMenu(getActivity(), selectOtherLocations);
					menu.getMenuInflater().inflate(R.menu.other_locations, menu.getMenu());
					menu.show();
					break;
				}
				case R.id.basketballground: {
					getActivity().getSupportFragmentManager()
							.beginTransaction()
							.addToBackStack(null)
							.replace(R.id.fl_content, new BasketballGroundFragment())
							.commit();
					break;
				}
				case R.id.footballground: {
					getActivity().getSupportFragmentManager()
							.beginTransaction()
							.addToBackStack(null)
							.replace(R.id.fl_content, new FootballGroundFragment())
							.commit();
					break;
				}
				case R.id.badmintonground: {
					getActivity().getSupportFragmentManager()
							.beginTransaction()
							.addToBackStack(null)
							.replace(R.id.fl_content, new BadmintonGroundFragment())
							.commit();
					break;
				}
			}
		}
	}

}
