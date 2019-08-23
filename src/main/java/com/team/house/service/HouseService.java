package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.entity.Page;
import com.team.house.util.PageCondition;

import java.util.List;

public interface HouseService {

    public int addHouse(House house);

    public PageInfo<House> getHouseA(Page page,int id);

    public House getHouse(String id);

    public int getUpdateHouse(House house);

    public int delHouse(String id,Integer isdel);

    public List<House> exHouse(Integer ispass);
    /*后台审核分页查询*/
    PageInfo<House> houseSheng(Integer ispass, com.team.house.util.Page page);

    public int exHouseTo(String id,Integer ispass);

    /*条件查询*/
    public PageInfo<House> getHouseBySearch(PageCondition condition);

    /*查单条*/
    House getCurrent(String id);
}
