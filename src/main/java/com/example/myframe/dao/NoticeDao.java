package com.example.myframe.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.myframe.entity.NoticeBean;
import com.example.myframe.vo.NoticeVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface NoticeDao  extends BaseMapper<NoticeBean>{
    List<NoticeBean> getAll();

    IPage<NoticeVo> getPage(Page page);

    void edit(NoticeBean noticeBean);

    void add(NoticeBean noticeBean);
}
