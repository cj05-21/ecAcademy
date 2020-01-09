package kr.co.academy;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	HomeDAO dao=new HomeDAO();
	public HomeController() {
		System.out.println("home() 객체생성");
	}

	//http://localhost:8090/academy/home.do
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mav=new ModelAndView();
		ArrayList<HomeDTO> list=dao.mainreview();	
		mav.setViewName("./index");
		mav.addObject("mainclass", dao.mainclass());
		mav.addObject("list", list); 
		return mav;
	}
	
}
