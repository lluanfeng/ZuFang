package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.entity.DistrictExample;
import com.team.house.entity.Type;
import com.team.house.entity.TypeExample;
import com.team.house.mapper.DistrictMapper;
import com.team.house.mapper.StreetMapper;
import com.team.house.mapper.TypeMapper;
import com.team.house.service.DistrictService;
import com.team.house.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private StreetMapper streetMapper;

    @Override
    public List<District> getDistrictAll() {
        DistrictExample districtExample = new DistrictExample();
        List<District> districts = districtMapper.selectByExample(districtExample);
        return districts;
    }

    @Override
    public PageInfo<District> getStudentByPage(Page page) {
        PageHelper.startPage(page.getPage(),page.getRows());
        DistrictExample districtExample = new DistrictExample();
        List<District> list =districtMapper.selectByExample(districtExample);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }



    @Override
    public int addDistrict(District district) {
        return districtMapper.insertSelective(district);
    }

    @Override
    public District getOneDistrict(Integer id) {
        return districtMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateDistrict(District district) {
        return districtMapper.updateByPrimaryKeySelective(district);
    }

    @Override
    public int deleteDistrictAll(Integer[] ids) {
        DistrictExample e = new DistrictExample();
        DistrictExample.Criteria c = e.createCriteria();
        c.andIdIn(Arrays.asList(ids));
        return districtMapper.deleteByExample(e);
    }

    @Override
    public int deleteDistrict(Integer id) {
        streetMapper.delStreetByDistrict(id);

        return districtMapper.deleteByPrimaryKey(id);
    }
}
