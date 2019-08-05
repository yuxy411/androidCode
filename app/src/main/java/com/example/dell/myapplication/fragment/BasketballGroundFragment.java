package com.example.dell.myapplication.fragment;

import android.media.Image;
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
import com.example.dell.myapplication.base.BaseFragment;


/**
 * Created by dell on 2018/8/24.
 */

public class BasketballGroundFragment extends BaseFragment {
    protected static double pricePerHour = 6;
    protected Button basketball_confirm,basketball_reset;
    protected CheckBox basketballground1up_pick,basketballground2up_pick,basketballground3up_pick,basketballground4up_pick;
    protected CheckBox basketballground1down_pick,basketballground2down_pick,basketballground3down_pick,basketballground4down_pick;
    protected ImageView basketballground1up_state,basketballground2up_state,basketballground3up_state,basketballground4up_state;
    protected ImageView basketballground1down_state,basketballground2down_state,basketballground3down_state,basketballground4down_state;
    protected Bundle bundle;
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        /*
//        * 实现对于球场当前状态的监听，并设置当前状态的图片在左上方
//        * */
//        View view = inflater.inflate(R.layout.fragment_basketballground,container,false);
//        init(view);
//        setListener();
//        return view;
//    }
    public View initView() {
        View view=View.inflate(mcontext, R.layout.fragment_basketballground,null);
        init(view);
        setListener();
        return view;
    }

    protected void init(View view){
        basketball_confirm = view.findViewById(R.id.basketball_confirm);
        basketball_reset = view.findViewById(R.id.basketball_reset);
        basketballground1up_pick = view.findViewById(R.id.basketballground1up_pick);
        basketballground2up_pick = view.findViewById(R.id.basketballground2up_pick);
        basketballground3up_pick = view.findViewById(R.id.basketballground3up_pick);
        basketballground4up_pick = view.findViewById(R.id.basketballground4up_pick);
        basketballground1down_pick = (CheckBox)view.findViewById(R.id.basketballground1down_pick);
        basketballground2down_pick = (CheckBox)view.findViewById(R.id.basketballground2down_pick);
        basketballground3down_pick = (CheckBox)view.findViewById(R.id.basketballground3down_pick);
        basketballground4down_pick = (CheckBox)view.findViewById(R.id.basketballground4down_pick);
        basketballground1up_state = view.findViewById(R.id.basketballground1up_state);
        basketballground2up_state = view.findViewById(R.id.basketballground2up_state);
        basketballground3up_state = view.findViewById(R.id.basketballground3up_state);
        basketballground4up_state = view.findViewById(R.id.basketballground4up_state);
        basketballground1down_state = view.findViewById(R.id.basketballground1down_state);
        basketballground2down_state =view.findViewById(R.id.basketballground2down_state);
        basketballground3down_state = view.findViewById(R.id.basketballground3down_state);
        basketballground4down_state = view.findViewById(R.id.basketballground4down_state);

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
        basketball_confirm.setOnClickListener(listener);
        basketball_reset.setOnClickListener(listener);
        CheckBoxListener checkBoxListener = new CheckBoxListener();
        basketballground1up_pick.setOnCheckedChangeListener(checkBoxListener);
        basketballground2up_pick.setOnCheckedChangeListener(checkBoxListener);
        basketballground3up_pick.setOnCheckedChangeListener(checkBoxListener);
        basketballground4up_pick.setOnCheckedChangeListener(checkBoxListener);
        basketballground1down_pick.setOnCheckedChangeListener(checkBoxListener);
        basketballground2down_pick.setOnCheckedChangeListener(checkBoxListener);
        basketballground3down_pick.setOnCheckedChangeListener(checkBoxListener);
        basketballground4down_pick.setOnCheckedChangeListener(checkBoxListener);

    }
    protected void resetAllGroundSelected(){
        basketballground1up_pick.setChecked(false);
        basketballground2up_pick.setChecked(false);
        basketballground3up_pick.setChecked(false);
        basketballground4up_pick.setChecked(false);
        basketballground1down_pick.setChecked(false);
        basketballground2down_pick.setChecked(false);
        basketballground3down_pick.setChecked(false);
        basketballground4down_pick.setChecked(false);
    }

    class Listener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.basketball_confirm:{
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
                    Toast.makeText(getActivity(),"点击篮球预约",Toast.LENGTH_SHORT).show();
                    break;
                }
                case R.id.basketball_reset:{
                    /*
                    * 更改全部的复选按钮为未选中状态
                    * */
                    resetAllGroundSelected();
                    Toast.makeText(getActivity(),"点击篮球重置",Toast.LENGTH_SHORT).show();
                    break;
                }
            }
        }
    }
    class CheckBoxListener implements CompoundButton.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked==true) {
                switch (buttonView.getId()) {
                    case R.id.basketballground1up_pick: {
                        resetAllGroundSelected();
                        basketballground1up_pick.setChecked(true);
                        setInfo("篮球场场地1上半场",R.id.basketballground1up_state);
                        Toast.makeText(getActivity(), "篮球场1上", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.basketballground1down_pick: {
                        resetAllGroundSelected();
                        basketballground1down_pick.setChecked(true);
                        setInfo("篮球场场地1下半场",R.id.basketballground1down_state);
                        Toast.makeText(getActivity(), "篮球场1下", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.basketballground2up_pick: {
                        resetAllGroundSelected();
                        basketballground2up_pick.setChecked(true);
                        setInfo("篮球场场地2上半场",R.id.basketballground2up_state);
                        Toast.makeText(getActivity(), "篮球场2上", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.basketballground2down_pick: {
                        resetAllGroundSelected();
                        basketballground2down_pick.setChecked(true);
                        setInfo("篮球场场地2下半场",R.id.basketballground2down_state);
                        Toast.makeText(getActivity(), "篮球场2下", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.basketballground3up_pick: {
                        resetAllGroundSelected();
                        basketballground3up_pick.setChecked(true);
                        setInfo("篮球场场地3上半场",R.id.basketballground3up_state);
                        Toast.makeText(getActivity(), "篮球场3上", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.basketballground3down_pick: {
                        resetAllGroundSelected();
                        basketballground3down_pick.setChecked(true);
                        setInfo("篮球场场地3下半场",R.id.basketballground3down_state);
                        Toast.makeText(getActivity(), "篮球场3下", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.basketballground4up_pick: {
                        resetAllGroundSelected();
                        basketballground4up_pick.setChecked(true);
                        setInfo("篮球场场地4上半场",R.id.basketballground4up_state);
                        Toast.makeText(getActivity(), "篮球场4上", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.basketballground4down_pick: {
                        resetAllGroundSelected();
                        basketballground4down_pick.setChecked(true);
                        setInfo("篮球场场地4下半场",R.id.basketballground4down_state);
                        Toast.makeText(getActivity(), "篮球场4下", Toast.LENGTH_SHORT).show();
                        break;
                    }

                }
            }
        }
    }

}
