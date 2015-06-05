package com.fh.taolijie.dao.mapper;

import com.fh.taolijie.domain.BulletinModel;
import org.springframework.stereotype.Repository;

@Repository
public interface BulletinModelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bulletin
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bulletin
     *
     * @mbggenerated
     */
    int insert(BulletinModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bulletin
     *
     * @mbggenerated
     */
    int insertSelective(BulletinModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bulletin
     *
     * @mbggenerated
     */
    BulletinModel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bulletin
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(BulletinModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bulletin
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(BulletinModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bulletin
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(BulletinModel record);
}