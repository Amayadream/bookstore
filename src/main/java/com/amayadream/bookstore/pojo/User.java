package com.amayadream.bookstore.pojo;

import org.springframework.stereotype.Repository;

/**
 * 用户实体
 * @author :  Amayadream
 * @date :  2016.02.15 14:53
 */
@Repository
public class User {
    public String userid;       //用户名
    public String password;     //密码
    public String firsttime;    //注册时间
    public String lasttime;     //最后登录时间
    public int status;          //状态, 1:正常, 0:禁用 -1:未激活
    public String code;     //激活码

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
