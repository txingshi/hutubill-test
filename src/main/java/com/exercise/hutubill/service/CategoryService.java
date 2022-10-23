package com.exercise.hutubill.service;

import com.exercise.hutubill.pojo.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 分类表的业务层
 * @author LuckyMi
 * @sine 2022/9/19 21:48
 */
public interface CategoryService {
    //获取全部分类统计数据
    List<Category> getAllCategoryNameAndCount();

    //增加分类属性
    void addCategoryByName(String name);

    /**
     * 根据id删除分类 ， 这里要开启事务进行判断，此类设置为外键类 所以有数据删除时数据库会报错 就删除失败
     * @param id
     */
    void deleteCategoryById(Integer id);
}
