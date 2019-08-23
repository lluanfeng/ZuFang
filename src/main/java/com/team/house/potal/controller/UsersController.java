package com.team.house.potal.controller;

import com.team.house.entity.Users;
import com.team.house.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/page")
public class UsersController {
    @Autowired
    private UserService userService;

    @RequestMapping("/checkUserName")
    @ResponseBody
    public Map<String,Object> checkUserName(String name){
        int temp=userService.isUserNameExists(name);
        //返回数据
        Map<String,Object> map=new HashMap<>();
        map.put("result",temp);
        return map;
    }
    @RequestMapping("/reg")
    public String getUser(Users users){
        int user = userService.getUser(users);
        if(user>0)
            return "login";
        else
            return "regs";
    }
    @RequestMapping("/login")
    public String UserDL(String name,String password,HttpSession session){
        Users users = userService.checkUserName(name, password);
        if(users==null)
            return "login";
        else
        //注意:只要登入，必需使用session保存登入人的信息或者cookie保存
        //session保存的信息在服务器与浏览共存
        session.setAttribute("userInfo",users);
        System.out.println(users);
        //设置保存的时间
        session.setMaxInactiveInterval(600);  //秒
        return "redirect:getHouseByUser";
    }
}
