package com.amayadream.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 路由控制器
 * @author :  Amayadream
 * @date :  2016.02.15 20:37
 */
@Controller
public class RouteController {
    @RequestMapping(value = "index")
    public String index(){
        return "apps/index";
    }

    @RequestMapping(value = "login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "register")
    public String register(){
        return "apps/register";
    }
}
