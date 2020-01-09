<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<!-- 본문시작  -->
<section>
<form name="sogaefrm" method="post" action="./sgcreate.do"
 enctype="multipart/form-data">

<div class="container">
<div class="col-md-6 mb-5" style="margin: 0 auto;">
<h3 class="mb-5">강좌 소개등록</h3>
<div class="p-5 bg-light">


<div class="form-group">
<label for="img_aIF">이미지 </label> <input type="file"
class="form-control" id="img_aIF" name="img_aIF">
</div>
<br>

<div class="form-group">
<label for="img_bIF">이미지 </label> <input type="file"
class="form-control" id="img_bIF" name="img_bIF">
</div>
<br>

<div class="form-group">
<label for="img_cIF">이미지 </label> <input type="file"
class="form-control" id="img_cIF" name="img_cIF">
</div>
<br>

<div class="form-group">
<label for="img_dIF">이미지 </label> <input type="file"
class="form-control" id="img_dIF" name="img_dIF">
</div>



<div class="form-group">
<input type="submit" value="등록" class="btn btn-primary">
<input type="reset" value="취소" class="btn btn-primary">
</div>

</div>
</div>
</div>
</form>
</section>	  
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>