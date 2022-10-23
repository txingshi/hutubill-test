package com.exercise.hutubill.service.impl;

import com.exercise.hutubill.mapper.RecordMapper;
import com.exercise.hutubill.pojo.Record;
import com.exercise.hutubill.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author LuckyMi
 * @sine 2022/9/19 21:50
 */
@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    RecordMapper recordMapper;

    /**
     * 查询本月全部消费
     * @return double
     */
    @Override
    public double getAllSpend() {
        if (recordMapper.getAllSpend() == null)
            return 0.0;
        return recordMapper.getAllSpend();
    }

    /**
     * 查询今日全部消费
     * @return
     */
    @Override
    public Double getToDaySpend() {
        if (recordMapper.getToDaySpend() == null)
            return 0.0;
        return recordMapper.getToDaySpend();
    }

    /**
     * 获取本月日均消费
     * @return
     */
    @Override
    public Double getAvgDaySpend() {
        //获取本月的总天数
        Calendar thisMonthDay = Calendar.getInstance();
        thisMonthDay.set(Calendar.DATE, 1); //将今天设为1号
        thisMonthDay.roll(Calendar.DATE, -1); //日期减一天相当于回到了本月的最后一天
        if (recordMapper.getAllSpend() == null)
            return 0.0;
        return recordMapper.getAllSpend() / thisMonthDay.get(Calendar.DATE);
    }


    /**
     * 本月剩余
     * @param budget
     * @return
     */
    @Override
    public Double thisMonthBalance(Double budget) {

        return budget - recordMapper.getAllSpend();
    }

    /**
     * 日均可用余额
     * @param thisMonthBalance
     * @return
     */
    @Override
    public Double avgDayBalance(double thisMonthBalance) {
        Calendar calendar = Calendar.getInstance();
        int toDay = calendar.get(Calendar.DAY_OF_MONTH);
        int last = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int dayResidue =last - toDay;
        return thisMonthBalance / (dayResidue > 0 ? dayResidue : 1);
    }

    /**
     * 添加消费信息
     * @param record
     */
    @Override
    public void addRecordInformation(Record record) {
        recordMapper.addRecordInformation(record);
    }

    /**
     * 获取本月消费按天分组
     *
     * @return
     */
    @Override
    public List<Map<String, String>> getAllSpendBasisDay() {

        List<Map<String, String>> listMaps = new ArrayList<>();
        HashMap<String, String> hashMap;

        for (Map<String, Object> map : recordMapper.getAllSpendBasisDay()) {
            //每次存储都是一个新的map对象
            hashMap = new LinkedHashMap<>();
            for (String key : map.keySet()) {
                if (key.equals("spend")){
                    hashMap.put(key, String.valueOf(map.get(key)));
                }
                if (key.equals("date")){
                    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                    String dateStr = fmt.format(map.get(key));
                    //获取日期中的天数
                    hashMap.put(key, dateStr.substring(8));
                }

            }
            //把map保存到list中
            listMaps.add(hashMap);
        }
        return listMaps;
    }
}
