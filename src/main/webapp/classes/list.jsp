<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../header.jsp"%>

<!-- 본문시작  -->
<section>
<div class="container mt-3">  	

		<h1 style="text-align: center; color: green;">CLASS LIST</h1>
		
	<br>

	 
		<table class="table table-borderless">
			<thead>
				<tr class="table-primary text-black">
					<th scope="col">글번호</th>
					<th scope="col">강좌분류</th>
					<th scope="col">강좌명</th>
					<th scope="col">강사명</th>
					<th scope="col">수강료</th>
					<th scope="col">수업시작일</th>
				</tr>
			</thead>
				<c:forEach var="dto" items="${list}">
					<tr>
						<td>${dto.w_code}</td>  
						<td>${dto.c_code}</td>
						<td><a href="read.do?w_code=${dto.w_code}">${dto.c_prod}</a></td>
						<td>${dto.tc_name}</td>
						<td>${dto.c_price}</td>
						<td>${dto.c_start.substring(0,10)}</td>
					</tr>	
				</c:forEach>					
		</table>    
	
          
<% 		  String s_id=(String)session.getAttribute("s_id");
          String s_level=(String)session.getAttribute("s_level");
%>
        <c:if test="${s_level eq 'A' }">  
			<div class="form-group" align="right">
				<input type="button" value="글쓰기" class="btn btn-primary" onclick="location.href='clcreate.do'">
			</div>
		</c:if>
	
		<br>	
		
		<!--페이징 -->
		<div class="custom-pagination text-center">
		${paging }
		
              <!-- <span>1</span>
              <a href="#">2</a>
              <a href="#">3</a>
              <span class="more-page">...</span>
              <a href="#">7</a>    -->     
		</div>		        
		
		<!-- 검색 -->
        <table class="table table-borderless" style="text-align: center;" >
        <tr>
			<td colspan="4" style="text-align: center; height: 50px" >      	  
			<form action="./list.do" onsubmit="return searchCheck(this)" > 
				<div class="p-5 form-group row">
				<select name="col" class="form-control" style="width: 20%; height: 78%; margin-right: 20px; margin-left: 45px;">
					<option value="tc_name">강사명
					<option value="c_prod">강좌명
					<option value="c_start">시작일
					<option value="name_prod">강사명+강좌명 <!-- 강사명+강좌명 둘 중 하나만이라도 검색어가 들어가 있으면 됨 -->
				</select>
				 	<input type="text" class="form-control" style="width: 50%; margin-right: 20px;" name="word"> 
				 	<input type="submit" value="검색" class="btn btn-primary">
				 	</div>
			</form>			
			</td>			
		</tr>		
		</table>
		
     </div>
</section>

<script>
<!-- 검색어를 입력하지 않았는데 검색이 될 수 있기 때문에 바리케이트 역할을 하는 js 를 적용  -->
function searchCheck(f){
  	var word=f.word.value;
  	word=word.trim();
  	if(word.length==0){  //길이가 0 이라는 것은 아무것도 들어가 있지 않다는 것
  		alert("검색어를 입력하세요.");
  		return false;	//서버 전송 불가
  	}//if end
  	return true;		//서버로 전송
}//searchCheck() end
</script>
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>












