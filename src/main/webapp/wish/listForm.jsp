<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../header.jsp"%>
<!-- 본문시작  -->
<section>
	<input type="hidden" name="w_code" value="${dto.w_code }">
	<div class="container">
		<h1 style="text-align: center; color: green;">위시리스트</h1>
			<table class="table table-borderless">
				<thead>
					<tr class="table-primary text-black">
					<th scope="col">글번호</th>
					<th scope="col">강좌명</th>
					<th scope="col">강사명</th>
					<th scope="col">수강료</th>
					<th scope="col">강의시작일</th>		
					<th scope="col">신청</th>	
					<th scope="col">삭제</th>		
					</tr>
				</thead>
			<tbody>
				<c:forEach var="dto" items="${wlist}">
					<tr>
						<td>${dto.wlist }</td>
						<td>${dto.c_prod }</td>
						<td>${dto.tc_name }</td>
						<td>${dto.c_price } </td>
						<td> ${dto.c_start.substring(0,10)}</td>
						<td><a href="../apply/form.do?w_code=${dto.w_code}&s_id=${s_id}" class="btn btn-primary" style="padding: 4px; ">수강</a></td>
						<td><a href="delete.do?wlist=${dto.wlist}&s_id=${s_id}" class="btn btn-primary" style="padding: 4px; ">삭제</a></td>				
						
					</tr>
				</c:forEach>
			</tbody>
			</table>
		
		
	</div>
</section>
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>












