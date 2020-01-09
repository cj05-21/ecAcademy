<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<%@ include file="../member/auth.jsp"%>
<!-- 본문시작  -->
<section>
                
 <div class="sidebar-box" 
   style=" width: 250px; margin-left: 200px; ">
              <div class="categories mb-5" >
              <br><br><br><br><br><br><br><br><br>
                <li style="font-size:17px;"><a href="./mypage.do?s_id=${s_id }"> - 나의 회원 정보 </a></li>
                <br>
                <li style="font-size:17px;"><a href="#"> - 나의 출석 현황 </a></li>
                <br>
                <li style="font-size:17px;"><a href="../pay/paylist.do?s_id=${s_id}"> - 나의 수강목록 </a></li>
                <br>               
                <li style="font-size:17px;"><a href="#"> - 게시물 관리 </a></li>
                <br>
                <li style="font-size:17px;"><a href="../wish/wlist.do?s_id=${s_id}"> - 위시리스트 </a></li>
              </div>
            </div>


	<div class="container">
	
			<br><br>
             <!--  <div class="comment-form-wrap pt-5"> -->
              <div class="col-md-9 mb-5" style="margin:0 auto; ">
             <div class="table-primary text-black" style=" ; height:50px;">
              <h2 class="mb-5 text-center">마이페이지</h2>
              </div>
              <hr>
                  <div class="text-right"><a href="./mem_delete.do?s_id=${s_id }"><i class="">회원탈퇴하기</i></a> &nbsp;&nbsp;&nbsp;&nbsp;</div><br>
                <div class="p-5 bg-light" >
                <h3 class="mb-5 text-center"  >회원정보 수정</h3>
                <form name="memform" method="post" action="mypage.do" class="p-5 bg-light" >
                  <div class="form-group">    
                    <label for="m_id">아이디</label><br> <!-- 못바꿈 -->
                    <input type="text" class="form-control" id="m_id" name="m_id" value="${s_id }" style="width:200px;" readonly>
                    <input type="hidden" name="s_id" id="s_id" value="${s_id}">
                  </div>
                  <div class="form-group">
                    <label for="m_pw">비밀번호</label>  <!-- 변경가능 -->
                    <input type="password" class="form-control" id="m_pw" name="m_pw" value="${dto.m_pw }" style="width:200px;">
          			<div id="pw_up" style="display:none;"></div><br>
          			<input type="button" id="m_pw_button" value="비밀번호 변경"  onclick="return m_pw_update()" class="btn btn-primary" style="height:50px; width:160px;">
                  </div>
                            
                  <div class="form-group">
                    <label for="m_name">이름</label> <!-- 못바꿈 -->
                    <input type="text" class="form-control" id="m_name" name="m_name" value="${s_name }"style="width:200px;"> 
                  </div>                         
                  <div class="form-group">
                    <label for="m_email">이메일</label>
                    <input type="email" class="form-control" id="m_email" name="m_email" value="${dto.m_email }"style="width:200px;">             
     			    </div>		         
                  <div class="form-group">
                    <label for="m_phone">전화번호</label>
                    <input type="text" class="form-control" id="m_phone" name="m_phone"  value="${dto.m_phone }"style="width:200px;">                   
                  </div>     			   
                  <div class="form-group">
                    <label for="m_job">직업</label>
                    <input type="text" class="form-control" id="m_job" name="m_job" value="${dto.m_job }"style="width:200px;">                 
                  </div>

                  <div class="form-group">
                     <!-- 갱신가능 -->
                	 환불 계좌번호
                    <input type="text" class="form-control" id="ref_acount" name="ref_acount" value="${dto.ref_acount }"style="width:400px;">
                  </div>
                  <div class="form-group">
                   	 예금주명
                    <input type="text" class="form-control" id="ref_name" name="ref_name"value="${dto.ref_name }" style="width:200px;">
                 <br>
                    <input type="submit" id="submit" value="수정완료" class="btn btn-primary">
                   </div> 
                   <br>
                  <hr>
                </form>
              </div>
           
             </div>
           </div>

</section>

<script>
	function m_pw_update(){
		//alert('왜안돼');
		
		$.post("m_pw_update.do"    //요청서버
			  ,"m_pw="+$("#m_pw").val()+"&s_id="+$("#s_id").val()   //서버 전달값
			  ,responseProc   //콜백함수
				); //post() end
			
	}; //keyup() end
	
	function responseProc(result){
				
		$("#pw_up").empty();
		$("#pw_up").html(result);
		$("#pw_up").show();
		
	}//responeseProc() end
/*	
	function mem_update(){
		$.post("mem_update.do"
				,"m_name="$("m_name").val()+"&m_email="+$("#m_email").val()
				+"&m_phone="+$("#m_phone").val()+"&m_job="+$("#m_job").val()
				+"&ref_count="+$("#ref_count").val()+"&ref_name="+$("#ref_name").val()
				,respon
		
		)//post() end
	}
*/	
	
</script>	
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>