package com.example.dell.myapplication.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.myapplication.R;
import com.example.dell.myapplication.adapter.FriendAdapter;
import com.example.dell.myapplication.javaBean.Friend;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by DELL on 2018/9/11.
 */

public class FriendsFragment extends Fragment {
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
//    {
//        /*
//        * 实现对于球场当前状态的监听，并设置当前状态的图片在左上方
//        * */
//        View view=View.inflate(getActivity(), R.layout.activity_friends,null);
//
//        return view;
//    }
    private List<Friend> friendList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view  = inflater.inflate(R.layout.activity_friend,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        RecyclerView recyclerView = getView().findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        FriendAdapter adapter = new FriendAdapter(friendList);
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        for(int i = 0;i < 15;i ++){
            Friend friend = new Friend(R.drawable.ic_launcher_background,"test_nickname"+i,"busy");
            friendList.add(friend);
        }
    }



    public View initView() {
        return null;
    }
}
