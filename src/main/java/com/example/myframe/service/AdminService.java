package com.example.myframe.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myframe.entity.AdminBean;
import com.example.myframe.entity.PageBean;

import java.util.List;

public interface AdminService extends IService<AdminBean>{
    List<AdminBean> get();

    /**
     * 分页查询
     * @param page
     * @return
     */
    IPage<AdminBean> getPage(Page<AdminBean> page);
}
