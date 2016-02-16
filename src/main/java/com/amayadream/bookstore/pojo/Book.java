package com.amayadream.bookstore.pojo;

import org.springframework.stereotype.Repository;

/**
 * 图书实体
 * @author :  Amayadream
 * @date :  2016.02.16 20:50
 */
@Repository
public class Book {
    public String bookid;       //图书编号
    public String name;         //书名
    public String picture;      //封面
    public String description;  //描述
    public String type;         //类型
    public int status;          //状态

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
