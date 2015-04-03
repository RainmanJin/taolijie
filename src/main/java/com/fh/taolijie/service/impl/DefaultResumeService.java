package com.fh.taolijie.service.impl;

import com.fh.taolijie.controller.dto.PostRecordDto;
import com.fh.taolijie.controller.dto.ResumeDto;
import com.fh.taolijie.domain.JobPostCategoryEntity;
import com.fh.taolijie.domain.MemberEntity;
import com.fh.taolijie.domain.ResumeEntity;
import com.fh.taolijie.service.ResumeService;
import com.fh.taolijie.service.repository.JobPostCategoryRepo;
import com.fh.taolijie.service.repository.MemberRepo;
import com.fh.taolijie.service.repository.ResumeRepo;
import com.fh.taolijie.utils.CollectionUtils;
import com.fh.taolijie.utils.Constants;
import com.fh.taolijie.utils.ObjWrapper;
import com.fh.taolijie.utils.json.JsonWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by wanghongfei on 15-3-7.
 */
@Repository
public class DefaultResumeService extends DefaultPageService implements ResumeService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private ResumeRepo resumeRepo;

    @Autowired
    private MemberRepo memRepo;

    @Autowired
    private JobPostCategoryRepo cateRepo;

    private static final String QUERY_INTEND = "SELECT resume_id AS resumeId, job_post_category_id AS categoryId FROM resume_job_post_category AS category WHERE category.job_post_category_id = :cateId";

    @Override
    @Transactional(readOnly = true)
    public List<ResumeDto> getAllResumeList(int firstResult, int capacity, ObjWrapper wrap) {
        int cap = CollectionUtils.determineCapacity(capacity);

        Page<ResumeEntity> entityList = resumeRepo.findAll(new PageRequest(firstResult, cap));

        wrap.setObj(entityList.getTotalPages());

        return CollectionUtils.transformCollection(entityList, ResumeDto.class, (ResumeEntity resumeEntity) -> {
            return  CollectionUtils.entity2Dto(resumeEntity, ResumeDto.class, (dto) -> {
                dto.setMemberId(resumeEntity.getMember().getId());
            });
        });
    }

    @Override
    @Transactional(readOnly = true)
    public List<ResumeDto> getAllResumeList(Constants.AccessAuthority authority, int firstResult, int capacity, ObjWrapper wrap) {
        int cap = CollectionUtils.determineCapacity(capacity);

        Page<ResumeEntity> entityList = resumeRepo.findByAuthority(authority.toString(), new PageRequest(firstResult, cap));
        wrap.setObj(entityList.getTotalPages());

        return CollectionUtils.transformCollection(entityList, ResumeDto.class, (ResumeEntity resumeEntity) -> {
            return  CollectionUtils.entity2Dto(resumeEntity, ResumeDto.class, (dto) -> {
                dto.setMemberId(resumeEntity.getMember().getId());
            });
        });
    }

    @Override
    @Transactional(readOnly = true)
    public List<ResumeDto> getResumeList(Integer memId, int firstResult, int capacity, ObjWrapper wrap) {
        int cap = CollectionUtils.determineCapacity(capacity);

        MemberEntity mem = em.getReference(MemberEntity.class, memId);

        Page<ResumeEntity> rList = resumeRepo.findByMember(mem, new PageRequest(firstResult, cap));
        wrap.setObj(rList.getTotalPages());
/*        List<ResumeEntity> rList = em.createNamedQuery("resumeEntity.findByMember", ResumeEntity.class)
                .setParameter("member", mem)
                .setFirstResult(firstResult)
                .setMaxResults(cap)
                .getResultList();*/

        return CollectionUtils.transformCollection(rList, ResumeDto.class, (ResumeEntity resumeEntity) -> {
            return  CollectionUtils.entity2Dto(resumeEntity, ResumeDto.class, (dto) -> {
                dto.setMemberId(resumeEntity.getMember().getId());
            });
        });
    }

    @Override
    public List<ResumeDto> getResumeList(Integer memId, Constants.AccessAuthority authority, int firstResult, int capacity, ObjWrapper wrap) {
        int cap = CollectionUtils.determineCapacity(capacity);

        MemberEntity mem = em.getReference(MemberEntity.class, memId);

/*        List<ResumeEntity> rList = em.createNamedQuery("resumeEntity.findByMember", ResumeEntity.class)
                .setParameter("member", mem)
                .setFirstResult(firstResult)
                .setMaxResults(cap)
                .getResultList();*/

        Page<ResumeEntity> rList = resumeRepo.findByMemberAndAuthority(mem, authority.toString(), new PageRequest(firstResult, cap));
        wrap.setObj(rList.getTotalPages());

        return CollectionUtils.transformCollection(rList, ResumeDto.class, (ResumeEntity resumeEntity) -> {
            return  CollectionUtils.entity2Dto(resumeEntity, ResumeDto.class, (dto) -> {
                dto.setMemberId(resumeEntity.getMember().getId());
            });
        });
    }

    @Override
    @Transactional(readOnly = true)
    public List<ResumeDto> getResumeListByIntend(Integer cateId) {
        // 查询关联表
        // object[0]是简历id, object[1]是工作分类id
        List<Object[]> rajList =  em.createNativeQuery(QUERY_INTEND)
                .setParameter("cateId", cateId)
                .getResultList();

        // 构造ResumeList
        List<ResumeDto> dtoList = new ArrayList<>();
        for (Object[] obj : rajList) {
            Integer resumeId = (Integer) obj[0];
            //ResumeAndJobCategory raj = (ResumeAndJobCategory) obj;
            //Integer resumeId = raj.getResumeId();
            ResumeEntity entity = resumeRepo.findOne(resumeId);

            dtoList.add(CollectionUtils.entity2Dto(entity, ResumeDto.class, (dto) -> {
                dto.setMemberId(entity.getMember().getId());
            }));
        }

        // 根据简历创建时间排序
        dtoList.stream().sorted( (dto1, dto2) -> {
            return dto1.getCreatedTime().compareTo(dto2.getCreatedTime());
        });

        return dtoList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostRecordDto> getPostRecord(Integer memId, int page, int capacity, ObjWrapper wrap) {
        MemberEntity mem = memRepo.getOne(memId);
        String recordJson = mem.getAppliedJobIds();

        // 没有记录，返回空List
        if (null == recordJson) {
            return new ArrayList<PostRecordDto>();
        }

        // 解析JSON
        JsonWrapper js = new JsonWrapper(recordJson);
        List<Map<String, String>> jsonList = js.getJsonList();


        // 取出记录信息
        List<PostRecordDto> dtoList = new ArrayList<>();
        for (Map<String, String> jsonObj : jsonList) {
            String postId = jsonObj.get(Constants.ApplicationRecord.KEY_ID);
            String timeString = jsonObj.get(Constants.ApplicationRecord.KEY_TIME);

            PostRecordDto dto = new PostRecordDto(Integer.valueOf(postId), new Date(Long.parseLong(timeString)) );
            dtoList.add(dto);
        }

        // 分页
        int cap = CollectionUtils.determineCapacity(capacity);
        Page<PostRecordDto> dtoPage = new PageImpl<>(dtoList, new PageRequest(page, cap), dtoList.size());

        return CollectionUtils.transformCollection(dtoPage, PostRecordDto.class, (dto) -> dto);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public boolean refresh(Integer resumeId) {
        ResumeEntity r = em.find(ResumeEntity.class, resumeId);

        Date original = r.getCreatedTime();
        Date now = new Date();


        if (now.getTime() - original.getTime() >= TimeUnit.DAYS.toSeconds(1)) {
            r.setCreatedTime(now);
            return true;
        }

        return false;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public boolean updateResume(Integer resumeId, ResumeDto resumeDto) {
        ResumeEntity r = em.find(ResumeEntity.class, resumeId);

        CollectionUtils.updateEntity(r, resumeDto, (entity) -> {
            // 设置求职意向
            entity.getCategoryList().clear();
            for (Integer cateId : resumeDto.getIntendCategoryId()) {
                JobPostCategoryEntity cate = cateRepo.getOne(cateId);
                entity.getCategoryList().add(cate);
            }
        });

        //updateResume(r, resumeDto);

        return true;
    }

    @Override
    @Transactional(readOnly = true)
    public ResumeDto findResume(Integer resumeId) {
        ResumeEntity entity = em.find(ResumeEntity.class, resumeId);

        return CollectionUtils.entity2Dto(entity, ResumeDto.class, (dto) -> {
            dto.setMemberId(entity.getMember().getId());
        });
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public boolean deleteResume(Integer resumeId) {
        ResumeEntity r = em.getReference(ResumeEntity.class, resumeId);

        // 从member中删除关联
        CollectionUtils.removeFromCollection(r.getMember().getResumeCollection(), (resume) -> {
            return resume.getId().equals(resumeId);
        });

        // 删除resume本身
        em.remove(r);

        return true;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void addResume(ResumeDto dto) {
        //ResumeEntity r = makeResume(dto);
        ResumeEntity r = CollectionUtils.dto2Entity(dto, ResumeEntity.class, (entity) -> {
            // 设置简历主人
            entity.setMember(memRepo.getOne(dto.getMemberId()));

            // 设置求职意向
            List<JobPostCategoryEntity> cateList = new ArrayList<>();
            for (Integer cateId : dto.getIntendCategoryId()) {
                JobPostCategoryEntity cate = cateRepo.getOne(cateId);
                cateList.add(cate);
            }
            entity.setCategoryList(cateList);
        });

        resumeRepo.save(r);
        //em.persist(r);
    }

    private ResumeEntity makeResume(ResumeDto dto) {
        ResumeEntity r = new ResumeEntity(dto.getName(), dto.getGender(), dto.getAge(), dto.getHeight(),
                dto.getPhonePath(), dto.getEmail(), dto.getQq(), dto.getExperience(), dto.getIntroduce(),
                null);

        r.setMember(em.getReference(MemberEntity.class, dto.getMemberId()));

        return r;
    }

    /**
     * 不更新关联信息
     * @param resume
     * @param dto
     */
    /*private void updateResume(ResumeEntity resume, ResumeDto dto) {
        resume.setName(dto.getName());
        resume.setGender(dto.getGender());
        resume.setAge(dto.getAge());
        resume.setHeight(dto.getHeight());
        resume.setPhotoPath(dto.getPhotoPath());
        resume.setEmail(dto.getEmail());
        resume.setQq(dto.getQq());
        resume.setIntroduce(dto.getIntroduce());
    }*/
    /*private ResumeDto makeResumeDto(ResumeEntity resume) {
        ResumeDto dto = new ResumeDto();
        dto.setId(resume.getId());
        dto.setName(resume.getName());
        dto.setGender(resume.getGender());
        dto.setAge(resume.getAge());
        dto.setHeight(resume.getHeight());
        dto.setPhotoPath(resume.getPhotoPath());
        dto.setEmail(resume.getEmail());
        dto.setQq(resume.getQq());
        dto.setExperience(resume.getExperience());
        dto.setIntroduce(resume.getIntroduce());
        dto.setCreatedTime(resume.getCreatedTime());

        dto.setMemberId(resume.getMember().getId());

        return dto;
    }*/
}
