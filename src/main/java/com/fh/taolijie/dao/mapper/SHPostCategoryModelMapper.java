package com.fh.taolijie.dao.mapper;

import com.fh.taolijie.domain.SHPostCategoryModel;
import org.springframework.stereotype.Repository;

@Repository
public interface SHPostCategoryModelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_hand_post_category
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_hand_post_category
     *
     * @mbggenerated
     */
    int insert(SHPostCategoryModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_hand_post_category
     *
     * @mbggenerated
     */
    int insertSelective(SHPostCategoryModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_hand_post_category
     *
     * @mbggenerated
     */
    SHPostCategoryModel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_hand_post_category
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SHPostCategoryModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_hand_post_category
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(SHPostCategoryModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_hand_post_category
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SHPostCategoryModel record);
}