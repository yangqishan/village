package com.example.myframe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.myframe.entity.CarBean;
import com.example.myframe.entity.ChargeOrderBean;
import com.example.myframe.vo.ChargeOrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ChargeOrderDao extends BaseMapper<ChargeOrderBean> {
    List<ChargeOrderBean> getAll();

    IPage<ChargeOrderVo> getPage(Page page);

    void editStatus(ChargeOrderBean chargeOrderBean);
}
