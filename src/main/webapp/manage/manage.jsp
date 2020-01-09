<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<!-- 본문시작  -->
<section>
<div style="width:200px;margin-left:150px;">

<img src="../images/manager.png" alt="Image" class="img-fluid" width="150px" height="150px"><br>
	<div style="width:150px; text-align:center; color:red;" ><strong>${dto.m_name }</strong></div>
	<div style="width:150px; text-align:center;" >${dto.m_email }</div>
	<div style="width:150px; text-align:center;" >${dto.m_phone}</div>
<br>
	<div style="width:150px; text-align:center;" >
	<a href="../member/logout"><i class="fa fa-sign-out"></i> 로그아웃</a>
	</div>
<br><br>	
	<div class="categories">
                <h3>Categories</h3>
                <ul>
                <li><a href="../apply/applylist.do?s_id=${s_id }">수강목록</a></li>
                <li><a href="../attend/attend.do?s_id=${s_id }">출석 등록</a></li>
                <li><a href="../attend/afterattend.do?s_id=${s_id }">출석 목록</a></li>
                <li><a href="../manage/mem_manage.do">회원관리</a></li>
                <li><a href="#">Web Development</a></li>
                </ul>
              </div>
</div>              
</section>	  
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>