package com.amayadream.bookstore.dao;

import com.amayadream.bookstore.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2016.02.15 16:27
 */
@Service(value = "userDao")
public interface IUserDao {
    List<User> selectAll(@Param("start") int start, @Param("end") int end);
    User count();
    User selectByUserid(String userid);
    boolean insert(User user);
    boolean update(User user);
    boolean delete(String userid);
}
