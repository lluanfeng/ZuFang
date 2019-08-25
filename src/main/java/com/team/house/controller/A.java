package com.team.house.controller;

import com.team.house.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class A {
    @Autowired
    private HouseService houseService;
    public String go(){
        return "go";
    }
}
