package com.fh.taolijie.service.impl;

import com.fh.taolijie.component.ListResult;
import com.fh.taolijie.constant.PostType;
import com.fh.taolijie.dao.mapper.MemberModelMapper;
import com.fh.taolijie.dao.mapper.ShPostModelMapper;
import com.fh.taolijie.domain.*;
import com.fh.taolijie.service.CollectionService;
import com.fh.taolijie.service.ShPostService;
import com.fh.taolijie.utils.CollectionUtils;
import com.fh.taolijie.utils.Constants;
import com.fh.taolijie.utils.ObjWrapper;
import com.fh.taolijie.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wanghongfei on 15-6-6.
 */
@Service
public class DefaultShPostService implements ShPostService {
    @Autowired
    ShPostModelMapper postMapper;

    @Autowired
    MemberModelMapper memMapper;

    @Autowired
    CollectionService coService;

    @Override
    @Transactional(readOnly = true)
    public ListResult<SHPostModel> getAllPostList(int firstResult, int capacity) {
        Pagination page = new Pagination(firstResult, CollectionUtils.determineCapacity(capacity));

        List<SHPostModel> list = postMapper.getAll(page.getMap());
        long tot = postMapper.countGetAll();

        return new ListResult<>(list, tot);
    }

    @Override
    @Transactional(readOnly = true)
    public ListResult<SHPostModel> getPostList(Integer cateId, int firstResult, int capacity) {
        List<SHPostModel> list = postMapper.getByCategory(cateId, false, firstResult, CollectionUtils.determineCapacity(capacity));
        long tot = postMapper.countGetByCategory(cateId);

        return new ListResult<>(list, tot);
    }

    @Override
    @Transactional(readOnly = true)
    public ListResult<SHPostModel> getPostList(Integer memId, boolean filtered, int firstResult, int capacity) {
        List<SHPostModel> list = postMapper.getByMember(memId, filtered, firstResult, CollectionUtils.determineCapacity(capacity));
        long tot = postMapper.countGetByMember(memId, filtered);

        return new ListResult<>(list, tot);
    }

    @Override
    @Transactional(readOnly = true)
    public ListResult<SHPostModel> getAndFilter(Integer cateId, boolean pageView, int firstResult, int capacity) {
        List<SHPostModel> list = postMapper.getByCategory(cateId, false, firstResult, CollectionUtils.determineCapacity(capacity));
        long tot = postMapper.countGetByCategory(cateId);

        return new ListResult<>(list, tot);
    }

    @Override
    @Transactional(readOnly = true)
    public ListResult<SHPostModel> runSearch(SHPostModel model) {
        List<SHPostModel> list = postMapper.searchBy(model);
        long tot = postMapper.countSearchBy(model);

        return new ListResult<>(list, tot);
    }

    @Override
    @Transactional(readOnly = true)
    public ListResult<SHPostModel> filterQuery(SHPostModel model) {
        List<SHPostModel> list = postMapper.findBy(model);
        long tot = postMapper.countFindBy(model);

        return new ListResult<>(list, tot);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SHPostModel> getUnverifiedPostList(SHPostModel model) {
        return postMapper.findBy(model);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SHPostModel> getSuedPost(int firstResult, int capacity) {
        return postMapper.getSuedPost(firstResult, CollectionUtils.determineCapacity(capacity));
    }

    @Override
    @Transactional(readOnly = false)
    public boolean addPost(SHPostModel model) {
        // 更新作者的上次发布时间
        MemberModel example = new MemberModel();
        example.setId(model.getMemberId());
        example.setLastShDate(model.getPostTime());
        memMapper.updateByPrimaryKeySelective(example);

        // 插入二手表
        postMapper.insertSelective(model);

        return true;
    }

    @Override
    @Transactional(readOnly = false)
    public void favoritePost(Integer memId, Integer postId) {
        coService.collect(memId, postId, PostType.SH);
    }

    @Override
    @Transactional(readOnly = false)
    public void unfavoritePost(Integer memId, Integer postId) {
        coService.cancelCollect(memId, postId, PostType.SH);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isPostFavorite(Integer memId, Integer postId) {
        return coService.alreadyCollected(memId, postId, PostType.SH);
    }

    @Override
    @Transactional(readOnly = true)
    public ListResult<SHPostModel> getFavoritePost(Integer memberId, int pn, int ps) {

        CollectionModelExample example = new CollectionModelExample(pn, ps);
        example.createCriteria()
                .andMemberIdEqualTo(memberId)
                .andShPostIdIsNotNull();
        // TODO 没分页
        ListResult<CollectionModel> coList = coService.findBy(example);
        if (0 == coList.getResultCount()) {
            return new ListResult<>(new ArrayList<>(0), 0);
        }

        // 转换成idList
        List<Integer> idList = coList.getList().stream()
                .map(CollectionModel::getShPostId)
                .collect(Collectors.toList());

        List<SHPostModel> list = postMapper.getInBatch(idList);

        return new ListResult<>(list, coList.getResultCount());
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isPostAlreadyFavorite(Integer memId, Integer postId) {
        return coService.alreadyCollected(memId, postId, PostType.SH);
    }

    @Override
    @Transactional(readOnly = false)
    public void complaint(Integer postId) {
        postMapper.increaseComplaint(postId);
    }

    @Override
    @Transactional(readOnly = true)
    public SHPostModel findPost(Integer postId) {
        return postMapper.selectByPrimaryKey(postId);
    }

    @Override
    @Transactional(readOnly = false)
    public boolean deletePost(Integer postId) {
        int row = postMapper.setDeleted(postId, true);

        return row <= 0 ? false : true;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean updatePost(Integer postId, SHPostModel model) {
        model.setId(postId);
        int row = postMapper.updateByPrimaryKeySelective(model);

        return row <= 0 ? false : true;
    }

    @Override
    @Transactional(readOnly = false)
    public void changeCategory(Integer postId, Integer cateId) {
        SHPostModel model = new SHPostModel();
        model.setId(postId);
        model.setSecondHandPostCategoryId(cateId);


        postMapper.updateByPrimaryKeySelective(model);
    }

    @Override
    @Transactional(readOnly = false)
    public void increasePageView(Integer postId) {
        postMapper.increasePageView(postId);
    }
}
