package com.exercise.hutubill.controller;

import com.exercise.hutubill.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

/**
 * 月消费报表视图
 * @author LuckyMi
 * @sine 2022/9/22 12:55
 */
@Controller
public class ExpenseController {

    @Autowired
    RecordService recordService;

    @GetMapping("/monthexpense")
    public String toMonthExpense(Model model){

        //获取全部消费按天分组
        List<Map<String, String>> everydaySpend = recordService.getAllSpendBasisDay();
        model.addAttribute("list", everydaySpend);
        return "monthexpense";
    }
}
