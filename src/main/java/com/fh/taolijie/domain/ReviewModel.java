package com.fh.taolijie.domain;

import java.util.Date;

public class ReviewModel {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column review.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column review.post_id
     *
     * @mbggenerated
     */
    private Integer postId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column review.member_id
     *
     * @mbggenerated
     */
    private Integer memberId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column review.time
     *
     * @mbggenerated
     */
    private Date time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column review.replied_review_id
     *
     * @mbggenerated
     */
    private Integer repliedReviewId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column review.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column review.id
     *
     * @return the value of review.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column review.id
     *
     * @param id the value for review.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column review.post_id
     *
     * @return the value of review.post_id
     *
     * @mbggenerated
     */
    public Integer getPostId() {
        return postId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column review.post_id
     *
     * @param postId the value for review.post_id
     *
     * @mbggenerated
     */
    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column review.member_id
     *
     * @return the value of review.member_id
     *
     * @mbggenerated
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column review.member_id
     *
     * @param memberId the value for review.member_id
     *
     * @mbggenerated
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column review.time
     *
     * @return the value of review.time
     *
     * @mbggenerated
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column review.time
     *
     * @param time the value for review.time
     *
     * @mbggenerated
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column review.replied_review_id
     *
     * @return the value of review.replied_review_id
     *
     * @mbggenerated
     */
    public Integer getRepliedReviewId() {
        return repliedReviewId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column review.replied_review_id
     *
     * @param repliedReviewId the value for review.replied_review_id
     *
     * @mbggenerated
     */
    public void setRepliedReviewId(Integer repliedReviewId) {
        this.repliedReviewId = repliedReviewId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column review.content
     *
     * @return the value of review.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column review.content
     *
     * @param content the value for review.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}