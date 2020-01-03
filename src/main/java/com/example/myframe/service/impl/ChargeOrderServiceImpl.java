package com.example.myframe.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myframe.dao.ChargeOrderDao;
import com.example.myframe.entity.ChargeOrderBean;
import com.example.myframe.service.ChargeOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargeOrderServiceImpl extends ServiceImpl<ChargeOrderDao,ChargeOrderBean> implements ChargeOrderService {
    @Autowired
    private ChargeOrderDao chargeOrderDao;
    @Override
    public List<ChargeOrderBean> get() {
        return chargeOrderDao.getAll();
    }

    @Override
    public IPage<ChargeOrderBean> getPage(Page<ChargeOrderBean> page) {
        return chargeOrderDao.getPage(page);
    }
}
