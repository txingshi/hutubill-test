package com.exercise.hutubill.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Category 消费分类 实体类
 * @author LuckyMi
 * @sine 2022/9/19 14:36
 */
@Data
public class Category  {
    //键 id
    private int id;
    //分类名称
    private String name;

    //外部属性
    private List<Record> recordList;
}
