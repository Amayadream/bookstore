package com.amayadream.bookstore.dao;

import com.amayadream.bookstore.pojo.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2016.02.16 20:58
 */
@Service(value = "bookDao")
public interface IBookDao {
    List<Book> selectAll(@Param("start") int start, @Param("end") int end);
    List<Book> selectByType(@Param("start") int start, @Param("end") int end, @Param("type") String type);
    Book selectAllCount();
    Book selectByTypeCount(String type);
    Book selectByBookid(String bookid);
    boolean insert(Book book);
    boolean update(Book book);
    boolean delete(String id);
}
