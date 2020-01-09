package kr.co.academy.notice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.utility.Paging;
import net.utility.Utility;

@Controller // 해당 클래스의 컨트롤러 기능
//스프링컨테이너(서버)에서 자동으로 객체 생성된다
public class NoticeCont {
	public NoticeCont() {
		System.out.println("--------------NoticeCont() 객체 생성!!");
	}

	// 게시판 폼
	// http://localhost:8090/academy/notice/notice.do
	@RequestMapping(value = "notice/notice.do", method = RequestMethod.GET)
	public ModelAndView noticeForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("notice/noticeForm");
		return mav;
	}

	@RequestMapping(value = "notice/notice.do", method = RequestMethod.POST)
	public ModelAndView noticeIns(NoticeDTO dto, HttpServletRequest req, HttpServletResponse resp) {
		ModelAndView mav = new ModelAndView();
		NoticeDAO dao = new NoticeDAO();
		mav.setViewName("notice/noticeIns");

		try {
			int cnt = 0;
			String inform = req.getParameter("inform");
			String subject = req.getParameter("n_subject");
			String id = req.getParameter("m_id");
			String content = req.getParameter("n_content");

			cnt = dao.insert(inform, subject, id, content);
			if (cnt == 0) {
				mav.addObject("msg1", "게시물 등록 실패하였습니다.");
				mav.addObject("msg2", "");
			} else {
				mav.addObject("msg1", "게시물 등록 성공하였습니다.");
				mav.addObject("msg2", "무브무브");
			}

		} catch (Exception e) {
			System.out.println("응답실패 " + e);
		}
		return mav;
	}

	/* 일반 list
	 * @RequestMapping("notice/nolist.do") public ModelAndView list() { ModelAndView
	 * mav = new ModelAndView(); NoticeDAO dao = new NoticeDAO();
	 * mav.setViewName("notice/noticeList"); mav.addObject("list", dao.list());
	 * mav.addObject("list2", dao.list2()); mav.addObject("list3", dao.list3());
	 * mav.addObject("root", Utility.getRoot()); return mav; }
	 */
	
	@RequestMapping("notice/nolist.do")
	public ModelAndView pagelist(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		NoticeDAO dao = new NoticeDAO();
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
		String paging=new Paging().paging(totalRecord, nowPage, recordPerPage, col, word, "nolist.do" );
		 
		mav.setViewName("notice/noticeList");
		mav.addObject("list", dao.list(col, word, nowPage, recordPerPage));
		mav.addObject("paging", paging);
		mav.addObject("root", Utility.getRoot());
		return mav;
	}// list() end
	
	@RequestMapping("notice/noread.do")
	public ModelAndView read(int n_no) {
		ModelAndView mav = new ModelAndView();
		NoticeDAO dao = new NoticeDAO();
		NoticeDTO dto = dao.read(n_no);
		dao.incrementCnt(n_no);
		mav.setViewName("notice/noticeRead");
		mav.addObject("root", Utility.getRoot());
		mav.addObject("dto", dto);
		return mav;
	}

//----------------------------------------------------------------------수정	
		@RequestMapping(value = "notice/noupdate.do", method = RequestMethod.GET)
		public ModelAndView noticeUpdate(int n_no) {
			ModelAndView mav = new ModelAndView();
			NoticeDAO dao = new NoticeDAO();
			mav.setViewName("notice/noticeUpdate");
			NoticeDTO dto = dao.read(n_no);
			mav.addObject("root", Utility.getRoot());
			mav.addObject("dto", dto);
			return mav;
		}

	  @RequestMapping(value="notice/noupdate.do",method=RequestMethod.POST) 
	  public ModelAndView updateProc(NoticeDTO dto,HttpServletRequest req) { 
		  ModelAndView mav=new ModelAndView(); 
		  mav.setViewName("notice/msgView");
		  NoticeDAO dao=new NoticeDAO(); 
		  try { 
			  int cnt=0; 
			  int n_no=Integer.parseInt(req.getParameter("n_no")); 
			  String  inform=req.getParameter("inform");
			  String n_subject=req.getParameter("n_subject"); 
			  String m_id=req.getParameter("m_id"); 
			  String n_content=req.getParameter("n_content"); 
			
			  cnt=dao.update(n_no,inform,n_subject,m_id,n_content);			  
			  
			  if(cnt==1) { 
					StringBuilder msg=new StringBuilder();
					msg.append("<script>");
					msg.append("   alert('수정이 완료되었습니다');");
					msg.append("   location.href='noread.do?n_no="+n_no+"';");
					msg.append("</script>");
					mav.addObject("msg", msg);
			  }else {
					StringBuilder msg=new StringBuilder();
					msg.append("<script>");
					msg.append("   alert('수정이 실패되었습니다')");
					msg.append("   history.back();");
					msg.append("</script>");
					mav.addObject("msg", msg);				  
			  }
			  
		  }catch(Exception e)	  {
				  System.out.println("수정 실패하였습니다."+e);
		  }
	  
		  return mav;
	  }
//----------------------------------------------------------------------삭제 	
	@RequestMapping(value = "notice/confirm.do", method = RequestMethod.GET)
	public ModelAndView confirm(NoticeDTO dto, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		NoticeDAO dao = new NoticeDAO();
		try {
			dto = dao.read(dto.getN_no());
			if (dto != null) {
				mav.setViewName("notice/confirmView");
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
	@RequestMapping("notice/nodelete.do")
	public ModelAndView delete(NoticeDTO dto) {
		ModelAndView mav = new ModelAndView();
		NoticeDAO dao = new NoticeDAO();
		try {
			int cnt = 0;
			cnt = dao.delete(dto);
			if (cnt == 0) {
			} else if (cnt == 1) {
				mav.setViewName("redirect:nolist.do");
			} // if end
		} catch (Exception e) {
			System.out.println("삭제 실패하였습니다." + e);
		}
		return mav;
	}
}// class() end
