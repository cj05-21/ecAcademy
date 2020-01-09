<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!-- 본문시작  -->
<section>
	<form name="classfrm" method="post" action="./clcreate.do"
		enctype="multipart/form-data">

		<div class="container">
			<div class="col-md-6 mb-5" style="margin: 0 auto;">
				<h3 class="mb-5">강좌 등록</h3>
				<div class="p-5 bg-light">

					<div class="form-group">
						<label for="c_code">강좌</label> <select name='c_code' id='c_code'
							class="form-control px-6">
							<option value='TOEIC' selected>TOEIC
							<option value='TOEFL'>TOEFL
							<option value='TEPS'>TEPS
							<option value='OPIC'>OPIC
						</select>
					</div>

					<div class="form-group">
						<label for="c_prod">강좌명 </label> <input type="text"
							class="form-control" id="c_prod" name="c_prod">
					</div>



					<div class="form-group">
						<label for="c_book">교재명 </label> <input type="text"
							class="form-control" id="c_book" name="c_book">
					</div>


					<div class="form-group">
						<label for="c_price">수강료 </label> <input type="text"
							class="form-control" id="c_price" name="c_price">
					</div>

					<div class="form-group">
						<label for="c_imageIF">대표이미지 </label> <input type="file"
							class="form-control" id="c_imageIF" name="c_imageIF">
					</div>

					<div class="form-group">
						<label for="c_detIF">강좌상세설명 </label> <input type="file"
							class="form-control" id="c_detIF" name="c_detIF">
					</div>


					<div class="form-group">
						<label for="c_max">최대정원 </label> <input type="text"
							class="form-control" id="c_max" name="c_max">
					</div>
 						<input type="hidden"class="form-control" id="c_test" name="c_test" value="test.jsp">
					

					<div class="form-group">
						<label for="c_date">강좌 등록일 </label> <input type="text"
							class="form-control" id="c_date" name="c_date">
					</div>

					<div class="form-group">
						<label for="c_datend">신청 마감일 </label> <input type="text"
							class="form-control" id="c_datend" name="c_datend">
					</div>
					<div class="form-group">
						<label for="c_start">수업 시작일 </label> <input type="text"
							class="form-control" id="c_start" name="c_start">
					</div>
					<div class="form-group">
						<label for="c_end">수업 종료일 </label> <input type="text"
							class="form-control" id="c_end" name="c_end">
					</div>

					<div class="form-group">
						<input type="submit" value="등록" class="btn btn-primary"> <input
							type="reset" value="취소" class="btn btn-primary">
					</div>

				</div>
			</div>
		</div>
	</form>
</section>
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>