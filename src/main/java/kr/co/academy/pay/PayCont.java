package kr.co.academy.pay;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.academy.classes.ClassDAO;
import kr.co.academy.classes.ClassDTO;
import net.utility.Utility;

@Controller
public class PayCont {
	
	private PayDAO dao=new PayDAO();
	public PayCont() {
		System.out.println("----- PayCont()객체생성됨. . . ");
		
	}
	
	
	@RequestMapping(value="/pay/paylist.do" , method=RequestMethod.GET)
	public ModelAndView list(HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		String m_id=req.getParameter("s_id");
		mav.setViewName("./pay/payList");
		mav.addObject("list", dao.list(m_id));
		mav.addObject("root", Utility.getRoot()); //Utility패키지를 쓸 경우 필요함
		return mav;
	
	}//list() end
	
	@RequestMapping(value="/pay/receipt.do",method=RequestMethod.GET)
	public ModelAndView receipt(HttpServletRequest req) {
		ModelAndView mav= new ModelAndView();
		
		String w_code=req.getParameter("w_code");
		String m_id=req.getParameter("s_id");
		
		PayDTO dto= new PayDTO();
		
		mav.setViewName("./pay/receipt");
		mav.addObject("dto", dao.receipt(m_id,w_code));
		
		return mav;
	}//receipt() end

}
