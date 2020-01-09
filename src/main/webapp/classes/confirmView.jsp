<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- 본문시작  -->
<section>
	<!-- alert 창 띄워서 반응하기 -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="../js/jquery.js"></script> 
<form method="post" action="delete.do">
<script>
    $(function(){
        var msg1 = "<c:out value="${msg1}" />";
        var msg2 = "<c:out value="${msg2}" />";
        var msg3 = "<c:out value="${msg3}" />";
        var delConfirm=confirm(msg1);
        if(delConfirm){
        	alert(msg2);
            location.href="delete.do?w_code="+${dto.w_code};
        }else{
        	alert(msg3);
        	history.back();
        }
    }); 
</script>	
</form>
</section>
  

