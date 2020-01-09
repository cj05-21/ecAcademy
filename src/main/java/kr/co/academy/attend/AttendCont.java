package kr.co.academy.attend;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.co.academy.manager.ManagerDTO;
import net.utility.Utility;

@Controller
public class AttendCont {
	AttendDAO dao=new AttendDAO();
	public AttendCont() {
		System.out.println("----------AttendCont() 객체 생성");
	}

	@RequestMapping("/attend/attend.do")
	public ModelAndView attend(HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("attend/attend");
		String attend_date=Utility.getDate();
		String m_id=req.getParameter("s_id");
		AttendDTO dto=new AttendDTO();
		dto=dao.read(m_id);
		mav.addObject("dto", dto);
		mav.addObject("list", dao.list());
		mav.addObject("root", Utility.getRoot());
		return mav;
	}
	@RequestMapping("/attend/afterattend.do")
	public ModelAndView afterAttend(HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("attend/afterAttend");
		String m_id=req.getParameter("s_id");
		String attend_date=Utility.getDate();
		AttendDTO dto=new AttendDTO();
		dto=dao.read(m_id);
		mav.addObject("dto", dto);
		mav.addObject("check",dao.check(attend_date));
		mav.addObject("root", Utility.getRoot());
		return mav;
	}
	
	@RequestMapping("/attend/confirm.do")
	public ModelAndView confirm(AttendDTO dto,HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.addObject("root", Utility.getRoot());
		String m_id=dto.getM_id();
		int w_code=dto.getW_code();
		String tc_name=dto.getTc_name();
		String p_sts=dto.getP_sts();
		String attend_date=Utility.getDate();
		dto=dao.confirm(m_id,w_code,attend_date);
		if(dto!=null) { 
			StringBuilder msg=new StringBuilder();
			msg.append("<script>");
			msg.append("   alert('출석이 이미 되어있습니다.');");
			msg.append("   history.back();");
			msg.append("</script>");
			mav.addObject("msg", msg);
	  }else {
		  	dao.insert(m_id,tc_name,w_code,attend_date,p_sts);
			StringBuilder msg=new StringBuilder();
			msg.append("<script>");
			msg.append("   alert('출석완료 되었습니다.');");
			msg.append("   location.href='attend.do?';");
			msg.append("</script>");
			mav.addObject("msg", msg);				  
	  }
		mav.setViewName("attend/msgView");
		return mav;
	}
}

