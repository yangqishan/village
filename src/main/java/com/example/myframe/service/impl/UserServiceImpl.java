package com.example.myframe.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myframe.dao.UserDao;
import com.example.myframe.entity.PageBean;
import com.example.myframe.entity.UserBean;
import com.example.myframe.service.UserService;
import com.example.myframe.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao,UserBean> implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public IPage<UserBean> getAll(Page page) {
        return userDao.getAll(page);
    }

    @Override
    public IPage<UserBean> get(Page page) {
        return userDao.get(page);
    }

    @Override
    public void addUser(UserBean userBean) {
        userDao.addUser(userBean);
    }

    @Override
    public void UpdateUser(UserBean userBean) {
        userDao.updateUser(userBean);
    }

    @Override
    public UserBean getByname(String name) {
        return userDao.getByname(name);
    }

    @Override
    public UserVo getbyid(int id) {
        return userDao.getbyid(id);
    }
}
