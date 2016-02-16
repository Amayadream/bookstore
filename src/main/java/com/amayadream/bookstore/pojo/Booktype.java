package com.amayadream.bookstore.pojo;

import org.springframework.stereotype.Repository;

/**
 * 图书类型实体
 * @author :  Amayadream
 * @date :  2016.02.16 20:57
 */
@Repository
public class Booktype {
    public String id;           //编号
    public String name;         //类型名称
    public String description;  //描述

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
