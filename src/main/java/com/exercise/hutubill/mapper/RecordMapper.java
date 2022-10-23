package com.exercise.hutubill.mapper;


import com.exercise.hutubill.pojo.Record;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LuckyMi
 * @sine 2022/9/19 14:52
 */
public interface RecordMapper {
    //获取全部消费spend
    Double getAllSpend();

    //获取全部当日消费
    Double getToDaySpend();

    //添加消费信息
    void addRecordInformation(Record record);

    //根据分类id cid获取消费记录
    List<Record> getRecordBySortId(@Param("id") Integer id);

    //获取本月消费按天分组
    List<Map<String, Object>> getAllSpendBasisDay();
}
