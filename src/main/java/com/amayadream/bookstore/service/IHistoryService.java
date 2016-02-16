package com.amayadream.bookstore.service;


import com.amayadream.bookstore.pojo.History;

import java.util.List;

/**
 * 阅读历史服务接口
 * @author :  Amayadream
 * @date :  2016.02.16 21:28
 */
public interface IHistoryService {
    List<History> selectByUserid(int page, int pageSize, String userid);
    History selectById(String id);
    History selectByBookid(String userid, String bookid);
    boolean insert(History history);
    boolean update(History history);
    boolean delete(String id);
    boolean deleteByBook(String userid, String bookid);
}
