package com.example.myframe.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.myframe.common.consts.ResultEnum;
import com.example.myframe.common.response.RestResponse;
import com.example.myframe.entity.CarBean;
import com.example.myframe.entity.PageBean;
import com.example.myframe.service.CarService;
import com.example.myframe.vo.CarVo;
import com.example.myframe.vo.HouseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/car")
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping(value="/getAll")
    public RestResponse getAll(){
        List<CarVo> list=carService.get();
        return new RestResponse(ResultEnum.SUCCESS,list);
    }

    /**
     * 分页查询(模糊查询0)
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
        IPage<CarVo> list;
        if(!name.equals("")){
            page.setSelectStr(name);
            list=carService.getLike(page);
        }else{
            list=carService.getPage(page);
        }
        return new RestResponse(ResultEnum.SUCCESS,list);
    }

    /**
     * 空车位模糊查询
     * @param str
     * @return
     */
    @RequestMapping(value="/getNullLike")
    public RestResponse getNullLike(@RequestParam(value="str") String str){
        List<CarVo> list=carService.getNullLike(str);
        return new RestResponse(ResultEnum.SUCCESS,list);
    }

    /**
     * 修改车位的状态
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("/editStatus")
    public RestResponse editStatus(@RequestParam(value="id") int id,
                                   @RequestParam(value="status") String status){

        CarBean carBean=new CarBean();
        carBean=carService.getById(id);
        carBean.setStatus(status);
        //修改状态
        carService.updateById(carBean);
        return new RestResponse(ResultEnum.SUCCESS);
    }
}
