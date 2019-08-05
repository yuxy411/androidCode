package com.example.dell.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.myapplication.R;
import com.example.dell.myapplication.base.BaseFragment;

/**
 * Created by DELL on 2018/9/11.
 */

public class RacesFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        /*
        * 实现对于球场当前状态的监听，并设置当前状态的图片在左上方
        * */
        View view=View.inflate(getActivity(), R.layout.activity_friends,null);

        return view;
    }
}
