package com.exercise.hutubill.controller;

import com.exercise.hutubill.pojo.Category;
import com.exercise.hutubill.pojo.Record;
import com.exercise.hutubill.service.CategoryService;
import com.exercise.hutubill.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * 记一笔页面
 * @author LuckyMi
 * @sine 2022/9/20 23:23
 */
@Controller
public class writeController {

    @Autowired
    RecordService recordService;
    @Autowired
    CategoryService categoryService;


    //写一笔页面跳转
    @GetMapping("/write")
    public String toWrite(Model model){
        List<Category> list = categoryService.getAllCategoryNameAndCount();
        model.addAttribute("categoryList", list);
        return "write";
    }

    //写一笔页面
    @PostMapping("/write")
    public String addRecordInformation(Record record){
        recordService.addRecordInformation(record);

        return "write";
    }
}
