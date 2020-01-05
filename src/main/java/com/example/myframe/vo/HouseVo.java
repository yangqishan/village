package com.example.myframe.vo;

import com.example.myframe.entity.DateBean;
import lombok.Data;

@Data
public class HouseVo extends DateBean {
    private int id;
    private String position;//楼房位置
    private String name;//住户姓名
    private String type;//房屋类型
    private String area;//房屋面积
    private String status;//状态
}
