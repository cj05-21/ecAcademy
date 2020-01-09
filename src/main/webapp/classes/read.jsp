<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../header.jsp"%>
<!-- 본문시작  -->
<section>
	<input type="hidden" name="w_code" value="${dto.w_code }">
	<div class="site-section" id="property-details">
		<div class="container">
			<div class="row">
				<div class="col-lg-7">

					<div>
						<img src="./storage/${dto.c_image }" alt="Image" class="img-fluid">
					</div>
					<br> <br>
					<hr>
					<img src="./storage/${dto.c_det}" alt="image" class="img-fluid">
				</div>

				<div class="col-lg-5 pl-lg-5 ml-auto">
					<div class="mb-5">
						<h3 class="text-black mb-4">${dto.c_prod }</h3>
						<p>강사명 : ${dto.tc_name}</p>
						<hr>
						<p>모집정원 : ${dto.c_max}명</p>
						<hr>
						<p>수강료 : ${dto.c_price } 원</p>
						<hr>
						<p>마감일 : ${dto.c_datend.substring(0,10)}</p>
						<hr>
						<p>개강일 : ${dto.c_start.substring(0,10)}</p>
						<hr>
						<p>종강일 : ${dto.c_end.substring(0,10)}</p>
						<hr>
						<p>교재 : ${dto.c_book}</p>
						<p>
							<a href="../wish/winsert.do?s_id=${s_id}&w_code=${dto.w_code}" class="btn btn-primary " >장바구니</a>
							<a href="../apply/form.do?w_code=${dto.w_code }&s_id=${s_id}" class="btn btn-primary" >수강신청</a>
							<a href="../review/relist.do" class="btn btn-primary">REVIEW</a>
							<br>
                   <% String s_id=(String)session.getAttribute("s_id");
           			String s_name=(String)session.getAttribute("s_name");
           			String s_level=(String)session.getAttribute("s_level");%>
           			<c:if test="${s_level eq 'A' }">  				
						<p>
							<a href="update.do?w_code=${dto.w_code}" class="btn btn-primary" style=" margin-top: 5px; ">수정</a>
							<a href="confirm.do?w_code=${dto.w_code}" class="btn btn-primary" style="margin-top: 5px; ">삭제</a>
						</p>
				    </c:if>
					</div>
							<br> <img src="../images/ecacademy.png" alt="Image"
								class="w-25 mb-3 rounded-circle">
							<h4 class="text-black">고객센터</h4>
							<p class="text-black mb-4">
								1234-5678 <br>09:00-18:00
							</p>

					<div class="mb-5">
						<div class="mt-5">
							<p class="text-black mb-4">
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>

</section>
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>

