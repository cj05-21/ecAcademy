<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<!-- 본문시작  -->

<form name="applyPay_tong" action="./alert.do" >

<section>
<div class="container mt-3"> 

<input type="hidden" name="ap_no" value="${dto.ap_no }">
<%-- <input type="hidden" name="w_code" value="${dto.w_code }">  
<input type="hidden" name="m_id" value="${m_id }">   --%>
     <div class="container" >
			<table class="table table-borderless">
			<thead>
				<tr class="table-primary text-black">
					<th scope="col">주문번호</th>
					<th scope="col">과목명</th>
					<th scope="col">결제일</th>
					<th scope="col">결제액</th>
				</tr>
				<tr>
					<td>${dto.ap_no }</td>
					<td>${dto.c_prod }	</td>
					<td>${dto.ap_date.substring(0, 10) }</td>
					<td>${dto.c_price }	</td>
					
				</tr>
			</thead>
			</table>	
			<br><br>	
			<div class="col-md-6 mb-5" style="margin: 0 auto;">  <!-- col-md-'숫자'가 사이즈 조절 // margin : 두 개가 나오면 상하, 네개가 나오면 상하좌우 -->
				<div class="p-5 bg-light">	
					<div class="form-group">
						<label for="tong_name">입금자명</label> <input type="text"
							class="form-control" id="tong_name" name="tong_name" required>
					</div>
					<div class="form-group">
						<label for="bank">입금은행</label> 
							<br>
						<select class="form-control" name='myBank' id='myBank'>
							<option value='1'> 국민 :: 123-456789-123
							<option value='2' > 농협 :: 456-78-987654-02
							<option value='3'> 신한 :: 987414-92-32145 
					   </select>
					</div>
					
<br>
					<div class="form-group" style="text-align: center; ">
						<input type="submit" value="결제완료" class="btn btn-primary" >
						<input type="button" value="취소" class="btn btn-primary" onclick="history.back();">
					</div>
					</div>
				</div>
			</div>
		</div>
</section>	  
</form>
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>