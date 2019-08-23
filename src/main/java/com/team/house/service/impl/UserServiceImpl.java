package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.Users;
import com.team.house.entity.UsersExample;
import com.team.house.mapper.UsersMapper;
import com.team.house.service.UserService;
import com.team.house.util.MD5Utils;
import com.team.house.util.UserConditioin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public PageInfo<Users> UserRAll(UserConditioin userConditioin) {
        PageHelper.startPage(userConditioin.getPage(),userConditioin.getRows());
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andIsadminEqualTo(new Integer("0"));
        if(userConditioin.getName()!=null&&!userConditioin.getName().equals("")){
            criteria.andNameLike("%"+userConditioin.getName()+"%");
        }
        if(userConditioin.getTelephone()!=null&&!userConditioin.getTelephone().equals("")){
            criteria.andTelephoneLike("%"+userConditioin.getTelephone()+"%");
        }
        List<Users> users = usersMapper.selectByExample(usersExample);
        PageInfo<Users> usersPageInfo = new PageInfo<>(users);
        return usersPageInfo;
    }

    @Override
    public int isUserNameExists(String name) {
        return usersMapper.getUserCount(name);
    }

    @Override
    public int getUser(Users users) {
        users.setIsadmin(new Integer("0"));
        users.setPassword(MD5Utils.md5Encrypt(users.getPassword()));
        return usersMapper.insertSelective(users);
    }

    @Override
    public Users checkUserName(String name, String password) {
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo(name);
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));
        List<Users> users = usersMapper.selectByExample(usersExample);
        if(users.size()==0)
            return null;
        else
            return users.get(0);
    }
}
