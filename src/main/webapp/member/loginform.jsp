<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<%@ include file="auth.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 본문시작  -->

<style>
  input[id="c_id"] {
    position: relative;
    top: 4px;
 }
</style>

 <c:if test="${empty sessionScope.s_id }">
<% if(s_id.equals("guest"))
	{
		//사용자 pc에 저장된 쿠키값 가져오기
		Cookie[] cookies=request.getCookies();
		String c_id="";
		if(cookies!=null){ //쿠키값이 있다면?
			for(int idx=0; idx<cookies.length; idx++){
				Cookie item=cookies[idx];
				if(item.getName().equals("c_id")==true){
					c_id=item.getValue();
			}//if end
		}//for end
	}//if end

%>	


<section>
	<div class="container">
      <div class="comment-form-wrap pt-5">
      <div class="col-md-6 mb-5" style="margin:0 auto;">
        <h3 class="mb-5 text-center">로그인</h3>
        <div class="p-5 bg-light">
        <form name="loginfrm" method="post" action="login.do" onsubmit="return loginCheck(this)" class="p-5 bg-light">
          <div class="form-group">
             <label for="m_id">아이디</label>
             <input type="text" class="form-control" id="m_id" name="m_id" value="<%=c_id %>" placeholder="아이디" required>
           </div>
           <div class="form-group">
             <label for="email">비밀번호</label>
             <input type="password" class="form-control" id="m_pw" name="m_pw" placeholder="비밀번호" required>
          	 <div style="font-size:14px;">아이디저장
             <input type="checkbox" name="c_id" id="c_id" value="SAVE" <%if(!c_id.isEmpty()){out.print("checked");} %> style=width:17px;height:17px; >
           	 </div>
           </div>
           <div class="form-group">               			 
			 <a href="agreement.do" style="font-size:15px;">회원가입</a>			 
			 &nbsp;&nbsp;&nbsp;&nbsp;
			 <a href="find_id_form.do" style="font-size:15px;">아이디찾기</a>&nbsp;|&nbsp;<a href="find_pw_form.do" onclick="pwSearch();" style="font-size:15px;">비밀번호찾기</a>
           </div>
           <div class="form-group">
             <input type="submit" id="submit" value="로그인" class="btn btn-primary">
           </div>
        </form>
        </div>
      </div>
    </div>
   </div> 
<%
}else{ //로그인에 성공했다면
	out.println("<strong>"+s_id+"</strong>");
	out.println("<a href='logout.jsp'>[로그아웃]</a>");
	out.println("<br><br>");
	out.println("<a href='memberUpdate.jsp'>[회원정보수정]</a>");
	out.println("<a href='memberDelete.jsp'>[회원탈퇴]</a>");
}//if end

%>
   
   
   

</section>	  
</c:if>
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>