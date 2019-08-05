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

public class BadmintonGroundFragment extends Fragment {
    protected static double pricePerHour = 12;
    protected Button badminton_confirm,badminton_reset;
    protected CheckBox badmintonground1_pick,badmintonground2_pick,badmintonground3_pick,badmintonground4_pick;
    protected ImageView badmintonground1_state,badmintonground2_state,badmintonground3_state,badmintonground4_state;
    protected Bundle bundle;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*
        * 实现对于球场当前状态的监听，并设置当前状态的图片在左上方
        * */
        View view = inflater.inflate(R.layout.fragment_badmintonground,container,false);
        init(view);
        setListener();

        return view;
    }
    protected void init(View view){
        badminton_confirm = (Button)view.findViewById(R.id.badminton_confirm);
        badminton_reset = (Button)view.findViewById(R.id.badminton_reset);
        badmintonground1_pick = (CheckBox)view.findViewById(R.id.badmintonground1_pick);
        badmintonground2_pick = (CheckBox)view.findViewById(R.id.badmintonground2_pick);
        badmintonground3_pick = (CheckBox)view.findViewById(R.id.badmintonground3_pick);
        badmintonground4_pick = (CheckBox)view.findViewById(R.id.badmintonground4_pick);
        badmintonground1_state = (ImageView)view.findViewById(R.id.badmintonground1_state);
        badmintonground2_state = (ImageView)view.findViewById(R.id.badmintonground2_state);
        badmintonground3_state = (ImageView)view.findViewById(R.id.badmintonground3_state);
        badmintonground4_state = (ImageView)view.findViewById(R.id.badmintonground4_state);

        bundle = new Bundle();

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
    protected void setListener(){
        Listener listener = new Listener();
        badminton_confirm.setOnClickListener(listener);
        badminton_reset.setOnClickListener(listener);
        CheckBoxListener checkBoxListener = new CheckBoxListener();
        badmintonground1_pick.setOnCheckedChangeListener(checkBoxListener);
        badmintonground2_pick.setOnCheckedChangeListener(checkBoxListener);
        badmintonground3_pick.setOnCheckedChangeListener(checkBoxListener);
        badmintonground4_pick.setOnCheckedChangeListener(checkBoxListener);

    }
    protected void resetAllGroundSelected(){
        badmintonground1_pick.setChecked(false);
        badmintonground2_pick.setChecked(false);
        badmintonground3_pick.setChecked(false);
        badmintonground4_pick.setChecked(false);

    }
    class Listener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.badminton_confirm:{
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
                    Toast.makeText(getActivity(),"点击羽毛球预约",Toast.LENGTH_SHORT).show();
                    break;
                }
                case R.id.badminton_reset:{
                    /*
                    * 更改全部的复选按钮为未选中状态
                    * */
                    resetAllGroundSelected();
                    Toast.makeText(getActivity(),"点击羽毛球重置",Toast.LENGTH_SHORT).show();
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
                    case R.id.badmintonground1_pick: {
                        resetAllGroundSelected();
                        badmintonground1_pick.setChecked(true);
                        setInfo("羽毛球球场场地1",R.id.badmintonground1_state);
                        Toast.makeText(getActivity(), "羽毛球场1", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.badmintonground2_pick: {
                        resetAllGroundSelected();
                        badmintonground2_pick.setChecked(true);
                        setInfo("羽毛球球场场地2",R.id.badmintonground2_state);
                        Toast.makeText(getActivity(), "羽毛球场2", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.badmintonground3_pick: {
                        resetAllGroundSelected();
                        badmintonground3_pick.setChecked(true);
                        setInfo("羽毛球球场场地3",R.id.badmintonground3_state);
                        Toast.makeText(getActivity(), "羽毛球场3", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.badmintonground4_pick: {
                        resetAllGroundSelected();
                        badmintonground4_pick.setChecked(true);
                        setInfo("羽毛球球场场地4",R.id.badmintonground4_state);
                        Toast.makeText(getActivity(), "羽毛球场4", Toast.LENGTH_SHORT).show();
                        break;
                    }


                }
            }
        }
    }
}
