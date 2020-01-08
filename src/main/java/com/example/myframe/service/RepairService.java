package com.example.myframe.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myframe.entity.RepairBean;
import com.example.myframe.vo.RepairVO;

import java.util.List;

public interface RepairService extends IService<RepairBean>{
    List<RepairBean> get();

    /**
     * 分页查询
     * @param page
     * @return
     */
    IPage<RepairVO> getPage(Page page);

    //增加维修工
    void addRepair(RepairBean repairBean);

    RepairVO getbyid(int id);

    void updateRepair(RepairBean repairBean);
}
