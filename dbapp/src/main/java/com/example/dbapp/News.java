package com.example.dbapp;

import org.litepal.crud.DataSupport;


import java.sql.Date;

/**
 * Created by DELL on 2018/8/20.
 */

public class News extends DataSupport {
   // @id(column = "id")

    private int id;
    private String title;
    private String content;
    private Date publishData;
    private int commentCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishData() {
        return publishData;
    }

    public void setPublishData(Date publishData) {
        this.publishData = publishData;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
}
