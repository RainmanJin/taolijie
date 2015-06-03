<%--
  Created by IntelliJ IDEA.
  User: wynfrith
  Date: 15-5-31
  Time: 下午6:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setCharacterEncoding("UTF-8") ;%>
<jsp:include page="block/start.jsp">
  <jsp:param name="title" value="${resume.id}的简历"/>
</jsp:include>

<%--顶栏--%>
<jsp:include page="block/top-bar.jsp"/>
<%--页首--%>
<jsp:include page="block/header.jsp"/>

<div class="container">


  <%--轮播--%>
  <jsp:include page="block/silder.jsp"/>
  <%--侧边栏--%>
  <jsp:include page="block/side.jsp"/>

  <!-- 正文 -->
  <div class="detail main white-bg">
    <div class="detail-bar">
      <span>${resume.id}的简历</span>
        <a href="/"><p class="fl"><i class="fa fa-angle-left">&nbsp;&nbsp;</i>返回</p></a>
      <p class="fr"><i class="fa fa-heart-o">&nbsp;&nbsp;</i>收藏</p>
    </div>
    <div style="clean:both"></div>
    <div class="resume-info">
      <img src="/images/miao.jpg" alt="">
      <div class="infos">
        <p>年龄 : ${resume.age}岁</p>
        <p>身高 : ${resume.height}cm</p>
        <p>城市 : 暂无</p>
        <p>学校 : 暂无</p>
        <p>专业 : 暂无</p>
      </div>
    </div>
    <br/>
    <div class="resume-detail theme-color-bd theme-color-bg" >
      <div class="title">求职意向</div>
      <p>${resume.intendCategoryId}</p>
      <div style="clear:both"></div>
    </div>
    <i class="resume-arrow theme-color"></i>

    <div class="resume-detail light-green-bg light-green-bd" >
      <div class="title">自我介绍</div>
      <p>${resume.introduce}</p>
      <div style="clear:both"></div>
    </div>
    <i class="resume-arrow light-green"></i>

    <div class="resume-detail dark-green-bg dark-green-bd" >
      <div class="title">工作经验</div>
      <p>${resume.experience}</p>
      <div style="clear:both"></div>
    </div>
    <i class="resume-arrow dark-green"></i>

    <div class="resume-detail red-bg red-bd resume-contact" >
      <div class="title">联系方式</div>
      <p><i class="fa fa-phone orange"></i> ${resume.phoneNumber}</p>
      <p><i class="fa fa-qq blue"></i> ${resume.qq}</p>
      <p><i class="fa fa-weixin green"></i> ${resume.wechatAccount}</p>
      <p><i class="fa fa-envelope-o red"></i> ${resume.email}</p>
      <div style="clear:both"></div>
    </div>

  </div>


</div>


<%--脚部--%>
<jsp:include page="block/footer.jsp"/>
