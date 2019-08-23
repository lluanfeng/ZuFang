package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.entity.Type;
import com.team.house.util.Page;

import java.util.List;

public interface DistrictService {
    public List<District> getDistrictAll();
    //分页区域查询
    public PageInfo<District> getStudentByPage(Page page);

    //添加
    public int addDistrict(District district);
    //查单条
    public District getOneDistrict(Integer id);
    //修改单条
    public int updateDistrict(District district);
    //批量删除
    public int deleteDistrictAll(Integer[] ids);
    //删除
    public int deleteDistrict(Integer id);
}
