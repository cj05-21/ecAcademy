<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 본문시작  -->
<!--  <style>
 th, td {border-bottom: 1px solid #ddd;}
 </style>   -->   
    <script src= 
"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"> 
    </script> 
      
    <script src= 
"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"> 
    </script> 
      
    <script src= 
"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"> 
    </script> 	
<section>
 <div class="container mt-3">  
        <h1 style="text-align:center;color:green;"> 
            <br>
            Review
        </h1> 
        <div class="col-md-10 mb-5" style="margin: 0 auto;"> 
        <form>
        <br>
        <div class="tab-content"> 
            <!--전체  -->
            <div id="whole" class="container tab-pane active"> 
               <table class="table table-borderless" >  
            <c:forEach var="dto" items="${list}">
			<tr bordercolor="black">
			<td style="width: 254px;">
			
			<c:choose>
			<c:when test="${dto.poster eq null}">
    		<a href="./reread.do?r_no=${dto.r_no }"><img  src="../images/poster.jpg" width="200"></a>
			</c:when>
			<c:otherwise>
			<a href="./reread.do?r_no=${dto.r_no }"><img src="storage/${dto.poster}" width="200"></a>
	        </c:otherwise>
			</c:choose>

			</td>
			<td style="width: 500px;">
			<div>
				<div >
				<span><img src="../images/hot.gif "></span>
				<span><a href="./reread.do?r_no=${dto.r_no }">${dto.r_subject}</a></span>
				</div>
				<div><span>
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
				</span></div>
				<div>${dto.r_content }</div>
				<div>
				<span>${dto.c_code}</span>
				</div>
				<div>
				<span>${dto.m_id}</span>
				<hr style="width: 50%; border: insert 3px #dedada;">
				</div>
				
				
			</div>
			</td>
			<td style="text-align: center; font-size: 15px; padding: 5px;">
				<span>${dto.r_date.substring(0,10)}</span>
			</td>	
			<td style="text-align: right; font-size: 15px; padding: 5px;"> 
				<span>${dto.r_readcnt}</span>
			</td>		
			</tr>
		
 			</c:forEach>
        	</table> 
            </div>         
        </div> 
        <br>
        </form>
        </div>
        <input type="hidden" id="s_id" name="s_id" value="${s_id}">
        	<div style="float: right;"> 
	         <a href="./review.do"><button type="button" class="btn btn-primary"> 
	            <span class="spinner-border spinner-border-sm"></span> 
	            write
	        </button></a>   
        	</div>
     <!--페이징 -->
		<div class="custom-pagination text-center">
		${paging }
		
              <!-- <span>1</span>
              <a href="#">2</a>
              <a href="#">3</a>
              <span class="more-page">...</span>
              <a href="#">7</a>    -->     
		</div>		        
		
		<!-- 검색 -->
        <table class="table table-borderless" style="text-align: center;" >
        <tr>
			<td colspan="4" style="text-align: center; height: 50px" >      	  
			<form action="./relist.do" onsubmit="return searchCheck(this)" > 
				<div class="p-5 form-group row">
				<select name="col" class="form-control" style="width: 20%; height: 78%; margin-right: 20px; margin-left: 45px;">
					<option value="c_code">분류					
					<option value="r_subject">제목
					<option value="r_content">내용
					<option value="m_id">작성자
					<option value="sub_cont">제목+내용 <!-- 강사명+강좌명 둘 중 하나만이라도 검색어가 들어가 있으면 됨 -->
				</select>
				 	<input type="text" class="form-control" style="width: 50%; margin-right: 20px;" name="word"> 
				 	<input type="submit" value="검색" class="btn btn-primary">
				 	</div>
			</form>			
			</td>			
		</tr>		
		</table>
        	
        	
    </div>   
</section>	
<script>
<!-- 검색어를 입력하지 않았는데 검색이 될 수 있기 때문에 바리케이트 역할을 하는 js 를 적용  -->
function searchCheck(f){
  	var word=f.word.value;
  	word=word.trim();
  	if(word.length==0){  //길이가 0 이라는 것은 아무것도 들어가 있지 않다는 것
  		alert("검색어를 입력하세요.");
  		return false;	//서버 전송 불가
  	}//if end
  	return true;		//서버로 전송
}//searchCheck() end
$("#write").click(function(){
	//$.post("요청명령어", 전달값, 콜백함수, 응답받는형식)
	var params="s_id="+$("#s_id").val();
	$.post("idcheck.do", params, checkID, "json");
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
</script>
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>