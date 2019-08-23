package com.team.house.controller;


import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.entity.Type;
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
public class typeController {
    @Autowired
    private TypeService typeService;
     @RequestMapping("/type1")
    @ResponseBody
    public HashMap<String,Object> getType(Page page)
    {
        PageInfo<Type> typeByPage = typeService.getTypeByPage(page);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("total",typeByPage.getTotal());
        hashMap.put("rows",typeByPage.getList());
        return hashMap;
    }
    @RequestMapping("/addType")
    @ResponseBody
    public String addDistrict(Type type)
    {
        int i=-1;
        try{
            i = typeService.addType(type);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "{\"result\":"+i+"}";
    }
    @RequestMapping("/getOneType")
    @ResponseBody
    public Type getOneDistrict(Integer id)
    {
        Type oneType = typeService.getOneType(id);
        return oneType;
    }
    @RequestMapping("/updateType")
    @ResponseBody
    public String updateDistrict(Type type)
    {
        int i=-1;
        try{
            i = typeService.updateType(type);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "{\"result\":"+i+"}";
    }
    @RequestMapping("/deleteType")
    @ResponseBody
    public String deleteDistrict(Integer id)
    {
        int i=-1;
        try{
            i = typeService.deleteType(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "{\"result\":"+i+"}";
    }
    //批量删除
    @RequestMapping("/deleteTypeAll")
    @ResponseBody
    public String deleteDistrictAll(Integer[] ids)
    {
        int i=-1;
        try{
            i = typeService.deleteTypeAll(ids);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "{\"result\":"+i+"}";
    }
    /*条件查询专用*/
    @RequestMapping("/getTypes")
    @ResponseBody
    public List<Type> getType() {
        List<Type> type = typeService.getType();
        return type;
    }
}
