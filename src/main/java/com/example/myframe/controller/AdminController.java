package com.example.myframe.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.myframe.common.consts.ResultEnum;
import com.example.myframe.common.response.RestResponse;
import com.example.myframe.entity.AdminBean;
import com.example.myframe.entity.PageBean;
import com.example.myframe.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
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
}
