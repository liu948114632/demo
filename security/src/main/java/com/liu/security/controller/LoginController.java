package com.liu.security.controller;

import com.liu.security.dao.UserDao;
import com.liu.security.model.User;
import com.liu.security.service.SessionManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private SessionManage sessionManage;

//    @GetMapping("/")
//    public String index(){
//        return "login";
//    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(String name, String password, HttpSession session){
        User user =userDao.findByNameAndPassword(name, password);
        if(user!=null){
//            将用户放入session中
            if(sessionManage.getUser(session.getId())==null){
                sessionManage.setUser(session.getId(), user);
            }
            return "ok";
        }
        return "error";
    }
}
