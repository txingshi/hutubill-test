package com.exercise.hutubill.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 消费信息
 * @author LuckyMi
 * @sine 2022/9/19 14:41
 */
@Data
public class Record  {
    //键 id
    private int id;
    //本次花费
    private double spend;
    //对应消费类别id
    private int cid;
    //备注
    private String comment;
    //消费日期
    @DateTimeFormat(pattern = "yyyy-MM-dd") //用于转换接受的时间
    private Date date;
}
