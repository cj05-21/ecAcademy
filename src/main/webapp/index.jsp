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
    <link rel="stylesheet" href="fonts/icomoon/style.css">

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/jquery-ui.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">

    <link rel="stylesheet" href="css/jquery.fancybox.min.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">

    <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/style.css">
    
     <script src="js/jquery-3.3.1.min.js"></script>
	  <script src="js/jquery-ui.js"></script>
	  <script src="js/popper.min.js"></script>
	  <script src="js/bootstrap.min.js"></script>
	  <script src="js/owl.carousel.min.js"></script>
	  <script src="js/jquery.countdown.min.js"></script>
	  <script src="js/bootstrap-datepicker.min.js"></script>
	  <script src="js/jquery.easing.1.3.js"></script>
	  <script src="js/aos.js"></script>
	  <script src="js/jquery.fancybox.min.js"></script>
	  <script src="js/jquery.sticky.js"></script>
	  <script src="/js/jquery.js"></script>
	  <script src="/js/jquery.cookie.js"></script>
      <script src="js/main.js"></script>
    
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
            <h1 class="mb-0 site-logo m-0 p-0"><a href="home.do" class="mb-0">EC Academy</a></h1>
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
                	 	<a href="./member/login.do"><i class="fa fa-sign-in"></i> 로그인</a>
             		</li>
             		<li>
                 		<a href="./member/agreement.do"><i class="fa fa-user"></i> 회원가입</a>
            	 	</li>
       			 </c:when>
       
                <c:otherwise>
                    <li>
                       <p>${s_name }님, 반갑습니다!</p>
                   </li>
                   <li>
                       <a href="./member/logout"><i class="fa fa-sign-out"></i> 로그아웃</a>
                   </li>
                   <li>
                   	   <a href="./mypage/mypage.do?s_id=${s_id}" onclick="mypage()"></i>마이페이지</a>
                   </li> 
                   <li>
                  	   <a href="./pay/paylist.do?s_id=${s_id}" ></i>나의수강목록</a>
                   </li> 
                   <c:choose>
       			 <c:when test="${s_level eq 'A'}">
           			 <li>
                	 	<a href="./manage/manage.do?s_id=${s_id}"><i class="fa fa-sign-in"></i> 관리페이지</a>
             		</li>
       			 </c:when>
       			 </c:choose>
                </c:otherwise>
            </c:choose>
		</c:catch>
              </ul>
              <ul class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block" style="text-align: left;">
               <li><a href="./sogae/introduce.jsp" >학원소개</a>
                	
                </li>
                <li><a href="./sogae/sglist.do" >강의소개</a></li>
                <li><a href="./classes/list.do" >강의신청</a></li>
                <li><a href="./teacher/list.do" >선생님소개</a></li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown">커뮤니티</a>
                	<ul class="dropdown-menu" style="color:black">	
          			 	<li><a href="./notice/nolist.do" style="color: black;" >공지사항</a></li>
           				<li><a href="./qna/qnaList.do" style="color: black;" >Q&A</a></li>
           				<li><a href="./review/relist.do" style="color: black;">REVIEW</a></li>
              </ul>
           	</li>
           	</ul>
            </nav>
          </div>
          <div class="col-6 d-inline-block d-xl-none ml-md-0 py-3"><a href="#" class="site-menu-toggle js-menu-toggle text-white float-right"><span class="icon-menu h3"></span></a></div>
        </div>
      </div>
    </header>
    
      <div class="site-block-wrap">
    <div class="owl-carousel with-dots">
      <div class="site-blocks-cover overlay overlay-2" style="background-image: url(images/main1.jpg);" data-aos="fade" id="home-section">


        <div class="container">
          <div class="row align-items-center justify-content-center">
            <div class="col-md-6 mt-lg-5 text-center">
              <h1 class="text-shadow">당신의 오늘은 젊기에</h1>
              <p class="mb-5 text-shadow">Find better with EC Academy   </p>
              <p><a href="https://github.com/cj05-21/ecAcademy" target="_blank" class="btn btn-primary px-5 py-3">Code View</a></p>
             
            </div>
          </div>
        </div>
 
       
      </div>  
 
      <div class="site-blocks-cover overlay overlay-2" style="background-image: url(images/main2.jpg);" data-aos="fade" id="home-section">
 
 
        <div class="container">
          <div class="row align-items-center justify-content-center">
            <div class="col-md-6 mt-lg-5 text-center">
              <h1 class="text-shadow">밝은 미래를 위해</h1>
              <p class="mb-5 text-shadow">We always with you  </p>
              <p><a href="https://github.com/cj05-21/ecAcademy" target="_blank" class="btn btn-primary px-5 py-3">Code View</a></p>
             
            </div>
          </div>
        </div>
 
       
      </div>  
    </div>  
   
  </div>      
<!-- 최신 강좌 리스트 -->
<div class="site-section" id="properties-section">
   <div class="container">
   	  <div class="col-12 text-center">
   		<h2 class="section-title mb-3">THE LATEST CLASS</h2>
   		<br>
   	  </div>			
      <div class="row large-gutters">
      <c:forEach var="dto" items="${mainclass }">
      	<div class="col-md-6 col-lg-4 mb-5 mb-lg-5 ">
            <div class="ftco-media-1">
               <div class="ftco-media-1-inner">
                 <img src="teacher/storage/${dto.poster}" alt="Free website template by Free-Template.co" class="img-fluid">
                  <div class="ftco-media-details">
                     <h3>${dto.c_prod }</h3>
                     <p>${dto.tc_name }</p>
                     <strong>${dto.c_price }</strong>
                  </div>
                </div> 
             </div>
         </div>
         </c:forEach>
     </div>
   </div>
</div>
    <section class="py-5 bg-primary site-section how-it-works" id="howitworks-section">
      <div class="container">
        <div class="row mb-5 justify-content-center">
          <div class="col-md-7 text-center">
            <h2 class="section-title mb-3 text-black">Why! E.C.A</h2>
          </div>
        </div>
        <div class="row">
          <div class="col-md-4 text-center">
            <div class="pr-5 first-step">
              
             
              <h3 class="text-black"><strong>Early-bird</strong></h3>
              <p class="text-black">바쁜 직장인들, 꼭 아침 아니면 안되는 분들! 그 분들을 위해 준비 된 새벽강좌!</p>
            </div>
          </div>

          <div class="col-md-4 text-center">
            <div class="pr-5 second-step">
              
              
              <h3 class="text-dark"><strong>Connection</strong></h3>
              <p class="text-black">강사와 학생의 1 대 1 관계를 <br>형성합니다</p>
            </div>
          </div>

          <div class="col-md-4 text-center">
            <div class="pr-5">
              
              
              <h3 class="text-dark"><strong>Appraisal</strong></h3>
              <p class="text-black">매 강좌 마지막에 파이널 테스트를 실시합니다. 시험 전 수강생 여러분의 역량을 확인해보세요.</p>
            </div>
          </div>
        </div>
      </div>  
    </section>
      <section class="site-section" id="news-section">
      <div class="container">
        <div class="row mb-5">
          <div class="col-12 text-center">
            <h2 class="section-title mb-3">Best Review</h2>
          </div>
        </div>
        
        <!--대표 리뷰 등장칸-->
			 <div class="row">
        <c:forEach var="dto" items="${list}">
         <div class="col-md-6 col-lg-4 mb-4 mb-lg-4">
            <div class="h-entry">
              
              <c:choose>
			<c:when test="${dto.poster eq null}">
    		<img src="./images/poster.jpg" alt="Free website template by Free-Template.co" class="img-fluid">
			</c:when>
			<c:otherwise>
			<img src="./review/storage/${dto.poster }" alt="Free website template by Free-Template.co" class="img-fluid">
	        </c:otherwise>
			</c:choose>
              <h2 class="font-size-regular" style="text-align:center;"><a href="single.html" class="text-dark">${dto.r_subject}</a></h2>
              <div class="meta mb-4" style="text-align:center;">${dto.m_id } <span class="mx-2">&bullet;</span>${dto.r_date.substring(0,10)}<span class="mx-2"></span></div>
            </div> 
          </div>
		</c:forEach>
          </div>
      </div>
    </section>

    <!--Footer  -->
    <footer class="site-footer">
      <div class="container">
        <div class="row">
          <div class="col-md-8">
            <div class="row">
              <div class="col-md-5">
                <h2 class="footer-heading mb-4">About Us</h2>
                <p>웹프로그래밍 개발자 과정 졸업작품</p>
                <p> - 학원 홈페이지 제작</p>
                <p>개발환경</p>
                <p> - Java,Oracle,SQL,Spring Framework</p>
               </div>
              <div class="col-md-3 mx-auto">
                <h2 class="footer-heading mb-4">Quick Links</h2>
                <ul class="list-unstyled">
                  <li><a href="../sogae/introduce.do">학원소개</a></li>
                  <li><a href="../sogae/sglist.do">강의소개</a></li>
                  <li><a href="../teacher/list.do">선생님소개</a></li>
                  <li><a href="../notice/nolist.do">커뮤니티</a></li>
                </ul>
              </div>
            </div>
          </div>           
            <div class="">
              <h2 class="footer-heading mb-4">Follow Us</h2>
                <a href="https://facebook.com/" class="pl-0 pr-3"><span class="icon-facebook"></span></a>
                <a href="https://twitter.com/" class="pl-3 pr-3"><span class="icon-twitter"></span></a>
                <a href="https://instagram.com/" class="pl-3 pr-3"><span class="icon-instagram"></span></a>
                <a href="https://www.linkedin.com/" class="pl-3 pr-3"><span class="icon-linkedin"></span></a>
            </div>


          </div>
        </div>
        <div class="row pt-5 mt-5 text-center">
          <div class="col-md-12">
            <div class="border-top pt-5">
            <!-- Link back to Free-Template.co can't be removed. Template is licensed under CC BY 3.0. -->
            <p class="copyright"><small>&copy; <script>document.write(new Date().getFullYear());</script> EC Academy. All Rights Reserved.  Design by eJo</small></p>
            </div>
          </div>
          
        </div>
    
    </footer>

  </div> <!-- .site-wrap -->
	<script>
      function mypage(){
    	  alert("마이 페이지로 이동합니다.");
      }
      </script>
  <a href="#top" class="gototop"><span class="icon-angle-double-up"></span></a> 

  <script src="js/jquery-3.3.1.min.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.countdown.min.js"></script>
  <script src="js/bootstrap-datepicker.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/jquery.fancybox.min.js"></script>
  <script src="js/jquery.sticky.js"></script>

  
  <script src="js/main.js"></script>
    
  </body>
</html>