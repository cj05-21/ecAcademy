<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html lang="ko">
  <head>
    <title>EC Academy Project</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <meta name="author" content="Free-Template.co" />

    <link rel="shortcut icon" href="ftco-32x32.png">

    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,900|Oswald:300,400,700" rel="stylesheet">
    <link rel="stylesheet" href="../fonts/icomoon/style.css">

    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/jquery-ui.css">
    <link rel="stylesheet" href="../css/owl.carousel.min.css">
    <link rel="stylesheet" href="../css/owl.theme.default.min.css">
    <link rel="stylesheet" href="../css/owl.theme.default.min.css">

    <link rel="stylesheet" href="../css/jquery.fancybox.min.css">

    <link rel="stylesheet" href="../css/bootstrap-datepicker.css">

    <link rel="stylesheet" href="../fonts/flaticon/font/flaticon.css">

    <link rel="stylesheet" href="../css/aos.css">

    <link rel="stylesheet" href="../css/style.css">
    
    
  <script src="../js/jquery-3.3.1.min.js"></script>
  <script src="..js/jquery-ui.js"></script>
  <script src="../js/popper.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
  <script src="../js/owl.carousel.min.js"></script>
  <script src="../js/jquery.countdown.min.js"></script>
  <script src="../js/bootstrap-datepicker.min.js"></script>
  <script src="../js/jquery.easing.1.3.js"></script>
  <script src="../js/aos.js"></script>
  <script src="../js/jquery.fancybox.min.js"></script>
  <script src="../js/jquery.sticky.js"></script>
   <script src="../js/jquery.js"></script>
  <script src="../js/jquery.cookie.js"></script>
  <script src="../js/main.js"></script>
    
    
  </head>
  <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300">
  
  <div class="site-wrap">

    <div class="site-mobile-menu site-navbar-target">
      <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-close mt-3">
          <span class="icon-close2 js-menu-toggle"></span>
        </div>
      </div>
      <div class="site-mobile-menu-body"></div>
    </div>
   
    
    <header class="site-navbar py-4 js-sticky-header site-navbar-target" role="banner">

      <div class="container">
        <div class="row align-items-center">
          
          <div class="col-6 col-xl-2">
            <h1 class="mb-0 site-logo m-0 p-0"><a href="../home.do" class="mb-0">EC Academy</a></h1>
          </div>

          <div class="col-12 col-md-10 d-none d-xl-block">
            <nav class="site-navigation position-relative text-right" role="navigation">
			
              <ul class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block" style="font-size: 14px">
                <c:catch>
              <% String s_id=(String)session.getAttribute("s_id");
              	 String s_name=(String)session.getAttribute("s_name");
              	 String s_level=(String)session.getAttribute("s_level");%>
   				 <c:choose>
       			 <c:when test="${empty s_id }">
           			 <li>
                	 	<a href="../member/login.do"><i class="fa fa-sign-in"></i> 로그인</a>
             		</li>
             		<li>
                 		<a href="../member/agreement.do"><i class="fa fa-user"></i> 회원가입</a>
            	 	</li>
       			 </c:when>
       
                <c:otherwise>
                    <li>
                       <p>${s_name }님, 반갑습니다!</p>
                   </li>
                   <li>
                       <a href="../member/logout"><i class="fa fa-sign-out"></i> 로그아웃</a>
                   </li>
                  <li>
                   	   <a href="../mypage/mypage.do?s_id=${s_id}">마이페이지</a>
                   </li> 
                   <li>
                  	   <a href="../pay/paylist.do?s_id=${s_id}" onclick="mypage()">나의수강목록</a>
                   </li> 
                    <c:choose>
       			 <c:when test="${s_id eq 'master'}">
           			 <li>
                	 	<a href="../manage/manage.do?s_id=${s_id}"><i class="fa fa-sign-in"></i> 관리페이지</a>
             		</li>
       			 </c:when>
       			 </c:choose>
                </c:otherwise>
            </c:choose>
		</c:catch>
              </ul>
              <ul class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block" style="text-align: left;">
               <li><a href="../sogae/introduce.jsp">학원소개</a>
                </li>
                <li><a href="../sogae/sglist.do" class="">강의소개</a></li>
                <li><a href="../classes/list.do" class="">강의신청</a></li>
                <li><a href="../teacher/list.do" class="">선생님소개</a></li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#" >커뮤니티</a>
                	<ul class="dropdown-menu" style="color:black">	
          			 	<li><a href="../notice/nolist.do" style="color: black;" class="nav-link">공지사항</a></li>
           				<li><a href="../qna/qnaList.do" style="color: black;" class="nav-link">Q&A</a></li>
           				<li><a href="../review/relist.do" style="color: black;" class="nav-link">REVIEW</a></li>
              </ul>
           	</li>
           	</ul>
            </nav>
          </div>
          <div class="col-6 d-inline-block d-xl-none ml-md-0 py-3"><a href="#" class="site-menu-toggle js-menu-toggle text-white float-right"><span class="icon-menu h3"></span></a></div>
        </div>
      </div>
    </header> 
    <!-- 메인 카테고리 끝  -->

	<!-- 본문시작 -->
	<!-- Container 시작 -->  
	<div style="background-color: black; width:100%; height:109px;">
	</div>

	<div class="site-section">  