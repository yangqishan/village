package com.example.myframe.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myframe.dao.HouseDao;
import com.example.myframe.entity.HouseBean;
import com.example.myframe.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl extends ServiceImpl<HouseDao,HouseBean> implements HouseService {

    @Autowired
    private HouseDao houseDao;
    @Override
    public List<HouseBean> get() {
        return houseDao.getAll();
    }

    @Override
    public IPage<HouseBean> getPage(Page<HouseBean> page) {
        return houseDao.getPage(page);
    }
}
