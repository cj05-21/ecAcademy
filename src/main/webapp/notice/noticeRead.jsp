<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- 본문시작  -->
<section>
<img  src="../images/noticere.png" style="width:100%;">
<div class="comment-form-wrap pt-5">
<%
		String s_id=(String)session.getAttribute("s_id");
		String s_level=(String)session.getAttribute("s_level");
%>
  <div class="container">  
      <div class="col-md-12 mb-5" style="margin: 0 auto;">
    	<div class="site-section" id="property-details">
      		<div class="container">
 			  <h3 class="text-black mb-4"></h3>
 			  <span style="font-size:30px; color:black;"><strong>${dto.n_subject } </strong></span>
 			  <p style="text-align: right;">${dto.m_id } &nbsp; |&nbsp;<span>${dto.n_date.substring(0,10) }</span> </p>
 			  <hr style="height:2px; background:black;">                        
 		      <div style="text-align: right;"><span>
				</span>&nbsp; |&nbsp;조회수 <span>${dto.n_readcnt }</span></div>
				<!--후기 이미지  -->		        
		        <div class="row">
		          <div class="col-lg-6">
		           
		          </div>
          		 <div class="col-lg-12 pl-lg-5 ml-auto">
           		 <div class="mb-5">
             	 <h3 class="text-black mb-4"></h3>
 			 	 <p>후기 내용 : </p><hr>                        
 		     	 <div style="height:250px;">
 		     	  ${dto.n_content } 
 		     	 </div>
              	<p style="text-align: center;">
                 <c:if test="${s_level eq 'A' }">
           			<div class="form-group" style="float: right;">
                    <input type="button" value="수정" class="btn btn-primary" onClick="location.href='./noupdate.do?n_no=${dto.n_no}'">
                    <input type="button" value="삭제" class="btn btn-primary" onClick="location.href='./confirm.do?n_no=${dto.n_no}'">
           			</div> 
       		 	 </c:if> 
            	 </p>
            				</div>
          				</div>
        			</div>
       	 		</div>
        	</div>
        </div>
    </div>  
 </div>
 
</section>	  
<script>

</script>
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>