package com.fh.taolijie.dao.mapper;

import com.fh.taolijie.domain.ApplicationIntendModel;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationIntendModelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resume_job_post_category
     *
     * @mbggenerated
     */
    int insert(ApplicationIntendModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table resume_job_post_category
     *
     * @mbggenerated
     */
    int insertSelective(ApplicationIntendModel record);
}