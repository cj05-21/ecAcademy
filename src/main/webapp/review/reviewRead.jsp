<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<!-- 본문시작  -->
<section>
	<img  src="../images/reviewre.png" style="width:100%;">
    <div class="site-section" id="property-details">
      <div class="container">
 		<h3 class="text-black mb-4"></h3>
 			  <span style="font-size:30px; color:black;"><strong>${dto.r_subject} 후기</strong></span>
 			  <p style="text-align: right;">${dto.m_id} 수강생 &nbsp; |&nbsp;<span>${dto.r_date.substring(0,10)}</span> </p>
 			  <hr style="height:2px; background:black;">                        
 		      <div style="text-align: right;"><span>
 		      	수강생 평점 &nbsp;
				<c:set var="star" value="${dto.score}" />
				<c:url value="../images/yellowstar.png" var="data"/>
				<c:if test="${star eq 5 }">
    			<img class="star" src="${data}" ><img class="star" src="${data}" ><img class="star" src="${data}" ><img class="star" src="${data}" ><img class="star" src="${data}" >
				&nbsp;${dto.score}
				</c:if>
				<c:if test="${star eq 4 }">
    			<img class="star" src="${data}" ><img class="star" src="${data}" ><img class="star" src="${data}" > <img class="star" src="${data}" >
				&nbsp;${dto.score}
				</c:if>
				<c:if test="${star eq 3 }">
    			<img class="star" src="${data}" ><img class="star" src="${data}" ><img class="star" src="${data}" >
				&nbsp;${dto.score}
				</c:if>
				<c:if test="${star eq 2 }">
    			<img class="star" src="${data}" ><img class="star" src="${data}" >
				&nbsp;${dto.score}
				</c:if>
				<c:if test="${star eq 1 }">
    			<img class="star" src="${data}" >
				&nbsp;${dto.score}
				</c:if>
				</span>&nbsp; |&nbsp;조회수 <span>${dto.r_readcnt}</span></div>
				<!--후기 이미지  -->		        
		        <div class="row">
		          <div class="col-lg-6">
		            <c:choose>
					<c:when test="${dto.poster eq null}">
					<br>
		    		<img  src="../images/poster.jpg" width="450">
					</c:when>
					<c:otherwise>
					<br>
					<img src="storage/${dto.poster}" width="450">
			        </c:otherwise>
					</c:choose>
		          </div>
          		 <div class="col-lg-6 pl-lg-6 ml-auto">
           		 <div class="mb-5">
             	 <h3 class="text-black mb-4"></h3>
 			 	 <p>후기 내용 : </p><hr>                        
 		     	 <div style="height:250px;">
 		     	 ${dto.r_content }
 		     	 </div>
              	<p style="text-align: center;">
              
	        
	         <input type="hidden" id="r_no" name="r_no" value="${dto.r_no}">
	         <input type="hidden" id="s_id" name="s_id" value="${s_id}">
	         <button type="button" id="update" class="btn btn-primary"> 
	            <span class="spinner-border spinner-border-sm"></span> 
	            	수정
	        </button>
	         
	         <button type="button" id="delete" class="btn btn-primary"> 
	            <span class="spinner-border spinner-border-sm"></span> 
	            	삭제
	        </button>
             </p>
            </div>
          </div>
        </div> 
      </div>
    </div>
 
</section>
<script>
$("#write").click(function(){
	//$.post("요청명령어", 전달값, 콜백함수, 응답받는형식)
	var params="s_id="+$("#s_id").val();
	$.post("idcheck.do", params, checkID, "json");
});

$("#update").click(function(){
	//$.post("요청명령어", 전달값, 콜백함수, 응답받는형식)
	var params="s_id="+$("#s_id").val()+"&r_no="+$("#r_no").val();
	$.post("idcheck1.do", params, IdCheck1, "json");
});

$("#delete").click(function(){
	//$.post("요청명령어", 전달값, 콜백함수, 응답받는형식)
	var params="s_id="+$("#s_id").val()+"&r_no="+$("#r_no").val();
	$.post("idcheck1.do", params, IdCheck2, "json");
});
function checkID(result){
	  //1)text 응답
	  //alert(result);
	  
	  //2)json 응답
	  //alert(result);
	  //alert(result.count);
	  var count=eval(result.count);
	  if(count==1){
		  location.href="./review.do"
	  }else{
		  alert("로그인후 이용가능합니다.");
		  location.href="../member/login.do"
	  }//if end
	  
  }//checkID() end
  function IdCheck1(result){
	  //2)json 응답
	  //alert(result);
	  var id=result.id;
	  var m_id=$("#s_id").val();
	  
	  var r_no=eval(result.r_no);
	  if(id==m_id){
		  location.href="./reupdate.do?r_no="+r_no
	  }else{
		  alert("작성자만 수정할 수 있습니다.");
		  location.href="#"
	  }//if end
	  
  }//IdCheck() end
  
  function IdCheck2(result){
	//2)json 응답
	  //alert(result);
	  var id=result.id;
	  var m_id=$("#s_id").val();
	  
	  var r_no=eval(result.r_no);
	  if(id==m_id){
		  location.href="./confirm.do?r_no="+r_no
	  }else{
		  alert("작성자만 삭제할 수 있습니다.");
		  location.href="#"
	  }//if end
  }//IdCheck() end
</script>
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>