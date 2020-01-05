package com.example.myframe.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myframe.entity.PageBean;
import com.example.myframe.entity.UserBean;
import com.example.myframe.vo.UserVo;

import java.util.List;

public interface UserService extends IService<UserBean> {
    IPage<UserBean> getAll(Page page);

    IPage<UserBean> get(Page page);

    void addUser(UserBean userBean);

    void UpdateUser(UserBean userBean);

    UserBean getByname(String name);

    UserVo getbyid(int id);
}
