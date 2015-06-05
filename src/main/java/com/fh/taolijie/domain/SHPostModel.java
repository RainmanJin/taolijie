package com.fh.taolijie.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SHPostModel {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_hand_post.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_hand_post.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_hand_post.expired_time
     *
     * @mbggenerated
     */
    private Date expiredTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_hand_post.post_time
     *
     * @mbggenerated
     */
    private Date postTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_hand_post.depreciation_rate
     *
     * @mbggenerated
     */
    private String depreciationRate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_hand_post.original_price
     *
     * @mbggenerated
     */
    private BigDecimal originalPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_hand_post.sell_price
     *
     * @mbggenerated
     */
    private BigDecimal sellPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_hand_post.likes
     *
     * @mbggenerated
     */
    private Integer likes;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_hand_post.dislikes
     *
     * @mbggenerated
     */
    private Integer dislikes;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_hand_post.member_id
     *
     * @mbggenerated
     */
    private Integer memberId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_hand_post.second_hand_post_category_id
     *
     * @mbggenerated
     */
    private Integer secondHandPostCategoryId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_hand_post.complaint
     *
     * @mbggenerated
     */
    private Integer complaint;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_hand_post.page_view
     *
     * @mbggenerated
     */
    private Integer pageView;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_hand_post.verified
     *
     * @mbggenerated
     */
    private String verified;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column second_hand_post.trade_place
     *
     * @mbggenerated
     */
    private String tradePlace;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_hand_post.id
     *
     * @return the value of second_hand_post.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_hand_post.id
     *
     * @param id the value for second_hand_post.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_hand_post.title
     *
     * @return the value of second_hand_post.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_hand_post.title
     *
     * @param title the value for second_hand_post.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_hand_post.expired_time
     *
     * @return the value of second_hand_post.expired_time
     *
     * @mbggenerated
     */
    public Date getExpiredTime() {
        return expiredTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_hand_post.expired_time
     *
     * @param expiredTime the value for second_hand_post.expired_time
     *
     * @mbggenerated
     */
    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_hand_post.post_time
     *
     * @return the value of second_hand_post.post_time
     *
     * @mbggenerated
     */
    public Date getPostTime() {
        return postTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_hand_post.post_time
     *
     * @param postTime the value for second_hand_post.post_time
     *
     * @mbggenerated
     */
    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_hand_post.depreciation_rate
     *
     * @return the value of second_hand_post.depreciation_rate
     *
     * @mbggenerated
     */
    public String getDepreciationRate() {
        return depreciationRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_hand_post.depreciation_rate
     *
     * @param depreciationRate the value for second_hand_post.depreciation_rate
     *
     * @mbggenerated
     */
    public void setDepreciationRate(String depreciationRate) {
        this.depreciationRate = depreciationRate == null ? null : depreciationRate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_hand_post.original_price
     *
     * @return the value of second_hand_post.original_price
     *
     * @mbggenerated
     */
    public BigDecimal getOriginalPrice() {
        return originalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_hand_post.original_price
     *
     * @param originalPrice the value for second_hand_post.original_price
     *
     * @mbggenerated
     */
    public void setOriginalPrice(BigDecimal originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_hand_post.sell_price
     *
     * @return the value of second_hand_post.sell_price
     *
     * @mbggenerated
     */
    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_hand_post.sell_price
     *
     * @param sellPrice the value for second_hand_post.sell_price
     *
     * @mbggenerated
     */
    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_hand_post.likes
     *
     * @return the value of second_hand_post.likes
     *
     * @mbggenerated
     */
    public Integer getLikes() {
        return likes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_hand_post.likes
     *
     * @param likes the value for second_hand_post.likes
     *
     * @mbggenerated
     */
    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_hand_post.dislikes
     *
     * @return the value of second_hand_post.dislikes
     *
     * @mbggenerated
     */
    public Integer getDislikes() {
        return dislikes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_hand_post.dislikes
     *
     * @param dislikes the value for second_hand_post.dislikes
     *
     * @mbggenerated
     */
    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_hand_post.member_id
     *
     * @return the value of second_hand_post.member_id
     *
     * @mbggenerated
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_hand_post.member_id
     *
     * @param memberId the value for second_hand_post.member_id
     *
     * @mbggenerated
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_hand_post.second_hand_post_category_id
     *
     * @return the value of second_hand_post.second_hand_post_category_id
     *
     * @mbggenerated
     */
    public Integer getSecondHandPostCategoryId() {
        return secondHandPostCategoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_hand_post.second_hand_post_category_id
     *
     * @param secondHandPostCategoryId the value for second_hand_post.second_hand_post_category_id
     *
     * @mbggenerated
     */
    public void setSecondHandPostCategoryId(Integer secondHandPostCategoryId) {
        this.secondHandPostCategoryId = secondHandPostCategoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_hand_post.complaint
     *
     * @return the value of second_hand_post.complaint
     *
     * @mbggenerated
     */
    public Integer getComplaint() {
        return complaint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_hand_post.complaint
     *
     * @param complaint the value for second_hand_post.complaint
     *
     * @mbggenerated
     */
    public void setComplaint(Integer complaint) {
        this.complaint = complaint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_hand_post.page_view
     *
     * @return the value of second_hand_post.page_view
     *
     * @mbggenerated
     */
    public Integer getPageView() {
        return pageView;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_hand_post.page_view
     *
     * @param pageView the value for second_hand_post.page_view
     *
     * @mbggenerated
     */
    public void setPageView(Integer pageView) {
        this.pageView = pageView;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_hand_post.verified
     *
     * @return the value of second_hand_post.verified
     *
     * @mbggenerated
     */
    public String getVerified() {
        return verified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_hand_post.verified
     *
     * @param verified the value for second_hand_post.verified
     *
     * @mbggenerated
     */
    public void setVerified(String verified) {
        this.verified = verified == null ? null : verified.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column second_hand_post.trade_place
     *
     * @return the value of second_hand_post.trade_place
     *
     * @mbggenerated
     */
    public String getTradePlace() {
        return tradePlace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column second_hand_post.trade_place
     *
     * @param tradePlace the value for second_hand_post.trade_place
     *
     * @mbggenerated
     */
    public void setTradePlace(String tradePlace) {
        this.tradePlace = tradePlace == null ? null : tradePlace.trim();
    }
}