package com.example.myframe.controller;


import com.example.myframe.common.consts.ResultEnum;
import com.example.myframe.common.response.RestResponse;
import com.example.myframe.entity.AdminBean;
import com.example.myframe.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping(value="/getAll")
    public RestResponse getAll(){
        List<AdminBean> list=adminService.get();
        return new RestResponse(ResultEnum.SUCCESS,list);
    }
}
