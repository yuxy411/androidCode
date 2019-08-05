package com.example.dell.myapplication.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.myapplication.R;
import com.example.dell.myapplication.javaBean.Friend;

import java.util.List;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder>{

    private List<Friend> mFriendList;

    public FriendAdapter(List<Friend> friendList){
        this.mFriendList = friendList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Friend friend = mFriendList.get(position);
        holder.friendHeads.setImageResource(friend.getHeads());
        holder.friendNickname.setText(friend.getNickName());
        holder.friendState.setText(friend.getState());
    }

    @Override
    public int getItemCount() {
        return mFriendList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView friendHeads;
        TextView friendNickname;
        TextView friendState;

        public ViewHolder(View itemView) {
            super(itemView);
            friendHeads = itemView.findViewById(R.id.friend_heads);
            friendNickname = itemView.findViewById(R.id.friend_nickname);
            friendState = itemView.findViewById(R.id.friend_state);
        }

    }

}