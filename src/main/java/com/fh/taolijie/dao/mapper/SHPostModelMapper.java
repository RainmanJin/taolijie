package com.fh.taolijie.dao.mapper;

import com.fh.taolijie.domain.SHPostModel;
import com.fh.taolijie.domain.SHPostModelWithBLOBs;
import org.springframework.stereotype.Repository;

@Repository
public interface SHPostModelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_hand_post
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_hand_post
     *
     * @mbggenerated
     */
    int insert(SHPostModelWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_hand_post
     *
     * @mbggenerated
     */
    int insertSelective(SHPostModelWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_hand_post
     *
     * @mbggenerated
     */
    SHPostModelWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_hand_post
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SHPostModelWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_hand_post
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(SHPostModelWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table second_hand_post
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SHPostModel record);
}