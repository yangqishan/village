package com.example.myframe.vo;

import com.example.myframe.entity.DateBean;
import lombok.Data;

/**
 * 维修员详情信息
 */
@Data
public class RepairVO extends DateBean {
    private int id;
    private String name;
    private int age;
    private String sex;
    private String address;
    private String tel;
    private String type;//维修员类型
    private String typeId;//类型id
    private String content;
}
