package com.example.myframe.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myframe.dao.TypeDao;
import com.example.myframe.entity.TypeBean;
import com.example.myframe.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl extends ServiceImpl<TypeDao,TypeBean> implements TypeService {

    @Autowired
    private TypeDao typeDao;
    @Override
    public List<TypeBean> get() {
        return typeDao.getAll();
    }

    @Override
    public IPage<TypeBean> getPage(Page<TypeBean> page) {
        return typeDao.getPage(page);
    }
}
