package com.example.myframe.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.myframe.dao.NoticeDao;
import com.example.myframe.entity.NoticeBean;
import com.example.myframe.service.NoticeService;
import com.example.myframe.vo.NoticeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeDao,NoticeBean> implements NoticeService {

    @Autowired
    private NoticeDao noticeDao;

    @Override
    public List<NoticeBean> get() {
        return noticeDao.getAll();
    }

    @Override
    public IPage<NoticeVo> getPage(Page page) {
        return noticeDao.getPage(page);
    }

    @Override
    public void edit(NoticeBean noticeBean) {
        noticeDao.edit(noticeBean);
    }

    @Override
    public void add(NoticeBean noticeBean) {
        noticeDao.add(noticeBean);
    }


}
