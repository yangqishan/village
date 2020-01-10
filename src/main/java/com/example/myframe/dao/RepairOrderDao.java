package com.example.myframe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.myframe.entity.RepairOrderBean;
import com.example.myframe.vo.RepairOrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface RepairOrderDao extends BaseMapper<RepairOrderBean>{
    List<RepairOrderBean> getAll();

    IPage<RepairOrderVo> getPage(Page page);

    void editStatus(RepairOrderBean repairOrderBean);
}
