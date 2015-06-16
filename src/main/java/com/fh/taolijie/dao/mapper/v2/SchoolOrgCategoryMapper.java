package com.fh.taolijie.dao.mapper.v2;

import com.fh.taolijie.domain.v2.SchoolOrgCategory;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolOrgCategoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_organization_category
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_organization_category
     *
     * @mbggenerated
     */
    int insert(SchoolOrgCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_organization_category
     *
     * @mbggenerated
     */
    int insertSelective(SchoolOrgCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_organization_category
     *
     * @mbggenerated
     */
    SchoolOrgCategory selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_organization_category
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SchoolOrgCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_organization_category
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(SchoolOrgCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table school_organization_category
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SchoolOrgCategory record);
}