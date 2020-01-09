<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/header.jsp"%>
<%@ include file="ssi.jsp" %>
<script src="../js/jquery.js"></script>
<!-- 본문시작  -->
<section>
<script>
	$(function() {
		var responseMessage = "<c:out value="${msg1}" />";
		var Message = "<c:out value="${msg2}" />";
		alert(responseMessage);
		if (Message != "") {
			location.href = "qnaList.do"
		} else {
			history.back();
		}
	})
</script>
<a href="qnaList.do">경고창이 뜨도록 수정할것.</a>
</section>
<!-- 본문 끝  -->
<%@ include file="/footer.jsp"%>