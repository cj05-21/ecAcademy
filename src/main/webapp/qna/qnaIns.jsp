<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="/header.jsp"%>
<%@ include file="ssi.jsp" %>
<!-- 본문시작  -->
<section>
<!-- 해당 유저의 ID 체크 -->
<!-- 
q_code		NOT NULL			NUMBER	5	Q&A코드(어떤게 질문이고 답변인지 알아보는 것)
q_no	PK	NOT NULL			NUMBER	5	번호
q_subject		NOT NULL			VARCHAR	30	제목
m_id	FK	NOT NULL	mem_inform	m_id	VARCHAR	20	아이디 (작성자)
q_date		NOT NULL			DATE	default  sysdate 	작성일 (자동추가)
q_group		NOT NULL			NUMBER	5	그룹(어떤것에대한 답변인지 질문과 답변을 묶는것)
q_content		NOT NULL			VARCHAR	255	상세내용 
-->




</section>
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>