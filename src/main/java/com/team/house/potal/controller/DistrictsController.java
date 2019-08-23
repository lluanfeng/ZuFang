package com.team.house.potal.controller;

import com.team.house.entity.District;
import com.team.house.service.DistrictService;
import com.team.house.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/page")
public class DistrictsController {
    @Autowired
    private DistrictService districtService;

    @RequestMapping("/getdistricts")
    @ResponseBody
    public List<District> getDistrictAll(){
        List<District> districtAll = districtService.getDistrictAll();
        return districtAll;
    }

}
