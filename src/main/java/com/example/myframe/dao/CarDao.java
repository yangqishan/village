package com.example.myframe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.myframe.entity.AdminBean;
import com.example.myframe.entity.CarBean;
import com.example.myframe.vo.CarVo;
import com.example.myframe.vo.HouseVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CarDao extends BaseMapper<CarBean> {
    List<CarBean> getAll();


    IPage<CarVo> getPage(Page page);

    IPage<CarVo> getLike(Page page);
    void updatebyuserId(CarBean carBean);
}
