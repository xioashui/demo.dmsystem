package com.demo.dmsystem.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class pageController {
    @RequestMapping("/")
    public String toindex(){
        return "index";
    }

    @RequestMapping("/login")
    public String tologin(){
        return "index";
    }
}
