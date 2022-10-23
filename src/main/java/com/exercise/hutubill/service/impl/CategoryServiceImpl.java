package com.exercise.hutubill.service.impl;

import com.exercise.hutubill.mapper.CategoryMapper;
import com.exercise.hutubill.pojo.Category;
import com.exercise.hutubill.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LuckyMi
 * @sine 2022/9/19 21:51
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    /**
     * 获取全部分类的统计
     * @return
     */
    @Override
    public List<Category> getAllCategoryNameAndCount() {

        //Map<String, Integer> map = new HashMap<>();
        //List<Category> categoryInfo = ;
        //for (Category category : categoryInfo) {
        //    map.put(category.getName(), category.getRecordList().size());
        //}
        return categoryMapper.getAllCategoryNameAndCount();
    }

    /**
     * 增加分类属性
     * @param name
     */
    @Override
    public void addCategoryByName(String name) {
        categoryMapper.addCategoryByName(name);
    }

    /**
     * 根据id删除分类， 没有设置主外键的情况下需要开启事务
     * @param id
     */
    @Override
    public void deleteCategoryById(Integer id) {
        categoryMapper.deleteCategoryById(id);
    }
}
