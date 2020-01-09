<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<!-- 본문시작  -->
<section>
<div class="sidebar-box" style="width:200px;margin-left:150px;">

<img src="../images/manager.png" alt="Image" class="img-fluid" width="150px" height="150px"><br>
	<div style="width:150px; text-align:center;color:red;" ><strong>${dto.m_name }</strong></div>
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
<div class="container mt-6" >  
	<div class="col-md-11 mb-5" style="margin:0 auto;">
        <h1 style="text-align:center;color:green;"> 
            Attend
        </h1>  
        <form>
        <ul class="nav nav-tabs" role="tablist"> 
            <li class="nav-item"> 
                <a class="nav-link active" data-toggle="tab" href="#before" >출석 목록 </a> 
            </li> 
        </ul> 
        <br>
    <!--  -->    
        <div class="tab-content"> 
            <div id="before" class="container tab-pane active"> 
               <table class="table table-borderless" >  
            <thead>  
                <tr class="table-primary text-black" >  
                    <th scope="col">Member</th>  
                    <th scope="col">Name</th>  
                    <th scope="col" style="width:150px;">Class</th>  
                    <th scope="col">Teacher</th>  
                    <th scope="col">Start</th>  
                    <th scope="col">End</th>  
                    <th scope="col">Sts</th>  
                    <th scope="col" style="width:4px;">Attend</th>  
                </tr>  
            </thead>  
            <c:forEach var="dto" items="${check}" >
			<tr>
			<td>${dto.m_id }m_id</td>
			<td>${dto.m_name }m_name</td>
			<td>${dto.c_prod }[c_prod]</td>
			<td>${dto.tc_name }tc_name</td>
			<td>${dto.c_start }c_start</td>
			<td>${dto.c_end }c_end</td>
			<td>${dto.p_sts }p_sts</td>
			<td>
			<input style="padding: 5px 13px" type="button" class="btn btn-primary"  value="출석완료" >
			</td>
			</tr>
 		</c:forEach>
        </table> 
            </div> 
        </div> 
        </form>
        <br><br> <br><br> <br><br><br><br><br><br>
    </div> 
    </div>
</div>   
</section>
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>