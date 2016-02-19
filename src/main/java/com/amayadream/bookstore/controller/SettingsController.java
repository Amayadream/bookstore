package com.amayadream.bookstore.controller;

import com.amayadream.bookstore.pojo.User;
import com.amayadream.bookstore.service.IUserService;
import com.amayadream.bookstore.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;

/**
 * 个人信息设置控制器<br>
 * 这里属于个人信息修改页面,为了安全,用户名是从session中取得
 * @author :  Amayadream
 * @date :  2016.02.16 22:37
 */
@Controller
@RequestMapping(value = "settings")
@SessionAttributes("userid")
public class SettingsController {
    @Resource private IUserService userService;

    @RequestMapping(value = "head")
    public void head(@ModelAttribute("userid") String userid){

    }

    @RequestMapping(value = "password")
    public String password(@ModelAttribute("userid") String userid, RedirectAttributes attributes){
        return null;
    }

    @RequestMapping(value = "profile")
    public String profile(){
        return null;
    }

    @RequestMapping(value = "update")
    public String update(@ModelAttribute("userid") String userid, User user, RedirectAttributes attributes){
        Result result = userService.update(user);
        attributes.addFlashAttribute(result.get("result").toString().equals("1")?"message" : "error", result.get("msg"));
        return "redirect:/index";
    }

    @RequestMapping(value = "email")
    public String email(@ModelAttribute("userid") String userid,  RedirectAttributes attributes){
        return null;
    }


}
