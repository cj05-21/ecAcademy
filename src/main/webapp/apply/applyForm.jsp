<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<!-- 본문시작  -->
<section>
 <input type="hidden" name="w_code" value="${dto.w_code }">     
<form  name="applyfrm" method="post" action="./form.do?w_code=${dto.w_code}&m_id=${m_id}">
<input type="hidden" value="${dto.tc_name }" name="tc_name">
<input type="hidden" value="${dto.ap_date }" name="ap_date">
<input type="hidden" value="${dto.ap_no }" name="ap_no">
<input type="hidden" value="${dto.c_price }" name="c_price">
<input type="hidden" value="${dto.c_start}" name="c_start">
<input type="hidden" value="${dto.p_sts}" name="p_sts">

<div class="container mt-3">  
     <h1 style="text-align:center; color:green;"> 수강 신청 </h1>  
     <br>
	 <table class="table table-borderless" >  
           <tr class="table-primary text-black">  
               <th>강좌명</th>    
               <th>강사명</th>  
               <th>강의시작일</th>  
               <th>결제가격</th>   
           </tr>             
			<tr>
				<td id="c_prod">${dto.c_prod }</td>
				<td id="tc_name">${dto.tc_name }</td> 
				<td id="c_start">${dto.c_start.substring(0,10) }</td>
				<td id="c_price">${dto.c_price }</td>
			</tr>
        </table> 
        <hr>
        <br>    
        <br>    
        <table class="table table-borderless" style="padding-top: 50px;">  
                <tr class="table-primary text-black">  
                    <th>결제방법</th> 
                </tr>   
         		<tr>
					<td>
						<input type="radio" name="ap_pay" value="card" checked> 신용카드
			   			&nbsp; &nbsp; &nbsp; &nbsp;		  						 
			   			<input type="radio" name="ap_pay"  value="tongjang" > 무통장입금
			   			&nbsp; &nbsp; &nbsp; &nbsp;	  						 
			   			<input type="radio" name="ap_pay"  value="phone"> 휴대폰결제	  						 
					</td>
				</tr>
     </table>
        <% String s_id=(String)session.getAttribute("s_id");
           String s_name=(String)session.getAttribute("s_name");
           String s_level=(String)session.getAttribute("s_level");%>
   				 <c:choose>
       			 	<c:when test="${empty s_id }">
       			 		<script>
       			 			alert("로그인이 필요합니다.");
       			 			location.href="../member/login.do";
       			 		</script>
       			 	</c:when>
       			 </c:choose>
        <div style="text-align: center; padding-top: 100px;">
        <span>신청 강좌를 확인하시고 결제방법을 선택 후 '결제' 버튼을 눌러주세요.</span> <br><br>
        	<input type="submit" value="결제" class="btn btn-primary"  style="padding: 5px 13px;" >
			<input type="button" value="취소" id="delete_btn" class="btn btn-primary" style="padding: 5px 13px;"  onclick="location.href='../classes/list.do' ">
	    </div> 
</div>
</form>		
</section>	  
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>