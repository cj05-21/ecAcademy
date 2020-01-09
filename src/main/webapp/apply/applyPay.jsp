<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<!-- 본문시작  -->
<section>
<table class="table table-borderless" style="padding-top: 50px;">  
                <tr class="table-primary text-black">  
                    <th>주문번호</th>
                    <th>결제방법</th>                       
                    <th>결제일</th>  
                </tr>   
         		<tr>
					<td id="ap_pay">
						<input type="radio" name='payment' value='card'> 신용카드  <!-- 그룹 중 하나만 선택하려고할 때 name 적용 -->
						<input type="radio" name='payment' value='tongjang'> 무통장입금  <!-- 그룹 중 하나만 선택하려고할 때 name 적용 -->
			   			<input type='radio' name='payment' value='phone'> 휴대폰결제			  						 
					</td>
					
					<td id="ap_date">2019-11-04</td>  
			</tr>
     </table>  
</section>	  
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>