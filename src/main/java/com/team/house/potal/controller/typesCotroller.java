package com.team.house.potal.controller;

import com.team.house.entity.Type;
import com.team.house.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/page")
public class typesCotroller {

    @Autowired
    private TypeService typeService;

    @RequestMapping("/getType")
    @ResponseBody
    public List<Type> getType() {
        List<Type> type = typeService.getType();
        return type;
    }
}
