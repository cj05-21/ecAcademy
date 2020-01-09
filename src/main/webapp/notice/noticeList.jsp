<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>

<!-- 본문시작  -->
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
            NOTICE
        </h1>  
        <form>
        
        <br>
    <!--  -->    
<%
        	String s_id=(String)session.getAttribute("s_id");      
        	String s_level=(String)session.getAttribute("s_level");       
%>
        <div class="tab-content"> 
            
            <div id="whole" class="container tab-pane active"> 
               <table class="table table-borderless" >  
            <thead>  
                <tr class="table-primary text-black" >  
                				
                    <th scope="col">No.</th>  
                    <th scope="col">Inform</th>  
                    <th scope="col">Subject</th>  
                    <th scope="col">Date</th>  
                    <th scope="col">Views</th>  
                </tr>  
            </thead>  
            <c:forEach var="dto" items="${list}">
			<tr>
			<td>${dto.n_no }</td>
			<td>${dto.inform }</td>
			<td><a href="noread.do?n_no=${dto.n_no}">${dto.n_subject }</a></td>
			<td>${dto.n_date.substring(0,10) }</td>
			<td>${dto.n_readcnt }</td>
			</tr>
 		</c:forEach>
        </table> 
            </div> 
    
        </div> 
        <br>
        </form>
     	<c:if test="${s_level eq 'A' }">  
        	<div style="float: right;"> 
	         <a href="./notice.do"><button type="button" class="btn btn-primary"> 
	            <span class="spinner-border spinner-border-sm"></span> 
	            글쓰기
	        </button></a>   
        	</div>
        </c:if>	
       
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
			<form action="./nolist.do" onsubmit="return searchCheck(this)" > 
				<div class="p-5 form-group row">
				<select name="col" class="form-control" style="width: 20%; height: 78%; margin-right: 20px; margin-left: 45px;">
					<option value="inform">분류
					<option value="n_subject">제목
					<option value="n_content">내용					
					<option value="subject_content">제목+내용 <!-- 강사명+강좌명 둘 중 하나만이라도 검색어가 들어가 있으면 됨 -->
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
</script> 
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>