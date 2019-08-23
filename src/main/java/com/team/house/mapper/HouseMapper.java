package com.team.house.mapper;

import com.team.house.entity.House;
import com.team.house.entity.HouseExample;
import com.team.house.util.PageCondition;

import java.util.List;

public interface HouseMapper {
    int deleteByPrimaryKey(String id);

    int insert(House record);

    int insertSelective(House record);

    List<House> selectByExample(HouseExample example);

    List<House> exHouse(Integer ispass);

    House selectByPrimaryKey(String id);

    List<House> getHouseByUser(Integer id);

    House getHouse(String id);

    House getCurrent(String id);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);



    /*条件查询*/
    List<House> getHouseBySearch(PageCondition condition);
}