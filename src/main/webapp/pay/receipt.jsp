<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<!-- 본문시작  -->
<section>
<input type="hidden" name="ap_no" value="${dto.ap_no }">
<input type="hidden" name="p_no" value="${dto.p_no }">

<div class="container">  
	<div class="comment-form-wrap pt-5">
      <div class="col-md-7 mb-5" style="margin:0 auto;">
        <div class="p-5 bg-light">
<form action="paylist.do" >
       <!--  <input type="hidden" id="m_id" name="m_id" value="m_id"> -->
        <div class="table-primary text-black" style="height:40px;">
        <h3 class="mb-5 text-center" >영수증</h3>
        </div>
        <br>
        <table class="table table-borderless">  
  <hr>
                <tr>
                <th>이름 </th>
                <td>${dto.m_name }(${dto.m_id })</td>
                </tr>
                <tr>
                <th>신청내역</th>
                <td>${dto.c_prod }</td>
                </tr>
                <tr>
                <th>수강료</th>
                <td>${dto.c_price } 원</td>
                </tr>
                <tr>
                <th>결제일</th>
                <td>${dto.ap_date.substring(0,10) }</td>
                </tr>
                <tr>
                <th>결제방식</th>
                <td>${dto.ap_pay }</td>
                </tr>
                <tr>
                <th>주문번호</th>
                <td>${dto.ap_no }</td>
                
                </tr>
                 
                    
            
           <%--  <tbody> 
            <c:forEach var="dto" items="${list}"> 
                <tr>  
                	<td>${dto.p_no }</td>
                    <td>${dto.c_code }</td>  
                    <td><a href="read.do?w_code=${dto.w_code}"></a></td>
                    <td>${dto.tc_name }</td>
                    <td>${dto.c_price }</td>
                    <td>${dto.c_start.substring(0,10) }</td>
                    <td>${dto.p_sts }</td>
                    <td><input type="button" value="영수증" id="receipt" onclick='return open_receipt()'></td>
                </tr>  
            </c:forEach>
            </tbody> --%>
        </table>
		<hr>
    </form>
    </div>
</div>
</div>
</div>
</section>	  
<!-- 본문 끝  -->
<%-- <%@ include file="../footer.jsp"%> --%>