<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<%@ include file="ssi.jsp" %>
<!-- 본문시작  -->
<section>
<form name="loginfrm"
				 method="post"
				 action="loginProc.jsp"
				 onsubmit="return loginCheck(this)">
		<!--get 이 아니라 반드시 post 방식으로 해 줘야한다 -->		 
		<div class="container">
		<table class="table table-striped">
		<tr>
		<td>
		<input type="text" name="id"  value="" placeholder="아이디" required>
		</td>
		<!-- cursor: pointer 커서손모양
				<input type=image>기본속성이 submit
			 -->
		<td rowspan="2" style="align:right">
		<input type="image" src="../images/bt_login.gif" style="cursor:pointer;">
		</td>
		</tr>
		<tr>
		<td>
		<input type="password"  name="passwd" placeholder="비밀번호" required>	
		</td>
		</tr>
		<tr>
		<td colspan="2">
		<input type="checkbox" name="c_id" value="SAVE" >아이디저장
		&nbsp;&nbsp;
		<a href="agreement.jsp">회원가입</a>
		&nbsp;&nbsp;
		<a href="#" onclick="idSearch();">아이디</a>/<a href="#" onclick="pwSearch();">비밀번호</a>
		</td>
		</tr>
		</table>
		</div>
		</form>

</section>	  
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>