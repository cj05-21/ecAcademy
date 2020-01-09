<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<!-- 본문시작  -->
<title>teacher/teacherForm.jsp</title>
<section>

	<form name="teacherfrm" method="post" action="./insert.do" enctype="multipart/form-data"
		onsubmit="return send()">
		<div class="container" >
			<div class="col-md-6 mb-5" style="margin: 0 auto;">  <!-- col-md-'숫자'가 사이즈 조절 // margin : 두 개가 나오면 상하, 네개가 나오면 상하좌우 -->
				<h3 class="mb-5 text-center" >강사 등록</h3>
				<div class="p-5 bg-light">	
					<div class="form-group">
						<label for="tc_name">강사 성명</label> <input type="text"
							class="form-control" id="tc_name" name="tc_name" required>
						<div><span id="panel_name"></span></div>
					</div>
					<div class="form-group">
						<label for="m_id">강사 아이디</label> <input type="text"
							class="form-control" id="m_id" name="m_id" required>
							<div><span id="panel_id"></span></div>
					</div>
					<div class="form-group">
						<label for="posterMF">강사 사진</label> 
						<div><input type='file' name='posterMF' size='50'></div>
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
			
					<div class="form-group" style="text-align: center; ">
						<input type="button" value="목록보기" class="btn btn-primary" onClick="location.href='list.do'">
						<input type="submit" value="등록" class="btn btn-primary">
						<input type="reset" value="취소" class="btn btn-primary">
					</div>

				</div>
			</div>
		</div>
	</form>

<script>
	//중복되는 id를 막아주기 위해서 쿠키값 필요
	$(function(){
		//해당 페이지가 읽혀졌을 때 쿠키변수 삭제
		$.removeCookie("checkID");
	});
	
	$("#m_id").keyup(function(){
	var params = "m_id="+$("#m_id").val();
	//요청명령어, 서버 요청전달값, 콜백함수, json 방식
	$.post("idcheck.do", params , checkID, "json"); //post() end, post방식
	}); //id → #, keyup 이라는 이벤트 

	function checkID(result){
		
		var count=eval(result.count);
		
		if(count==0){			
			$("#panel_id").css("font-size", "13px");
			$("#panel_id").css("color", "#37cfa2");
			$("#panel_id").text("사용 가능한 아이디 입니다.");		
			//$.cookies("쿠키변수명", 값)
			$.cookie("checkID", "PASS"); //쿠키변수 생성
		}else{
			$("#panel_id").css("font-size", "13px");
			$("#panel_id").css("color", "red");
			$("#panel_id").text("중복된 아이디 입니다.");
			$("#m_id").focus();  //커서 생성
		}//if end	
	}//checkID() end
	
	$(function(){
		//해당 페이지가 읽혀졌을 때 쿠키변수 삭제
		$.removeCookie("checkNAME");
		
	});
	
	$("#tc_name").keyup(function(){
	var params = "tc_name="+$("#tc_name").val();
	//요청명령어, 서버 요청전달값, 콜백함수, json 방식
	$.post("namecheck.do", params , checkNAME, "json"); //post() end, post방식
	}); //id → #, keyup 이라는 이벤트 

	function checkNAME(result){		
		var count=eval(result.count);
		if(count==0){			
			$("#panel_name").css("font-size", "13px");
			$("#panel_name").css("color", "#37cfa2");
			$("#panel_name").text("사용 가능한 강사 이름 입니다.");		
			//$.cookies("쿠키변수명", 값)
			$.cookie("checkNAME", "PASS"); //쿠키변수 생성
		}else{
			$("#panel_name").css("font-size", "13px");
			$("#panel_name").css("color", "red");
			$("#panel_name").text("중복된 강사 이름 입니다.");
			$("#tc_name").focus();  //커서 생성
		}//if end	
	}//checkID() end
	
	function send(){
		
		//아이디 중복확인을 해야만 회원가입폼이 서버로 전송
		//쿠키 변수값 가져오기
		//alert($.cookie("checkID"));
		var checkNAME=$.cookie("checkNAME");
		//alert(checkNAME);
		var checkID=$.cookie("checkID");
		//alert(chekcID);
		
		 if(checkNAME=="PASS" && checkID =="PASS"){
			return true;
		}else{
			$("#panel_name").css("font-size", "13px");
			$("#panel_name").css("color", "green");
			$("#panel_name").text("강사 이름 중복을 확인해주십시오");
			$("#tc_name").focus();	//커서 생성
			
			$("#panel_id").css("font-size", "13px");
			$("#panel_id").css("color", "green");
			$("#panel_id").text("아이디 중복을 확인해주십시오");
			//$("#m_id").focus();	//커서 생성
			
			return false;
			
		}//if end 
		

	}//send() end
	
</script>
</section>
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>