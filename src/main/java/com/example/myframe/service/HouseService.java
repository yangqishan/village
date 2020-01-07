package com.example.myframe.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myframe.entity.HouseBean;
import com.example.myframe.vo.HouseVo;

import java.util.List;

public interface HouseService extends IService<HouseBean>{
    List<HouseVo> get();

    /**
     * 分页查询
     * @param page
     * @return
     */
    IPage<HouseVo> getPage(Page page);
    IPage<HouseVo> getLike(Page page);
    void updatebyuserId(HouseBean houseBean);

    /**
     * 空楼模糊查询
     * @param str
     * @return
     */
    List<HouseVo> getNullLike(String str);
}
