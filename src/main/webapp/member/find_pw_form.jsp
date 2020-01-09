<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<!-- 본문시작  -->
<section>
<div class="container">
      <div class="comment-form-wrap pt-5">
      <div class="col-md-7 mb-5" style="margin:0 auto;">
        <h3 class="mb-5">비밀번호 찾기</h3>
        <div class="p-5 bg-light">
        <form name="find_pw_form" method="post" action="find_pw_form.do" onsubmit="return loginCheck(this)" class="p-5 bg-light">
          <div class="form-group">
             <label for="find_pw"><strong>내 정보에 입력된 이메일로 찾기</strong></label>
             <label for="find_pw" style='font-size:14px;'>입력하신 이메일이 해당 아이디의 이메일과 같아야 진행 가능합니다.</label>
             <br>
             <label for="m_id">아이디</label>
             	<input type="text" class="form-control" id="m_id" name="m_id" placeholder="아이디를 입력해주세요" required>
           </div>
           <div class="form-group">
             <label for="m_email">이메일주소</label>
             <input type="text" class="form-control" id="m_email" name="m_email" placeholder="이메일주소 전체를 입력해주세요" required>
             <br>
             <input type="submit" id="find_pw_mail" value="다음단계" class ="btn btn-primary">
           </div>

        </form>
        </div>
      </div>
    </div>
   </div> 
</section>	  
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>