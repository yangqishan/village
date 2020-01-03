package com.example.myframe.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("house")
@AllArgsConstructor
@NoArgsConstructor
public class HouseBean extends DateBean{
    @TableId
    private int id;
    private String position;
    private int userId;//用户id
    private String area;//房屋面积
    private int typeId;//类型id
}
