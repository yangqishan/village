package com.example.myframe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.myframe.entity.AdminBean;
import com.example.myframe.entity.CarBean;
import com.example.myframe.vo.CarVo;
import com.example.myframe.vo.DataVo;
import com.example.myframe.vo.HouseVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface CarDao extends BaseMapper<CarBean> {
    List<CarVo> getAll();

    List<CarVo> getNullLike(String str);

    IPage<CarVo> getPage(Page page);

    IPage<CarVo> getLike(Page page);
    void updatebyuserId(CarBean carBean);

    List<DataVo> getTypeCount();
}
