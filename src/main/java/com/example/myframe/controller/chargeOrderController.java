package com.example.myframe.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.myframe.common.consts.ResultEnum;
import com.example.myframe.common.response.RestResponse;
import com.example.myframe.entity.ChargeOrderBean;
import com.example.myframe.entity.PageBean;
import com.example.myframe.entity.RepairOrderBean;
import com.example.myframe.service.ChargeOrderService;
import com.example.myframe.vo.ChargeOrderVo;
import com.example.myframe.vo.RepairOrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/chargeOrder")
public class chargeOrderController {
    @Autowired
    private ChargeOrderService chargeOrderService;


    @RequestMapping(value="/getPage")
    public RestResponse getPage(@RequestParam(value="name",defaultValue = "") String name,
                                @RequestParam(value="current",defaultValue = "1") int current,
                                @RequestParam(value = "size",defaultValue = "5") int size){
        PageBean page=new PageBean<>(current,size);
        IPage<ChargeOrderVo> list;
        page.setSelectStr(name);
        list=chargeOrderService.getPage(page);
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
        ChargeOrderBean chargeOrderBean=new ChargeOrderBean();
        chargeOrderBean.setId(id);
        chargeOrderBean.setStatus(status);
        chargeOrderService.editStatus(chargeOrderBean);
        return new RestResponse(ResultEnum.SUCCESS);
    }
}
