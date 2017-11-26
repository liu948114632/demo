package com.liu.security.service;

import com.liu.security.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SessionManage {

    private Map<String, User> userMap  = new HashMap<>();

    public void setUser(String sessionid , User user){
        userMap.put(sessionid, user);
    }
    public User getUser(String seeesionid){
        return userMap.get(seeesionid);
    }
    public void deleteUser(String sessionid){
        userMap.remove(sessionid);
    }
}
