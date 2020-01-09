package kr.co.academy.manager;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManagerPage {
		ManagerDAO dao=new ManagerDAO();
	public ManagerPage() {
		System.out.println("----------ManagerPage()객체생성");
	}

	@RequestMapping("/manage/manage.do")
	public ModelAndView manager(HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/manage/manage");
		String m_id=req.getParameter("s_id");
		ManagerDTO dto=new ManagerDTO();
		dto=dao.read(m_id);
		System.out.println(dao.list());
		mav.addObject("dto", dto);
		mav.addObject("list", dao.list());
		return mav;
	}
	
	@RequestMapping("/manage/mem_manage.do")
	public ModelAndView memManage(ManagerDTO dto) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/manage/mem_manage");
		mav.addObject("list", dao.read());
		return mav;
	}
	@RequestMapping(value="/manage/mem_update.do",method = RequestMethod.GET)
	public ModelAndView memUpdate(ManagerDTO dto) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("/manage/mem_update");
		String m_id=dto.getM_id();
		dto=dao.read(m_id);
		mav.addObject("dto", dto);
		return mav;
	}
	@RequestMapping(value="/manage/mem_update.do",method = RequestMethod.POST)
	public ModelAndView Update(ManagerDTO dto) {
		ModelAndView mav=new ModelAndView();
		String m_level=dto.getM_level();
		String m_id=dto.getM_id();
		int cnt=dao.update(m_id,m_level);
		if(cnt==1) {
		mav.setViewName("redirect:/manage/mem_manage.do");
		}
		return mav;
	}
}
