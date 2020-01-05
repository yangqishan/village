package com.example.myframe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.myframe.entity.CarBean;
import com.example.myframe.entity.PageBean;
import com.example.myframe.entity.UserBean;
import com.example.myframe.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface UserDao extends BaseMapper<UserBean> {

    IPage<UserBean> getAll(Page page);

    IPage<UserBean> get(Page page);

    void addUser(UserBean userBean);

    void updateUser(UserBean userBean);

    UserBean getByname(String name);

    UserVo getbyid(int id);
}


