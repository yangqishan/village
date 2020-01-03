package com.example.myframe.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myframe.entity.RepairBean;

import java.util.List;

public interface RepairService extends IService<RepairBean>{
    List<RepairBean> get();

    /**
     * 分页查询
     * @param page
     * @return
     */
    IPage<RepairBean> getPage(Page<RepairBean> page);
}
