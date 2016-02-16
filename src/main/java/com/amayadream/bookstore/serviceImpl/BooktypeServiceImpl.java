package com.amayadream.bookstore.serviceImpl;

import com.amayadream.bookstore.dao.IBooktypeDao;
import com.amayadream.bookstore.pojo.Booktype;
import com.amayadream.bookstore.service.IBooktypeService;
import com.amayadream.bookstore.utils.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2016.02.16 21:53
 */
@Service(value = "booktypeService")
public class BooktypeServiceImpl implements IBooktypeService {

    @Resource private IBooktypeDao booktypeDao;

    public List<Booktype> selectAllType() {
        return booktypeDao.selectAllType();
    }

    public Booktype selectById(String id) {
        return booktypeDao.selectById(id);
    }

    public Booktype selectByName(String name) {
        return booktypeDao.selectByName(name);
    }

    public Result insert(Booktype booktype) {
        if(booktypeDao.selectByName(booktype.getName())  != null)
            return Result.error("类型已存在!");
        return booktypeDao.insert(booktype) ? Result.success("添加成功!") : Result.error("添加失败!");
    }

    public Result update(Booktype booktype) {
        if(booktypeDao.selectByName(booktype.getName()) == null)
            return Result.error("类型不存在!");
        return booktypeDao.update(booktype) ? Result.success("更新成功!") : Result.error("更新失败!");
    }

    public Result delete(String id) {
        if(booktypeDao.selectById(id) == null)
            return Result.error("类型不存在!");
        return booktypeDao.delete(id) ? Result.success("更新成功!") : Result.error("更新失败!");
    }
}
