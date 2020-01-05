package com.example.myframe.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myframe.entity.CarBean;
import com.example.myframe.vo.CarVo;
import com.example.myframe.vo.HouseVo;

import java.util.List;

public interface CarService extends IService<CarBean>{
    List<CarBean> get();

    /**
     * 分页查询
     * @param page
     * @return
     */
    IPage<CarVo> getPage(Page page);
    IPage<CarVo> getLike(Page page);

    void updatebyuserId(CarBean carBean);
}
