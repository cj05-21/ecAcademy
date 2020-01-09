package kr.co.academy.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import DBPKG.DBOpen;
import kr.co.academy.classes.ClassDAO;
import kr.co.academy.classes.ClassDTO;
import net.utility.Paging;
import net.utility.UploadSaveManager;
import net.utility.Utility;

@Controller
public class ClassCont {

	private ClassDAO dao = new ClassDAO();

	public ClassCont() {
		System.out.println("----- ClassCont()객체생성됨...");

	}

	@RequestMapping(value = "/classes/clcreate.do", method = RequestMethod.GET)
	public String createForm() {
		return "classes/createForm";
	}// createForm() end

	@RequestMapping(value = "/classes/clcreate.do", method = RequestMethod.POST)
	public ModelAndView createProc(ClassDTO dto, HttpServletRequest req) {

		// 1)pom.xml -> 파일업로드/다운로드 관련 의존성 추가
		// 2)MediaDTO-> posterMF, filenameMF 필드추가후
		// getter, setter함수 생성
		// 3)servlet-context.xml에 스프링빈 등록

		ModelAndView mav = new ModelAndView();
		// mav.setViewName("classes/createForm");
		mav.addObject("root", Utility.getRoot());// /ecAcademy
		// -----------------------------------------------------
//	      전송된 파일 처리
//	      -> 실제 파일은 /media/stroage폴더에 저장
//	      -> 저장된 파일관련 정보는 media테이블에 저장
		// 파일이 저장될 실제 물리적인 경로
		String basePath = req.getRealPath("/classes/storage");

		// 1)<input type='file' name='posterMF'>
		// 파일 가져오기
		MultipartFile c_detIF = dto.getC_detIF();
		// 파일 저장하고 리네임된 파일명 반환
		String c_det = UploadSaveManager.saveFileSpring30(c_detIF, basePath);
		// 리네임된 파일명 dto객체 담기
		dto.setC_det(c_det);

		MultipartFile c_imageIF = dto.getC_imageIF();
		String c_image = UploadSaveManager.saveFileSpring30(c_imageIF, basePath);
		dto.setC_image(c_image);

		// ---------------------------------------------------------------
		int cnt = dao.create(dto);
		if (cnt == 0) {
			mav.setViewName("redirect:/classes/list.do");
			// mav.addObject("msg1", "<p>강좌등록실패!!</p>");
			// mav.addObject("img", "<img src='../images/fail.png'>");
			// mav.addObject("link1", "<input type='button' value='목록으로'
			// onclick='location.href=\"list.do\"'>");
			// mav.addObject("link2", "<input type='button' value='다시시도'
			// onclick='javascript:history.back()'>");
		} else {
			mav.setViewName("redirect:/classes/list.do");
			// mav.addObject("msg1", "<p>강좌등록성공~~</p>");
			// mav.addObject("img", "<img src='../images/sound.png'>");
			// mav.addObject("link1", "<input type='button' value='목록으로'
			// onclick='location.href=\"list.do\"'>");
		} // if end
		return mav;
	}// createProc() end

	/*
	 * //일반list
	 * 
	 * @RequestMapping("/classes/list.do") public ModelAndView list() { ModelAndView
	 * mav = new ModelAndView(); mav.setViewName("classes/list");
	 * mav.addObject("list", dao.list()); mav.addObject("root", Utility.getRoot());
	 * return mav; }// list() end
	 */	
	//페이징+검색 list
	@RequestMapping("/classes/list.do")
	public ModelAndView pagelist(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		String col=req.getParameter("col"); 		//검색칼럼
		String word=req.getParameter("word");  //검색어칼럼
		
		//utility.java 에 있는 checknull 사용
		//String값이 null이면 공백문자열 반환
		col=Utility.checkNull(col);
		word=Utility.checkNull(word);
		
		//페이징--------------------------------------------------
		//현재 페이지
		int nowPage=1; //초기 값은 1페이지
		if(req.getParameter("nowPage")!=null){  //초기값은 1페이지인데 nowPage가 있으면 그 페이지값 가져옴
			nowPage=Integer.parseInt(req.getParameter("nowPage"));
		}//if end
		
		//한 페이지당 출력할 글의 줄수 (5줄로 하려는 것)
		int recordPerPage=6;
		
		//전체 글 개수
		int totalRecord=dao.count(col, word);
		String paging=new Paging().paging(totalRecord, nowPage, recordPerPage, col, word, "list.do" );
		
		mav.setViewName("classes/list");
		mav.addObject("list", dao.list(col, word, nowPage, recordPerPage));
		mav.addObject("paging", paging);
		mav.addObject("root", Utility.getRoot());
		return mav;
	}// list() end
	@RequestMapping("/classes/listtoeic.do")
	public ModelAndView listtoeic(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("classes/listToeic");
		mav.addObject("list1", dao.list1());
		mav.addObject("root", Utility.getRoot());
		return mav;
	}// list() end
	@RequestMapping("/classes/listtoefl.do")
	public ModelAndView listtoefl(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("classes/listToefl");
		mav.addObject("list2", dao.list2());
		mav.addObject("root", Utility.getRoot());
		return mav;
	}// list() end
	@RequestMapping("/classes/listteps.do")
	public ModelAndView listteps(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("classes/listTeps");
		mav.addObject("list3", dao.list3());
		mav.addObject("root", Utility.getRoot());
		return mav;
	}// list() end
	@RequestMapping("/classes/listopic.do")
	public ModelAndView listopic(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("classes/listOpic");
		mav.addObject("list4", dao.list4());
		mav.addObject("root", Utility.getRoot());
		return mav;
	}// list() end
	

	@RequestMapping("/classes/read.do")
	public ModelAndView read(int w_code) {
		ModelAndView mav = new ModelAndView();
		ClassDAO dao = new ClassDAO();
		ClassDTO dto = dao.read(w_code);
		mav.setViewName("classes/read");
		mav.addObject("root", Utility.getRoot());
		mav.addObject("dto", dto);
		return mav;
	}// read() end

	@RequestMapping(value = "/classes/update.do", method = RequestMethod.GET)
	public ModelAndView updateForm(ClassDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("classes/updateForm");
		mav.addObject("dto", dao.read(dto.getW_code()));
		return mav;
	}// updateForm end

	@RequestMapping(value = "/classes/update.do", method = RequestMethod.POST)
	public ModelAndView updateProc(ClassDTO dto, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();

		String basePath = req.getRealPath("/classes/storage");
		// 수정전 저장된 기존의 정보 가져오기
		ClassDTO oldDTO = dao.read(dto.getW_code());

//			파일을 수정할 것 인지 ?
		// 1)
		MultipartFile c_detIF = dto.getC_detIF();
		if (c_detIF.getSize() > 0) {
			// 파일이 전송된 경우
			// 기존파일 삭제
			UploadSaveManager.deleteFile(basePath, oldDTO.getC_det());
			// 신규파일저장
			String c_det = UploadSaveManager.saveFileSpring30(c_detIF, basePath);
			dto.setC_det(c_det);
		} else {
			// 파일이 전송되지 않은 경우
			dto.setC_det(oldDTO.getC_det());
		} // if end
		MultipartFile c_imageIF = dto.getC_imageIF();
		if (c_imageIF.getSize() > 0) {
			// 파일이 전송된 경우
			// 기존파일 삭제
			UploadSaveManager.deleteFile(basePath, oldDTO.getC_image());
			// 신규파일저장
			String c_image = UploadSaveManager.saveFileSpring30(c_imageIF, basePath);
			dto.setC_image(c_image);
		} else {
			// 파일이 전송되지 않은 경우
			dto.setC_image(oldDTO.getC_image());
		} // if end

		int cnt = dao.update(dto);
		if (cnt == 0) {
			mav.setViewName("redirect:/classes/list.do");
			mav.addObject("msg1", "<p>강좌수정실패!!</p>");

			// mav.addObject("link1", "<input type='button' value='목록으로'
			// onclick='location.href=\"list.do\"'>");
			// mav.addObject("link2", "<input type='button' value='다시시도'
			// onclick='javascript:history.back()'>");
		} else {
			mav.setViewName("redirect:/classes/list.do");
			mav.addObject("msg1", "<p>강좌수정성공!!</p>");

			// mav.addObject("link1", "<input type='button' value='목록으로'
			// onclick='location.href=\"list.do\"'>");
		} // if end
		return mav;
	}// updateproc end

	@RequestMapping(value = "/classes/confirm.do", method = RequestMethod.GET)
	public ModelAndView confirm(ClassDTO dto, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		ClassDAO dao = new ClassDAO();
		try {
			dto = dao.read(dto.getW_code());
			if (dto != null) {
				mav.setViewName("classes/confirmView");
				mav.addObject("msg1", "게시글 목록에서 삭제하시겠습니까?");
				mav.addObject("msg2", "삭제가 완료 되었습니다.");
				mav.addObject("msg3", "삭제를 취소하셨습니다.");
				mav.addObject("dto", dto);
			}
		} catch (Exception e) {
			System.out.println("읽어오기 실패하였습니다." + e);
		}
		return mav;
	}

	@RequestMapping("/classes/delete.do")
	public ModelAndView delete(ClassDTO dto) {
		ModelAndView mav = new ModelAndView();
		ClassDAO dao = new ClassDAO();
		try {
			int cnt = 0;
			cnt = dao.delete(dto);
			if (cnt == 0) {
			} else if (cnt == 1) {
				mav.setViewName("redirect:list.do");
			} // if end
		} catch (Exception e) {
			System.out.println("삭제 실패하였습니다." + e);
		}
		return mav;
	}

}// class end
