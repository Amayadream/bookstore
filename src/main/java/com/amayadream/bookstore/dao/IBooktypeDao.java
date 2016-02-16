package com.amayadream.bookstore.dao;

import com.amayadream.bookstore.pojo.Booktype;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2016.02.16 21:05
 */
@Service(value = "boottypeDao")
public interface IBooktypeDao {
    List<Booktype> selectAllType();
    Booktype selectById(String id);
    Booktype selectByName(String name);
    boolean insert(Booktype booktype);
    boolean update(Booktype booktype);
    boolean delete(String id);
}
