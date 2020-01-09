<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- 본문시작  -->
<section>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
    $(function(){
        var responseMessage = "<c:out value="${msg1}" />";
        var Message = "<c:out value="${msg2}" />";
            alert(responseMessage);
        if(Message != ""){
            location.href="noread.do?n_no="+${dto.n_no};
        }else{
        	history.back();
        }
    }) 
</script>
</section>	  
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>