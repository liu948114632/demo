package com.example.demo;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam(required = false) String name,
                        @RequestParam(required = false) String password,
                        HttpServletRequest request) throws Exception {
        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
        if(files != null){
            for(int i=0; i<files.size();i++) {
                if(!files.get(i).isEmpty()){
                    OutputStream out =new FileOutputStream(new File("d:/test/"+files.get(i).getOriginalFilename()));
                    out.write(files.get(i).getBytes());
                    out.close();
                }
            }
        }
        if(name.equals("liu") && password.equals("123")){
            return "ok";
        }
        return "fail";
    }
}
