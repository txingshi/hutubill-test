package com.exercise.hutubill.mapper;

import com.exercise.hutubill.pojo.Category;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;

import java.util.List;
import java.util.Map;

/**
 * @author LuckyMi
 * @sine 2022/9/19 14:50
 */
public interface CategoryMapper {

    //获取全部分类的统计;

    List<Category> getAllCategoryNameAndCount();

    /**
     * 增加分类属性
     * @param name
     */
    void addCategoryByName(@Param("name") String name);

    /**
     * 根据id删除分类
     * @param id
     */
    void deleteCategoryById(@Param("id") Integer id);
}
