<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../header.jsp"%>
<!-- 본문시작  -->
<section>
<h1 style="text-align: center; color: green;">CLASS LIST</h1>
<div class="container mt-3">  
	<div class="tab-content"> 
	 <div id="TEPS" class="container tab-pane active"> 
		<table class="table table-borderless">
			<thead>
				<tr class="table-primary text-black">
					<th scope="col">글번호</th>
					<th scope="col">강좌분류</th>
					<th scope="col">강좌명</th>
					<th scope="col">강사명</th>
					<th scope="col">수업시작일</th>
				</tr>
			</thead>
			
				<c:forEach var="dto" items="${list3}">
					<tr>
						<td>${dto.w_code }</td>
						<td>${dto.c_code }</td>
						<td><a href="read.do?w_code=${dto.w_code}">${dto.c_prod }</a></td>
						<td>${dto.tc_name }</td>
						<td>${dto.c_start.substring(0,10) }</td>
					</tr>
				</c:forEach>		
			</table>
			</div>	
         </div> 
<% 		  String s_id=(String)session.getAttribute("s_id");
          String s_level=(String)session.getAttribute("s_level");
%>
        <c:if test="${s_level eq 'A' }">  
			<div class="form-group" align="right">
				<input type="button" value="글쓰기" class="btn btn-primary" onclick="location.href='clcreate.do'">
			</div>
		</c:if>
	</div>
</section>
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>
