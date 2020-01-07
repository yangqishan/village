package com.example.myframe.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myframe.dao.HouseDao;
import com.example.myframe.entity.HouseBean;
import com.example.myframe.service.HouseService;
import com.example.myframe.vo.HouseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl extends ServiceImpl<HouseDao,HouseBean> implements HouseService {

    @Autowired
    private HouseDao houseDao;

    @Override
    public List<HouseVo> get() {
        return houseDao.getAll();
    }

    @Override
    public IPage<HouseVo> getPage(Page page) {
        return houseDao.getPage(page);
    }

    @Override
    public IPage<HouseVo> getLike(Page page) {
        return houseDao.getLike(page);
    }

    @Override
    public void updatebyuserId(HouseBean houseBean){
        houseDao.updatebyuserId(houseBean);
    }

    @Override
    public List<HouseVo> getNullLike(String str) {
        return houseDao.getNullLike(str);
    }
}
