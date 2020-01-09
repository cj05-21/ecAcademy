<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<!-- 본문시작  -->


<section>

<div class="container">
      <div class="comment-form-wrap pt-5">
      <div class="col-md-7 mb-5" style="margin:0 auto;">
        <h3 class="mb-5">아이디 찾기</h3>
        <div class="p-5 bg-light">
        <form name="find_id_form" method="post" action="find_id_form.do"  class="p-5 bg-light">
          <div class="form-group">
             <label for="find_id"><strong>내 정보에 입력된 이메일로 찾기</strong></label>
             <label for="find_id" style='font-size:14px;'>내 정보의 이메일과 입력 이메일이 같아야 진행이 가능합니다.</label>
             <br>
             	이름<input type="text" class="form-control" id="m_name" name="m_name" placeholder="이름을 입력해주세요" required>
           </div>
           <div class="form-group">
             <label for="email">이메일주소</label>
             <input type="text" class="form-control" id="m_email" name="m_email" placeholder="이메일주소 전체를 입력해주세요" required>
             <br>
             <input type="submit" id="find_id_mail" value="다음단계" class ="btn btn-primary">
           </div>

        </form>
        </div>
      </div>
    </div>
   </div> 




</section>	  
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>