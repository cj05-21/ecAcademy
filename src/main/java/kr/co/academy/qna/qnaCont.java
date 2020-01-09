package kr.co.academy.qna;

import javax.servlet.http.HttpServletRequest;

import kr.co.academy.qna.Utility.*;
import net.utility.Paging;
import net.utility.Utility;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

//out.println("<script>");

@Controller
public class qnaCont {
	private qnaDAO dao=new qnaDAO();
	public qnaCont() {System.out.println("----- qnaCont() 객체생성됨-----");}
	
	//결과확인:http://localhost:8090/academy/qna/qnaIns.do
	@RequestMapping(value="/qna/qnaIns.do", method=RequestMethod.GET)
	public String qform() {
		System.out.println("----- InsForm으로 이동함.-----");
		return "qna/qnaInsForm";
	}//qform end
	
	
	@RequestMapping(value = "/qna/qnaIns.do", method = RequestMethod.POST)
	public ModelAndView qna_Ins(qnaDTO dto, HttpServletRequest req) {
		//입력 체크
		ModelAndView mav = new ModelAndView();
		mav.setViewName("qna/qna_waring");
		
		String q_subject = req.getParameter("q_subject").trim();
		String q_con = req.getParameter("q_content").trim();
		String q_id = req.getParameter("s_id").trim();

		dto.setQ_subject(q_subject);
		dto.setQ_content(q_con);
		dto.setQ_id(q_id);
		int cnt = dao.insert(dto);
		if (cnt == 0) {
			mav.addObject("msg1", "질문 등록이 실패했습니다");
			mav.addObject("msg2", "");
			System.out.println("질문등록 실패");
		} else {
			mav.addObject("msg1", "질문을 성공적으로 등록했습니다.");
			mav.addObject("msg2", "자동으로 리스트로 복귀합니다.");
			System.out.println("질문등록 성공");
		} // if end
		return mav;

	}//qin end
	
	/* 일반 list
	 * //결과확인:http://localhost:8090/academy/qna/qnaList.do
	 * 
	 * @RequestMapping("/qna/qnaList.do") public ModelAndView list() { ModelAndView
	 * mav=new ModelAndView(); mav.setViewName("qna/qnaList"); mav.addObject("list",
	 * dao.list()); mav.addObject("root", Utility.getRoot()); mav.addObject("img1",
	 * "q-mark.jpg"); //이미지를 출력할수 있는 명령문 작성 mav.addObject("img2", "a-mark.png");
	 * return mav; }//list() end
	 */
	
	//페이징+검색 list
	@RequestMapping("/qna/qnaList.do")
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
		String paging=new Paging().paging(totalRecord, nowPage, recordPerPage, col, word, "qnaList.do" );
		
		mav.setViewName("qna/qnaList");
		mav.addObject("list", dao.list(col, word, nowPage, recordPerPage));
		mav.addObject("paging", paging);
		mav.addObject("root", Utility.getRoot());

		return mav;
	}// list() end
	
	@RequestMapping("/qna/qnaRead.do")
	public ModelAndView Read(int q_no) { //상세보기 체크
		ModelAndView mav = new ModelAndView();
		qnaDTO dto = dao.read(q_no);
		if (dto != null) {
			mav.setViewName("qna/qnaRead");
			mav.addObject("dto", dto);
		} else if (dto == null) {
			mav.setViewName("qna/Error1");
		}

		return mav;
	}//Read end
	
	@RequestMapping(value = "/qna/qnaUp.set", method = RequestMethod.POST)
	public ModelAndView UpRead(HttpServletRequest req) { //수정 체크
		ModelAndView mav = new ModelAndView();
		String s_id = req.getParameter("s_id").trim();
		String s_level = req.getParameter("s_level").trim();
		String q_id = req.getParameter("q_id").trim();
		int q_no = Integer.parseInt(req.getParameter("q_no").trim());
		qnaDTO dto = dao.upread(q_no);
		if (s_level.equals("B") || s_level.equals("A") || s_id.equals(q_id)) {
			// 보안등급이 B 혹은 A등급이상인경우 또는 작성자 본인인 경우
			if (dto != null) {
				mav.setViewName("qna/qnaUpForm");
				mav.addObject("dto", dto);
			} else if (dto == null) {
				mav.setViewName("qna/Error2");
			}
		} else { //보안 등급이 B등급 이하 및 이름이 다른경우
			mav.setViewName("qna/qna_waring");
			System.out.println("권한 및 유저 비매칭");
			mav.addObject("msg1", "죄송합니다.    글의 수정, 삭제는 반드시 작성자 본인 또는 관리자만 가능합니다.[TEST]");
			mav.addObject("msg2", "");
		}
		return mav;
	}// UpRead end
	
	@RequestMapping(value="/qna/qnaUp.do", method=RequestMethod.POST)
	public ModelAndView UpDo(qnaDTO dto, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView(); //수정 게시
		mav.setViewName("qna/qna_waring");

		String q_subject = req.getParameter("q_subject").trim();
		String q_con = req.getParameter("q_content").trim();
		String q_id = req.getParameter("s_id").trim();

		dto.setQ_subject(q_subject);
		dto.setQ_content(q_con);
		dto.setQ_id(q_id);
		int cnt = dao.updo(dto);
		if (cnt == 0) {
			mav.addObject("msg1", "재등록 실패.관리자에게 문의하시오.");
			mav.addObject("msg2", "");
			System.out.println("질문등록 실패");
		} else {
			mav.addObject("msg1", "재등록 성공.");
			mav.addObject("msg2", "자동으로 리스트로 복귀합니다.");
			System.out.println("질문등록 성공");
		} // if end
		return mav;
	}//Updo end
	
	@RequestMapping("/qna/qnaDel.do")
	public ModelAndView delete(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		String s_id = req.getParameter("s_id").trim();
		String s_level = req.getParameter("s_level").trim();
		String q_id = req.getParameter("q_id").trim();
		int q_no = Integer.parseInt(req.getParameter("q_no").trim());
		if (s_id.equals(q_id) || s_level.equals("B") || s_level.equals("A")) {
			int cnt = dao.delete(q_no);
			if (cnt == 0) {
				mav.setViewName("qna/qnaDelCheck");
				mav.addObject("msg1", "삭제를 실패하였습니다.");
				mav.addObject("msg2", "실패");
			} else {
				mav.setViewName("qna/qnaDelCheck");
				mav.addObject("msg1", "이 개시글을 삭제하시겠습니까?");
				mav.addObject("msg2", "삭제가 완료 되었습니다.");
				mav.addObject("msg3", "삭제를 취소하셨습니다.");
			} // if end
		} else {
			mav.setViewName("qna/qna_waring");
			System.out.println("권한 및 유저 비매칭");
			mav.addObject("msg1", "죄송합니다.    글의 수정, 삭제는 반드시 작성자 본인 또는 관리자만 가능합니다.[TEST]");
			mav.addObject("msg2", "");
		}
		return mav;
	}// delete.do
	
	
	@RequestMapping(value = "/qna/qnaRe.set", method = RequestMethod.POST) // 필요시 수정
	public ModelAndView ReForm(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		int q_no = Integer.parseInt(req.getParameter("q_no").trim());
		String s_level = req.getParameter("s_level").trim();
		qnaDTO dto = dao.reread(q_no);
		//이 글을 작성하려고 시도하는 사람이 MASTER계정인지 확인하기.
		if (s_level.equals("B")||s_level.equals("A")) {//s_id 대신 member테이블 의 m_level을 불러와서 비교해도 가능.
			if (dto != null) {
				mav.setViewName("qna/qnaReForm");
				mav.addObject("dto", dto);
			} else if (dto == null) {
				mav.setViewName("qna/Error2");
			}
		} else {
			mav.setViewName("qna/qna_waring");
			System.out.println("권한 및 유저 비매칭");
			mav.addObject("msg1", "죄송합니다. 현재 답변은 관리자만 작성할수 있습니다.[TEST]");
			mav.addObject("msg2", "");
		}
		return mav;
	}// UpRead end
	
	@RequestMapping(value = "/qna/qnaRe.do", method = RequestMethod.POST)
	public ModelAndView reple(qnaDTO dto, HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("qna/qna_waring");
		int q_no = Integer.parseInt(req.getParameter("q_no").trim());
		String q_subject = req.getParameter("q_subject").trim();
		String q_con = req.getParameter("q_content").trim();
		String q_id = req.getParameter("s_id").trim(); 
		//이 단문은 "현재 로그인한 계정의 데이터가 담긴 변수"로 만들것. 접속된id를 작성한 글의q_id로 전환하는 과정임.
		
		dto.setQ_no(q_no);//부모글 번호
		dto.setQ_subject(q_subject); //글제목
		dto.setQ_content(q_con);//글 내용
		dto.setQ_id(q_id); //글 작성자
		int cnt = dao.reply(dto);
		if (cnt == 0) {
			mav.addObject("msg1", "답변 등록이 실패했습니다");
			mav.addObject("msg2", "");
			System.out.println("답변등록 실패");
		} else {
			mav.addObject("msg1", "답변을 성공적으로 등록했습니다.");
			mav.addObject("msg2", "자동으로 리스트로 복귀합니다.");
			System.out.println("답변등록 성공");
		} // if end
		return mav;
	}//Reple END
	
}
