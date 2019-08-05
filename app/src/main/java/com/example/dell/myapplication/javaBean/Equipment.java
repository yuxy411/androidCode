package com.example.dell.myapplication.javaBean;

import org.litepal.crud.DataSupport;

/**
 * Created by DELL on 2018/9/10.
 */

public class Equipment extends DataSupport {
    private int eid;
    private  int eicon;
    private String ename;
    private String eprice;

    public Equipment(int eid, int eicon, String ename, String eprice) {
        this.eid = eid;
        this.eicon = eicon;
        this.ename = ename;
        this.eprice = eprice;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getEicon() {
        return eicon;
    }

    public void setEicon(int eicon) {
        this.eicon = eicon;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEprice() {
        return eprice;
    }

    public void setEprice(String eprice) {
        this.eprice = eprice;
    }
}
