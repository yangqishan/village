package com.example.myframe.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.myframe.common.consts.ResultEnum;
import com.example.myframe.common.response.RestResponse;
import com.example.myframe.entity.CarBean;
import com.example.myframe.entity.HouseBean;
import com.example.myframe.entity.PageBean;
import com.example.myframe.entity.UserBean;
import com.example.myframe.service.CarService;
import com.example.myframe.service.HouseService;
import com.example.myframe.service.UserService;
import com.example.myframe.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 住户的增改查操作
 * author Dream
 */
@RestController
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private HouseService houseService;
    @Autowired
    private CarService carService;

    /**
     * 模糊查询
     * @param name
     * @return
     */
    @RequestMapping(value="get")
    public RestResponse get(@RequestParam(value="name") String name,
                            @RequestParam(value="current",defaultValue = "1") int current,
                            @RequestParam(value = "size",defaultValue = "5") int size){
        //设置分页
        PageBean page=new PageBean<>(current,size);
        //设置查询参数
        page.setSelectStr(name);
        IPage<UserBean> list=userService.get(page);
        return new RestResponse(ResultEnum.SUCCESS,list);
    }
    /**
     * 查找用户
     * @return
     */
    @RequestMapping(value = "/getAll")
    public RestResponse getAll(@RequestParam(value="name",defaultValue = "") String name,
                               @RequestParam(value="current",defaultValue = "1") int current,
                               @RequestParam(value = "size",defaultValue = "5") int size){
        //设置分页
        PageBean page=new PageBean<>(current,size);
        IPage<UserBean> list=userService.getAll(page);
        return new RestResponse(ResultEnum.SUCCESS,list);
    }

    /**
     * 添加用户
     * @return
     */
    @RequestMapping(value="/add")
    public RestResponse add(@RequestParam(value="name") String name,
                                @RequestParam(value="age") int age,
                                @RequestParam(value="sex") String sex,
                                @RequestParam(value="content",defaultValue = "") String content,
                                @RequestParam(value="typeId") int typeId,
                                @RequestParam(value="img",defaultValue = "") String img,
                                @RequestParam(value="memo",defaultValue = "") String memo,
                                @RequestParam(value="tel") String tel,
                                @RequestParam(value="houseId") int houseId,
                                @RequestParam(value="carId") int carId){
        UserBean userBean=new UserBean();
        userBean.setName(name);
        userBean.setAge(age);
        userBean.setSex(sex);
        userBean.setContent(content);
        userBean.setTypeId(typeId);
        userBean.setImg(img);
        userBean.setMemo(memo);
        userBean.setTel(tel);
        userService.addUser(userBean);
        //重新查询刚刚加进去的
        UserBean userBean1=userService.getByname(userBean.getName());
        //给楼房修改数值
        HouseBean houseBean=new HouseBean();
        houseBean.setUserId(userBean1.getId());
        houseBean.setId(houseId);
        houseBean.setStatus("预定");
        houseService.updateById(houseBean);
        ////给车位修改数值
        CarBean carBean=new CarBean();
        carBean.setId(carId);
        carBean.setUserId(userBean1.getId());
        carBean.setStatus("预定");
        carService.updateById(carBean);
        return new RestResponse(ResultEnum.SUCCESS);
    }

    /**
     * 修改用户信息
     * @param id
     * @param content
     * @param typeId
     * @param houseStatus
     * @param carStatus
     * @param tel
     * @return
     */
    @RequestMapping(value="/update")
    public RestResponse update(@RequestParam(value="id") int id,
                               @RequestParam(value="content") String content,
                               @RequestParam(value="typeId") int typeId,
                               @RequestParam(value="houseStatus") String houseStatus,
                               @RequestParam(value="carStatus") String carStatus,
                               @RequestParam(value="tel") String tel){
        UserBean userBean=new UserBean();
        userBean.setId(id);
        userBean.setContent(content);
        userBean.setTypeId(typeId);
        userBean.setTel(tel);
        //修改用户的数值
        userService.UpdateUser(userBean);
        HouseBean houseBean=new HouseBean();
        houseBean.setStatus(houseStatus);
        houseBean.setUserId(id);
        //修改楼房的数值
        houseService.updatebyuserId(houseBean);
        CarBean carBean=new CarBean();
        carBean.setStatus(carStatus);
        carBean.setUserId(id);
        //修改车位的数值
        carService.updatebyuserId(carBean);
        return new RestResponse(ResultEnum.SUCCESS,userBean);
    }

    /**
     * 查询用户详细信息
     * @param id
     * @return
     */
    @RequestMapping(value="/getbyid")
    public RestResponse getbyid(@RequestParam(value="id") int id){
        UserVo userVo=userService.getbyid(id);
        return new RestResponse(ResultEnum.SUCCESS,userVo);
    }
}
