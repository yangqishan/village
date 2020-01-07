package com.example.myframe.vo;

import com.example.myframe.entity.DateBean;
import lombok.Data;

@Data
public class CarVo extends DateBean {
    private int id;
    private String position;
    private String name;
    private String type;
    private String size;
    private String status;
}
