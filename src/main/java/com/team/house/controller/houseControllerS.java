package com.team.house.controller;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.service.HouseService;
import com.team.house.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/admin")
@Controller
public class houseControllerS {
    @Autowired
    private HouseService houseService;

    @RequestMapping("/sHouse")
    @ResponseBody
    public Map<String,Object> exHouse(Integer ispass, Page page){
        PageInfo<House> house = houseService.houseSheng(ispass, page);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",house.getTotal());
        map.put("rows",house.getList());
        return map;
    }
    /*根据id审核/退回审核*/
    @RequestMapping("/sHouseGo")
    @ResponseBody
    public String exHouse(String id,Integer ispass){
        int i = houseService.exHouseTo(id, ispass);
        System.out.println(i);
        return "{\"result\":"+i+"}";
    }
}
