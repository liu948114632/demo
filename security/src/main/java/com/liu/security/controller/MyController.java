package com.liu.security.controller;

import com.liu.security.annotation.HasPermission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController("/hello")
@Controller
public class MyController {
    @HasPermission("hello")
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "这个方法需要权限";
    }
}
