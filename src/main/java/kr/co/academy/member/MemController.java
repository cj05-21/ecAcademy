package kr.co.academy.member;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.utility.MyAuthenticator;
import net.utility.Utility;



@Controller
public class MemController {
	
	//가입약관 호출(agreement.do)
		@RequestMapping(value="/member/agreement.do", method=RequestMethod.GET)
		public ModelAndView agreement() {
			ModelAndView mav= new ModelAndView();
			
			mav.setViewName("/member/agreement");
			
			return mav;
			
		}//memberForm() end
		
	//가입약관 호출 POST
		@RequestMapping(value="/member/agreement.do", method=RequestMethod.POST)
		public ModelAndView agreementpro() {
			ModelAndView mav= new ModelAndView();

			mav.setViewName("/member/memberform");			

			
			return mav;
			
		}//memberInsert() end		

	
	//회원가입 폼 호출(memberform.do)
	@RequestMapping(value="/member/memberform.do", method=RequestMethod.GET)
	public ModelAndView memberForm() {
		ModelAndView mav= new ModelAndView();
		
		mav.setViewName("/member/memberform");
		
		return mav;
		
	}//memberForm() end
	
	//아이디 중복확인 검사 
		@RequestMapping("/member/idcheck.do")
		public void idCheck(HttpServletRequest req, HttpServletResponse resp ) {
			try {
				String m_id=req.getParameter("m_id").trim();
				
				String message=""; //응답메세지
				if(m_id.length()<5 || m_id.length()>=11) {
					message="<span style='color:red; font-size: 13px;'>아이디를 5~10글자 이내로 입력해주십시오. </span>";
					
				}else{
					memberDAO dao= new memberDAO();
					int cnt=dao.duplecateId(m_id);//아이디 중복확인
					if(cnt==0) {
						message="<span style='color:#37cfa2; font-size: 13px;'>사용가능한 아이디입니다.</span>";
					}else {
					message="<span style='color:green; font-size: 13px;'>중복된 아이디 입니다.</span>";
					}//if end
				}//if end
				
				resp.setContentType("text/plain; charset=UTF-8");
				PrintWriter out=resp.getWriter();
				out.print(message);
				out.flush();
				out.close();
				
			}catch(Exception e) {
				System.out.println("응답 실패 . . . "+ e);
			
			}//try end
		}//idCheck() end
	
	
	
	//회원가입 데이터 insert
	@RequestMapping(value="/member/memberform.do", method=RequestMethod.POST)
	public ModelAndView memberInsert(memberDTO dto) {
		ModelAndView mav= new ModelAndView();
		memberDAO dao= new memberDAO();
		mav.setViewName("/member/memberpro");

		int cnt=dao.insert(dto);
		
		if(cnt==1){ 
			mav.addObject("message1", "EC아카데미에 오신걸 환영합니다!");
		}else {
			//isnert 실패
//			mav.setViewName("login/msgView");
			mav.addObject("message2", "회원 가입이 불가능합니다. ");			
//			mav.addObject("link","<a href='javascript:history.back()'>[다시시도]</a>");
		}//if end
		return mav;
	}//memberInsert() end
	
	//회원가입이 완료되면 alert창 띄워주는 jsp
	@RequestMapping(value="/member/memberpro.do", method=RequestMethod.GET)
	public ModelAndView memberpro() {
		ModelAndView mav= new ModelAndView();
		
		mav.setViewName("/member/memberpro");
		
		return mav;
		
	}//memberForm() end
	//로그인폼 호출(login.do) GET
	@RequestMapping(value="/member/login.do", method=RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav= new ModelAndView();
		
		mav.setViewName("/member/loginform");
		
		return mav;
		
	}//login() end
	
	//로그인POST
	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	public ModelAndView loginpro(HttpServletRequest req, HttpServletResponse resp) {
		
		String m_id=req.getParameter("m_id");
		String m_pw=req.getParameter("m_pw");
		
		ModelAndView mav= new ModelAndView();
		memberDAO dao= new memberDAO();
		memberDTO dto= new memberDTO();
		
		
		mav.setViewName("/member/loginpro");
		int res=0;
		
		res=dao.login(m_id, m_pw);
		
		StringBuilder message=new StringBuilder();

		if(res==1) { //아이디/비번이 맞  은 경우
			//session 영역에 자료올리기
			
			HttpSession session=req.getSession(); //session객체 생성
			session.setAttribute("s_id", m_id);   //"s_id"라는 세션변수에 로그인폼에서 받은 m_id값을 넣어준다
			
			//로그인 폼에선 m_namd, m_level을 받지 못하기 때문에
			//로그인 폼에서 받은 m_id에 해당하는 m_name, m_level을 받아올 dao메소드가 필요하다
			dto=dao.sessName(m_id);               
			                                      
			//dao.sessNamd()에서 찾아온 m_name을 세션변수 s_name에 넣어준다
			session.setAttribute("s_name", dto.getM_name()); 
			
			//dao.sessNamd()에서 찾아온 m_level을 세션변수 s_level에 넣어준다
			session.setAttribute("s_level",dto.getM_level());
			
		
			//쿠키(아이디저장)
			String c_id=req.getParameter("c_id");
			if(c_id==null){ //저장된 아이디가 없을경우
				c_id="";
			}//if end
			Cookie cookie=null;
			if(c_id.equals("SAVE")){
				cookie=new Cookie("c_id", m_id);
				cookie.setMaxAge(60*60*24*31); //한달동안 쿠키저장
			}else{ 
				cookie=new Cookie("c_id", "");
				cookie.setMaxAge(0);			
			}//if end
			resp.addCookie(cookie);  ///사용자 pc에 쿠키값 저장
			
			message.append("<script>");
			message.append(" alert('환영합니다~!');");
			message.append(" location.href='../home.do';");
			message.append("</script>");
			mav.addObject("message", message);
			
		}else { //아이디/비번이 틀린경우		
			message.append("<script>");
			message.append(" alert('아이디와 비밀번호를 확인해주세요!');");
			message.append(" history.back();");
			message.append("</script>");
			mav.addObject("message", message);					
		}//if end

		return mav;
	}//login() end

	@RequestMapping(value="/member/logout")
	public ModelAndView logout( HttpSession session) {
		session.invalidate();
		ModelAndView mav= new ModelAndView("redirect:/home.do");

		return mav;
		
	}//logout() end
	
	// 아이디 찾기 폼(find_id_form.do GET)
	@RequestMapping(value = "/member/find_id_form.do", method=RequestMethod.GET)
	public ModelAndView find_id_form() {
		ModelAndView mav= new ModelAndView();
		mav.setViewName("/member/find_id_form");
			
		return mav;
	}//find_id_form() end
		 
	// 아이디 찾기 POST
	@RequestMapping(value = "/member/find_id_form.do", method=RequestMethod.POST)
	public ModelAndView find_id_form_pro(HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		memberDAO dao= new memberDAO();
		memberDTO dto=new memberDTO();
			
		String m_name= req.getParameter("m_name");
		String m_email=req.getParameter("m_email");
			
			
		//입력받은 m_name이랑 m_email이 일치하는 id를 찾아서 뿌려줌
		dto=dao.findId(m_name,m_email); //dto에 찾은 id가 들어가있다			
			
		if(dto!=null){ //dto값이 있을경우 아이디가 존재함(성공)
			mav.addObject("m_id",dto.getM_id());  //m_id에 dto.m_id값 넣어서 사용										  		
			mav.setViewName("/member/find_id_fin");		
				
		}else if(dto==null){ //dto값이 없으므로 아이디에 해당하는 이름/이메일이 일치하지 않음
		StringBuilder message=new StringBuilder();
		message.append("<script>");
		message.append(" alert('이름과 이메일을 다시 확인해주세요');");
		message.append(" history.back();");
		message.append("</script>");
		mav.addObject("message", message);		
		mav.setViewName("./member/find_id_msg");
		}//if end
			
		return mav;
	}//find_id_form() end
		
			
	// 비밀번호 찾기 GET ( find_pw_form.do)
	@RequestMapping(value = "/member/find_pw_form.do", method = RequestMethod.GET)
	public ModelAndView find_pw_form(){
		ModelAndView mav= new ModelAndView();
		mav.setViewName("/member/find_pw_form");
		return mav;
	}//find_pw_form() end
			
			
			
	// 비밀번호 찾기  POST
	// https://vip00112.tistory.com/24 참고
	@RequestMapping(value = "/member/find_pw_form.do", method=RequestMethod.POST)
	public ModelAndView sendMailPassword(HttpServletRequest req) {
				
		ModelAndView mav=new ModelAndView();
		memberDAO dao= new memberDAO();
		memberDTO dto=new memberDTO();
		//MailServiceImpl msvi= new MailServiceImpl(); //해당 클래스를 객체화 시켜줘야 send() 사용 가능 
			
		String m_id= req.getParameter("m_id");
		String m_email=req.getParameter("m_email");
		       
		dto = dao.find_pw(m_id,m_email);  //m_email에 해당하는 m_id를 받아온다
		
		StringBuilder message=new StringBuilder();//alert 띄워줄 내용 넣을 변수
				
		if (dto == null) {  //m_pw가 null이라면 
			message.append("<script>");
			message.append(" alert('아이디와 이메일을 확인해주세요');");
			message.append(" history.back();");
			message.append("</script>");
		    mav.addObject("message", message);			       
		       
		  } else {
			  String m_pw= dto.getM_pw();  //회원의 비밀번호

			//1) 메일 서버 지정 (POP3/SMTP)
			String mailServer="mw-002.cafe24.com";  //메일 서버의 아이피
			
			//문법에 해당, 한번에 알아두기 (나중에 복사해서 사용)
			Properties props=new Properties();
			props.put("mail.smtp.host", mailServer);
			props.put("mail.smtp.auth", "true");
			
			//2) 메일 서버에서 인증받은 계정/비번
			Authenticator myAuth=new MyAuthenticator();
			
			//3) 1)과 2)가 유효한지 검증 (session의 임포트가 javax.mail 인지 확인 필수)
			Session sess=Session.getInstance(props,myAuth);

			//4) 메일보내기
			try{
				req.setCharacterEncoding("UTF-8");
				String to		   =req.getParameter("m_email").trim();
				String from	   ="master@ecacademy.cafe24.com";
				String subject  ="고객님의 비밀번호입니다.";
				String content ="고객님의 비밀번호는 "+m_pw+" 입니다. ";
					
				//엔터 및 특수문자 변경 (utility에 있는 convertChar를 사용 - 내용중에 특수문자 표현을 위해 HTML 특수문자로 변환)
				content = Utility.convertChar(content);
				//메일관련 메세지 작성
				Message msg=new MimeMessage(sess);
						
				//받는 사람
				InternetAddress[] address={
								new InternetAddress(to)		
				};
				
				msg.setRecipients(Message.RecipientType.TO, address);
				//보내는 사람
				msg.setFrom(new InternetAddress(from));
				
				//메일 제목
				msg.setSubject(subject);
				
				//메일 내용 (받는 사람도 같은 형식을 가지는 것이기 때문에 위에서 복사)
				msg.setContent(content, "text/html; charset=UTF-8"); 
				
				//보낸 날짜
				msg.setSentDate(new Date());
				
				//메일 전송
				Transport.send(msg);
				
				message.append("<script>");
				message.append(" alert('이메일로 비밀번호를 발송하였습니다');");
				message.append(" location.href='./login.do'");
				message.append("</script>");	           
			    mav.addObject("message", message);
				
			    
			}catch(Exception e){
				System.out.println("실패.."+e);
			}//try end
		    
		    
		  }//if end
		    
		mav.setViewName("/member/find_pw_msg"); 		
		return mav;
	}//find_pw_end
		    
			/*			
			String subject = "EC 아카데미 비밀번호 찾기 이메일입니다.";
			StringBuilder sb = new StringBuilder();
			sb.append("귀하의 비밀번호는 " + m_pw + " 입니다.");
			msvi.send(subject, sb.toString(), "아이디@gmail.com", m_email.toString(), null);
		    message.append("<script>");
			message.append(" alert('이메일로 비밀번호를 발송하였습니다');");
			message.append(" location.href='member/login.do'");
			message.append("</script>");	           
		    mav.addObject("message", message);
		    */
		       		        
		    		        
		
		



	
	//아직 미완 (나중에 하기)
	// 마이페이지 이동(mypage.do)
	@RequestMapping(value = "/mypage.do")
	public ModelAndView mypage(){
		ModelAndView mav= new ModelAndView();
		mav.setViewName("/member/mypage");
		return mav;
	}//mypage() end
	
	
}//class end
