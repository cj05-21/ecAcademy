<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<!-- 본문시작  -->
<section>
<form name="applyPay_Card" action="./alert.do" >
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
					<div class="form-group">
						<label for="tong_name">카드명의자</label> <input type="text"
							class="form-control" id="tong_name" name="tong_name" required>
					</div>
					<div class="form-group">
						<label for="card">카드사</label> 
							<br>
						 <input type="radio" name='card' value='sh' checked> 신한  <!-- 그룹 중 하나만 선택하려고할 때 name 적용 --> 
			   			 <input type='radio' name='card' value='kb' > KB국민			   			
			   			 <input type="radio" name='card' value='nh'> NH			   			
			   			 <input type="radio" name='card' value='lo'> 롯데			   			 
			   			 <input type="radio" name='card' value='wr'> 우리 			   			 
			   			 <input type="radio" name='card' value='ss'> 삼성 
			   			 <input type="radio" name='card' value='hn'> 하나			   			
					</div>
					<div class="form-group">
						<label for="card_num">카드번호</label> <input type="text"
							class="form-control" id="card_num" name="card_num" required>
							* 입력시 하이픈 (-) 은 불필요합니다.
					</div>
					<div class="form-group">
						<label for="card_long">유효기간</label> 
						<div class="row">
						
						<input type="text" class="form-control" id="card_m" name="card_m" style="width: 46%; margin-left: 18px;" placeholder="월" required>
						<input type="text" class="form-control" id="card_y" name="card_y" style="width: 46%; margin-left: 5px;" placeholder="년" required> 
						</div>
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