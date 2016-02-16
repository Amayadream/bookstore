package com.amayadream.bookstore.service;

import com.amayadream.bookstore.pojo.Booktype;
import com.amayadream.bookstore.utils.Result;

import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2016.02.16 21:52
 */
public interface IBooktypeService {
    List<Booktype> selectAllType();
    Booktype selectById(String id);
    Booktype selectByName(String name);
    Result insert(Booktype booktype);
    Result update(Booktype booktype);
    Result delete(String id);
}
