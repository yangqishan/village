package com.example.myframe.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.myframe.common.consts.ResultEnum;
import com.example.myframe.common.response.RestResponse;
import com.example.myframe.entity.PageBean;
import com.example.myframe.entity.RepairBean;
import com.example.myframe.entity.TypeBean;
import com.example.myframe.service.RepairService;
import com.example.myframe.service.TypeService;
import com.example.myframe.vo.HouseVo;
import com.example.myframe.vo.RepairVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 维修员控制层
 */
@RestController
@RequestMapping(value="/repair")
public class RepairController {

    @Autowired
    private RepairService repairService;
    @Autowired
    private TypeService typeService;
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

    /**
     * 增加新的维修工
     * @param name
     * @param age
     * @param sex
     * @param tel
     * @param address
     * @param typeId
     */
    @RequestMapping(value="/addRepair")
    public void addRepair(@RequestParam(value="name") String name,
                          @RequestParam(value="age") int age,
                          @RequestParam(value="sex") String sex,
                          @RequestParam(value="tel") String tel,
                          @RequestParam(value="address") String address,
                          @RequestParam(value="typeId") int typeId){
        RepairBean repairBean=new RepairBean();
        repairBean.setName(name);
        repairBean.setAge(age);
        repairBean.setSex(sex);
        repairBean.setTel(tel);
        repairBean.setAddress(address);
        repairBean.setTypeId(typeId);
        //添加到数据库
        repairService.addRepair(repairBean);
    }

    @RequestMapping(value="/getbyid")
    public RestResponse getbyid(@RequestParam(value="repairId") int repairId){
        Map<String,Object> map=new HashMap<String,Object>();
        RepairVO repairVO=new RepairVO();
        //获取维修员的基本信息
        repairVO=repairService.getbyid(repairId);
        map.put("repair",repairVO);
        //获取所有类型(修理工)
        List<TypeBean> list=typeService.get();
        map.put("type",list);
        return new RestResponse(ResultEnum.SUCCESS,map);
    }

    /**
     * 修改维修工的基本信息
     * @param id
     * @param tel
     * @param typeId
     * @param content
     * @param address
     */
    @RequestMapping(value="/updateRepair")
    public void updateRepair(@RequestParam(value="id") int id,
                             @RequestParam(value="tel") String tel,
                             @RequestParam(value="typeId") int typeId,
                             @RequestParam(value="content") String content,
                             @RequestParam(value="address") String address){

        RepairBean repairBean=new RepairBean();
        repairBean.setId(id);
        repairBean.setTypeId(typeId);
        repairBean.setAddress(address);
        repairBean.setMemo(content);
        repairBean.setTel(tel);
        //修改维修工的信息
        repairService.updateRepair(repairBean);
    }

}
