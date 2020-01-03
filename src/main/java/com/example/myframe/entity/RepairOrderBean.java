package com.example.myframe.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("repairorder")
@AllArgsConstructor
@NoArgsConstructor
public class RepairOrderBean extends DateBean{
    @TableId
    private int id;
    private String title;//维修订单标题
    private int repairId;//维修员id
    private int userId;//用户id
    private int houseId;//房屋id
    private String status;//状态
    private int typeId;//类型id
}
