<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<!-- 본문시작  -->
<section>
<form name="applyPay_Phone" action="./alert.do" >
<input type="hidden" name="ap_no" value="${dto.ap_no }">
<div class="container mt-3">  

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
    </div>
 	<br><br>
			<div class="col-md-6 mb-5" style="margin: 0 auto;">  <!-- col-md-'숫자'가 사이즈 조절 // margin : 두 개가 나오면 상하, 네개가 나오면 상하좌우 -->
				<div class="p-5 bg-light">	
					<div class="form-group row" >
						<label for="tong_name">가입자명</label> <input type="text"
							class="form-control" id="tel_name" name="tel_name" required>
					</div>
					<div class="form-group row">
					<label for="bank">핸드폰번호</label> 
					   <select name='myTel' id='myTel' class="form-control" style="width: 30%; height: 78%; margin-left: 10px; margin-bottom: 5px;">
							<option value='1'> SKT
							<option value='2' > KT
							<option value='3'> LGT 
					   </select>
						<input type="text"
							class="form-control" id="Tel" name="Tel" required>
					</div>
<br>
			
					<div class="form-group" style="text-align: center; ">
						<input type="submit" value="결제완료" class="btn btn-primary" >
						<input type="button" value="취소" class="btn btn-primary" onclick="history.back();">
					</div>
					
					</div>

				</div>
			</div>
		
  
     </form>
</section>	  
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>