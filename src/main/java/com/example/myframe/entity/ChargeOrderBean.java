package com.example.myframe.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("chargeorder")
@AllArgsConstructor
@NoArgsConstructor
public class ChargeOrderBean extends DateBean{
    @TableId
    private int id;
    private String title;
    private int adminId;
    private int userId;
    private int houseId;
    private String status;
    private int typeId;
    private int money;
}
