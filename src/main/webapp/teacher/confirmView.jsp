<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
        
<!-- 본문시작  -->
<section>
	<!-- alert 창 띄워서 반응하기 -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="../js/jquery.js"></script> 
<script>
    $(function(){
        var msg1 = "<c:out value="${msg1}" />";
        var msg2 = "<c:out value="${msg2}" />";
        var msg3 = "<c:out value="${msg3}" />";
         if(confirm(msg1)){
            alert(msg2);
            location.href="list.do";
        }else{
        	alert(msg3);
        	history.back();
        }
    }); 
   
</script>	
</section>	  
