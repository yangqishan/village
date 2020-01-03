package com.example.myframe.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myframe.entity.HouseBean;

import java.util.List;

public interface HouseService extends IService<HouseBean>{
    List<HouseBean> get();

    /**
     * 分页查询
     * @param page
     * @return
     */
    IPage<HouseBean> getPage(Page<HouseBean> page);
}
