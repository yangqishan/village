package com.example.myframe.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.myframe.entity.NoticeBean;
import com.example.myframe.vo.NoticeVo;

import java.util.List;

public interface NoticeService extends IService<NoticeBean>{
    List<NoticeBean> get();

    /**
     * 分页查询
     * @param page
     * @return
     */
    IPage<NoticeVo> getPage(Page page);


    void edit(NoticeBean noticeBean);

    void add(NoticeBean noticeBean);
}
