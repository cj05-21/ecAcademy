<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<!-- 본문시작  -->
<title>teacher/teacherUpdate.jsp</title>
<section>

	<form name="teacherupd" method="post" action="./update.do" enctype="multipart/form-data"
		onsubmit="return update()">
	
	<input type="hidden" value="${dto.tc_no }" name="tc_no" >
		<div class="container" >
			<div class="col-md-6 mb-5" style="margin: 0 auto;">  <!-- col-md-'숫자'가 사이즈 조절 // margin : 두 개가 나오면 상하, 네개가 나오면 상하좌우 -->
				<h3 class="mb-5 text-center" >강사 수정</h3>
				<div class="p-5 bg-light">	
					<div class="form-group">
						<label for="tc_name">강사 성명</label> <input type="text"
							class="form-control" id="tc_name" name="tc_name"  value="${dto.tc_name }" required>
					</div>
					<div class="form-group">
						<label for="m_id">강사 아이디</label><input type="text"
							class="form-control" id="m_id" name="m_id"  value="${dto.m_id }"  readonly>
					</div>
					<div class="form-group">
						<label for="posterMF">강사 사진</label> 
						<div><img src="storage/${dto.poster }" width="100"></div>
						<div><input type="file" name="posterMF" size="50"></div>
					</div>
					
					<div class="form-group">
						<label for="website">담당 강좌</label> 
							
						<select name='w_code' id='w_code' class="form-control px-3" size='5'>							
						<c:forEach var="list"  items="${list}" begin="1" end="${fn:length(list)}" step="1" >
						<!-- 강좌에서 w_code 중심으로 강좌명 가져오기 -->
						 <c:choose>						
							<c:when test="${list.w_code < 10 }">
								<option value='${list.w_code}'>${list.c_prod}
							</c:when>
							<c:when test="${list.w_code >= 10 }">
								<option value='${list.w_code}' >${list.c_prod}
							</c:when>						
						 </c:choose>
						</c:forEach>
						
						</select> 
					</div>
<br>
			
					<div class="form-group">
						<input type="button" value="목록보기" class="btn btn-primary" onclick="location.href='list.do'">
						<input type="submit" value="등록" class="btn btn-primary">
						<input type="button" value="취소" class="btn btn-primary" onclick="history.back();">
					</div>

				</div>
			</div>
		</div>
	</form>	  
</section>	
<script>
	function update(){
    if(confirm("수정하시겠습니까 ?") == true){
        alert("수정되었습니다");
    }
    else{
    	
        return ;
    }
});
</script>

<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>