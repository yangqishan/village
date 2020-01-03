package com.example.myframe.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("repair")
@AllArgsConstructor
@NoArgsConstructor
public class RepairBean extends DateBean {
    @TableId
    private int id;
    private String name;
    private int age;
    private String sex;
    private String address;
    private String tel;
    private int typeId;


}
