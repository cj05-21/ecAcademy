<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<!-- 본문시작  -->
<section>
 <input type="hidden" name="tc_no" value="${dto.tc_no}">
    <div class="site-section" id="property-details">
      <div class="container">

        <div class="row">
          <div class="col-lg-7">
            
              <img src="./storage/${dto.poster}" alt="Image" class="img-fluid">
            
          </div>
          <div class="col-lg-5 pl-lg-5 ml-auto">
            <div class="mb-5">
              <h3 class="text-black mb-4">${dto.tc_name}</h3>
 			  <p>강좌코드 : ${dto.c_code}</p><hr>                        
 		      <p>담당강좌 : ${dto.c_prod}</p><hr>
 		      <p>강사 이메일 : ${dto.m_email}</p><hr>
              <p><a href="list.do" class="btn btn-primary" >목록보기</a>
            </div>

            <div class="mb-5">              
              <div class="mt-5">
                <img src="../images/ecacademy.png" alt="Image" class="w-25 mb-3 rounded-circle">
                <h4 class="text-black">고객센터</h4>
                <p class="text-muted mb-4">
                1234-5678 <br>09:00-18:00</p>
              </div>
            </div>
    
          </div>
        </div> 
   
      </div>
    </div>
   
</section>

<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>