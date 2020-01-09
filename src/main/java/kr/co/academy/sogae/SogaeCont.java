package kr.co.academy.sogae;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import DBPKG.DBOpen;
import kr.co.academy.sogae.SogaeDAO;
import kr.co.academy.sogae.SogaeDTO;
import net.utility.UploadSaveManager;
import net.utility.Utility;

@Controller
public class SogaeCont {
	
	private SogaeDAO dao=new SogaeDAO();
	public SogaeCont() {
		System.out.println("----- SogaeCont()객체생성됨...");
		
	}
	/*
		@RequestMapping(value="/sogae/sgcreate.do", method=RequestMethod.GET)
		public String createForm() {
			return "sogae/createForm";
		}//createForm() end
		
		
		@RequestMapping(value="/sogae/sgcreate.do", method=RequestMethod.POST)
		public ModelAndView createProc(SogaeDTO dto, HttpServletRequest req) {	
			ModelAndView mav=new ModelAndView();
			mav.addObject("root", Utility.getRoot());
	//-----------------------------------------------------		
//	      전송된 파일 처리
//	      -> 실제 파일은 /media/stroage폴더에 저장
//	      -> 저장된 파일관련 정보는 media테이블에 저장
			//파일이 저장될 실제 물리적인 경로
			String basePath=req.getRealPath("/sogae/storage");

			//파일 가져오기
			MultipartFile img_aIF=dto.getImg_aIF();
			//파일 저장하고 리네임된 파일명 반환
			String img_a=UploadSaveManager.saveFileSpring30(img_aIF, basePath);
			//리네임된 파일명 dto객체 담기
			dto.setImg_a(img_a);
			
			MultipartFile img_bIF=dto.getImg_bIF();
			String img_b=UploadSaveManager.saveFileSpring30(img_bIF, basePath);
			dto.setImg_b(img_b);
			
			MultipartFile img_cIF=dto.getImg_cIF();
			String img_c=UploadSaveManager.saveFileSpring30(img_cIF, basePath);
			dto.setImg_c(img_c);

			
			MultipartFile img_dIF=dto.getImg_dIF();
			String img_d=UploadSaveManager.saveFileSpring30(img_dIF, basePath);
			dto.setImg_d(img_d);

	//---------------------------------------------------------------		
			int cnt=dao.create(dto);   
			if(cnt==0) {
				mav.setViewName("redirect:/sogae/sglist.do");
				//mav.addObject("msg1",   "<p>강좌등록실패!!</p>");
				//mav.addObject("img",   "<img src='../images/fail.png'>");
				//mav.addObject("link1", "<input type='button' value='목록으로' onclick='location.href=\"list.do\"'>");
				//mav.addObject("link2", "<input type='button' value='다시시도' onclick='javascript:history.back()'>");
			}else {
				mav.setViewName("redirect:/sogae/sglist.do");
				//mav.addObject("msg1", "<p>강좌등록성공~~</p>");
				//mav.addObject("img",   "<img src='../images/sound.png'>");
				//mav.addObject("link1", "<input type='button' value='목록으로' onclick='location.href=\"list.do\"'>");
			}//if end		
			return mav;
		}//createProc() end
		*/
	
	@RequestMapping("/sogae/introduce.do") 
	public ModelAndView sogae() { 
		ModelAndView mav=new ModelAndView(); 
		mav.setViewName("sogae/introduce");
		mav.addObject("root", Utility.getRoot());
		return mav; 
	}//list() end
	
	  @RequestMapping("/sogae/sglist.do") 
	  public ModelAndView list() { 
		  ModelAndView mav=new ModelAndView(); 
		  	mav.setViewName("sogae/list");
		  	mav.addObject("root", Utility.getRoot());
		  	return mav; 
	  }//list() end
	 

}//class end






