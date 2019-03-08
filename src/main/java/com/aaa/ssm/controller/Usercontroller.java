package com.aaa.ssm.controller;

import com.aaa.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/User")
public class Usercontroller {
@Autowired
    private UserService us;

    @ResponseBody
    @RequestMapping("/list")
    public Object getUserList(){
        return us.getUserList();
    }
}
