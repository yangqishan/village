package com.example.myframe.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myframe.entity.TypeBean;

import java.util.List;

public interface TypeService extends IService<TypeBean>{
    List<TypeBean> get();

    /**
     * 分页查询
     * @param page
     * @return
     */
    IPage<TypeBean> getPage(Page page);
    void addType(TypeBean typeBean);
}
