package com.example.myframe.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.myframe.common.consts.ResultEnum;
import com.example.myframe.common.response.RestResponse;
import com.example.myframe.entity.PageBean;
import com.example.myframe.entity.RepairOrderBean;
import com.example.myframe.service.RepairOrderService;
import com.example.myframe.vo.RepairOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 维修订单控制层
 */
@RestController
@RequestMapping(value="/repairOrder")
public class RepairOrderController {
    @Autowired
    private RepairOrderService repairOrderService;

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
        IPage<RepairOrderVo> list;
        page.setSelectStr(name);
        list=repairOrderService.getPage(page);
        return new RestResponse(ResultEnum.SUCCESS,list);
    }

    /**
     *
     * 修改订单状态
     * @param id
     * @param status
     */
    @RequestMapping(value="/editStatus")
    public RestResponse editStatus(@RequestParam(value="id") int id,
                           @RequestParam(value="status") String status){
        RepairOrderBean repairOrderBean=new RepairOrderBean();
        repairOrderBean.setId(id);
        repairOrderBean.setStatus(status);
        repairOrderService.editStatus(repairOrderBean);
        return new RestResponse(ResultEnum.SUCCESS);
    }
}
