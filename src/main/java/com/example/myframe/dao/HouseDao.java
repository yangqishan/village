package com.example.myframe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.myframe.entity.ChargeOrderBean;
import com.example.myframe.entity.HouseBean;
import com.example.myframe.entity.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface HouseDao extends BaseMapper<HouseBean> {
    List<HouseBean> getAll();


    IPage<HouseBean> getPage(Page<HouseBean> page);
}
