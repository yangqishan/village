package com.example.myframe.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.myframe.common.consts.ResultEnum;
import com.example.myframe.common.response.RestResponse;
import com.example.myframe.entity.HouseBean;
import com.example.myframe.entity.PageBean;
import com.example.myframe.service.HouseService;
import com.example.myframe.vo.HouseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/house")
public class HouseController {
    @Autowired
    private HouseService houseService;

    /**
     * 查询所有楼房
     * @return
     */
    @RequestMapping(value="/getAll")
    public RestResponse getAll(){
        List<HouseVo> list=houseService.get();
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
        IPage<HouseVo> list;
        if(!name.equals("")){
            page.setSelectStr(name);
            list=houseService.getLike(page);
        }else{
            list=houseService.getPage(page);
        }
        return new RestResponse(ResultEnum.SUCCESS,list);
    }

    /**
     * 空楼模糊查询
     * @param str
     * @return
     */
    @RequestMapping(value="/getNullLike")
    public RestResponse getNullLike(@RequestParam(value="str") String str){
        List<HouseVo> list=houseService.getNullLike(str);
        return new RestResponse(ResultEnum.SUCCESS,list);
    }

    /**
     * 修改楼房的状态
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("/editStatus")
    public RestResponse editStatus(@RequestParam(value="id") int id,
                                   @RequestParam(value="status") String status){
        HouseBean houseBean=new HouseBean();
        houseBean=houseService.getById(id);
        houseBean.setStatus(status);
        //修改状态
        houseService.updateById(houseBean);
        return new RestResponse(ResultEnum.SUCCESS);
    }
}
