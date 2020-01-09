<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<%@ include file="ssi.jsp" %>
<!-- 본문시작  -->
<section>
	<img  src="../images/qnare.png" style="width:100%;">
	<form name="qnafrm" method="POST">
		<!-- onsubmit="return bbsCheck(this)"> -->
		<input type="hidden" name = "s_id" id="s_id" value="${s_id}"><!-- 임시로 설정한 "로그인한 계정" -->
		<input type="hidden" name = "s_level" id="s_level" value="${s_level}">
		<input type="hidden" name = "q_id" id="q_id" value = "${dto.q_id}">
		<input type="hidden" name = "q_no" id="q_no" value="${dto.q_no}">
	<div class="site-section" id="property-details">
		<div class="container">
			<h3 class="text-black mb-2">Q&A</h3>
			<span style="font-size: 30px; color: black;"><strong>
					질문과 답변</strong></span>
			<p style="text-align: right;">작성자&nbsp;|&nbsp;${dto.q_id}&nbsp;&nbsp;</p>
			<hr style="height: 2px; background: black;">
			<div style="text-align: right;">
				<span>작성일</span>&nbsp;|&nbsp;${dto.q_date}
			</div>
				 <!-- 본항목 수정하기 -->
					<div class="mb-5">
						<h3 class="text-black mb-4"></h3>
						<p>${dto.q_subject}</p>
						<hr>
						<% // TODO UPDATE의 폼을 이 폼으로 수정 %>
						<div style="height: 250px;"><pre>${dto.q_content }</pre></div>
					</div>				
						<p style="float: right;">
							<button type="submit" class="btn btn-primary"
								formaction="qnaUp.set">수정</button>
							<button type="submit" class="btn btn-primary"
								formaction="qnaDel.do">삭제</button>
							<c:if test="${dto.q_code == 1}">
								<button type="submit" class="btn btn-primary"
									formaction="qnaRe.set">답변</button>
							</c:if>
						</p>
			</div>
		</div>

	</form>
</section>
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>