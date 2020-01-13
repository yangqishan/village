package com.example.myframe.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myframe.dao.RepairDao;
import com.example.myframe.entity.RepairBean;
import com.example.myframe.service.RepairService;
import com.example.myframe.vo.RepairVO;
import com.example.myframe.vo.PersonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairServiceImpl extends ServiceImpl<RepairDao,RepairBean> implements RepairService {
    @Autowired
    private RepairDao repairDao;

    @Override
    public List<RepairBean> get() {
        return repairDao.getAll();
    }

    @Override
    public IPage<RepairVO> getPage(Page page) {
        return repairDao.getPage(page);
    }

    @Override
    public void addRepair(RepairBean repairBean) {
        repairDao.addRepair(repairBean);
    }

    @Override
    public RepairVO getbyid(int id) {
        return repairDao.getbyid(id);
    }

    @Override
    public void updateRepair(RepairBean repairBean) {
        repairDao.updateRepair(repairBean);
    }

    @Override
    public List<PersonVo> getTypeCount() {
        return repairDao.getTypeCount();
    }

    @Override
    public List<PersonVo> getSexCount() {
        return repairDao.getSexCount();
    }
}
