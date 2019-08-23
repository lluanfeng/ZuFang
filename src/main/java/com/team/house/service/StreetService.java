package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Street;
import com.team.house.util.Page;

import java.util.List;

public interface StreetService {
    public PageInfo<Street> StreetAll(Page page,Integer did);

    public List<Street> getAllStreet(Integer did);

    public int Street(Street street);

    public  int delStreet(Integer id);

    public  int updateStreet(Street street);
}
