package com.fh.taolijie.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class ResumeModel extends Pageable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.id
     *
     * @mbggenerated
     */
    private Integer id;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.experience
     *
     * @mbggenerated
     */
    @NotNull
    @Length(min = 15, max = 500)
    private String experience;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.introduce
     *
     * @mbggenerated
     */
    @NotNull
    @Length(min = 15, max = 200)
    private String introduce;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.name
     *
     * @mbggenerated
     */
    @NotNull
    @Length(max = 10)
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.gender
     *
     * @mbggenerated
     */
    @NotNull
    @Length(max = 4)
    private String gender;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.age
     *
     * @mbggenerated
     */
    private Integer age;

    @NotNull
    @Min(50) @Max(260)
    private Integer height;

    private String photoPath;

    @Email
    private String email;

    @Length(max = 20)
    private String qq;

    private Integer memberId;

    private String accessAuthority;

    private Integer pageView;

    private String verified;

    private Integer photoId;

    private Date createdTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.phone_number
     *
     * @mbggenerated
     */
    @NotNull
    @Length(max = 30)
    private String phoneNumber;

    private String spareTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.wechat_account
     *
     * @mbggenerated
     */
    @Length(max = 20)
    private String wechatAccount;

    @NotNull
    @Length(max = 20)
    private String major;

    @NotNull
    @Length(max = 20)
    private String school;

    @NotNull
    @Length(max = 10)
    private String preferredProvince;
    @NotNull
    @Length(max = 10)
    private String preferredCity;
    @NotNull
    @Length(max = 10)
    private String preferredRegion;

    private MemberModel member;

    public ResumeModel() {}
    public ResumeModel(int pageNumber, int pageSize) {
        super(pageNumber, pageSize);
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public MemberModel getMember() {
        return member;
    }

    public void setMember(MemberModel member) {
        this.member = member;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPreferredProvince() {
        return preferredProvince;
    }

    public void setPreferredProvince(String preferredProvince) {
        this.preferredProvince = preferredProvince;
    }

    public String getPreferredCity() {
        return preferredCity;
    }

    public void setPreferredCity(String preferredCity) {
        this.preferredCity = preferredCity;
    }

    public String getPreferredRegion() {
        return preferredRegion;
    }

    public void setPreferredRegion(String preferredRegion) {
        this.preferredRegion = preferredRegion;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.id
     *
     * @return the value of resume.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.id
     *
     * @param id the value for resume.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpareTime() {
        return spareTime;
    }

    public void setSpareTime(String spareTime) {
        this.spareTime = spareTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.name
     *
     * @return the value of resume.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.name
     *
     * @param name the value for resume.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.gender
     *
     * @return the value of resume.gender
     *
     * @mbggenerated
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.gender
     *
     * @param gender the value for resume.gender
     *
     * @mbggenerated
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.age
     *
     * @return the value of resume.age
     *
     * @mbggenerated
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.age
     *
     * @param age the value for resume.age
     *
     * @mbggenerated
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.height
     *
     * @return the value of resume.height
     *
     * @mbggenerated
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.height
     *
     * @param height the value for resume.height
     *
     * @mbggenerated
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.photo_path
     *
     * @return the value of resume.photo_path
     *
     * @mbggenerated
     */
    public String getPhotoPath() {
        return photoPath;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.photo_path
     *
     * @param photoPath the value for resume.photo_path
     *
     * @mbggenerated
     */
    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath == null ? null : photoPath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.email
     *
     * @return the value of resume.email
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.email
     *
     * @param email the value for resume.email
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.qq
     *
     * @return the value of resume.qq
     *
     * @mbggenerated
     */
    public String getQq() {
        return qq;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.qq
     *
     * @param qq the value for resume.qq
     *
     * @mbggenerated
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.member_id
     *
     * @return the value of resume.member_id
     *
     * @mbggenerated
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.member_id
     *
     * @param memberId the value for resume.member_id
     *
     * @mbggenerated
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.access_authority
     *
     * @return the value of resume.access_authority
     *
     * @mbggenerated
     */
    public String getAccessAuthority() {
        return accessAuthority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.access_authority
     *
     * @param accessAuthority the value for resume.access_authority
     *
     * @mbggenerated
     */
    public void setAccessAuthority(String accessAuthority) {
        this.accessAuthority = accessAuthority == null ? null : accessAuthority.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.page_view
     *
     * @return the value of resume.page_view
     *
     * @mbggenerated
     */
    public Integer getPageView() {
        return pageView;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.page_view
     *
     * @param pageView the value for resume.page_view
     *
     * @mbggenerated
     */
    public void setPageView(Integer pageView) {
        this.pageView = pageView;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.verified
     *
     * @return the value of resume.verified
     *
     * @mbggenerated
     */
    public String getVerified() {
        return verified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.verified
     *
     * @param verified the value for resume.verified
     *
     * @mbggenerated
     */
    public void setVerified(String verified) {
        this.verified = verified == null ? null : verified.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.photo_id
     *
     * @return the value of resume.photo_id
     *
     * @mbggenerated
     */
    public Integer getPhotoId() {
        return photoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.photo_id
     *
     * @param photoId the value for resume.photo_id
     *
     * @mbggenerated
     */
    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.phone_number
     *
     * @return the value of resume.phone_number
     *
     * @mbggenerated
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.phone_number
     *
     * @param phoneNumber the value for resume.phone_number
     *
     * @mbggenerated
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.wechat_account
     *
     * @return the value of resume.wechat_account
     *
     * @mbggenerated
     */
    public String getWechatAccount() {
        return wechatAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.wechat_account
     *
     * @param wechatAccount the value for resume.wechat_account
     *
     * @mbggenerated
     */
    public void setWechatAccount(String wechatAccount) {
        this.wechatAccount = wechatAccount == null ? null : wechatAccount.trim();
    }
}