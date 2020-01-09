<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>

<!--  <script>
 
if(${empty m_id }){ //m_id값이 없다면?
	$(function(){
        var responseMessage = "<c:out value="${message}" />";
        if(responseMessage != ""){
            alert(responseMessage)
            location.href='find_id_form.do'
        }
    })    
}

</script> -->

<!-- 본문시작  -->

<section>
<div class="container">
      <div class="comment-form-wrap pt-5">
      <div class="col-md-6 mb-5" style="margin:0 auto;">
        <h3 class="mb-5">아이디 찾기</h3>
        <div class="p-5 bg-light">
        <form name="loginfrm" method="post" action="login.do" onsubmit="return loginCheck(this)" class="p-5 bg-light">
          <div class="form-group">
             <label for="find_id">회원님의 아이디는</label><br>
    		 <label for="m_id" style="font-size:40px;"><strong>${m_id } </strong></label>&nbsp;&nbsp;
    		 <label for="find_id">입니다!</label>
           </div>
         
           <div class="form-group">
             <input type="submit" id="submit" value="로그인페이지로" class="btn btn-primary">
           </div>
        </form>
        </div>
      </div>
    </div>
   </div> 
</section>	  
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>
<script>
}

</script>