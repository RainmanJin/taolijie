package com.fh.taolijie.dao.mapper;

import com.fh.taolijie.domain.ApplicationIntendModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    void delete(ApplicationIntendModel model);

    List<ApplicationIntendModel> getByIntend(@Param("categoryId") Integer categoryId, @Param("pageNumber") int pageNumber, @Param("pageSize") int pageSize);
    List<ApplicationIntendModel> getByResume(@Param("resumeId") Integer resumeId);
}