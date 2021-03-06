package com.fh.taolijie.domain.v2;

import com.fh.taolijie.domain.Pageable;

public class SchoolActCategoryModel extends Pageable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_activity_category.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_activity_category.name
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_activity_category.level
     *
     * @mbggenerated
     */
    private Integer level;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_activity_category.theme_color
     *
     * @mbggenerated
     */
    private String themeColor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_activity_category.memo
     *
     * @mbggenerated
     */
    private String memo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_activity_category.id
     *
     * @return the value of school_activity_category.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_activity_category.id
     *
     * @param id the value for school_activity_category.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_activity_category.name
     *
     * @return the value of school_activity_category.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_activity_category.name
     *
     * @param name the value for school_activity_category.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_activity_category.level
     *
     * @return the value of school_activity_category.level
     *
     * @mbggenerated
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_activity_category.level
     *
     * @param level the value for school_activity_category.level
     *
     * @mbggenerated
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_activity_category.theme_color
     *
     * @return the value of school_activity_category.theme_color
     *
     * @mbggenerated
     */
    public String getThemeColor() {
        return themeColor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_activity_category.theme_color
     *
     * @param themeColor the value for school_activity_category.theme_color
     *
     * @mbggenerated
     */
    public void setThemeColor(String themeColor) {
        this.themeColor = themeColor == null ? null : themeColor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_activity_category.memo
     *
     * @return the value of school_activity_category.memo
     *
     * @mbggenerated
     */
    public String getMemo() {
        return memo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_activity_category.memo
     *
     * @param memo the value for school_activity_category.memo
     *
     * @mbggenerated
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }
}