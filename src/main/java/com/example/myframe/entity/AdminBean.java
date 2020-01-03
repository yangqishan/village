package com.example.myframe.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("admin")
@NoArgsConstructor
@AllArgsConstructor
public class AdminBean extends DateBean {
    @TableId
    private int id;
    private String name;
    private String password;
    private String level;//管理员权限
    private String img;
    private String sex;
    private int age;
    private String address;
}
