package com.fh.taolijie.service;

import com.fh.taolijie.controller.dto.SecondHandPostCategoryDto;
import com.fh.taolijie.exception.checked.CascadeDeleteException;

import java.util.List;

/**
 * 规定与二手帖子分类相关的操作
 * Created by wanghongfei on 15-3-5.
 */
public interface SHPostCategoryService {
    /**
     * 获取(所有)分类
     * @param firstResult
     * @param capacity
     * @return
     */
    List<SecondHandPostCategoryDto> getCategoryList(int firstResult, int capacity);

    /**
     * 根据id查找分类
     * @param cateId
     * @return
     */
    SecondHandPostCategoryDto findCategory(Integer cateId);

    /**
     * 修改一个分类
     * @param cateId
     * @param cateDto
     * @return
     */
    boolean updateCategory(Integer cateId, SecondHandPostCategoryDto cateDto);

    /**
     * 删除一个分类. 仅当该分类下没有数据时才能删除
     * @param cateId
     * @return
     */
    boolean deleteCategory(Integer cateId) throws CascadeDeleteException;
}
