package kr.co.academy.apply;


import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplyCont {
	public ApplyDAO dao=new ApplyDAO();
	
	public ApplyCont() {
		System.out.println("----- ApplyCont() 객체생성됨...");
	}

	@RequestMapping(value="/apply/form.do", method=RequestMethod.GET)
	public ModelAndView applyform(ApplyDTO dto, HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		String m_id=req.getParameter("s_id");
		
		mav.setViewName("apply/applyForm");
		mav.addObject("dto", dao.read(dto.getW_code()));
		mav.addObject("m_id", m_id);
		mav.addObject("ap_pay", dto.getAp_pay());
		return mav;
	}
	
	@RequestMapping(value = "/apply/form.do", method = RequestMethod.POST)
	public ModelAndView applyupdate(ApplyDTO dto, HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		map=dao.insert(dto);
		int cnt=(Integer)map.get("cnt");
		//System.out.println(cnt);
		if(cnt==0) {
			mav.setViewName("redirect:/apply/form.do");	
			
		}else {
			String m_id=dto.getM_id();
			int w_code=dto.getW_code();

			//String ap_no=dao.line(m_id, w_code);
			String ap_no=map.get("ap_no").toString();
			//System.out.println(ap_no);
			if(dto.getAp_pay().equals("card")) {
				mav.setViewName("apply/applyCard");
				//mav.addObject("ap_no", ap_no );				
				//System.out.println(dao.jumun(ap_no));
			}else if(dto.getAp_pay().equals("tongjang")) {
				mav.setViewName("apply/applyTongjang");
				//mav.addObject("ap_no", ap_no );
			}else {
				mav.setViewName("apply/applyPhone");
				//mav.addObject("ap_no", ap_no );
			}
				//insert가 되면 모든 곳에 다 들어가야하기 때문에 밖에 넣음
				mav.addObject("dto", dao.jumun(ap_no));		

		}	
		return mav;
	}
	
	
	
	
	@RequestMapping("/apply/applylist.do")
	public ModelAndView applylist(HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("apply/applyList");
		ApplyDTO dto=new ApplyDTO();
		String m_id=req.getParameter("s_id");
		dto=dao.read(m_id);
		mav.addObject("dto", dto);
		mav.addObject("list",dao.list() );
		return mav;
	}
	
	@RequestMapping(value = "/apply/alert.do")
	public ModelAndView alert(ApplyDTO dto) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("apply/msgView");
		mav.addObject("ap_no", dto.getAp_no());
		
		//System.out.println(dto.getAp_no());
		int cnt=dao.update(dto);
		
		if(cnt==0) {
		StringBuilder msg=new StringBuilder();		
			msg.append("<script>");
			msg.append(" 	alert('신청이 완료되지 않았습니다.');");
			msg.append(" 	history.back();");
			msg.append("</script>");
			mav.addObject("msg", msg);
		}else {
			StringBuilder msg=new StringBuilder();
			msg.append("<script>");
			msg.append(" 	alert('신청이 완료되었습니다.');");
			msg.append(" 	location.href='../home.do'; ");
			msg.append("</script>");
			mav.addObject("msg", msg);
		}
		return mav;
	}

}//class end
