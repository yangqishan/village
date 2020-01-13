package com.example.myframe.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myframe.dao.RepairOrderDao;
import com.example.myframe.entity.RepairOrderBean;
import com.example.myframe.service.RepairOrderService;
import com.example.myframe.vo.DataVo;
import com.example.myframe.vo.RepairOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairOrderServiceImpl extends ServiceImpl<RepairOrderDao,RepairOrderBean> implements RepairOrderService {

    @Autowired
    private RepairOrderDao repairOrderDao;
    @Override
    public List<RepairOrderBean> get() {
        return repairOrderDao.getAll();
    }

    @Override
    public IPage<RepairOrderVo> getPage(Page page) {
        return repairOrderDao.getPage(page);
    }

    @Override
    public void editStatus(RepairOrderBean repairOrderBean) {
        repairOrderDao.editStatus(repairOrderBean);
    }

    @Override
    public List<DataVo> getTypeCount() {
        return repairOrderDao.getTypeCount();
    }
}
