package kr.co.academy.mypage;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.academy.member.memberDAO;

@Controller
public class MypageCont {
	
	private MyPageDAO dao= new MyPageDAO();
	public MypageCont() {
		System.out.println("--------MypageCont() 객체 생성됨 ~!~!~!~!~!~!~!~!");
		
	}
	//마이페이지 호출(mypage.do)
	@RequestMapping(value="/mypage/mypage.do", method=RequestMethod.GET)
	public ModelAndView mypage() {
		ModelAndView mav= new ModelAndView();
		mav.setViewName("/mypage/mypage_main");			
		return mav;		
	}//memberForm() end

	@RequestMapping(value = "/mypage/mypage_update.do")
	public ModelAndView pageupdate(HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		String m_id=req.getParameter("s_id").trim();
		mav.setViewName("/mypage/mypage_memform");
		mav.addObject("dto",dao.select(m_id));
		return mav;
	}
	
	/*
	 * @RequestMapping(value="/mypage/mypage.do", method=RequestMethod.GET) public
	 * ModelAndView mypage(HttpServletRequest req) { ModelAndView mav= new
	 * ModelAndView(); String m_id= req.getParameter("s_id").trim(); // String m_pw=
	 * req.getParameter("m_pw").trim(); mav.setViewName("/mypage/mypage_memform");
	 * mav.addObject("dto",dao.select(m_id));
	 * 
	 * return mav;
	 * 
	 * }//memberForm() end
	 */			
			//비밀번호 변경
			@RequestMapping("/mypage/m_pw_update.do")
			public void m_pw_update(HttpServletRequest req, HttpServletResponse resp ) {
				try {
					String m_id= req.getParameter("s_id").trim();
					String m_pw=req.getParameter("m_pw").trim();

					String message=""; //응답메세지			
					
					MyPageDAO dao= new MyPageDAO();
					int cnt=dao.m_pw_update(m_id, m_pw);//비밀번호 업데이트
					if(cnt==0) { //실패
						message="<span style='color:red;font-weight:bold'>비밀번호를 다시 적어주세요!</span>";
								
					}else {     //성공
						message="<span style='color:skyblue;font-weight:bold'>비밀번호 업데이트가 완료되었습니다!</span>";
					}//if end
					
					resp.setContentType("text/plain; charset=UTF-8");
					PrintWriter out=resp.getWriter();
					out.print(message);
					out.flush();
					out.close();
					
					
				}catch(Exception e) {
					System.out.println("응답 실패 . . . "+ e);
				
				}//try end
			}//m_pw_update() end		
			
			
			//비밀번호 변경
			@RequestMapping("/mypage/mem_update.do")
			public void mem_update(HttpServletRequest req, HttpServletResponse resp ) {
				try {
					String m_id= req.getParameter("s_id").trim();
					String m_pw=req.getParameter("m_pw").trim();

					String message=""; //응답메세지			
					
					MyPageDAO dao= new MyPageDAO();
					int cnt=dao.m_pw_update(m_id, m_pw);//비밀번호 업데이트
					if(cnt==0) { //실패
						message="<span style='color:red;font-weight:bold'>비밀번호를 다시 적어주세요!</span>";
								
					}else {     //성공
						message="<span style='color:skyblue;font-weight:bold'>비밀번호 업데이트가 완료되었습니다!</span>";
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
			
			
			//마이페이지 mypage.do POST
			@RequestMapping(value="/mypage/mypage.do", method=RequestMethod.POST)
			public ModelAndView mypagepro(MypageDTO dto) {
				ModelAndView mav= new ModelAndView();
				int cnt=0;
				StringBuilder message=new StringBuilder();
				String m_id= dto.getM_id().trim();
				String m_name= dto.getM_name().trim();
				String m_email=dto.getM_email().trim();
				String m_phone=dto.getM_phone().trim();
				String m_job=dto.getM_job().trim();
				String ref_acount=dto.getRef_acount().trim();
				String ref_name=dto.getRef_name().trim();
				
				cnt=dao.mem_update(dto);
				
				if(cnt==0) {  //수정실패
					message.append("<script>");
					message.append(" alert('수정 실패! 다시 시도해주세요!');");
					message.append(" history.back();");
					message.append("</script>");
					mav.addObject("message", message);	
				}else {       //수정성공
					message.append("<script>");
					message.append(" alert('회원정보 업데이트에 성공하였습니다~!');");
					message.append(" history.back();");
					message.append("</script>");
					mav.addObject("message", message);
				}
				
//				String m_pw= req.getParameter("m_pw").trim();
				mav.setViewName("./mypage/mypage_msg");				
				
				
				return mav;
				
			}//memberForm() end
			
			//회원탈퇴폼 호출 mem_delete.do GET
			@RequestMapping(value="/mypage/mem_delete.do", method=RequestMethod.GET)
			public ModelAndView mypage_delForm(HttpServletRequest req) {
				ModelAndView mav= new ModelAndView();
				//String m_id= req.getParameter("s_id").trim();
//				String m_pw= req.getParameter("m_pw").trim();
				mav.setViewName("/mypage/mypage_memDel");				
				//mav.addObject("dto",dao.select(m_id));
				
				return mav;
				
			}//memberForm() end
			
			
			//마이페이지 mypage.do POST
			@RequestMapping(value="/mypage/mem_delete.do", method=RequestMethod.POST)
			public ModelAndView mypate_delFormpro(MypageDTO dto, HttpSession session) {
				ModelAndView mav= new ModelAndView();
				int cnt=0;
				StringBuilder message=new StringBuilder();
				String m_id= dto.getM_id().trim();
				String m_pw= dto.getM_pw().trim();
				
				cnt=dao.mem_delete(m_id, m_pw);
				
				if(cnt==0) {  //삭제실패
					message.append("<script>");
					message.append(" alert('저런! 탈퇴실패!');");
					message.append(" history.back();");
					message.append("</script>");
					mav.addObject("message", message);	
				}else {       //삭제성공
					message.append("<script>");
					message.append(" alert('탈퇴에 성공했습니다 ㅜㅜ 안녕히가세요');");
					message.append(" location.href='../home.do';");
					message.append("</script>");
					mav.addObject("message", message);
					session.invalidate();
					
				}
				
//				String m_pw= req.getParameter("m_pw").trim();
				mav.setViewName("./mypage/memdel_msg");				
				
				
				return mav;
				
			}//memberForm() end
			
			
			
}//class end
