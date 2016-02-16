package com.amayadream.bookstore.serviceImpl;

import com.amayadream.bookstore.dao.IUserDao;
import com.amayadream.bookstore.pojo.User;
import com.amayadream.bookstore.service.IUserService;
import com.amayadream.bookstore.utils.CommonDate;
import com.amayadream.bookstore.utils.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author :  Amayadream
 * @date :  2016.02.15 16:35
 */
@Service(value = "userService")
public class UserServiceImpl implements IUserService {
    @Resource private IUserDao userDao;

    public Result login(String userid, String password, HttpSession session) {
        if(userid.isEmpty() || password.isEmpty())  return Result.error("用户名和密码均不能为空!");
        User user = userDao.selectByUserid(userid);
        if(user == null)    return Result.error("用户不存在!");
        if(!password.equals(user.getPassword()))    return Result.error("密码错误!");
        if(user.getStatus() != 1)  return user.getStatus() == 0 ? Result.error("用户已被禁用") : Result.error("用户尚未激活");
        session.setAttribute("userid", user.getUserid());
        session.setAttribute("login_status", true);
        user.setLasttime(new CommonDate().getTime24());
        userDao.update(user);
        return Result.success("登录成功!");
    }

    public Result logout(HttpSession session) {
        session.removeAttribute("userid");
        session.removeAttribute("login_status");
        return Result.success("注销成功!");
    }

    public List<User> selectUserList(int page, int pageSize) {
        int start = 1;
        int end = pageSize;
        if(page != 1) {
            start = pageSize * (page - 1) + 1;
            end = pageSize * page;
        }
        return userDao.selectAll(start, end);
    }

    public int count(int pageSize) {
        int pageCount = Integer.parseInt(userDao.count().getUserid());
        return pageCount % pageSize == 0 ? pageCount/pageSize : pageCount/pageSize + 1;
    }

    public Result insert(User user) {
        User olduser = userDao.selectByUserid(user.getUserid());
        if(olduser != null) return Result.error("用户已存在!");
        user.setFirsttime(new CommonDate().getTime24());
        user.setLasttime(new CommonDate().getTime24());
        return userDao.insert(user) ? Result.success("添加成功!") : Result.error("添加失败");
    }

    public Result update(User user) {
        User olduser = userDao.selectByUserid(user.getUserid());
        if(olduser == null) return Result.error("用户不存在!");
        user.setLasttime(new CommonDate().getTime24());
        return userDao.update(user) ? Result.success("修改成功!") : Result.error("修改失败");
    }

    public Result delete(String userid) {
        User olduser = userDao.selectByUserid(userid);
        if(olduser == null) return Result.error("用户不存在!");
        return userDao.delete(userid) ? Result.success("删除成功!") : Result.error("删除失败!");
    }

}
