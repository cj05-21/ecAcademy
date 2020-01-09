<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<!-- 본문시작  -->
<section>
<div class="container">
	<br><br>
     <!-- <div class="comment-form-wrap pt-5">  -->
      <div class="col-md-9 mb-5" style="margin:0 auto; ">
         <div class="table-primary text-black" style=" ; height:50px;">
           <h2 class="mb-5 text-center">마이페이지</h2>
         </div>
         <br>
         <form name="memform" method="post" action="mypage.do" class="p-5 bg-light" >
         	<div class="row" style="padding-bottom: 60px;" >         		       			
         			<table class="mytable" style="margin-right: 60px; margin-left: 35px; margin-top: 25px;" >
         				<tr>
         					<td style="text-align: center;">
         						<h4 class="text-center">회원정보 수정</h4>
         						<br>
         						<!-- <hr class="my-hr1"> -->
         						<input type="button" class="btn btn-mypage" value="수정" onclick="location.href='./mypage_update.do?s_id=${s_id}'">         						
         					</td>
         				</tr>         		
         			</table>         		
         		       		       			
         			<table class="mytable" style="align-self: right; margin-top: 25px;" >
         				<tr>
         					<td style="text-align: center;">
         						<h4 class="text-center">출석현황</h4>
         						<br>
         						<!-- <hr class="my-hr1"> -->
         						<input type="button" class="btn btn-mypage" value="이동" onclick="location.href='./mypage_update.do?s_id=${s_id}'">         						
         					</td>
         				</tr>         		
         			</table>       		
         	</div>	
         	<div class="row" style="padding-bottom: 20px;" >         			
         			<table class="mytable " style="margin-right: 60px; margin-left: 35px;">
         				<tr>
         					<td style="text-align: center;">
         						<h4 class="text-center">나의 수강목록</h4>
         						<br>
         						<!-- <hr class="my-hr1"> -->
         						<input type="button" class="btn btn-mypage" value="확인" onclick="location.href='../pay/paylist.do?s_id=${s_id}'">         						
         					</td>
         				</tr>         		
         			</table>        		       			
         			<table class="mytable" style="align-self: right;" >
         				<tr>
         					<td style="text-align: center;">
         						<h4 class="text-center">위시리스트</h4>
         						<br>
         						<!-- <hr class="my-hr1"> -->
         						<input type="button" class="btn btn-mypage" value="이동" onclick="location.href='../wish/wlist.do?s_id=${s_id}'">         						
         					</td>
         				</tr>
         		
         			</table>       		
         	</div>	
         </form>
    </div>
</div> 
<!-- </div> -->   
</section>	  
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>