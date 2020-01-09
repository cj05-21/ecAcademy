package kr.co.academy.review;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.academy.notice.NoticeDAO;
import kr.co.academy.notice.NoticeDTO;
import net.utility.Paging;
import net.utility.UploadSaveManager;
import net.utility.Utility;

@Controller // 해당 클래스의 컨트롤러 기능
//스프링컨테이너(서버)에서 자동으로 객체 생성된다
public class ReviewCont {
	ReviewDAO dao=new ReviewDAO();
	public ReviewCont() {
		System.out.println("--------------ReviewCont() 객체 생성!!");
	}

	@RequestMapping(value = "review/review.do", method = RequestMethod.GET)
	public ModelAndView reviewForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("review/reviewForm");
		return mav;
	}
	
	@RequestMapping(value = "review/review.do", method = RequestMethod.POST)
	public ModelAndView reviewIns(ReviewDTO dto, HttpServletRequest req) {
		//1)pom.xml  => 파일업로드/다운로드 관련 의존성 추가
		//2)MediaDTO =>posterMF,filenameMF  필드추가후
		//				getter setter 함수 행성
		//3)servlet-context.xml 에 스프링빈 등록
		ModelAndView mav = new ModelAndView();
		mav.setViewName("review/reviewIns");
		mav.addObject("root", Utility.getRoot());
//----------------------------------------------------------			
//		전송된 파일 처리
//		-> 실제 파일은 / media/stroage 폴더에 저장
//		-> 저장된 파일관련 정보는 media테이블에 저장
//		//파일이 저장될 실제 물리적인 경로
		String basePath=req.getRealPath("/review/storage");
		
		//1)<input type='file' name='posterMF'>
		//파일 가져오기
		MultipartFile posterMF=dto.getPosterMF();
		//파일 저장하고 리네임된 파일명 반환
		//static 함수이기 때문에 사용
		String poster=UploadSaveManager.saveFileSpring30(posterMF, basePath);
		//리네임된 파일명 dto객체에 담기
		dto.setPoster(poster);
//------------------------------------------------------------		
		try {
			int cnt = dao.insert(dto);
			if (cnt == 0) {
				mav.addObject("msg1", "후기 등록 실패하였습니다.");
				mav.addObject("msg2", "");
			} else {
				mav.addObject("msg1", "후기 등록 성공하였습니다.");
				mav.addObject("msg2", "무브무브");
			}
		} catch (Exception e) {
			System.out.println("응답실패 " + e);
		}
		return mav;
	}
	
//----------후기 목록보기----------------------
	/*
	@RequestMapping("review/relist.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("review/reviewList");
		mav.addObject("list", dao.list());
		mav.addObject("list1", dao.list1());
		mav.addObject("list2", dao.list2());
		mav.addObject("list3", dao.list3());
		mav.addObject("list4", dao.list4());
		mav.addObject("root", Utility.getRoot());
		return mav;
	}
	*/
	/*
	 * @RequestMapping("review/relist.do") public ModelAndView list() { ModelAndView
	 * mav = new ModelAndView(); mav.setViewName("review/reviewList");
	 * mav.addObject("list", dao.list()); mav.addObject("list1", dao.list1());
	 * mav.addObject("list2", dao.list2()); mav.addObject("list3", dao.list3());
	 * mav.addObject("list4", dao.list4()); mav.addObject("root",
	 * Utility.getRoot()); return mav; }
	 */
	//페이징+검색 list
		@RequestMapping("review/relist.do")
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
			int recordPerPage=5;
			
			//전체 글 개수
			int totalRecord=dao.count(col, word);
			String paging=new Paging().paging(totalRecord, nowPage, recordPerPage, col, word, "relist.do" );
			
			mav.setViewName("review/reviewList");
			mav.addObject("list", dao.list(col, word, nowPage, recordPerPage));
			mav.addObject("paging", paging);
			mav.addObject("root", Utility.getRoot());
			return mav;
		}// list() end
//----------후기 상세보기----------------------
		@RequestMapping("/review/reread.do")
		public ModelAndView read(int r_no) {
			ModelAndView mav=new ModelAndView();
			dao.incrementCnt(r_no);
			ReviewDTO dto=dao.read(r_no);
			
			mav.setViewName("review/reviewRead");
			mav.addObject("dto", dto);
			return mav;
		}//read() end
//----------후기 수정하기----------------------	
		@RequestMapping(value="/review/reupdate.do",method=RequestMethod.GET)
		public ModelAndView updateForm(ReviewDTO dto) {
				ModelAndView mav=new ModelAndView();
				mav.setViewName("review/reviewUpdate");
				mav.addObject("dto", dao.read(dto.getR_no()));
				return mav;
		}//updateForm() end
		
		
		@RequestMapping(value="/review/reupdate.do",method=RequestMethod.POST)
		public ModelAndView updateProc(ReviewDTO dto,HttpServletRequest req) {
			ModelAndView mav=new ModelAndView();
			mav.setViewName("review/msgView");
			String basePath=req.getRealPath("/review/storage");
			//수정전 저장된 기존의 정보 가져오기
			int r_no=Integer.parseInt(req.getParameter("r_no"));
			ReviewDTO oldDTO=dao.read(dto.getR_no());
//			파일을 수정할것인지?
			//1)
			MultipartFile posterMF=dto.getPosterMF();
			if(posterMF.getSize()>0) {
				//파일이 전송된 경우
					//기존파일을 삭제하자
					UploadSaveManager.deleteFile(basePath, oldDTO.getPoster());
					//신규 파일 저장
					String poster=UploadSaveManager.saveFileSpring30(posterMF, basePath);
					dto.setPoster(poster);
			}else {
				//파일이 전송되지 않은 경우
					dto.setPoster(oldDTO.getPoster());
			}//if end

			int cnt=dao.update(dto);
			if(cnt==1) { 
				StringBuilder msg=new StringBuilder();
				msg.append("<script>");
				msg.append("   alert('수정이 완료되었습니다');");
				msg.append("   location.href='reread.do?r_no="+r_no+"';");
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
			return mav;
		}	//updateProc end	
//----------후기 삭제하기----------------------			
		@RequestMapping(value = "review/confirm.do", method = RequestMethod.GET)
		public ModelAndView confirm(ReviewDTO dto, HttpServletRequest req) {
			ModelAndView mav = new ModelAndView();
			try {
				dto = dao.read(dto.getR_no());
				if (dto != null) {
					mav.setViewName("review/confirmView");
					mav.addObject("msg1", "후기글 목록에서 삭제하시겠습니까?");
					mav.addObject("msg2", "삭제가 완료 되었습니다.");
					mav.addObject("msg3", "삭제를 취소하셨습니다.");
					mav.addObject("dto", dto);
				}
			} catch (Exception e) {
				System.out.println("읽어오기 실패하였습니다." + e);
			}
			return mav;
		}
		@RequestMapping("review/redelete.do")
		public ModelAndView delete(ReviewDTO dto,HttpServletRequest req) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("root", Utility.getRoot());
			String basePath=req.getRealPath("/review/storage");
			//수정전 저장된 기존의 정보 가져오기
			try {
				int cnt = 0;
				cnt = dao.delete(dto,basePath);
				if (cnt == 0) {
				} else if (cnt == 1) {
					mav.setViewName("redirect:relist.do");
				} // if end
			} catch (Exception e) {
				System.out.println("삭제 실패하였습니다." + e);
			}
			return mav;
		}
		
		@RequestMapping("/review/idcheck.do")
		public void idCheck(HttpServletRequest req,HttpServletResponse resp) {
			try {
				String m_id=req.getParameter("s_id").trim();
				ReviewDAO dao=new ReviewDAO();
				int cnt= dao.duplecateID(m_id);//아이디 중복확인
				
				/*
				//1)text로 응답--------------------------------------------------
				resp.setContentType("text/plain; charset=UTF-8");
				PrintWriter out=resp.getWriter();
				out.println(cnt);
				out.flush();
				out.close();
				*/
				//2)json 응답
				//pom.xml 에 의존성 추가 (라이브러리 추가)
				JSONObject obj= new JSONObject();
				//     key, value
				obj.put("count",cnt);
				resp.setContentType("text/plain; charset=UTF-8");
				PrintWriter out=resp.getWriter();
				out.println(obj.toString());
				out.flush();
				out.close();
			}catch(Exception e) {System.out.println("응답 실패~!"+e);}
		}//idCheck() end
		
		@RequestMapping("/review/idcheck1.do")
		public void idCheck1(HttpServletRequest req,HttpServletResponse resp) {
			try {
				String m_id=req.getParameter("s_id").trim();
				int r_no=Integer.parseInt(req.getParameter("r_no").trim());
				ReviewDAO dao=new ReviewDAO();
				ReviewDTO dto=dao.ID(r_no);
				int cnt=1;
				//2)json 응답
				//pom.xml 에 의존성 추가 (라이브러리 추가)
				JSONObject obj= new JSONObject();
				//     key, value
				obj.put("id",dto.getM_id());
				obj.put("r_no",r_no);
				
				resp.setContentType("text/plain; charset=UTF-8");
				PrintWriter out=resp.getWriter();
				out.println(obj.toString());
				out.flush();
				out.close();
			}catch(Exception e) {System.out.println("응답 실패~!"+e);}
		}//idCheck2() end
		
		
}// class() end
