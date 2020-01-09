package kr.co.academy.wish;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.academy.qna.Utility;

@Controller
public class WishCont {

	private WishDAO dao=new WishDAO();
	
	public WishCont() {
		System.out.println("-------------WishCont() 객체 생성 됨");
	}//WishCont()end
	
	
	@RequestMapping("wish/winsert.do")
	public ModelAndView winsertProc(WishDTO dto, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		String m_id=req.getParameter("s_id");
		System.out.println(m_id);
		System.out.println(dto.getW_code());
		dao.winsert(m_id,dto.getW_code());
		
		mav.setViewName("redirect:/wish/wlist.do?s_id="+m_id);
		mav.addObject("root", Utility.getRoot());// /ecAcademy
		return mav;
	}// createProc() end
	
	@RequestMapping("/wish/wlist.do")
	public ModelAndView wlist(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		String m_id=req.getParameter("s_id");
		mav.setViewName("wish/listForm");
		mav.addObject("wlist", dao.list(m_id));
		mav.addObject("root", Utility.getRoot());
		return mav;
		
	}// list() end
	
	@RequestMapping("/wish/delete.do")
	public ModelAndView delete(WishDTO dto,HttpServletRequest req) {
		ModelAndView mav= new ModelAndView();
		String m_id=req.getParameter("s_id");
		WishDAO dao=new WishDAO();
		try {
			int cnt=0;
			cnt=dao.delete(dto);
			if(cnt==0) {
			}else if(cnt==1) {
				mav.setViewName("redirect:./wlist.do?s_id="+m_id);
			}//if end
		}catch( Exception e) {
			System.out.println("삭제실패"+e);
		}
		return mav;
	}
	
}//class end
