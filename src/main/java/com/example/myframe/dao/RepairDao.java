package com.example.myframe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.myframe.entity.RepairBean;
import com.example.myframe.vo.RepairVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface RepairDao extends BaseMapper<RepairBean> {
    List<RepairBean> getAll();

    IPage<RepairVO> getPage(Page page);

    //增加维修工
    void addRepair(RepairBean repairBean);

    RepairVO getbyid(int id);
    //修改维修工的信息
    void updateRepair(RepairBean repairBean);
}
