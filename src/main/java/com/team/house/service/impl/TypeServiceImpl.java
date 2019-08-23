package com.team.house.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.team.house.entity.Type;
import com.team.house.entity.TypeExample;
import com.team.house.mapper.TypeMapper;
import com.team.house.service.TypeService;
import com.team.house.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;
    @Override
    public PageInfo<Type> getTypeByPage(Page page) {
        PageHelper.startPage(page.getPage(),page.getRows());
        TypeExample typeExample = new TypeExample();
        List<Type> list =typeMapper.selectByExample(typeExample);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public List<Type> getType() {
        List<Type> types = typeMapper.selectByExample(new TypeExample());
        return types;
    }

    @Override
    public int addType(Type type) {
        return typeMapper.insertSelective(type);
    }

    @Override
    public Type getOneType(Integer id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateType(Type type) {
        return typeMapper.updateByPrimaryKeySelective(type);
    }

    @Override
    public int deleteTypeAll(Integer[] ids) {
        TypeExample e = new TypeExample();
        TypeExample.Criteria c = e.createCriteria();
        c.andIdIn(Arrays.asList(ids));
        return typeMapper.deleteByExample(e);
    }

    @Override
    public int deleteType(Integer id) {
        return typeMapper.deleteByPrimaryKey(id);
    }
}
