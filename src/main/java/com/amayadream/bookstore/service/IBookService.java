package com.amayadream.bookstore.service;

import com.amayadream.bookstore.pojo.Book;
import com.amayadream.bookstore.utils.Result;

import java.util.List;

/**
 * 图书服务接口
 * @author :  Amayadream
 * @date :  2016.02.16 21:11
 */
public interface IBookService {
    List<Book> selectAll(int page, int pageSize);
    List<Book> selectByType(int page, int pageSize, String type);
    int selectAllCount(int pageSize);
    int selectByTypeCount(int pageSize, String type);
    Book selectByBookid(String bookid);
    Result insert(Book book);
    Result update(Book book);
    Result delete(String bookid);

}
