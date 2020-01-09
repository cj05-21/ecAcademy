package kr.co.academy.qna;

import DBPKG.DBOpen;
import kr.co.academy.classes.ClassDTO;

//import java.lang.reflect.Array;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class qnaDAO {
	public int insert(qnaDTO dto) {
		int cnt = 0;
		try {
			Connection con = DBOpen.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" INSERT INTO qna(q_code, q_no, q_subject, q_content, q_id, q_date, q_group) ");
			sql.append(" VALUES ( ");
			sql.append("          1 ");
			sql.append("         ,(SELECT ifnull(MAX(q_no), 0)+1 FROM qna ALIAS_FOR_SUBQUERY)");
			sql.append("         ,?,?,? ");
			sql.append("         ,now()");
			sql.append("         ,(SELECT ifnull(MAX(q_group), 0)+1 FROM qna ALIAS_FOR_SUBQUERY)");
			sql.append("        )  ");

			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getQ_subject());
			pstmt.setString(2, dto.getQ_content());
			pstmt.setString(3, dto.getQ_id());

			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("행추가실패:" + e);
		} // try end
		return cnt;
	}// insert() end
	
	/*
	 * public ArrayList<qnaDTO> list(){ ArrayList<qnaDTO> list = null; try{
	 * Connection con=DBOpen.getConnection(); StringBuilder sql=new StringBuilder();
	 * sql.
	 * append(" SELECT	q_code, q_no, q_id, q_subject, q_content, q_date, q_indent"
	 * ); sql.append(" FROM qna");
	 * sql.append(" ORDER BY q_group DESC, q_indent ASC");
	 * 
	 * PreparedStatement pstmt=con.prepareStatement(sql.toString()); ResultSet
	 * rs=pstmt.executeQuery(); if(rs.next()) { list=new ArrayList<qnaDTO>(); do {
	 * qnaDTO dto=new qnaDTO(); dto.setQ_code(rs.getInt("q_code"));
	 * dto.setQ_no(rs.getInt("q_no")); dto.setQ_subject(rs.getString("q_subject"));
	 * dto.setQ_id(rs.getString("q_id")); dto.setQ_date(rs.getDate("q_date"));
	 * dto.setQ_indent(rs.getInt("q_indent")); list.add(dto); }while(rs.next());
	 * }//if end
	 * 
	 * }catch(Exception e){ System.out.println("행목록실패:"+e); }//try end
	 * 
	 * return list; }
	 */
	

	public ArrayList<qnaDTO> list(String col, String word, int nowPage, int recordPerPage){
        ArrayList<qnaDTO> list=null;
        
        // 페이지당 출력할 레코드 갯수 (10개를 기준)
        // 1 page : WHERE r>=1 AND r<=10
        // 2 page : WHERE r>=11 AND r<=20
        // 3 page : WHERE r>=21 AND r<=30
        int startRow = ((nowPage-1) * recordPerPage) ;
        int endRow   = nowPage * recordPerPage;
        
        try{
            Connection con=DBOpen.getConnection();
            StringBuilder sql=new StringBuilder();
          
          word = word.trim(); //검색어의 좌우 공백 제거
          
          if(word.length()==0) { //검색을 하지 않는 경우
            sql.append(" SELECT q_code, q_no, q_id, q_subject, q_content, q_date, q_indent ");
            sql.append("       FROM qna ");            
            sql.append("       ORDER BY q_group DESC, q_indent ASC ");
            sql.append(" limit " + startRow + "," + recordPerPage) ;
          } else {
            //검색을 하는 경우
        	  sql.append(" SELECT q_code, q_no, q_id, q_subject, q_content, q_date, q_indent ");
        	  sql.append("       FROM qna "); 
              
            
            String search="";
            if(col.equals("q_subject")) { //제목
              search += " WHERE q_subject LIKE '%" + word + "%'";
            } else if(col.equals("q_content")) { //내용
              search += " WHERE q_content LIKE '%" + word + "%'";
            } else if(col.equals("q_id")) { //작성자
              search += " WHERE q_id LIKE '%" + word + "%'";
            } else if(col.equals("sub_cont")) { //강사명, 강좌명
              search += " WHERE q_subject LIKE '%" + word + "%'";
              search += " OR q_content LIKE '%" + word + "%'";
            }//if end
            
            sql.append(search);        
            
            sql.append("       ORDER BY q_group DESC, q_indent ASC ");
            sql.append(" limit " + startRow + "," + recordPerPage) ;
          }//if end
          
          PreparedStatement pstmt=con.prepareStatement(sql.toString());
          ResultSet rs=pstmt.executeQuery();
          if(rs.next()){
            list=new ArrayList<qnaDTO>();
            do{
              qnaDTO dto=new qnaDTO();
              
              dto.setQ_code(rs.getInt("q_code"));
              dto.setQ_no(rs.getInt("q_no"));
              dto.setQ_id(rs.getString("q_id"));
              dto.setQ_subject(rs.getString("q_subject"));
              dto.setQ_content(rs.getString("q_content"));
              dto.setQ_date(rs.getString("q_date"));
              dto.setQ_indent(rs.getInt("q_indent"));
              list.add(dto);
            }while(rs.next());
          }//if end
          
        }catch(Exception e) {
          System.out.println("목록 페이징 실패: "+e);
        }   
        return list;
      }//list() end  
	
	public int count (String col, String word){  
		int cnt=0;
		try{
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			
			sql.append(" SELECT count(*) AS cnt ");
			sql.append(" from qna ");
            
			
			//검색을 했을 때 나타는 리스트에서 복사
			if(word.trim().length()>=1){ //검색어가 존재한다 라는 의미 = where 조건절로서 선택할 것을 찾아주기
				 String search="";
		            if(col.equals("q_subject")) { //제목
		              search += " WHERE q_subject LIKE '%" + word + "%'";
		            } else if(col.equals("q_content")) { //내용
		              search += " WHERE q_content LIKE '%" + word + "%'";
		            } else if(col.equals("q_id")) { //작성자
		              search += " WHERE q_id LIKE '%" + word + "%'";
		            } else if(col.equals("sub_cont")) { //제목, 내용
		              search += " WHERE q_subject LIKE '%" + word + "%'";
		              search += " OR q_content LIKE '%" + word + "%'";
		            }//if end
				
				sql.append(search);
				
			}// if end
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			ResultSet rs=pstmt.executeQuery(); //select 이기 때문에 resultset에 query문을 담아야 함
			if(rs.next()){
					cnt=rs.getInt("cnt");
			}//if end						
		}catch(Exception e){
			System.out.println("글 개수 카운팅 실패 : "+e);
		}//try end
		return cnt; 
	}//count end
	
    public qnaDTO read(int q_no){
        qnaDTO dto=null;
        try{
            Connection con=DBOpen.getConnection();
            StringBuilder sql=new StringBuilder();
            sql.append(" SELECT q_code, q_no, q_id, q_subject, q_content, q_group, q_date");
            sql.append(" FROM qna ");
            sql.append(" WHERE q_no=? ");
            
            PreparedStatement pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, q_no);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next()){
                dto=new qnaDTO();
                dto.setQ_code(rs.getInt("q_code"));
                dto.setQ_no(rs.getInt("q_no"));
                dto.setQ_id(rs.getString("q_id"));
                dto.setQ_subject(rs.getString("q_subject"));
                dto.setQ_content(rs.getString("q_content"));
                dto.setQ_group(rs.getInt("q_group"));
                dto.setQ_date(rs.getString("q_date"));
            }else{
                dto=null;
            }//if end
            
        }catch(Exception e){
            System.out.println("상세보기실패:"+e);
        }//try end
        return dto;
    }//read() end
    
    public qnaDTO upread(int q_no){
        qnaDTO dto=null;
        try{
            Connection con=DBOpen.getConnection();
            StringBuilder sql=new StringBuilder();
            sql.append(" SELECT q_code, q_no, q_id, q_subject, q_content, q_group, q_date");
            sql.append(" FROM qna ");
            sql.append(" WHERE q_no=? ");
            
            PreparedStatement pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, q_no);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next()){
                dto=new qnaDTO();
                dto.setQ_code(rs.getInt("q_code"));
                dto.setQ_no(rs.getInt("q_no"));
                dto.setQ_id(rs.getString("q_id"));
                dto.setQ_subject(rs.getString("q_subject"));
                dto.setQ_content(rs.getString("q_content"));
                dto.setQ_group(rs.getInt("q_group"));
                dto.setQ_date(rs.getString("q_date"));
            }else{
                dto=null;
            }//if end
            
        }catch(Exception e){
            System.out.println("수정상세보기실패:"+e);
        }//try end
        return dto;
    }//upread() end
    
    public qnaDTO reread(int q_no){
        qnaDTO dto=null;
        try{
            Connection con=DBOpen.getConnection();
            StringBuilder sql=new StringBuilder();
            sql.append(" SELECT q_code, q_no, q_id, q_subject, q_content, q_group, q_date");
            sql.append(" FROM qna ");
            sql.append(" WHERE q_no=? ");
            
            PreparedStatement pstmt=con.prepareStatement(sql.toString());
            pstmt.setInt(1, q_no);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next()){
                dto=new qnaDTO();
                dto.setQ_code(rs.getInt("q_code"));
                dto.setQ_no(rs.getInt("q_no"));
                dto.setQ_id(rs.getString("q_id"));
                dto.setQ_subject(rs.getString("q_subject"));
                dto.setQ_content(rs.getString("q_content"));
                dto.setQ_group(rs.getInt("q_group"));
                dto.setQ_date(rs.getString("q_date"));
            }else{
                dto=null;
            }//if end
            
        }catch(Exception e){
            System.out.println("답변 대상 조회 실패:"+e);
        }//try end
        return dto;
    }//upread() end
	
    public int updo(qnaDTO dto){
    	int cnt=0;
    	try {    
    	  Connection con=DBOpen.getConnection();
    	  StringBuilder sql=new StringBuilder();
    	  sql.append(" UPDATE qna ");
    	  sql.append(" SET q_id=? ");
    	  sql.append(" ,q_subject=? ");
    	  sql.append(" ,q_content=? ");
    	  sql.append(" ,q_date=now() ");
    	  sql.append(" WHERE q_no=? ");
    	  PreparedStatement pstmt=con.prepareStatement(sql.toString());
    	  pstmt.setString(1, dto.getQ_id());
    	  pstmt.setString(2, dto.getQ_subject());
    	  pstmt.setString(3, dto.getQ_content());
    	  pstmt.setInt(4, dto.getQ_no());
    	  cnt=pstmt.executeUpdate();

    	}catch(Exception e) {
    	  System.out.println("수정 실패 : " + e);
    	}//try end    
    	return cnt;
        }//updateProc() end  

	public int delete(int q_no) {
		int cnt = 0; // retrun = int(cnt)
		try {
			Connection con = DBOpen.getConnection(); // 서버연결(필수)
			StringBuilder sql = new StringBuilder(); // sql작업준비
			sql.append(" DELETE	FROM qna ");
			sql.append(" WHERE q_no=? "); 
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, q_no);
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("삭제 실패:" + e);
		} // try end
		return cnt;
	}// delete() end
	

	public int reply(qnaDTO dto) {
		int cnt = 0;
		try {
			Connection con = DBOpen.getConnection();
			StringBuilder sql = new StringBuilder();
			//이 단문에 왔을때 반드시 DTO에 q_subject, q_con, q_id가 존재해야함.

			// 1)부모글정보 가져오기(select문)
			// 부모글을 불러오는 과정 (그룹번호,들여쓰기)
			int q_group = 0, q_indent = 0;
			sql.append(" SELECT q_group, q_indent");
			sql.append(" FROM	qna ");
			sql.append(" WHERE q_no=? ");
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, dto.getQ_no());
			ResultSet rs = pstmt.executeQuery(); //결과를 rs에 저장
			if (rs.next()) {
				q_group = rs.getInt("q_group"); //부모글의 그룹번호
				q_indent = rs.getInt("q_indent"); //부모글의 들여쓰기
			} // if end

			// 2)글순서 재조정하기(update문)
			// 댓글의 수가 많아지면 원문이 댓글보다 뒤에 달릴 가능성이 있으니 혼란을 방지하기 위해 순서를 재구성한다.
			
			/*
			sql.delete(0, sql.length()); //sql 변수 초기화
			sql.append(" UPDATE qna ");
			sql.append(" SET ansnum=ansnum+1 ");
			sql.append(" WHERE grpno=? AND ansnum>?");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, q_group);
			pstmt.setInt(2, q_no);
			pstmt.executeUpdate();
			*/
			
			// 3)답변글 추가하기(insert문)
			// 정리가 완료되면 해당하는곳에 작성한 댓글을 입력만 하면 완성.
			sql.delete(0, sql.length());
			sql.append(" INSERT INTO qna(q_code, q_no, q_subject, q_content, q_id, q_date, q_group, q_indent) ");
			sql.append(" VALUES (");
			sql.append("          2 ");
			sql.append("         , (SELECT ifnull(MAX(q_no), 0)+1 FROM qna ALIAS_FOR_SUBQUERY)");
			sql.append("         ,?,?,? ");
			sql.append("         ,now()");
			sql.append("         ,?, ?");
			sql.append("        )  ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getQ_subject());
			pstmt.setString(2, dto.getQ_content());
			pstmt.setString(3, dto.getQ_id());
			pstmt.setInt(4, q_group);
			pstmt.setInt(5, q_indent+1);
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("답변 실패	: " + e);
		} // try end
		return cnt;

	}// reply() end
	
	
}
