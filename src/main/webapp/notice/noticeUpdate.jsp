<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js-->
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote-bs4.js"></script>
<section>
 <div class="comment-form-wrap pt-5">
 	<div class="container">
 		<div class="col-md-8 mb-5" style="margin: 0 auto;">
                <h2 class="mb-5">Notice</h2>
                <form method="post" action="noupdate.do" class="p-4 bg-light" onsubmit="return update()">
                  <input type="hidden" value="${dto.n_no}" name="n_no">
                  <label for="name">안내/점검 *</label>
                  <select name="inform"  class="custom-select mb-3"> 
		                <option selected>Select inform</option> 
		                <option value="안내" selected>안내</option> 
		                <option value="점검">점검</option> 
		            </select> 
                  <div class="form-group">
                    <label for="name">subject *</label>
                    <input type="text" class="form-control" name="n_subject" id="n_subject" value="${dto.n_subject}"> 
                  </div>
                  <div class="form-group">
                    <label for="writer">writer *</label>
                    <input type="text" class="form-control" name="m_id" id="m_id" value="${dto.m_id}" readonly>
                  </div>
                  <div class="form-group">
                    <label for="message">content *</label>
                    <textarea name="n_content" id="n_content" cols="30" rows="10" class="form-control">${dto.n_content}</textarea>
                  </div>
                  <div class="form-group" style="float: right;">
                    <input type="submit" value="수정" class="btn btn-primary">
                    <input type="button" value="목록" class="btn btn-primary" onClick="location.href='./nolist.do'">
                  </div>
                </form>
               </div>
             </div>
           </div>
</section>	  
<script>
function update(){
	if(confirm("수정하시겠습니까?")){
		return true;
	}else{
		return false;
	}
}

function check(f){
	//inform
	var inform=f.inform.value;
	if(inform==0){
		alert('안내/점검을 선택해 주세요');
	return false;
	}
	var n_subject=f.n_subject.value;
	if(n_subject<5||n_subject>20){
		alert('제목을 5~20자 안으로 입력해주세요.');
		return false;
	}
	var m_id=f.m_id.value;
	if(m_id<4||m_id>10){
		alert('작성자를 4~10자 안으로 입력해주세요');
		return false;
	}
	
	var n_content=f.n_content.value;
	if(n_content<4||n_content>20){
		alert('내용을 4~20자 안으로 입력해주세요.');
		return false;
	}
}
$('#n_content').summernote({
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