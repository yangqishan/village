package com.example.myframe.vo;

import com.example.myframe.entity.DateBean;
import lombok.Data;

@Data
public class ChargeOrderVo extends DateBean {
    private int id;
    private String title;
    private String adminName;
    private String userName;
    private String housePosition;
    private String type;
    private int money;
    private String status;
}
