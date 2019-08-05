package com.example.dell.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.dell.myapplication.MainActivity;
import com.example.dell.myapplication.R;

/**
 * Created by DELL on 2018/9/9.
 */

public class SuccessFragment extends Fragment {
    private ImageView iv_pay;
    private Button btn_pay;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        /*
        * 实现对于球场当前状态的监听，并设置当前状态的图片在左上方
        * */
        View view=View.inflate(getActivity(), R.layout.success,null);
        iv_pay= view.findViewById(R.id.iv_pay);
        btn_pay=view.findViewById(R.id.btn_pay);
        onOperate();
        return view;
    }

    private void onOperate()
    {
                btn_pay.setOnClickListener(new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        FragmentManager fm = getActivity().getSupportFragmentManager();
                        OrderFragment orderf = new OrderFragment();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.addToBackStack(null);
                        ft.replace(R.id.fl_content, orderf);
                        ft.commit();

                    }
                });
    }
}
