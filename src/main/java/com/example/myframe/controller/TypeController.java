package com.example.myframe.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.myframe.common.consts.ResultEnum;
import com.example.myframe.common.response.RestResponse;
import com.example.myframe.entity.PageBean;
import com.example.myframe.entity.TypeBean;
import com.example.myframe.service.TypeService;
import com.example.myframe.vo.RepairVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 类型控制层
 */
@RestController
@RequestMapping(value="/type")
public class TypeController {
    @Autowired
    private TypeService typeService;


    /**
     * 查询所有的维修员的类型
     * @return
     */
    @RequestMapping(value="/getAll")
    public RestResponse getAll(){
        List<TypeBean> list=typeService.get();
        return new RestResponse(ResultEnum.SUCCESS,list);
    }

    /**
     * 类型分类查询（，模糊查询）
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
        IPage<TypeBean> list;
        page.setSelectStr(name);
        list=typeService.getPage(page);
        return new RestResponse(ResultEnum.SUCCESS,list);

    }

    /**
     * 添加类型
     * @param content
     * @param memo
     */
    @RequestMapping(value="/addType")
    public void addType(@RequestParam(value="content") String content,
                        @RequestParam(value="memo") String memo){
        TypeBean typeBean=new TypeBean();
        typeBean.setContent(content);
        typeBean.setMemo(memo);
        typeService.addType(typeBean);
    }

    /**
     * 删除类型
     * @param id
     */
    @RequestMapping(value="/del")
    public void del(@RequestParam(value="id") int id){
        typeService.removeById(id);
    }
}
