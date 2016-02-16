package com.amayadream.bookstore.pojo;

import org.springframework.stereotype.Repository;

/**
 * 阅读历史实体
 * @author :  Amayadream
 * @date :  2016.02.16 20:53
 */
@Repository
public class History {
    public String id;       //编号
    public String userid;   //用户名
    public String bookid;   //图书编号
    public String firsttime;//初次阅读时间
    public String lasttime; //最后阅读时间
    public String until;    //阅读至

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getFirsttime() {
        return firsttime;
    }

    public void setFirsttime(String firsttime) {
        this.firsttime = firsttime;
    }

    public String getLasttime() {
        return lasttime;
    }

    public void setLasttime(String lasttime) {
        this.lasttime = lasttime;
    }

    public String getUntil() {
        return until;
    }

    public void setUntil(String until) {
        this.until = until;
    }
}
