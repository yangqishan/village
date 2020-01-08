package com.example.myframe.controller;

import com.example.myframe.common.consts.ResultEnum;
import com.example.myframe.common.response.RestResponse;
import com.example.myframe.entity.TypeBean;
import com.example.myframe.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 类型控制层
 */
@RestController
@RequestMapping(value="/type")
public class TypeController {
    @Autowired
    private TypeService typeService;


    /**
     * 查询所有的维修员的类型
     * @return
     */
    @RequestMapping(value="/getAll")
    public RestResponse getAll(){
        List<TypeBean> list=typeService.get();
        return new RestResponse(ResultEnum.SUCCESS,list);
    }
}
