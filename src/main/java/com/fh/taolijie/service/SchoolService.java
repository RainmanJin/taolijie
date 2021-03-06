package com.fh.taolijie.service;

import com.fh.taolijie.domain.AcademyModel;
import com.fh.taolijie.domain.SchoolModel;
import com.fh.taolijie.exception.checked.CascadeDeleteException;
import com.fh.taolijie.utils.ObjWrapper;

import java.util.List;

/**
 * 规定与school(学校), academy(学院)有关的CRUD操作.
 * Created by wanghongfei on 15-3-4.
 */
public interface SchoolService {
    /**
     * 得到所有的学校信息
     * @return
     */
    List<SchoolModel> getSchoolList(int firstResult, int capacity, ObjWrapper wrapper);

    /**
     * 得到某一省份的所有学校
     * @param province 省名
     * @return
     */
    List<SchoolModel> getSchoolListByProvince(String province, int firstResult, int capacity, ObjWrapper wrapper);

    /**
     * 根据id查找学校
     * @param schoolId {@link SchoolModel}实体的主键值.
     * @return 查找成功返回找到的对象，查找失败返回{@code null}.
     */
    SchoolModel findSchool(Integer schoolId);

    /**
     * 添加一所新学校
     * @param schoolDto 封装了学校信息的dto对象
     * @return 添加成功返回true, 失败返回false
     */
    boolean addSchool(SchoolModel model);

    void addAcademy(Integer schoolId, SchoolModel model);

    /**
     * 更新学校信息
     * @param schoolId {@link SchoolModel}实体的主键值.
     * @param schoolDto 封装了学校信息的dto对象
     * @return 更新成功返回true, 失败返回false
     */
    boolean updateSchoolInfo(Integer schoolId, SchoolModel model);

    /**
     * 删除一所学校. 只有当对应的学院为空时才允许删除
     * @param schoolId {@link SchoolModel}实体的主键值.
     * @return 删除成功返回true, 失败返回false
     */
    boolean deleteSchool(Integer schoolId) throws CascadeDeleteException;



    
    /**
     * 查询指定学校所有的学院信息
     * @return
     */
    List<AcademyModel> getAcademyList(Integer schoolId);
    /**
     * 根据id查找学院
     * @param academyId {@link AcademyModel}实体的主键值
     * @return 查找成功返回找到的对象，查找失败返回{@code null}.
     */
    AcademyModel findAcademy(Integer academyId);

    /**
     * 更新学院信息
     * @param academyId {@link AcademyModel}实体的主键值
     * @param academyDto 封装了学院信息的dto对象
     * @return 更新成功返回true, 失败返回false
     */
    boolean updateAcademy(Integer academyId, AcademyModel model);

    /**
     * 删除一个学院
     * @param academyId {@link AcademyModel}实体的主键值
     * @return 删除成功返回true, 失败返回false
     */
    boolean deleteAcademy(Integer academyId);
}
