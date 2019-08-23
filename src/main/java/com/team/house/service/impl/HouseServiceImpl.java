package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.entity.Page;
import com.team.house.mapper.HouseMapper;
import com.team.house.service.HouseService;
import com.team.house.util.PageCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;

    @Override
    public int addHouse(House house) {
        return houseMapper.insertSelective(house);
    }

    @Override
    public PageInfo<House> getHouseA(Page page,int id) {
        PageHelper.startPage(page.getPage(),page.getRows());
        List<House> list=houseMapper.getHouseByUser(id);
        return new PageInfo<House>(list);
    }

    @Override
    public House getHouse(String id) {
        return houseMapper.getHouse(id);
    }

    @Override
    public int getUpdateHouse(House house) {
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public int delHouse(String id, Integer isdel) {
        House house = new House();
        house.setId(id);
        house.setIsdel(isdel);
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public List<House> exHouse(Integer ispass) {
        return houseMapper.exHouse(ispass);
    }

    @Override
    public PageInfo<House> houseSheng(Integer ispass,com.team.house.util.Page page) {
        PageHelper.startPage(page.getPage(),page.getRows());
        List<House> houses = houseMapper.exHouse(ispass);
        PageInfo<House> PageInfo = new PageInfo<>(houses);
        return PageInfo;
    }

    @Override
    public int exHouseTo(String id, Integer ispass) {
        House house = new House();
        house.setId(id);
        house.setIspass(ispass);
        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public PageInfo<House> getHouseBySearch(PageCondition condition) {
        PageHelper.startPage(condition.getPage(),condition.getRows());
        List<House> housBySerch = houseMapper.getHouseBySearch(condition);
        return new PageInfo<House>(housBySerch);
    }

    @Override
    public House getCurrent(String id) {
        return houseMapper.getCurrent(id);
    }
}
