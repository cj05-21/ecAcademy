<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<!-- 본문시작  -->
<section>

<div class="container">
      <div class="comment-form-wrap pt-5">
      <div class="col-md-7 mb-5" style="margin:0 auto;">
        <h3 class="mb-5">회원탈퇴</h3>
        <div class="p-5 bg-light">
        <form name="find_id_form" method="post" action="mem_delete.do"  class="p-5 bg-light">
          <div class="form-group">
              <input type="hidden" name="s_id" id="s_id" value="${s_id}">
              <input type="hidden" name="m_id" id="m_id" value="${s_id}">
             <label for="delete_m_pw"><strong>비밀번호가 일치해야 탈퇴가 가능합니다</strong></label>
             <br>
             	비밀번호<input type="password" class="form-control" id="m_pw" name="m_pw" placeholder="비밀번호를 입력해주세요" required>
           </div>
          
             <input type="submit" id="find_id_mail" value="다음단계" class ="btn btn-primary">
         

        </form>
        </div>
      </div>
    </div>
    </div>





</section>	  
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>