package com.example.myframe.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.myframe.common.consts.ResultEnum;
import com.example.myframe.common.response.RestResponse;
import com.example.myframe.entity.NoticeBean;
import com.example.myframe.entity.PageBean;
import com.example.myframe.service.NoticeService;
import com.example.myframe.vo.NoticeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/notice")
public class noticeController {
    @Autowired
    private NoticeService noticeService;

    /**
     * 公告分页模糊查询
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
        IPage<NoticeVo> list;
        page.setSelectStr(name);
        list=noticeService.getPage(page);
        return new RestResponse(ResultEnum.SUCCESS,list);

    }

    /**
     * 修改公告的内容
     * @param id
     * @param title
     * @param content
     */
    @RequestMapping(value="/edit")
    public void edit(@RequestParam(value="id") int id,
                     @RequestParam(value="title") String title,
                     @RequestParam(value="content") String content){
        NoticeBean noticeBean=new NoticeBean();
        noticeBean.setId(id);
        noticeBean.setTitle(title);
        noticeBean.setContent(content);
        noticeService.edit(noticeBean);
    }

    /**
     * 增加公告
     * @param title
     * @param content
     * @param adminId
     */
    @RequestMapping(value="/add")
    public void add(@RequestParam(value="title") String title,
                    @RequestParam(value="content") String content,
                    @RequestParam(value ="adminId") int adminId){
        NoticeBean noticeBean=new NoticeBean();
        noticeBean.setTitle(title);
        noticeBean.setContent(content);
        noticeBean.setAdminId(adminId);
        noticeService.add(noticeBean);
    }

}
