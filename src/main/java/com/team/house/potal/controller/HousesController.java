package com.team.house.potal.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.entity.Page;
import com.team.house.entity.Users;
import com.team.house.service.HouseService;
import com.team.house.util.PageCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/page")
public class HousesController {
@Autowired
private HouseService houseService;
    @RequestMapping("/addHouse")

    public String addHouse(House house, HttpSession session, Model model,@RequestParam(value="pfile",required = false) CommonsMultipartFile pfile){
        try {
            //第一步上传图片
            String path="f:\\images\\";  //存放文件的位置
            //生成唯一文件名
            String oldName=pfile.getOriginalFilename();
            String expname=oldName.substring(oldName.lastIndexOf("."));
            String filename=System.currentTimeMillis()+expname;
            File file=new File(path+filename);
            pfile.transferTo(file);  //上传，保存
            //第二步保存信息到数据库
            //设置主键
            house.setId(System.currentTimeMillis()+"");
            //设置发布出租房的用户
            Users users=(Users) session.getAttribute("userInfo");
            System.out.println(users);
            house.setUserId(users.getId());
            //设置图片
            house.setPath(filename);
            houseService.addHouse(house);
            return "redirect:getHouseByUser";  //跳转到管理页
        }catch (Exception e){
            e.printStackTrace();
            model.addAttribute("info","上传文件失败..");
        }
        return "fabu";
    }
    @RequestMapping("/getHouseByUser")
    public String getHouseByUser(Model model, Page page,HttpSession session){
        Users user=(Users)session.getAttribute("userInfo");
        PageInfo<House> houseA = houseService.getHouseA(page, user.getId());
        model.addAttribute("houseA",houseA);
        return "guanli";
    }
    @RequestMapping("/getHouse")
    public String getHouse(Model model,String id){
        House house = houseService.getHouse(id);
        model.addAttribute("house",house);
        return "showHouse";
    }
    @RequestMapping("/updateOne")
    public String getUpdateHouse(House house,@RequestParam("pfile") CommonsMultipartFile pfile,String delimage){
        try {
            //判断用户是否选择文件
            String oldName=pfile.getOriginalFilename();
            if(oldName.equals(""))  //没有选择文件
            {
                houseService.getUpdateHouse(house);
            }else
            {
                //上传
                //第一步上传图片
                String path="f:\\images\\";  //存放文件的位置
                //生成唯一文件名
                String expname=oldName.substring(oldName.lastIndexOf("."));
                String filename=System.currentTimeMillis()+expname;
                File file=new File(path+filename);
                pfile.transferTo(file);  //上传，保存
                //更新数据库
                //设置更新图片路径
                house.setPath(filename);
                houseService.getUpdateHouse(house);
                //删除旧图
                File delfile=new File(path+delimage);
                delfile.delete();
            }
            return "redirect:getHouseByUser";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "error";
    }
    /*根据id删除*/
    @RequestMapping("/delHouse")
    public String getHouse(String id,Integer isdel){
        houseService.delHouse(id,isdel);
        return "redirect:getHouseByUser";
    }
    /*审核页面*/
    @RequestMapping("/exHouse")
    public String exHouse(Model model,Integer ispass){
        List<House> houses = houseService.exHouse(ispass);
        model.addAttribute("houses",houses);
        return "examine";
    }
    /*根据id审核*/
    @RequestMapping("/exHouseTo")
    public String exHouse(String id,Integer ispass){
            houseService.exHouseTo(id, ispass);
        return "examine";
    }
    @RequestMapping("/getHouseSearch")
    public String HouseSerch(PageCondition condition,Model model){
        PageInfo<House> houseBySerch = houseService.getHouseBySearch(condition);
        model.addAttribute("houseBySerch",houseBySerch);
        model.addAttribute("condition",condition);
        return "list";
    }
    @RequestMapping("/getCurrent")
    public String getCurrent(String id,Model model){
        Date date = new Date();
        House current = houseService.getCurrent(id);
        model.addAttribute("current",current);
        model.addAttribute("date",date);
        return "details";
    }
}