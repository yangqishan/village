package com.example.myframe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.myframe.entity.RepairBean;
import com.example.myframe.entity.RepairOrderBean;
import com.example.myframe.entity.TypeBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface TypeDao extends BaseMapper<TypeBean> {
    List<TypeBean> getAll();

    IPage<TypeBean> getPage(Page<TypeBean> page);


}
