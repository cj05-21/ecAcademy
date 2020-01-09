<%@page import="java.awt.Image"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="/header.jsp"%>
<%@ include file="ssi.jsp" %>
<!-- 본문시작  -->
<%-- <%request.getSession().setAttribute("s_id", "master");
 request.getSession().setAttribute("s_level", "A");%> --%>
<!-- 인위적으로 s_id = master로 부여 -->
<section>
	<div class="container">

		<h1 style="text-align: center; color: green;">Q&A</h1>
		<!-- Bootstrap table, table-borderless classes -->
		<table class="table table-borderless">
			<thead>
				<tr class="table-primary text-black">
					<th scope="col">Q&A</th>
					<th scope="col" name="q_subject">제목</th>
					<th scope="col" name="q_id">작성자</th>
					<th scope="col" name="q_date">작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${list}">

					<tr>
						<th scope="row">${dto.q_no}</th>
						<td><c:if test="${dto.q_code==2}">&nbsp;&nbsp;&nbsp;&nbsp;</c:if><a href="qnaRead.do?q_no=${dto.q_no}">
						<c:if test="${dto.q_indent!=0}"><img src='../images/qna/reply.gif'></c:if>${dto.q_subject}</a></td>
						<td>${dto.q_id}</td>
						<td>${dto.q_date.substring(0,10)}</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
		<div class="form-group" align="right">
			<input type="button" value="글쓰기" class="btn btn-primary" onclick="location.href='qnaIns.do'" >
		</div>
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
			<form action="./qnaList.do" onsubmit="return searchCheck(this)" > 
				<div class="p-5 form-group row">
				<select name="col" class="form-control" style="width: 20%; height: 78%; margin-right: 20px; margin-left: 45px;">
					<option value="q_subject">제목
					<option value="q_content">내용
					<option value="q_id">작성자
					<option value="sub_cont">제목+내용 <!-- 강사명+강좌명 둘 중 하나만이라도 검색어가 들어가 있으면 됨 -->
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
<%@ include file="/footer.jsp"%>