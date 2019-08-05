package com.example.dell.myapplication.javaBean;

import org.litepal.crud.DataSupport;

/**
 * Created by DELL on 2018/8/24.
 */

public class notice1 extends DataSupport {
    private int nid;
    private String content;
    private String  ntime;

    //insert into notice1(content,ntime) values("由于暑期放假问题，体育馆更改开馆闭馆时间，如有不便请谅解！","2018-7-16");
    //insert into notice1(content,ntime) values("紧急通知，请参加2018年7月1日下午14：00的篮球联谊赛的同学及时到场","2018-7-1");

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNtime() {
        return ntime;
    }

    public void setNtime(String ntime) {
        this.ntime = ntime;
    }

}
