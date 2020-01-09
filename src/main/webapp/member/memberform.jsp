<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ include file="../header.jsp"%>
<style>
  input[id="email_agree"] {
    position: relative;
    top: 6px;
 }
  input[id="phone_agree"] {
    position: relative;
    top: 6px;
  }
</style>


<section>
			<div class="container">
              <div class="comment-form-wrap pt-5">
              <div class="col-md-7 mb-5" style="margin:0 auto;">
                <h3 class="mb-5 text-center">회원가입</h3>
                <div class="p-5 bg-light">
                <form name="memform" method="post" action="memberform.do" onsubmit="return checkAll(this)" class="p-5 bg-light">	
                  <div class="form-group">
                    <label for="m_id">아이디</label>
                    <input type="text" class="form-control" id="m_id" name="m_id" >
                    <div id="idcheck" style="display:none"></div>
                  </div>
                  <div class="form-group">
                    <label for="m_pw">비밀번호</label>
                    <input type="password" class="form-control" id="m_pw" name="m_pw" >
                  </div>
                 <div class="form-group">
                    <label for="m_pw_re">비밀번호 확인</label>
                    <input type="password" class="form-control" id="m_pw_re" name="m_pw_re" >
                     <div  id="alert-success"style="display:none; color:#37cfa2;font-size: 13px;">비밀번호가 일치합니다.</div> 
                     <div  id="alert-danger"style="display:none; color:red; font-size: 13px;">비밀번호가 일치하지 않습니다.</div>
                  </div>                  
                  <div class="form-group">
                    <label for="m_name">이름</label>
                    <input type="text" class="form-control" id="m_name" name="m_name" >
                  </div>                         
                  <div class="form-group">
                    <label for="m_email">이메일</label>
                    <input type="email" class="form-control" id="m_email" name="m_email" >             
                  
                  	강의정보/마케팅 이메일 수신에 동의하십니까?<br><div class="row">
     			    &nbsp;&nbsp;&nbsp;&nbsp;네&nbsp;
     			    <input type="radio" class="form-control" id="email_agree" name="email_agree" value="Y"
     			    	   style=width:17px;height:17px; >
     			    &nbsp;&nbsp;아니오&nbsp;
     			    <input type="radio" class="form-control" id="email_agree" name="email_agree" value="N"
     			    	   style=width:17px;height:17px; >	
     			    	   </div>
     			    </div>		         
                  <div class="form-group">
                    <label for="m_phone">전화번호</label>
                    <input type="text" class="form-control" id="m_phone" name="m_phone" >
                   	 강의정보/마케팅 MMS 수신에 동의하십니까?<br><div class="row">
     			    &nbsp;&nbsp;&nbsp;&nbsp;네&nbsp;
     			    <input type="radio" class="form-control" id="phone_agree" name="phone_agree" value="Y"
     			    	   style="width:17px;height:17px;" >
     			    &nbsp;&nbsp;아니오&nbsp;
     			    <input type="radio" class="form-control" id="phone_agree" name="phone_agree" value="N"
     			    	   style=width:17px;height:17px;>	</div>
                  </div>     			   
                  <div class="form-group">
                    <label for="m_job">직업</label>
                    <input type="text" class="form-control" id="m_job" name="m_job">                 
                  </div>
                   <div class="form-group">
                    <input type="submit" id="submit" value="회원가입" class="btn btn-primary">
                  </div>

                </form>
              </div>
             </div> 
             </div>
           </div>

<!-- 아이디 중복확인  -->

<script>
	$("#m_id").keyup(function idcheck(){
		//alert();
		$.post("idcheck.do"    //요청서버
			  ,"m_id="+$("#m_id").val()   //서버 전달값
			  ,responseProc   //콜백함수
				); //post() end
	}); //keyup() end
	
	function responseProc(result){
		
		
		$("#idcheck").empty();
		$("#idcheck").html(result);
		$("#idcheck").show();
		
	}//responeseProc() end
 
</script>

<!-- 비밀번호/비밀번호확인이 일치하는지 -->
<script type="text/javascript">
$(function(){
	$("#alert-success").hide(); 
	$("#alert-danger").hide(); 
	$("input").keyup(function(){ 
		
		
		var m_pw=$("#m_pw").val(); 
		var m_pw_re=$("#m_pw_re").val(); 
		if(m_pw != "" || m_pw_re != ""){ 
			if(m_pw == m_pw_re){ $("#alert-success").show(); 
			$("#alert-danger").hide(); 
			//$("#submit").removeAttr("disabled"); //비밀번호 확인이 일치하므로 회원가입버튼 활성화
			}else{ 
				$("#alert-success").hide(); 
				$("#alert-danger").show(); 
				//$("#submit").attr("disabled", "disabled"); //비번확인이 일치하지 않으므로 회원가입버튼 비활성화
				} 
			} 
		}); 
	}); 
</script>
 
<script>
function checkAll(f) {
	alert('알려라');
	
	//아이디 유효성검사--------------------------------------
	var m_id=f.m_id.value;
	m_id=m_id.trim();
	
	
		
	//아이디는 5~10글자만 가능
	if (m_id.length<5 || m_id.length>10) {
		alert("아이디는 5~10글자로 입력해주세요");
		return false;
        m_id.focus();
		
    }	
	//아이디는 영문과 숫자만 가능
	for (var i = 0; i < m_id.length; i++) {
	      var chm = m_id.charAt(i);
	      if (!(chm >= '0' && chm <= '9') && !(chm >= 'a' && chm <= 'z')&&!(chm >= 'A' && chm <= 'Z')) {
	          alert("아이디는 영문 대소문자, 숫자만 입력가능합니다.");
	          return false;
	          m_id.focus();	           
	      }
	  }

    //비밀번호 유효성검사------------------------------------------------
    var m_pw=f.m_pw.value;
    var m_pw_re=f.m_pw_re.value;
    
    //비밀번호와 비밀번호확인 일치해야됨
    if (m_pw!=m_pw_re) {
        alert("비밀번호와 비밀번호 확인이 일치하지 않습니다");
        return false;
       m_pw_re.focus();
    };
    
    //이메일 유효성검사-------------------------------------------------
    var m_email=f.m_email.value.trim();
    
    //이메일은 영문과 숫자만 가능
    for (var i = 0; i < m_email.length; i++) {
        var chm = m_email.charAt(i);
        if (!(chm >= '0' && chm <= '9') && !(chm >= 'a' && chm <= 'z')&&!(chm >= 'A' && chm <= 'Z')) && !() {
            alert("이메일은 영문 대소문자, 숫자만 입력가능합니다.");
            return false;
            m_email.focus();
           
        }
    }
    
    
    //전화번호 유효성검사-------------------------------------------------
    var m_phone=f.m_phone.value.trim();
    
    //전화번호는 숫자만 가능
    for (var i = 0; i < m_phone.length; i++) {
        var chm = m_phone.charAt(i);
        if (!(chm >= '0' && chm <= '9')) {
            alert("전화번호는 숫자만 입력 가능합니다");
            return false;
            m_phone.focus();
           
        }
    }
    
	/*
    */    
    }//checkAll() end
    
</script>
</section>

<!-- 본문 끝  -->
<%@ include file="../footer.jsp"%>