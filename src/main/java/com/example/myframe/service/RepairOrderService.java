package com.example.myframe.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myframe.entity.RepairOrderBean;

import java.util.List;

public interface RepairOrderService extends IService<RepairOrderBean>{
    List<RepairOrderBean> get();

    /**
     * 分页查询
     * @param page
     * @return
     */
    IPage<RepairOrderBean> getPage(Page<RepairOrderBean> page);
}
