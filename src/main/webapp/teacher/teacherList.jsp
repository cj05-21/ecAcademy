<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<!-- 본문시작 teacher/teacherList.jsp -->
<section>
<div class="container mt-3">  
      
        <h1 style="text-align:center;color:green;"> 
            TEACHER LIST
        </h1>  

        <ul class="nav nav-tabs" role="tablist"> 
            <li class="nav-item"> 
                <a class="nav-link active" data-toggle="tab" href="#TOEIC" >TOEIC</a> 
            </li> 
            <li class="nav-item"> 
                <a class="nav-link" data-toggle="tab" href="#TOEFL">TOEFL</a> 
            </li> 
            <li class="nav-item"> 
                <a class="nav-link" data-toggle="tab" href="#TEPS">TEPS</a> 
            </li> 
            <li class="nav-item"> 
                <a class="nav-link" data-toggle="tab" href="#OPIC">OPIC</a> 
            </li> 
        </ul> 
        <br>
    <!--  -->    
        <div class="tab-content">             
            <div id="TOEIC" class="container tab-pane active"> 
               <table class="table table-borderless" >  
            <thead>  
                <tr class="table-primary text-black">  
                    <th scope="col">강사번호</th>  
                    <th scope="col">강좌코드</th>    
                    <th scope="col">강사이름</th>  
                    <th scope="col">강좌명</th> 
                   <% String s_id=(String)session.getAttribute("s_id");
           			String s_name=(String)session.getAttribute("s_name");
           			String s_level=(String)session.getAttribute("s_level");%>
           			<c:if test="${s_level eq 'A' }">  
                    <th scope="col">수정/삭제</th>   
                    </c:if>
                </tr>    
            </thead>  
            <c:forEach var="dto" items="${list1}">
			<tr>
				<td>${dto.tc_no }</td>
				<td>${dto.c_code }</td>
				<td><a href="read.do?tc_no=${dto.tc_no }">${dto.tc_name }</a></td> 
				<td>${dto.c_prod }</td>
				<td>
	
           		<c:if test="${s_level eq 'A' }">
			<div>
				<input type="button" value="수정" class="btn btn-primary" style="padding: 5px 13px;" onclick="location.href='update.do?tc_no=${dto.tc_no} '">
				<input type="button" value="삭제" id="delete_btn" class="btn btn-primary" style="padding: 5px 13px;"  onclick="delCheck(${dto.tc_no})">
			</div>
			</c:if>
		</td>
			</tr>
 		</c:forEach>
        </table> 
            </div>         
            <div id="TOEFL" class="container tab-pane fade"> 
               <table class="table table-borderless" >  
            <thead>  
                 <tr class="table-primary text-black">  
                    <th scope="col">강사번호</th>  
                    <th scope="col">강좌코드</th>    
                    <th scope="col">강사이름</th>  
                    <th scope="col">강좌명</th> 
             
           			<c:if test="${s_level eq 'A' }">  
                    <th scope="col">수정/삭제</th>   
                    </c:if>
                </tr>   
            </thead>  
            <c:forEach var="dto" items="${list2}">
			<tr>
			<td>${dto.tc_no }</td>
			<td>${dto.c_code }</td>
			<td><a href="read.do?tc_no=${dto.tc_no }">${dto.tc_name }</a></td>  
			<td>${dto.c_prod }</td>
			<td>
		
           <c:if test="${s_level eq 'A' }">
			<div>
				<input type="button" value="수정" class="btn btn-primary" style="padding: 5px 13px;" onclick="location.href='update.do?tc_no=${dto.tc_no} '">
				<input type="button" value="삭제" id="delete_btn" class="btn btn-primary" style="padding: 5px 13px;"  onclick="delCheck(${dto.tc_no})">
			</div>
			</c:if>
			</td>
			</tr>
 		</c:forEach>
        </table> 
            </div> 
              
            <div id="TEPS" class="container tab-pane fade"> 
              <table class="table table-borderless" >  
            <thead>  
                <tr class="table-primary text-black">  
                    <th scope="col">강사번호</th>  
                    <th scope="col">강좌코드</th>    
                    <th scope="col">강사이름</th>  
                    <th scope="col">강좌명</th> 
           			<c:if test="${s_level eq 'A' }">  
                    <th scope="col">수정/삭제</th>   
                    </c:if>
                </tr>   
            </thead>  
            <c:forEach var="dto" items="${list3}">
			<tr>
			<tr>
			<td>${dto.tc_no }</td>
			<td>${dto.c_code }</td>
			<td><a href="read.do?tc_no=${dto.tc_no }">${dto.tc_name }</a></td>  
			<td>${dto.c_prod }</td>
			<td>
           <c:if test="${s_level eq 'A' }">
			<div>
				<input type="button" value="수정" class="btn btn-primary" style="padding: 5px 13px;" onclick="location.href='update.do?tc_no=${dto.tc_no} '">
				<input type="button" value="삭제" id="delete_btn" class="btn btn-primary" style="padding: 5px 13px;"  onclick="delCheck(${dto.tc_no})">
			</div>
			</c:if>
			</td>
			</tr>

 		</c:forEach>
        </table> 
            </div> 
            <div id="OPIC" class="container tab-pane fade"> 
              <table class="table table-borderless" >  
            <thead>  
                <tr class="table-primary text-black">  
                    <th scope="col">강사번호</th>  
                    <th scope="col">강좌코드</th>    
                    <th scope="col">강사이름</th>  
                    <th scope="col">강좌명</th> 
 
           			<c:if test="${s_level eq 'A' }">  
                    <th scope="col">수정/삭제</th>   
                    </c:if>
                </tr>  
            </thead>  
            <c:forEach var="dto" items="${list4}">

			<tr>
			<td>${dto.tc_no }</td>
			<td>${dto.c_code }</td>
			<td><a href="read.do?tc_no=${dto.tc_no }">${dto.tc_name }</a></td>  
			<td>${dto.c_prod }</td>
			
			<td>	
           <c:if test="${s_level eq 'A' }">
			<div>
				<input type="button" value="수정" class="btn btn-primary" style="padding: 5px 13px;" onclick="location.href='update.do?tc_no=${dto.tc_no} '">
				<input type="button" value="삭제" id="delete_btn" class="btn btn-primary" style="padding: 5px 13px;"  onclick="delCheck(${dto.tc_no})">
			</div>
			</c:if>
				</td>
			</tr>
 		</c:forEach>
        </table> 
            </div> 
        </div> 
        <br>
            <c:if test="${s_level eq 'A' }">
        	<div style="float: right;"> 
	         <button class="btn btn-primary" onclick="location.href='insert.do'"> 
	            <span class="spinner-border spinner-border-sm"></span> 
	            		글쓰기
	        </button>   
        	</div>
        	</c:if>
       </div>  
</section>
 <script>

 function delCheck(tc_no){
	 //alert(tc_no);
	 if(confirm("삭제할까요?")){
		 location.href="delete.do?tc_no=" + tc_no;
	 }
 }
 
</script>
      
	  
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>