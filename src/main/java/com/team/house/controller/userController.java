package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Users;
import com.team.house.service.UserService;
import com.team.house.util.UserConditioin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/admin")
public class userController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user1")
    @ResponseBody
    public HashMap<String,Object> UserPageRAll(UserConditioin userConditioin){
        PageInfo<Users> usersPageInfo = userService.UserRAll(userConditioin);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",usersPageInfo.getTotal());
        map.put("rows",usersPageInfo.getList());
        return map;
    }

}
