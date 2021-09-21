package com.demo.dmsystem.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class loginController {
    @RequestMapping("/login_error")
    @ResponseBody
    public String loginError() {
        return "error";
    }
}
