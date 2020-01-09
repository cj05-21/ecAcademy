<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!-- 본문시작  -->
<section>
	<div class="sidebar-box" style="width: 200px; margin-left: 150px;">

		<img src="../images/manager.png" alt="Image" class="img-fluid"
			width="150px" height="150px"><br>
		<div style="width: 150px; text-align: center; color: red;">
			<strong>${dto.m_name }</strong>
		</div>
		<div style="width: 150px; text-align: center;">${dto.m_email }</div>
		<div style="width: 150px; text-align: center;">${dto.m_phone}</div>
		<br>
		<div style="width: 150px; text-align: center;">
			<a href="../member/logout"><i class="fa fa-sign-out"></i> 로그아웃</a>
		</div>
		<br>
		<br>
		<div class="categories">
			<h3>Categories</h3>
			<ul>
				 <ul>
                <li><a href="../apply/applylist.do?s_id=${s_id }">수강목록</a></li>
                <li><a href="../attend/attend.do?s_id=${s_id }">출석 등록</a></li>
                <li><a href="../attend/afterattend.do?s_id=${s_id }">출석 목록</a></li>
                <li><a href="../manage/mem_manage.do">회원관리</a></li>
                </ul>
			</ul>
		</div>
	</div>

	<div class="container mt-3">
		<div class="col-md-11 mb-5" style="margin: 0 auto;">
			<h1 style="text-align: center; color: green;">회원등급</h1>
			<div class="container">
				<br>
				<br>
				<hr>
				<div class="p-5 bg-light">
					<h3 class="mb-5 text-center">회원등급 수정</h3>
					<form name="memform" method="post" action="mem_update.do"
						class="p-5 bg-light">
						<div class="form-group">
							<label for="m_id">아이디</label><br>
							<!-- 못바꿈 -->
							<input type="text" class="form-control" id="m_id" name="m_id"
								value="${dto.m_id }" style="width: 200px;" readonly>
						</div>
						<div class="form-group">
							<label for="m_name">이름</label>
							<!-- 못바꿈 -->
							<input type="text" class="form-control" id="m_name" name="m_name"
								value="${dto.m_name }" style="width: 200px;">
						</div>
						<div class="form-group">
							<label for="m_email">이메일</label> <input type="email"
								class="form-control" id="m_email" name="m_email"
								value="${dto.m_email }" style="width: 200px;">
						</div>
						<div class="form-group">
							<label for="m_phone">전화번호</label> <input type="text"
								class="form-control" id="m_phone" name="m_phone"
								value="${dto.m_phone }" style="width: 200px;">
						</div>
						<div class="form-group">
							<label for="m_job">직업</label> <input type="text"
								class="form-control" id="m_job" name="m_job"
								value="${dto.m_job }" style="width: 200px;">
						</div>
						<div class="form-group">
							<label for="m_level">등급 *</label> <select name="m_level"
								class="custom-select mb-3">
								<option value="X">탈퇴</option>
								<option value="A">관리자</option>
								<option value="B">강사</option>
								<option value="C">수강생</option>
								<option value="F">제적</option>
							</select> <br> <input type="submit" id="submit" value="수정완료"
								class="btn btn-primary">
						</div>
						<br>
						<hr>
					</form>
				</div>

			</div>
		</div>
</section>
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>