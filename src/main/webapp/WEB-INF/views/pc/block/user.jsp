<%--
  Created by IntelliJ IDEA.
  User: wynfrith
  Date: 15-5-9
  Time: 下午3:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="segment user-top">
  <div class="user-img" id="userImg">
    <img src="/static/images/users/${sessionScope.user.profilePhotoId}" alt="">
  </div>
  <div class="fr big-btn">
    <a href="/user/job/post">发布信息</a>
  </div>
  <div class="content">
    <p>${sessionScope.user.username}<span>${sessionScope.role.memo}</span></p>
    <div class="user-description">
      <p>去完善自己的个人资料把</p>
      <p>去完善自己的个人资料把</p>
      <p>去完善自己的个人资料把</p>
    </div>
  </div>

</div>
<style>
  .user-nav ul .active{
    background-color: #4ccda4;
  }
  .user-nav ul .active a{
    color: #fff !important;
  }
</style>

<div class="segment user-nav">
  <ul>
    <li class="${param.navShow == 'profile'?'active':''}" ><a href="/user/" >个人资料</a></li>
    <li class="${param.navShow == 'resume'?'active':''}" ><a href="/user/resume/create">我的简历</a></li>
    <li class="${param.navShow == 'favlist'?'active':''}" ><a href="/user/job/myfav">我的收藏</a></li>
    <li class="${param.navShow == 'postlist'?'active':''}" ><a href="/user/job/mypost">我的发布</a></li>
    <li class="${param.navShow == 'message'?'active':''}" ><a href="">消息通知</a></li>
    <li class="${param.navShow == 'security'?'active':''}" ><a href="/user/setting/security">修改密码</a></li>
    <li class="${param.navShow == 'feedback'?'active':''}" ><a href="/user/feedback">意见反馈</a></li>
  </ul>
</div>
