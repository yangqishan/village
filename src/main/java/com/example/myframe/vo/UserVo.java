package com.example.myframe.vo;

import com.example.myframe.entity.DateBean;
import lombok.Data;

@Data
public class UserVo extends DateBean{
    private int id;
    private String name;
    private int age;
    private String sex;
    private String content;
    private String tel;
    private String img;//用户头像
    private String level;
    private String housePosition;//楼房地址
    private String area;
    private String houseStatus;
    private String carPosition;//车位地址
    private String size;
    private String carStatus;
}
