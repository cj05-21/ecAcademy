<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<!-- 본문시작  -->
<section>
<div class="sidebar-box" style="width:200px;margin-left:150px;">

<img src="../images/manager.png" alt="Image" class="img-fluid" width="150px" height="150px"><br>
	<div style="width:150px; text-align:center; color:red;" ><strong>${dto.m_name }</strong></div>
	<div style="width:150px; text-align:center;" >${dto.m_email }</div>
	<div style="width:150px; text-align:center;" >${dto.m_phone}</div>
<br>
	<div style="width:150px; text-align:center;" >
	<a href="../member/logout"><i class="fa fa-sign-out"></i> 로그아웃</a>
	</div>
<br><br>	
	<div class="categories">		
                <h3>Categories</h3>
                <ul>
                <li><a href="../apply/applylist.do?s_id=${s_id }">수강목록</a></li>
                <li><a href="../attend/attend.do?s_id=${s_id }">출석 등록</a></li>
                <li><a href="../attend/afterattend.do?s_id=${s_id }">출석 목록</a></li>
                <li><a href="../manage/mem_manage.do">회원관리</a></li>
                </ul>
              </div>
</div> 

<div class="container mt-3">  
    <div class="col-md-11 mb-5" style="margin:0 auto;">
        <h1 style="text-align:center;color:green;"> 
            	회원목록
        </h1>  
        <form>
        <ul class="nav nav-tabs" role="tablist"> 
            <li class="nav-item"> 
                <a class="nav-link active" data-toggle="tab" href="#whole" >회원</a> 
            </li> 
        </ul> 
        <br>
    <!--  -->    
        <div class="tab-content"> 
            <div id="whole" class="container tab-pane active"> 
               <table class="table table-borderless" >  
            <thead>  
                <tr class="table-primary text-black" >  
                    <th scope="col">Level</th>  
                    <th scope="col">Id</th>  
                    <th scope="col">Name</th>  
                    <th scope="col">Job</th>  
                    <th scope="col">Email</th>  
                    <th scope="col">Phone</th>  
                </tr>  
            </thead>  
            <c:forEach var="dto" items="${list}">
			<tr>
			<td style="font-size: 16px"><a href="./mem_update.do?m_id=${dto.m_id }">${dto.m_level}</a></td>
			<td style="font-size: 16px"><a href="./mem_update.do?m_id=${dto.m_id }">${dto.m_id}</a></td>
			<td style="font-size: 16px"><a href="./mem_update.do?m_id=${dto.m_id }">${dto.m_name}</a></td>
			<td style="font-size: 16px">[${dto.m_job}]</td>
			<td style="font-size: 16px">${dto.m_email}</td>
			<td style="font-size: 16px">${dto.m_phone}</td>
			</tr>
 		</c:forEach>
        </table> 
            </div> 
            </div> 
             <br>
        </form>
        </div>
        </div>
        
</section>	  
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>