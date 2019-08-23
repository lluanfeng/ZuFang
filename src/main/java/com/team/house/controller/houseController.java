package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.service.DistrictService;
import com.team.house.service.TypeService;
import com.team.house.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
@RequestMapping("/admin")
@Controller
public class houseController {
    @Autowired
    private DistrictService districtService;

    @RequestMapping("/district")
    @ResponseBody
    public List<District> getDistrictAll(){
        List<District> districtAll = districtService.getDistrictAll();
        return districtAll;
    }
    @RequestMapping("/district2")
    @ResponseBody
    public HashMap<String,Object> getDataByPage(Page page)
    {
        PageInfo<District> studentByPage = districtService.getStudentByPage(page);
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("total",studentByPage.getTotal());
        objectObjectHashMap.put("rows",studentByPage.getList());
        return objectObjectHashMap;
    }
    @RequestMapping("/addDistrict")
    @ResponseBody
    public String addDistrict(District district)
    {
        int i=-1;
        try{
            i = districtService.addDistrict(district);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "{\"result\":"+i+"}";
    }
    @RequestMapping("/getOneDistrict")
    @ResponseBody
    public District getOneDistrict(Integer id)
    {
        District oneDistrict = districtService.getOneDistrict(id);
        return oneDistrict;
    }
    @RequestMapping("/updateDistrict")
    @ResponseBody
    public String updateDistrict(District district)
    {
        int i=-1;
        try{
            i = districtService.updateDistrict(district);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "{\"result\":"+i+"}";
    }
    @RequestMapping("/deleteDistrict")
    @ResponseBody
    public String deleteDistrict(Integer id)
    {
        int i=-1;
        try{
            i = districtService.deleteDistrict(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "{\"result\":"+i+"}";
    }
    //批量删除
    @RequestMapping("/deleteDistrictAll")
    @ResponseBody
    public String deleteDistrictAll(Integer[] ids)
    {
        int i=-1;
        try{
            i = districtService.deleteDistrictAll(ids);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "{\"result\":"+i+"}";
    }

}
