package com.team.house.service;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.Type;
import com.team.house.util.Page;

import java.util.List;

public interface TypeService {
    //分页类型查询
    public PageInfo<Type> getTypeByPage(Page page);

    public List<Type> getType();

    //添加
    public int addType(Type type);
    //查单条
    public Type getOneType(Integer id);
    //修改单条
    public int updateType(Type type);
    //批量删除
    public int deleteTypeAll(Integer[] ids);
    //删除
    public int deleteType(Integer id);
}
