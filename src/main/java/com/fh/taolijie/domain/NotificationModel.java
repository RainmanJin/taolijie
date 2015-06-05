package com.fh.taolijie.domain;

import java.util.Date;

public class NotificationModel {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification.member_id
     *
     * @mbggenerated
     */
    private Integer memberId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification.is_read
     *
     * @mbggenerated
     */
    private Integer isRead;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification.time
     *
     * @mbggenerated
     */
    private Date time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification.access_range
     *
     * @mbggenerated
     */
    private String accessRange;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notification.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification.id
     *
     * @return the value of notification.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification.id
     *
     * @param id the value for notification.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification.member_id
     *
     * @return the value of notification.member_id
     *
     * @mbggenerated
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification.member_id
     *
     * @param memberId the value for notification.member_id
     *
     * @mbggenerated
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification.title
     *
     * @return the value of notification.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification.title
     *
     * @param title the value for notification.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification.is_read
     *
     * @return the value of notification.is_read
     *
     * @mbggenerated
     */
    public Integer getIsRead() {
        return isRead;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification.is_read
     *
     * @param isRead the value for notification.is_read
     *
     * @mbggenerated
     */
    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification.time
     *
     * @return the value of notification.time
     *
     * @mbggenerated
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification.time
     *
     * @param time the value for notification.time
     *
     * @mbggenerated
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification.access_range
     *
     * @return the value of notification.access_range
     *
     * @mbggenerated
     */
    public String getAccessRange() {
        return accessRange;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification.access_range
     *
     * @param accessRange the value for notification.access_range
     *
     * @mbggenerated
     */
    public void setAccessRange(String accessRange) {
        this.accessRange = accessRange == null ? null : accessRange.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notification.content
     *
     * @return the value of notification.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notification.content
     *
     * @param content the value for notification.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}