<%--
  Created by IntelliJ IDEA.
  User: wynfrith
  Date: 15-6-2
  Time: 下午4:23
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setCharacterEncoding("UTF-8") ;%>

<jsp:include page="../block/start.jsp" >
<jsp:param name="title" value="我的收藏"/>
</jsp:include>

<jsp:include page="../block/top-bar-reverse.jsp"></jsp:include>

<div class="container user">
  <jsp:include page="../block/user.jsp"></jsp:include>

    <div class="segment infos resume link-segment">
        <div class="quickbtn">
            <ul>
                <li><a href="">兼职信息</a></li>
                <li><a href="">二手物品</a></li>
                <li><a href="">兼职简历</a></li>
            </ul>
        </div>
        <div style="clear:both"></div>
        <div class="col_content">
            <div class="col_list">
                <div class="col_choice" style="line-height:112px; width:45px;">
                    <input name="collection" type="checkbox" value="" class="col_del_check">
                </div>
                <div class="col_style">
                    家教
                </div>
                <div class="col_main" style="margin-left:40px; width:630px;">
                    <div class="col_main_top">
                        <div class="title">诚聘高三物理老师一名</div>
                        <div class="style">学生</div>
                    </div>
                    <div class="col_main_bottom">
                        <div class="location"><i class="fa fa-map-marker fa-lg"></i> 张店</div>
                        <div class="salary"><i class="fa fa-jpy fa-lg"></i> 200/天</div>
                        <div class="salarystyle">月结</div>
                        <div class="time"><i class="fa fa-clock-o fa-lg"></i> 2015-1-8 8:00</div>
                        <div class="clickno">800</div>
                    </div>
                </div>
                <div class="col_delete">
                    <a href="#"><i class="fa fa-trash fa-2x"></i><br>删除</a>
                </div>
            </div>
            <div class="col_list">
                <div class="col_choice" style="line-height:112px; width:45px;">
                    <input name="collection" type="checkbox" value=""  class="col_del_check">
                </div>
                <div class="col_style">
                    家教
                </div>
                <div class="col_main" style="margin-left:40px; width:630px;">
                    <div class="col_main_top">
                        <div class="title">诚聘高三物理老师一名</div>
                        <div class="style">学生</div>
                    </div>
                    <div class="col_main_bottom">
                        <div class="location"><i class="fa fa-map-marker fa-lg"></i> 张店</div>
                        <div class="salary"><i class="fa fa-jpy fa-lg"></i> 200/天</div>
                        <div class="salarystyle">月结</div>
                        <div class="time"><i class="fa fa-clock-o fa-lg"></i> 2015-1-8 8:00</div>
                        <div class="clickno">800</div>
                    </div>
                </div>
                <div class="col_delete">
                    <a href="#"><i class="fa fa-trash fa-2x"></i><br>删除</a>
                </div>
            </div>
            <div class="col_list">
                <div class="col_choice" style="line-height:112px; width:45px;">
                    <input name="collection" type="checkbox" value=""  class="col_del_check">
                </div>
                <div class="col_style">
                    家教
                </div>
                <div class="col_main" style="margin-left:40px; width:630px;">
                    <div class="col_main_top">
                        <div class="title">诚聘高三物理老师一名</div>
                        <div class="style">学生</div>
                    </div>
                    <div class="col_main_bottom">
                        <div class="location"><i class="fa fa-map-marker fa-lg"></i> 张店</div>
                        <div class="salary"><i class="fa fa-jpy fa-lg"></i> 200/天</div>
                        <div class="salarystyle">月结</div>
                        <div class="time"><i class="fa fa-clock-o fa-lg"></i> 2015-1-8 8:00</div>
                        <div class="clickno">800</div>
                    </div>
                </div>
                <div class="col_delete">
                    <a href="#"><i class="fa fa-trash fa-2x"></i><br>删除</a>
                </div>
            </div>
            <div class="col_delete_all">
                <div class="col_choice">
                    <input name="" type="checkbox" value="" id="checkAll">全选
                    <button class="del_all">删除选中项</button>
                </div>
            </div>
        </div>
    <%--</div>--%>
</div>

<jsp:include page="../block/user-footer.jsp"></jsp:include>
<script src="/scripts/security.js"></script>
</body>
</html>

