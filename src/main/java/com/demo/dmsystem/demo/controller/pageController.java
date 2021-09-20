package com.demo.dmsystem.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class pageController {
    @RequestMapping("/")
    public String tomain(){return "/login";}
    @RequestMapping("/admin")
    public String toadmin(){return "page/admin/index";}
    @RequestMapping("/student")
    public String tostudent(){return "page/student/index";}
    @RequestMapping("/aunt")
    public String toaunt(){return "page/aunt/index";}
}
