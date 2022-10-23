package com.exercise.hutubill.controller;

import com.exercise.hutubill.pojo.Record;
import com.exercise.hutubill.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * 消费一览页面
 * @author LuckyMi
 * @sine 2022/9/19 15:57
 */
@Controller
public class overViewController {

    @Autowired
    RecordService recordService;

    //设置预算的页面跳转和 业务跳转
    @GetMapping("/set.html")
    public String setBudget(@RequestParam("budget") double budget
                            , HttpSession session
                            , Model model){
        //获取Session
        //if (StringUtils.isEmpty(budget))
        session.setAttribute("budget", budget);

        return "redirect:overview";
    }

    //消费一览的页面跳转
    @GetMapping("/overview")
    public String toOverView(HttpSession session, Model model){

        //获取总预算
        Double budget = (Double) session.getAttribute("budget");

        //本月消费， 今日消费， 日均消费，本月剩余, 日均可用, 进度条
        double thisMonthSpend = recordService.getAllSpend();
        double toDaySpend =  recordService.getToDaySpend();
        double thisMonthBalance = recordService.thisMonthBalance(budget);
        double percent = thisMonthSpend / budget * 100;
        model.addAttribute("thisMonthSpend", thisMonthSpend);
        model.addAttribute("toDaySpend", toDaySpend);
        model.addAttribute("avgDaySpend", recordService.getAvgDaySpend());
        model.addAttribute("thisMonthBalance", thisMonthBalance);
        model.addAttribute("avgDayBalance", recordService.avgDayBalance(thisMonthBalance));
        model.addAttribute("percent", percent > 100 ? 100 : percent);


        return "overview";
    }


}
