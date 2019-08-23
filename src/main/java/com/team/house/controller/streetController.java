package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Street;
import com.team.house.service.StreetService;
import com.team.house.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class streetController {
    @Autowired
    private StreetService streetService;
    @RequestMapping("/Street")
    @ResponseBody
    public HashMap<String,Object> Street(Page page,Integer did){
        PageInfo<Street> streetPageInfo = streetService.StreetAll(page,did);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",streetPageInfo.getTotal());
        map.put("rows",streetPageInfo.getList());
        return map;
    }
    @RequestMapping("/addStreet")
    @ResponseBody
    public String addStreet(Street street){
        int street1 = streetService.Street(street);
        return "{\"result\":"+street1+"}";
    }
    @RequestMapping("/delStreet")
    @ResponseBody
    public String delStreet(Integer id){
        int i = streetService.delStreet(id);
        return "{\"result\":"+i+"}";
    }
    @RequestMapping("/updateStreet")
    @ResponseBody
    public String updateStreet(Street street){
        int i = streetService.updateStreet(street);
        return "{\"result\":"+i+"}";
    }
    @RequestMapping("/getAllStreet2")
    @ResponseBody
    public List<Street> getAllStreet(Integer did){
        List<Street> allStreet = streetService.getAllStreet(did);
        return allStreet;
    }
}
