package com.exercise.hutubill.controller;

import com.exercise.hutubill.pojo.Category;
import com.exercise.hutubill.pojo.Record;
import com.exercise.hutubill.service.CategoryService;
import com.exercise.hutubill.service.RecordService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author LuckyMi
 * @sine 2022/9/20 23:25
 */
@Controller
public class sortController {
    @Autowired
    CategoryService categoryService;

    //查询全部分类统计数量
    @GetMapping("/sort")
    public String getAllSort(Model model){
        model.addAttribute("categoryMap",categoryService.getAllCategoryNameAndCount());
        return "sort";
    }

    //增加分类
    @GetMapping("/sort/add")
    public String addCategoryByName(@RequestParam("name") String name){

        categoryService.addCategoryByName(name);
        return "redirect:/sort";
    }

    //删除分类
    @GetMapping("/sort/delete")
    public String deleteCategoryById(@RequestParam("id") Integer id){
        categoryService.deleteCategoryById(id);
        return "redirect:/sort";
    }
}
