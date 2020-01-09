package kr.co.academy.teacher;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
//import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.co.academy.teacher.TeacherDAO;
import net.utility.UploadSaveManager;
import net.utility.Utility;


@Controller
public class TeacherCont {
	//DAO객체 생성
	private TeacherDAO dao=new TeacherDAO();
	
	public TeacherCont() {
		System.out.println("-----TeacherCont() 객체 생성 됨");
	}//TeacherCont() end

//------------------------------------------------------------
	//http://localhost:8090/academy/teacher/insert.do
	//get방식
	@RequestMapping(value = "/teacher/insert.do", method = RequestMethod.GET)
	public ModelAndView insertForm() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("teacher/teacherForm");
		
		//w_code로만 들어간 강좌를 끌어올 DAO
		mav.addObject("list", dao.li());
		return mav;
	}//teacherForm() end
	
	//post방식
	@RequestMapping(value="/teacher/insert.do", method=RequestMethod.POST)
	public ModelAndView insertForm(TeacherDTO dto, HttpServletRequest req) {
		//1) pom.xml  → 파일 업로드 / 다운로드 관련 의존성 추가
		//2) MediaDTO → posterMF, filenameMF 필드 추가후
		//				getterm setter 함수 생성
		//3) servlet-context.xml 에 스프링빈 등록
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("teacher/msgView");
		mav.addObject("root", Utility.getRoot());

		//전송된 파일 처리 ( /teacher/media/storage)
		String basePath=req.getRealPath("/teacher/storage");
		
		//posterMF를 dto로 받아오기 위해서 getter와 setter 추가
		MultipartFile posterMF=dto.getPosterMF();
		
		//파일 저장하고 리네임된 파일명 반환
		String poster=UploadSaveManager.saveFileSpring30(posterMF, basePath);
		
		//리네임된 파일명을 dto 객체에 담기
		dto.setPoster(poster);
		
		int count=dao.insert(dto);
		if(count==0) {
			StringBuilder msg=new StringBuilder();
			msg.append("<script>");
			msg.append(" 	alert('강사 등록에 실패하였습니다.'); ");
			msg.append(" 	history.back(); ");
			msg.append("</script>");
			mav.addObject("msg", msg);
		}else {
			StringBuilder msg=new StringBuilder();
			msg.append("<script>");
			msg.append(" 	alert('강사가 등록되었습니다.');");
			msg.append(" 	location.href='list.do';");
			msg.append("</script>");
			mav.addObject("msg", msg);
		}//if end
		return mav;			
	}
//--------------------------------------------id 중복체크
		@RequestMapping("/teacher/idcheck.do")
		public void idCheck(HttpServletRequest req, HttpServletResponse resp) {
			try {
				String m_id=req.getParameter("m_id").trim();
					int cnt = dao.duplecateID(m_id); //아이디 중복확인
				
				JSONObject obj=new JSONObject();
				obj.put("count", cnt);  //(key, value) count 에는 cnt 값이 담김 → front 단에 count를 가져감
				resp.setContentType("text/plain; charset=UTF-8");  
				PrintWriter out = resp.getWriter();
				out.println(obj.toString());  //문자열로 만들어 리턴
				out.flush();  //스트림에 남아있는 데이터를 강제로 보냄
				out.close();
			}catch(Exception e) {
				System.out.println("응답 실패 : "+e);
			}//try end
		}//idCheck() end	
//--------------------------------------------강사이름 중복체크
	@RequestMapping("/teacher/namecheck.do")
	public void nameCheck(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String tc_name=req.getParameter("tc_name").trim();
				int cnt = dao.duplecateName(tc_name); //아이디 중복확인
			
			JSONObject obj=new JSONObject();
			obj.put("count", cnt);  //(key, value) count 에는 cnt 값이 담김 → front 단에 count를 가져감
			resp.setContentType("text/plain; charset=UTF-8");  
			PrintWriter out = resp.getWriter();
			out.println(obj.toString());  //문자열로 만들어 리턴
			out.flush();  //스트림에 남아있는 데이터를 강제로 보냄
			out.close();
		}catch(Exception e) {
			System.out.println("응답 실패 : "+e);
		}//try end
	}//idCheck() end
	
//----------------------------------강사 리스트-----------------
	@RequestMapping ("/teacher/list.do")
	public ModelAndView list() {
		ModelAndView mav=new ModelAndView();
		
		mav.setViewName("teacher/teacherList");
		
		//나눠져 있는 toeic, toefl, teps, opic을 리스트 4개로 분리
		mav.addObject("list1", dao.list1());
		mav.addObject("list2", dao.list2());
		mav.addObject("list3", dao.list3());
		mav.addObject("list4", dao.list4());
		return mav;
	}//list() end
//----------강사 상세보기----------------------
	@RequestMapping("/teacher/read.do")
	public ModelAndView read(int tc_no) {
		ModelAndView mav=new ModelAndView();
		TeacherDTO dto=dao.read(tc_no);
		mav.setViewName("teacher/teacherRead");
		mav.addObject("dto", dto);
		return mav;
	}//read() end
	
//------------------강사 목록 삭제----------------------
	
	 @RequestMapping("/teacher/delete.do")
	 public ModelAndView delete(TeacherDTO dto, HttpServletRequest req) { ModelAndView
	 mav=new ModelAndView(); 
	 mav.setViewName("/teacher/msgView");
	 mav.addObject("root", Utility.getRoot());
	  
	 //삭제하고자하는 정보 가져오기
	 TeacherDTO oldDTO=dao.read(dto.getTc_no());
	 
	 int cnt=dao.delete(dto.getTc_no());
	 if(cnt==0) {
			StringBuilder msg=new StringBuilder();
			msg.append("<script>");
			msg.append(" 	alert('삭제 실패하였습니다.');");
			msg.append(" 	history.back(); ");
			msg.append("</script>");
			mav.addObject("msg", msg);
	 }else {
		//관련파일 삭제
		 StringBuilder msg=new StringBuilder();
		 String basepath=req.getRealPath("/teacher/storage");
		 UploadSaveManager.deleteFile(basepath, oldDTO.getPoster());
		 msg.append("<script>");
		 msg.append(" 	alert('삭제되었습니다.');");
		 msg.append(" 	location.href='list.do';");
		 msg.append("</script>");
		 mav.addObject("msg", msg);
	 }//if end
	  return mav;
	  }//delete.do
///-------------------강사 목록 수정---------------------------------
	@RequestMapping(value="/teacher/update.do", method=RequestMethod.GET)
	public ModelAndView updateform(TeacherDTO dto) {
		ModelAndView mav= new ModelAndView();
		
		mav.setViewName("teacher/teacherUpdateForm");
		mav.addObject("dto", dao.read(dto.getTc_no()));
		mav.addObject("list", dao.li());
		return mav;
	}
	
	@RequestMapping(value="/teacher/update.do", method = RequestMethod.POST)
	public ModelAndView updateproc(TeacherDTO dto, HttpServletRequest req) {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("teacher/msgView");
		String basePath=req.getRealPath("/teacher/storage");
		
		//수정 전 저장된 기존의 정보 가져오기
		TeacherDTO oldDTO=dao.read(dto.getTc_no());
		
		//파일을 수정할 것인가
		MultipartFile posterMF=dto.getPosterMF();
		if(posterMF.getSize()>0) {
			//기존 파일 삭제
			UploadSaveManager.deleteFile(basePath, oldDTO.getPoster());
			
			//신규파일 저장
			String poster=UploadSaveManager.saveFileSpring30(posterMF, basePath);
			dto.setPoster(poster);
		}else {
			//파일이 전송되지 않는 경우
			dto.setPoster(oldDTO.getPoster());
		}
		
		int cnt=dao.update(dto);
		if(cnt==0) {
			StringBuilder msg=new StringBuilder();
			msg.append("<script>");
			msg.append(" 	alert('수정에 실패하였습니다.');");
			msg.append(" 	history.back(); ");
			msg.append("</script>");
			mav.addObject("msg", msg);
			
		}else {
			StringBuilder msg=new StringBuilder();
			msg.append("<script>");
			msg.append(" alert('수정되었습니다.');");
			msg.append(" location.href='list.do';");
			msg.append("</script>");
			mav.addObject("msg", msg);
		}
		return mav;
	}//
	
	
	
}//class end


