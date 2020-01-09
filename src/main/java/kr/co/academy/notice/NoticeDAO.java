package kr.co.academy.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.print.attribute.standard.PresentationDirection;

import DBPKG.DBOpen;
import kr.co.academy.classes.ClassDTO;

public class NoticeDAO {
	public int insert(String inform,String subject,String content, String id) {
		int cnt=0;
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql= new StringBuilder();
			sql.append(" insert into notice (inform,n_no, n_subject, n_content, m_id, n_date) ");
			sql.append(" values (?,(SELECT IFNULL(MAX(n_no), 0)+1 FROM notice ALIAS_FOR_SUBQUERY) ,?,?,?,now()) ");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, inform);
			pstmt.setString(2, subject);
			pstmt.setString(3, id);
			pstmt.setString(4, content);
			cnt=pstmt.executeUpdate();
		}catch(Exception e) {System.out.println("게시물 등록 실패"+e);}
		return cnt;
	}//insert() end
	

//페이징+검색 list------------------------------------------------------------------------------------------
		public ArrayList<NoticeDTO> list(String col, String word, int nowPage, int recordPerPage){
	        ArrayList<NoticeDTO> list=null;
	        
	        // 페이지당 출력할 레코드 갯수 (10개를 기준)
	        // 1 page : WHERE r>=1 AND r<=10
	        // 2 page : WHERE r>=11 AND r<=20
	        // 3 page : WHERE r>=21 AND r<=30
	        int startRow = ((nowPage-1) * recordPerPage);
	        int endRow   = nowPage * recordPerPage;
	        
	        try{
	            Connection con=DBOpen.getConnection();
	            StringBuilder sql=new StringBuilder();
	          
	          word = word.trim(); //검색어의 좌우 공백 제거
	          
	          if(word.length()==0) { //검색을 하지 않는 경우
	            sql.append(" select inform,n_no,n_subject,n_content,m_id,n_date,n_readcnt ");
	            sql.append("       FROM notice ");
	            sql.append("      order by n_no desc ");
	            sql.append(" limit " + startRow + "," + recordPerPage) ;
	          } else {
	            //검색을 하는 경우
		          sql.append(" select inform,n_no,n_subject,n_content,m_id,n_date,n_readcnt");
		          sql.append("       FROM notice ");
	            
		          String search="";
		            if(col.equals("n_subject")) { //제목
		              search += " WHERE n_subject LIKE '%" + word + "%'";
		            } else if(col.equals("n_content")) { //내용
		              search += " WHERE n_content LIKE '%" + word + "%'";
		            } else if(col.equals("inform")) { //내용
			              search += " WHERE inform LIKE '%" + word + "%'";
		            }else if(col.equals("subject_content")) { //제목, 내용
		              search += " WHERE n_subject LIKE '%" + word + "%'";
		              search += " OR n_content LIKE '%" + word + "%'";
		            }//if end
	            
	            sql.append(search);        
	            
	            sql.append("      order by n_no desc ");
	            sql.append(" limit " + startRow + "," + recordPerPage) ;
	          }//if end
	          
	          PreparedStatement pstmt=con.prepareStatement(sql.toString());
	          ResultSet rs=pstmt.executeQuery();
	          if(rs.next()){
	            list=new ArrayList<NoticeDTO>();
	            do{
	            	NoticeDTO dto=new NoticeDTO();
	              dto.setInform(rs.getString("inform"));
	              dto.setN_no(rs.getInt("n_no"));
	              dto.setN_subject(rs.getString("n_subject"));
	              dto.setN_content(rs.getString("n_content"));
	              dto.setM_id(rs.getString("m_id"));
	              dto.setN_date(rs.getString("n_date"));
	              dto.setN_readcnt(rs.getInt("n_readcnt"));
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
				sql.append(" from notice ");
				//검색을 했을 때 나타는 리스트에서 복사
				if(word.trim().length()>=1){ //검색어가 존재한다 라는 의미 = where 조건절로서 선택할 것을 찾아주기
					String search="";
		            if(col.equals("n_subject")) { //제목
		              search += " WHERE n_subject LIKE '%" + word + "%'";
		            } else if(col.equals("n_content")) { //내용
		              search += " WHERE n_content LIKE '%" + word + "%'";
		            } else if(col.equals("inform")) { //내용
			              search += " WHERE inform LIKE '%" + word + "%'";
		            }else if(col.equals("subject_content")) { //제목, 내용
		              search += " WHERE n_subject LIKE '%" + word + "%'";
		              search += " OR n_content LIKE '%" + word + "%'";
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
	
	/*
	 * public ArrayList<NoticeDTO> list(){ ArrayList<NoticeDTO> list=null; try {
	 * Connection con=DBOpen.getConnection(); StringBuilder sql=new StringBuilder();
	 * sql.append(" select inform,n_no,n_subject,n_content,m_id,n_date,n_readcnt ");
	 * sql.append(" from notice  "); sql.append(" order by n_no desc  ");
	 * PreparedStatement pstmt=con.prepareStatement(sql.toString()); ResultSet
	 * rs=pstmt.executeQuery();
	 * 
	 * if(rs.next()) { list=new ArrayList<NoticeDTO>(); do { NoticeDTO dto=new
	 * NoticeDTO(); dto.setInform(rs.getString("inform"));
	 * dto.setN_no(rs.getInt("n_no")); dto.setN_subject(rs.getString("n_subject"));
	 * dto.setN_content(rs.getString("n_content"));
	 * dto.setM_id(rs.getString("m_id")); dto.setN_date(rs.getString("n_date"));
	 * dto.setN_readcnt(rs.getInt("n_readcnt")); list.add(dto); }while(rs.next()); }
	 * }catch(Exception e) {System.out.println("목록 불러오기 실패");} return list;
	 * }//list() end
	 */		
	
	public NoticeDTO read(int n_no) {
		NoticeDTO dto=null;
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append(" select inform,n_no,n_subject,n_content,m_id,n_date,n_readcnt ");
			sql.append(" from notice ");
			sql.append(" where n_no=? ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, n_no);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				do {
					dto=new NoticeDTO();
					dto.setInform(rs.getString("inform"));
					dto.setN_no(rs.getInt("n_no"));
					dto.setN_subject(rs.getString("n_subject"));
					dto.setN_content(rs.getString("n_content"));
					dto.setM_id(rs.getString("m_id"));
					dto.setN_date(rs.getString("n_date"));
					dto.setN_readcnt(rs.getInt("n_readcnt"));
				}while(rs.next());
			}
		}catch(Exception e) {System.out.println("불러오기 실패"+e);}
		return dto;
	}//read() end
	
	public int update(int n_no,String inform,String n_subject,String m_id,String n_content) {
		int cnt=0;
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append(" update notice set inform=?,n_subject=?,m_id=?,n_content=? ");
			sql.append(" where n_no=? ");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,inform);
			pstmt.setString(2,n_subject );
			pstmt.setString(3,m_id );
			pstmt.setString(4,n_content );
			pstmt.setInt(5,n_no );
			cnt=pstmt.executeUpdate();
			
		}catch(Exception e) {System.out.println("수정 실패"+e);}
		return cnt;
	}//update() end
	
	public int delete(NoticeDTO dto) {
		int cnt=0;
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append(" delete from notice where n_no=? ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, dto.getN_no());
			cnt=pstmt.executeUpdate();
		}catch(Exception e) {System.out.println("삭제 실패"+e);}
		return cnt;
	}//delete() end
	
	public void incrementCnt(int n_no){
		try{
			Connection con=DBOpen.getConnection();
			StringBuilder sql =new StringBuilder();
			sql.append(" UPDATE notice SET ");
			sql.append(" n_readcnt=n_readcnt+1 ");
			sql.append(" WHERE n_no=? ");
			PreparedStatement pstmt= con.prepareStatement(sql.toString());
			pstmt.setInt(1,n_no);
			pstmt.executeUpdate();	
		}catch(Exception e){System.out.println("조회수 증가 실패"+e);}
			
		}//incrementCnt() end
}
