package com.example.myframe.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myframe.dao.AdminDao;
import com.example.myframe.entity.AdminBean;
import com.example.myframe.entity.PageBean;
import com.example.myframe.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminDao,AdminBean> implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public List<AdminBean> get() {
        return adminDao.getAll();
    }

    @Override
    public IPage<AdminBean> getPage(Page<AdminBean> page) {
        return adminDao.getPage(page);
    }

    @Override
    public void addAdmin(AdminBean adminBean) {
        adminDao.addAdmin(adminBean);
    }

    @Override
    public void edit(AdminBean adminBean) {
        adminDao.edit(adminBean);
    }

    @Override
    public AdminBean getByName(String name) {
        return adminDao.getByName(name);
    }

    @Override
    public void editPwd(AdminBean adminBean) {
        adminDao.editPwd(adminBean);
    }
}
