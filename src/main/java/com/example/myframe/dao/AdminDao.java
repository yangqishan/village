package com.example.myframe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.myframe.entity.AdminBean;
import com.example.myframe.entity.PageBean;
import com.example.myframe.entity.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AdminDao extends BaseMapper<AdminBean>{
    List<AdminBean> getAll();

    IPage<AdminBean> getPage(Page<AdminBean> page);

    void addAdmin(AdminBean adminBean);

    void edit(AdminBean adminBean);

    AdminBean getByName(String name);

    void editPwd(AdminBean adminBean);
}
