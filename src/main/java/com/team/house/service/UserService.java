package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Users;

import com.team.house.util.UserConditioin;

public interface UserService {
    public PageInfo<Users> UserRAll(UserConditioin userConditioin);

    //查询注册名字是否重名
    public int isUserNameExists(String name);

    //添加用户
    public int getUser(Users users);

    //登录
    public Users checkUserName(String name,String password);
}
