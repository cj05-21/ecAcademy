<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<!-- 본문시작  -->
<section>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
    $(function(){
        var responseMessage = "<c:out value="${message1}" />";
        if(responseMessage != ""){
            alert(responseMessage)
            location.href='login.do';
        }
        
        var responseMessage = "<c:out value="${message2}" />";
        if(responseMessage != ""){
            alert(responseMessage)
            history.back();
        }
    }) 
</script>



</section>	  
<!-- 본문 끝  -->
