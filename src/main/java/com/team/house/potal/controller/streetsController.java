package com.team.house.potal.controller;

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
@RequestMapping("/page")
public class streetsController {
    @Autowired
    private StreetService streetService;

    @RequestMapping("/getAllStreets")
    @ResponseBody
    public List<Street> getAllStreet(Integer did){
        List<Street> allStreet = streetService.getAllStreet(did);
        return allStreet;
    }
}
