<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<%@ include file="../member/auth.jsp"%>
<!-- 본문시작  -->

<!-- <script>
	$("#receipt").onclick(function open_receipt(){
		window.open("/pay/receipt.do","receipt","width=400 height=350")
	}//function() end
</script> -->
<section>
<div class="container">  
<form action="paylist.do">
        <h1 style="text-align:center;color:green;"> 
            나의 수강내역
        </h1>  
        <br>
       <!--  <input type="hidden" id="m_id" name="m_id" value="m_id"> -->
        <table class="table table-borderless">  
            <thead>  
                <tr class="table-primary text-black">  
                    <th scope="col">강좌분류</th>    
                    <th scope="col">강좌명</th>  
                    <th scope="col">강사명</th>   
                    <th scope="col">수강료</th>
                    <th scope="col">수업시작일</th>  
                    <th scope="col">상태</th>   
                    <th scope="col">결제상세</th> 
                </tr>  
            </thead>  
            <tbody> 
            <c:forEach var="dto" items="${list}"> 
                <tr>  
                    <td>${dto.c_code}</td>  
                    <td><a href="read.do?w_code=${dto.w_code}">${dto.c_prod}</a></td>
                    <td>${dto.tc_name}</td>
                    <td>${dto.c_price}</td>
                    <td>${dto.c_start.substring(0,10) }</td>
                    <td>${dto.p_sts }</td>
                    <td>
                    	<input type="button" value="영수증" id="receipt" 
                    	onclick="window.open('./receipt.do?w_code=${dto.w_code}&s_id=${s_id}','receipt','width=600 height=800')" 
                    	class="btn btn-primary" style="width:120px; height:50px;">
                    </td>
                </tr>  
            </c:forEach>
            </tbody>
        </table>

    </form>
    </div>  

</section>	  
<!-- 본문 끝  -->
 <%@ include file="../footer.jsp"%> 