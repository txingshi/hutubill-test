package com.exercise.hutubill.service;

import com.exercise.hutubill.pojo.Record;

import java.util.List;
import java.util.Map;

/**
 * 消费记录表业务层
 * @author LuckyMi
 * @sine 2022/9/19 21:48
 */
public interface RecordService {

    //获取本月全部消费的费用
    double getAllSpend();

    //获取今天消费的费用
    Double getToDaySpend();

    //获取本月的日均消费
    Double getAvgDaySpend();

    //本月剩余的金额
    Double thisMonthBalance(Double budget);

    //日均可用余额
    Double avgDayBalance(double thisMonthBalance);

    //添加消费信息
    void addRecordInformation(Record record);

    //获取全部消费按天分组
    List<Map<String, String>> getAllSpendBasisDay();
}
