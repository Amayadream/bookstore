package com.amayadream.bookstore.controller;

import com.amayadream.bookstore.pojo.User;
import com.amayadream.bookstore.service.IUserService;
import com.amayadream.bookstore.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 验证控制器
 * @author :  Amayadream
 * @date :  2016.02.15 16:41
 */
@Controller
@RequestMapping(value = "auth")
public class AuthController {
    @Resource private IUserService userService;

    /**
     * 登录
     * @param user
     * @param attributes
     * @param session
     * @return
     */
    @RequestMapping(value = "login")
    public String login(User user, HttpSession session, RedirectAttributes attributes){
        Result result = userService.login(user.getUserid(), user.getPassword(), session);
        attributes.addFlashAttribute("message", result.get("msg"));
        return result.get("result").equals(1) ?  "redirect:/index" :  "redirect:/login";
    }

    /**
     * 注销
     * @param attributes
     * @param session
     * @return
     */
    @RequestMapping(value = "logout")
    public String logout(HttpSession session, RedirectAttributes attributes){
        Result result = userService.logout(session);
        attributes.addFlashAttribute("message", result.get("msg"));
        return "redirect:/login";
    }

    /**
     * 用户注册
     * @param user
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "register")
    public String register(User user, RedirectAttributes redirectAttributes){
        return null;
    }

}
