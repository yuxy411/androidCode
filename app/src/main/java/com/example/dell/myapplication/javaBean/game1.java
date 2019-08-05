package com.example.dell.myapplication.javaBean;

import org.litepal.crud.DataSupport;

/**
 * Created by DELL on 2018/8/23.
 */

public class game1 extends DataSupport {
    private int gid;  //比赛的id号
    private String gname;//比赛名称-
    private String pname;//比赛场地
    private String gtime;//比赛时间
    private String name;//比赛发起人
    private int flag=0;//显示比赛的状态
    private int number;//比赛的人数
    private int kind;//比赛的类型 ： 1篮球  2足球  3羽毛球  4乒乓球 5游泳

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getGtime() {
        return gtime;
    }

    public void setGtime(String gtime) {
        this.gtime = gtime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
