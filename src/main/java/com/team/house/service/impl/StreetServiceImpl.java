package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.Street;
import com.team.house.entity.StreetExample;
import com.team.house.mapper.StreetMapper;
import com.team.house.service.StreetService;
import com.team.house.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {
    @Autowired
    private StreetMapper streetMapper;

    @Override
    public PageInfo<Street> StreetAll(Page page,Integer did) {
        PageHelper.startPage(page.getPage(),page.getRows());
        StreetExample streetExample = new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        criteria.andDistrictIdEqualTo(did);
        List<Street> streets = streetMapper.selectByExample(streetExample);
        PageInfo<Street> streetPageInfo = new PageInfo<>(streets);
        return streetPageInfo;
    }

    @Override
    public List<Street> getAllStreet(Integer did) {
        StreetExample streetExample = new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        criteria.andDistrictIdEqualTo(did);
        return streetMapper.selectByExample(streetExample);
    }

    @Override
    public int Street(Street street) {
        return streetMapper.insertSelective(street);
    }

    @Override
    public int delStreet(Integer id) {
        return streetMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateStreet(Street street) {
        StreetExample streetExample = new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        criteria.andIdEqualTo(street.getId());
        return streetMapper.updateByPrimaryKeySelective(street);
    }
}
