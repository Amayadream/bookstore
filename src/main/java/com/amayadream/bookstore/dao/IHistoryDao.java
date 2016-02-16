package com.amayadream.bookstore.dao;

import com.amayadream.bookstore.pojo.History;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2016.02.16 21:07
 */
@Service(value = "historyDao")
public interface IHistoryDao {
    List<History> selectByUserid(@Param("start") int start, @Param("end") int end, @Param("userid") String userid);
    History selectById(String id);
    History selectByBookid(String userid, String bookid);
    boolean insert(History history);
    boolean update(History history);
    boolean delete(String id);
    boolean deleteByBook(String userid, String bookid);
}
