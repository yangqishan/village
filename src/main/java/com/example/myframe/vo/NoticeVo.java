package com.example.myframe.vo;

import com.example.myframe.entity.DateBean;
import lombok.Data;

@Data
public class NoticeVo extends DateBean {
   private int id;
   private String title;//标题
   private String content;//内容
   private String adminName;//管理员姓名
   private int adminId;//管理员id

}
