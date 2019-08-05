package com.example.dell.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dell.myapplication.R;


/**
 * Created by dell on 2018/8/24.
 */

public class FootballGroundFragment extends Fragment {
    protected static double pricePerHour = 18;
    protected Button football_confirm,football_reset;
    protected CheckBox footballground1_pick,footballground2_pick,footballground3_pick,footballground4_pick;
    protected ImageView footballground1_state,footballground2_state,footballground3_state,footballground4_state;
    protected Bundle bundle;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*
        * 实现对于球场当前状态的监听，并设置当前状态的图片在左上方
        * */
        View view = inflater.inflate(R.layout.fragment_footballground,container,false);
        init(view);
        setListener();
        return view;
    }
    protected void init(View view){
        football_confirm = (Button)view.findViewById(R.id.football_confirm);
        football_reset = (Button)view.findViewById(R.id.football_reset);
        footballground1_pick = (CheckBox)view.findViewById(R.id.footballground1_pick);
        footballground2_pick = (CheckBox)view.findViewById(R.id.footballground2_pick);
        footballground3_pick = (CheckBox)view.findViewById(R.id.footballground3_pick);
        footballground4_pick = (CheckBox)view.findViewById(R.id.footballground4_pick);
        footballground1_state = (ImageView)view.findViewById(R.id.footballground1_state);
        footballground2_state = (ImageView)view.findViewById(R.id.footballground2_state);
        footballground3_state = (ImageView)view.findViewById(R.id.footballground3_state);
        footballground4_state = (ImageView)view.findViewById(R.id.footballground4_state);

        bundle = new Bundle();

    }
    protected void setListener(){
        Listener listener = new Listener();
        football_confirm.setOnClickListener(listener);
        football_reset.setOnClickListener(listener);
        CheckBoxListener checkBoxListener = new CheckBoxListener();
        footballground1_pick.setOnCheckedChangeListener(checkBoxListener);
        footballground2_pick.setOnCheckedChangeListener(checkBoxListener);
        footballground3_pick.setOnCheckedChangeListener(checkBoxListener);
        footballground4_pick.setOnCheckedChangeListener(checkBoxListener);
    }
    protected void resetAllGroundSelected(){
        footballground1_pick.setChecked(false);
        footballground2_pick.setChecked(false);
        footballground3_pick.setChecked(false);
        footballground4_pick.setChecked(false);

    }
    protected void setInfo(String name,int id){
        bundle.clear();
        bundle.putString("groundInfo",name);
        bundle.putInt("groundID",id);
        bundle.putDouble("pricePerHour", pricePerHour);
    }
    protected Bundle getInfo(){
        return bundle;
    }
    class Listener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.football_confirm:{
                    /*
                    * 点击“预约”按钮 打开一个窗口
                    * 窗口中包含当前的场地信息 及 预约时间 及 需要的金额
                    * 实现：实现对于复选按钮的监听，从而得到场地的信息
                    * */
                    BookingDetails nextFragment = BookingDetails.newInstance(bundle);
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.fl_content, nextFragment)
                            .commit();
                    Toast.makeText(getActivity(),"点击足球预约",Toast.LENGTH_SHORT).show();
                    break;
                }
                case R.id.football_reset:{
                    /*
                    * 更改全部的复选按钮为未选中状态
                    * */
                    resetAllGroundSelected();
                    Toast.makeText(getActivity(),"点击足球重置",Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
    }
    class CheckBoxListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked == true) {
                switch (buttonView.getId()) {
                    case R.id.footballground1_pick: {
                        resetAllGroundSelected();
                        footballground1_pick.setChecked(true);
                        setInfo("足球场场地1",R.id.footballground1_state);
                        Toast.makeText(getActivity(), "足球球场1", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.footballground2_pick: {
                        resetAllGroundSelected();
                        footballground2_pick.setChecked(true);
                        setInfo("足球场场地2",R.id.footballground2_state);
                        Toast.makeText(getActivity(), "足球球场2", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.footballground3_pick: {
                        resetAllGroundSelected();
                        footballground3_pick.setChecked(true);
                        setInfo("足球场场地3",R.id.footballground3_state);
                        Toast.makeText(getActivity(), "足球球场3", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.footballground4_pick: {
                        resetAllGroundSelected();
                        footballground4_pick.setChecked(true);
                        setInfo("足球场场地4",R.id.footballground4_state);
                        Toast.makeText(getActivity(), "足球球场4", Toast.LENGTH_SHORT).show();
                        break;
                    }


                }
            }
        }
    }
}
