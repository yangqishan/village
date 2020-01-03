package com.example.myframe.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("notice")
@AllArgsConstructor
@NoArgsConstructor
public class NoticeBean extends DateBean {
    @TableId
    private int id;
    private String title;
    private String content;
    private int adminId;//管理员id

}
