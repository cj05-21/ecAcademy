<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//auth.jsp
	//로그인 상태 확인 페이지
	String s_id ="";
	String s_pw= "";
	String s_mlevel="";
	
	if(session.getAttribute("s_id")    ==null ||
	   session.getAttribute("s_pw")==null ||
	   session.getAttribute("s_mlevel")==null){
		s_id     = "guest";
		s_pw = "guest";
		s_mlevel = "guest";
	}else{
		s_id     = (String)session.getAttribute("s_id");
		s_pw = (String)session.getAttribute("s_pw");
		s_mlevel = (String)session.getAttribute("s_mlevel");
	}//if end
%>
