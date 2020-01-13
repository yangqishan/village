package com.example.myframe.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myframe.dao.CarDao;
import com.example.myframe.entity.CarBean;
import com.example.myframe.service.CarService;
import com.example.myframe.vo.CarVo;
import com.example.myframe.vo.DataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl extends ServiceImpl<CarDao,CarBean> implements CarService {
    @Autowired
    private CarDao carDao;

    @Override
    public List<CarVo> get() {
        return carDao.getAll();
    }

    @Override
    public IPage<CarVo> getPage(Page page) {
        return carDao.getPage(page);
    }

    @Override
    public IPage<CarVo> getLike(Page page) {
        return carDao.getLike(page);
    }

    @Override
    public void updatebyuserId(CarBean carBean){
        carDao.updatebyuserId(carBean);
    }

    @Override
    public List<CarVo> getNullLike(String str) {
        return carDao.getNullLike(str);
    }

    @Override
    public List<DataVo> getTypeCount() {
        return carDao.getTypeCount();
    }
}
