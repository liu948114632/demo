package com.liu.security.listen;


import com.liu.security.service.SessionManage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
    @Autowired
    SessionManage sessionManage;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        sessionManage.deleteUser(httpSessionEvent.getSession().getId());
        System.out.println("移除登录session");
    }
}
