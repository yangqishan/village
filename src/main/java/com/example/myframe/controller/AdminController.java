package com.example.myframe.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.myframe.common.consts.ResultEnum;
import com.example.myframe.common.response.RestResponse;
import com.example.myframe.entity.AdminBean;
import com.example.myframe.entity.PageBean;
import com.example.myframe.service.*;
import com.example.myframe.vo.DataVo;
import com.example.myframe.vo.PersonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value="/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired
    private RepairService repairService;
    @Autowired
    private HouseService houseService;
    @Autowired
    private CarService carService;
    @Autowired
    private RepairOrderService repairOrderService;
    @Autowired
    private ChargeOrderService chargeOrderService;

    /**
     * 管理员登录
     * @param name
     * @param password
     * @param pagerandom
     * @param request
     * @return
     */
    @RequestMapping(value="/login")
    public RestResponse login(@RequestParam(value="name") String name,
                              @RequestParam(value="password") String password,
                              @RequestParam(value="pagerandom") String pagerandom,
                              HttpServletRequest request){
        //从session先获取验证码
        String code=request.getSession().getAttribute("random").toString();
        String message="";
        //去数据库获取账号密码
        AdminBean adminBean=adminService.getByName(name);
        if(adminBean==null){
            message="账号错误";
            System.out.println("账号错误");
        }
        else if(!password.equals(adminBean.getPassword())){
            message="密码错误";
            System.out.println("密码错误");
        }
        else if(password.equals(adminBean.getPassword())&&code.equals(pagerandom)){
            message="正确";
            System.out.println("正确");
        }else{
            message="验证码错误";
            System.out.println("验证码错误");
        }
        return new RestResponse(ResultEnum.SUCCESS,message);
    }

    /**
     * 修改密码
     * @param name
     * @param oldpwd
     * @param pwd
     * @return
     */
    @RequestMapping(value="/editPwd")
    public RestResponse editPwd(@RequestParam(value="name") String name,
                             @RequestParam(value="oldpwd") String oldpwd,
                             @RequestParam(value="pwd") String pwd){
        AdminBean adminBean=adminService.getByName(name);
        String msg="";
        if(!oldpwd.equals(adminBean.getPassword())){
            msg="原密码错误";
        }else{
            //修改密码
            adminBean.setPassword(pwd);
            adminService.updateById(adminBean);
        }
        return new RestResponse(ResultEnum.SUCCESS,msg);
    }
    @RequestMapping(value="/getAll")
    public RestResponse getAll(){
        List<AdminBean> list=adminService.get();
        return new RestResponse(ResultEnum.SUCCESS,list);
    }

    /**
     * 分页查询
     * @param name
     * @param current
     * @param size
     * @return
     */
    @RequestMapping(value="getPage")
    public RestResponse getPage(@RequestParam(value="name",defaultValue = "") String name,
                                @RequestParam(value="current",defaultValue = "1") int current,
                                @RequestParam(value = "size",defaultValue = "5") int size){
        //设置分页
        PageBean page=new PageBean<>(current,size);
        //设置查询参数
        page.setSelectStr(name);
        IPage<AdminBean> list=adminService.getPage(page);
        return new RestResponse(ResultEnum.SUCCESS,list);
    }

    /**
     * 增加管理员
     * @param name
     * @param password
     * @param level
     * @param sex
     * @param age
     */
    @RequestMapping(value="/add")
    public void addAdmin(@RequestParam(value="name") String name,
                         @RequestParam(value="password") String password,
                         @RequestParam(value="level") String level,
                         @RequestParam(value="sex") String sex,
                         @RequestParam(value="age") int age){
        AdminBean adminBean=new AdminBean();
        adminBean.setName(name);
        adminBean.setPassword(password);
        adminBean.setLevel(level);
        adminBean.setSex(sex);
        adminBean.setAge(age);
        adminService.addAdmin(adminBean);
    }

    /**
     * 编辑管理员等级
     * @param id
     * @param level
     */
    @RequestMapping(value="/edit")
    public void edit(@RequestParam(value="id") int id,
                     @RequestParam(value="level") String level){
        AdminBean adminBean=new AdminBean();
        adminBean.setId(id);
        adminBean.setLevel(level);
        adminService.edit(adminBean);
    }

    /**
     * 获取人员分类信息统计
     * @return
     */
    @RequestMapping(value="/get")
    public RestResponse get(){
        HashMap<String,Object> map=new HashMap<String,Object>();
        //分组查询用户类型和性别
        List<PersonVo> userType=userService.getTypeCount();
        List<PersonVo> userSex=userService.getSexCount();
        map.put("userType",userType);
        map.put("userSex",userSex);
        //分组查询维修员类型和性别
        List<PersonVo> repairType=repairService.getTypeCount();
        List<PersonVo> repairSex=repairService.getSexCount();
        map.put("repairType",repairType);
        map.put("repairSex",repairSex);
        return new RestResponse(ResultEnum.SUCCESS,map);
    }

    /**
     * 获取房屋车位以及订单的统计数据
     * @return
     */
    @RequestMapping(value="/getData")
    public RestResponse getData(){
        HashMap<String,Object> map=new HashMap<String,Object>();
        List<DataVo> house=houseService.getTypeCount();
        List<DataVo> car=carService.getTypeCount();
        //查到的数据存到map中
        map.put("house",house);
        map.put("car",car);
        //查询订单统计数据
        List<DataVo> repairOrder=repairOrderService.getTypeCount();
        List<DataVo> chargeOrder=chargeOrderService.getMoney();
        map.put("repairOrder",repairOrder);
        map.put("chargeOrder",chargeOrder);
        return new RestResponse(ResultEnum.SUCCESS,map);
    }
}
