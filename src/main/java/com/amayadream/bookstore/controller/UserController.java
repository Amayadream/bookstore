package com.amayadream.bookstore.controller;

import com.amayadream.bookstore.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 用户控制器
 * @author :  Amayadream
 * @date :  2016.02.15 17:24
 */
@Controller
public class UserController {
    @Resource private IUserService userService;

    @RequestMapping(value = "{userid}")
    public String index(){
        return null;
    }


}
