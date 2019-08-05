package com.example.dell.myapplication.javaBean;

public class Friend {
    private String NickName;
    private int Heads;
    private String State;

    public Friend(int Heads,String NickName,String State){
        this.Heads = Heads;
        this.NickName = NickName;
        this.State = State;
    }

    public int getHeads(){
        return Heads;
    }

    public String getNickName() {
        return NickName;
    }


    public String getState() {
        return State;
    }
}