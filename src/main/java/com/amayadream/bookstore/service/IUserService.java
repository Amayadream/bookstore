package com.amayadream.bookstore.service;


import com.amayadream.bookstore.pojo.User;
import com.amayadream.bookstore.utils.Result;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 用户服务接口
 * @author :  Amayadream
 * @date :  2016.02.15 16:35
 */
public interface IUserService {
    Result login(String userid, String password, HttpSession session);
    Result logout(HttpSession session);
    List<User> selectUserList(int page, int pageSize);
    int count(int pageSize);
    Result insert(User user);
    Result update(User user);
    Result delete(String userid);
}
