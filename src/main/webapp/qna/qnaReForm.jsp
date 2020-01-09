<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<%@ include file="ssi.jsp" %>
<!-- 
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet"> 
먼저 들어가 있던 부트스트랩 링크, 3.3.5 로 안되서 4.0으로 바꿔서 넣어보니 됨
-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>

<!-- 본문시작  -->
<section>
	<form name="qnafrm" method="post" action="qnaRe.do">
		<input type="hidden" name="s_id" id="s_id" value="${s_id}"><!-- 로그인 정보 로드하기 -->
		<input type="hidden" name="q_no" value="${dto.q_no}">
	<div class="site-section" id="property-details">
		<div class="container">
			<h3 class="text-black mb-2">Q&A</h3>
			<span style="font-size: 30px; color: black;">
			<strong>답변등록</strong></span>
			<p style="text-align: right;">표시할 이름&nbsp;|&nbsp;${s_id}&nbsp;&nbsp;</p>
			<hr style="height: 2px; background: black;">
		 <!-- 본항목 수정하기 -->
					<div class="mb-5">
						<h3 class="text-black mb-4"></h3>
						<input type="text" class="form-control" name="q_subject" id="q_subject" placeholder="답변제목">
						<hr>
						<%//TODO Rows:줄넘기기 가 가능한 횟수. "4"라면 4줄. COLS :한 줄 에"숫자"만큼의 글자를작성가능. %>
						<textarea rows="5" cols="50"  id="q_content" name="q_content"></textarea>
						<div style="float: right;">
							<button type="submit" class="btn btn-primary" style="position: relative; top: 10px">
							등록</button>
							<button type="reset" class="btn btn-primary" style="position: relative; top: 10px">
							취소</button>
					</div>
				</div>
		</div>
	</form>		
</section>
<script>

$('#q_content').summernote({
        placeholder: '이 곳에 내용을 입력해주십시오.',
        minHeight: null, maxHeight: null,
        height: 300, focus: true,
        lang: 'ko-KR',
        onImageUpload: function(files, editor, welEditable) {
            sendFile(files[0], editor, welEditable);
        }
      });

</script>
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>