package com.example.myframe.vo;

import com.example.myframe.entity.DateBean;
import lombok.Data;

@Data
public class RepairOrderVo extends DateBean {
    private int id;
    private String title;
    private String repairName;
    private String userName;
    private String housePosition;
    private String type;
    private String status;
}
