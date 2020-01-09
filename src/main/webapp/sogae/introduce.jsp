<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../header.jsp"%>
<!-- 본문시작  -->
<section class="site-section" id="about-section">
	<div class="container">

		<div class="row large-gutters">
			<div class="col-lg-6 mb-5">
				<div>
					<img src="../images/property_3.jpg"
						alt="Free website template by Free-Template.co" class="img-fluid">
				</div>
			</div>
			<div class="col-lg-6 ml-auto">
				<h2 class="section-title mb-3">EC ACADEMY</h2>
				<h4>Our Process</h4>
				<p class="lead"></p>
				<p>- 글로벌 리크루팅 네트워크</p>
				<p>- 체계적인 트레이닝</p>
				<p>- 지속적인 트레이닝 강사 수준 유지</p>
				<p>- 1:1교육 시스템</p>
				<br>

				<h4>시설</h4>
				<ul class="list-unstyled ul-check success">
					<li>1F - Reception Desk</li>
					<li>2F - Interview Room</li>
					<li>3F - Internet Zone</li>
					<li>4F - 강의실, 사물함</li>
					<li>5F - EC ACADEMY ONE (1:1수업)</li>
				</ul>

				<p>주소 : 서울 종로구 종로12길 15 코아빌딩 EC ACADEMY</p>
				<p>DESK : 02-1234-4567</p>
			</div>
		</div>
		<br> <br> <br>
		<hr>


		<h3 class="section-title mb-3">MAP</h3>
		<p class="lead">찾아오시는 길</p>
		<!--
	* 카카오맵 - 약도서비스
	* 한 페이지 내에 약도를 2개 이상 넣을 경우에는
	* 약도의 수 만큼 소스를 새로 생성, 삽입해야 합니다.
-->
		<!-- 1. 약도 노드 -->
		<div id="daumRoughmapContainer1573091059879"
			class="root_daum_roughmap root_daum_roughmap_landing"></div>

		<!-- 2. 설치 스크립트 -->
		<script charset="UTF-8" class="daum_roughmap_loader_script"
			src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>

		<!-- 3. 실행 스크립트 -->
		<script charset="UTF-8">
			new daum.roughmap.Lander({
				"timestamp" : "1573091059879",
				"key" : "vqrv",
				"mapWidth" : "640",
				"mapHeight" : "360"
			}).render();
		</script>
	</div>
</section>
<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>












