package com.example.myframe.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("car")
@NoArgsConstructor
@AllArgsConstructor
public class CarBean extends DateBean {
    @TableId
    private int id;
    private String size;//车库尺寸
    private int userId;//住户id
    private int typeId;//类型id
    private String status;//状态
    private String img;

}
