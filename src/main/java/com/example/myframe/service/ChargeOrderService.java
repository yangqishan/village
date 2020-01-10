package com.example.myframe.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myframe.entity.ChargeOrderBean;
import com.example.myframe.vo.ChargeOrderVo;

import java.util.List;

public interface ChargeOrderService extends IService<ChargeOrderBean>{
    List<ChargeOrderBean> get();

    /**
     * 分页查询
     * @param page
     * @return
     */
    IPage<ChargeOrderVo> getPage(Page page);
    void editStatus(ChargeOrderBean chargeOrderBean);
}
