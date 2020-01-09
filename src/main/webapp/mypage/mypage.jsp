<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<!-- 본문시작  -->
<section>
 <div class="sidebar-box">
              <div class="categories">
                <h3>마이페이지</h3>
                <li><a href="#"> - 나의 출석 현황<span>(12)</span></a></li>
                <li><a href="#"> - 나의 수강정보<span>(12)</span></a></li>
                <li><a href="#"> - 시험관리 <span>(22)</span></a></li>
                <li><a href="#"> - 게시물 관리 <span>(37)</span></a></li>
                <li><a href="#"> - 위시리스트 <span>(42)</span></a></li>
              </div>
            </div>


	<div class="container">
	
	<div class="text-right">회원정보 수정 | 회원탈퇴 </div>
	
              <div class="comment-form-wrap pt-5">
              <div class="col-md-9 mb-5" style="margin:0 auto; ">
                <h3 class="mb-5 text-center">나의 회원정보</h3>
                <div class="p-5 bg-light">
                <form name="memform" method="post" action="memberform.do" class="p-5 bg-light">
                  <div class="form-group">    
                    <label for="m_id">아이디</label> <!-- 못바꿈 -->
                    <input type="text" class="form-control" id="m_id" name="m_id" style="width:200px; ">
                    <div id="idcheck" style="display:none;"></div>
                  </div>
                  <div class="form-group">
                    <label for="m_pw">비밀번호</label>  <!-- 변경가능 -->
                    <input type="password" class="form-control" id="m_pw" name="m_pw" style="width:200px;">
                    <br>
                    <input type="button" value="비밀번호 변경" class="btn btn-primary">
                  </div>
                            
                  <div class="form-group">
                    <label for="m_name">이름</label> <!-- 못바꿈 -->
                    <input type="text" class="form-control" id="m_name" name="m_name" style="width:200px;">
                  </div>                         
                  <div class="form-group">
                    <label for="m_email">이메일</label>
                    <input type="email" class="form-control" id="m_email" name="m_email" style="width:200px;">             
     			    </div>		         
                  <div class="form-group">
                    <label for="m_phone">전화번호</label>
                    <input type="text" class="form-control" id="m_phone" name="m_phone" style="width:200px;">                   
                  </div>     			   
                  <div class="form-group">
                    <label for="m_job">직업</label>
                    <input type="text" class="form-control" id="m_job" name="m_job" style="width:200px;">                 
                  </div>

                  <div class="form-group">
                     <!-- 갱신가능 -->
                	 환불 계좌번호
                    <input type="text" class="form-control" id="ref_acount" name="ref_acoun"style="width:400px;">
                  </div>
                  <div class="form-group">
                   	 예금주명
                    <input type="text" class="form-control" id="ref_name" name="ref_name"style="width:200px;">
                 <br>
                    <input type="submit" id="submit" value="수정완료" class="btn btn-primary">
                   </div> 
                  <hr>
                </form>
              </div>
             </div> 
             </div>
           </div>

</section>	  
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>