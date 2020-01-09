<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<!-- 본문시작  -->
<section>
 <div class="comment-form-wrap pt-5">
 	<div class="container">
 		<div class="col-md-8 mb-5" style="margin: 0 auto;">
                <h2 class="mb-5">Review</h2>
                <form method="post" onsubmit="return check(this)" action="./review.do" class="p-4 bg-light" enctype="multipart/form-data">
                  <label for="score">만족도 *</label>
                  <select name="score"  class="custom-select mb-3"> 
		                <option value="0" selected>만족도를 선택해 주세요</option> 
		                <option value="1">1점</option> 
		                <option value="2">2점</option> 
		                <option value="3">3점</option> 
		                <option value="4">4점</option> 
		                <option value="5">5점</option> 
		            </select> 
                  <div class="form-group">
                    <label for="subject">subject *</label>
                    <input type="text" class="form-control" name="r_subject" id="r_subject">
                  </div>
                  <div class="form-group">
                    <label for="writer">writer *</label>
                    <input type="text" class="form-control" name="m_id" id="m_id" value="${s_id }" readonly>
                  </div>
                  
                  <div>
			      <label for="content">사진 *</label>
			      <input type='file' name='posterMF' size='50'>  
		    	  </div>
                  <div class="form-group">
                    <label for="content">content *</label>
                    <textarea name="r_content" id="r_content" cols="30" rows="10" class="form-control"></textarea>
                  </div>
                  <label for="score">과목 *</label>
                  <select name="c_code"  class="custom-select mb-3"> 
		                <option value="0" selected>수강과목을 선택해 주세요</option> 
		                <option value="TOEIC">TOEIC</option> 
		                <option value="TOEFL">TOEFL</option> 
		                <option value="OPIC">OPIC</option> 
		                <option value="TEPS">TEPS</option> 
		            </select> 
                  <div class="form-group">
                    <input type="submit" value="Register" class="btn btn-primary">
                    <input type="button" value="list" class="btn btn-primary" onClick="location.href='./relist.do'">
                  </div>
                </form>
               </div>
             </div>
           </div>
</section>
<script>
function check(r){
	//score
	var score=r.score.value;
	if(score==0){
		alert('강의 만족도를 선택해 주세요');
	return false;
	}
	//subject
	var r_subject=r.r_subject.value;
	if(r_subject.length<4||r_subject.length>30){
		alert('제목을 4~30자 내로 입력해 주세요');
	return false;
	}
	//content
	var r_content=r.r_content.value;
	if(r_content.length<4||r_content.length>200){
		alert('내용을  4~200자 내로 입력해 주세요');
	return false;
	}
	//c_code
	var c_code=r.c_code.value;
	if(c_code==0){
		alert('수강과목을 선택해 주세요');
	return false;
	}
	
}
</script>	  
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>