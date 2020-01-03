package com.example.myframe.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myframe.entity.CarBean;

import java.util.List;

public interface CarService extends IService<CarBean>{
    List<CarBean> get();

    /**
     * 分页查询
     * @param page
     * @return
     */
    IPage<CarBean> getPage(Page<CarBean> page);
}
