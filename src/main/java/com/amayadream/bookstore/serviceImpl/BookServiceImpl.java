package com.amayadream.bookstore.serviceImpl;

import com.amayadream.bookstore.dao.IBookDao;
import com.amayadream.bookstore.pojo.Book;
import com.amayadream.bookstore.service.IBookService;
import com.amayadream.bookstore.utils.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2016.02.16 21:15
 */
@Service(value = "bookService")
public class BookServiceImpl implements IBookService {

    /** 图书服务接口 */
    @Resource private IBookDao bookDao;

    public List<Book> selectAll(int page, int pageSize) {
        int start = 1;
        int end = pageSize;
        if(page != 1) {
            start = pageSize * (page - 1) + 1;
            end = pageSize * page;
        }
        return bookDao.selectAll(start, end);
    }

    public List<Book> selectByType(int page, int pageSize, String type) {
        int start = 1;
        int end = pageSize;
        if(page != 1) {
            start = pageSize * (page - 1) + 1;
            end = pageSize * page;
        }
        return bookDao.selectByType(start, end, type);
    }

    public int selectAllCount(int pageSize) {
        int pageCount = Integer.parseInt(bookDao.selectAllCount().getBookid());
        return pageCount % pageSize == 0 ? pageCount/pageSize : pageCount/pageSize + 1;
    }

    public int selectByTypeCount(int pageSize, String type) {
        int pageCount = Integer.parseInt(bookDao.selectByTypeCount(type).getBookid());
        return pageCount % pageSize == 0 ? pageCount/pageSize : pageCount/pageSize + 1;
    }

    public Book selectByBookid(String bookid) {
        return bookDao.selectByBookid(bookid);
    }

    public Result insert(Book book) {
        if(bookDao.insert(book))    return Result.success("添加成功!");
        return Result.error("添加失败!");
    }

    public Result update(Book book) {
        Book oldbook = bookDao.selectByBookid(book.getBookid());
        if(oldbook == null) return Result.error("书籍不存在!");
        return bookDao.update(book) ? Result.success("更新成功!") : Result.error("更新失败!");
    }

    public Result delete(String bookid) {
        Book oldbook = bookDao.selectByBookid(bookid);
        if(oldbook == null) return Result.error("书籍不存在!");
        return bookDao.delete(bookid) ? Result.success("删除成功!") : Result.error("删除失败");
    }
}
