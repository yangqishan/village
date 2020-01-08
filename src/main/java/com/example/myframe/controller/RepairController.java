package com.example.myframe.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.myframe.common.consts.ResultEnum;
import com.example.myframe.common.response.RestResponse;
import com.example.myframe.entity.PageBean;
import com.example.myframe.service.RepairService;
import com.example.myframe.vo.HouseVo;
import com.example.myframe.vo.RepairVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 维修员控制层
 */
@RestController
@RequestMapping(value="/repair")
public class RepairController {

    @Autowired
    private RepairService repairService;

    /**
     * 分页查询（模糊查询）
     * @param name
     * @param current
     * @param size
     * @return
     */
    @RequestMapping(value="/getPage")
    public RestResponse getPage(@RequestParam(value="name",defaultValue = "") String name,
                                @RequestParam(value="current",defaultValue = "1") int current,
                                @RequestParam(value = "size",defaultValue = "5") int size){
        PageBean page=new PageBean<>(current,size);
        IPage<RepairVO> list;
        page.setSelectStr(name);
        list=repairService.getPage(page);
        return new RestResponse(ResultEnum.SUCCESS,list);
    }


}
