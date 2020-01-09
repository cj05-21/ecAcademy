package kr.co.academy.review;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBPKG.DBOpen;
import kr.co.academy.notice.NoticeDTO;
import net.utility.Utility;

public class ReviewDAO {
	public int insert(ReviewDTO dto) {
		int cnt=0;
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql= new StringBuilder();
			sql.append(" insert into review (score,r_no,r_subject,r_content,m_id,poster,r_date,c_code) ");
			sql.append(" values (?,(select ifnull(max(r_no),0)+1 from review ALIAS_FOR_SUBQUERY) ,?,?,?,?,now(),?) ");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, dto.getScore());
			pstmt.setString(2, dto.getR_subject());
			pstmt.setString(3, dto.getR_content());
			pstmt.setString(4, dto.getM_id());
			pstmt.setString(5, dto.getPoster());
			pstmt.setString(6, dto.getC_code());
			cnt=pstmt.executeUpdate();
		}catch(Exception e) {System.out.println("게시물 등록 실패"+e);}
		return cnt;
	}//insert() end
/*	
	public ArrayList<ReviewDTO> list(){
		ArrayList<ReviewDTO> list=null;
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append(" select r_no,r_subject,r_content,m_id,poster,r_date,r_readcnt,score,c_code");
			sql.append(" from review  ");
			sql.append(" order by r_no desc  ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<ReviewDTO>();
				do {
				ReviewDTO dto=new ReviewDTO();
				dto.setR_no(rs.getInt("r_no"));
				dto.setR_subject(rs.getString("r_subject"));
				dto.setR_content(rs.getString("r_content"));
				dto.setM_id(rs.getString("m_id"));
				dto.setPoster(rs.getString("poster"));
				dto.setR_date(rs.getString("r_date"));
				dto.setR_readcnt(rs.getInt("r_readcnt"));
				dto.setScore(rs.getInt("score"));
				dto.setC_code(rs.getString("c_code"));
				list.add(dto);
				}while(rs.next());
			}
		}catch(Exception e) {System.out.println("목록 불러오기 실패");}
		return list;
	}//list() end
*/	
	//페이징+검색 list------------------------------------------------------------------------------------------
			public ArrayList<ReviewDTO> list(String col, String word, int nowPage, int recordPerPage){
		        ArrayList<ReviewDTO> list=null;
		        
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
		          word = word.toUpperCase();
		          
		          if(word.length()==0) { //검색을 하지 않는 경우
		            sql.append(" select r_no,r_subject,r_content,m_id,poster,r_date,r_readcnt,score,c_code");
		            sql.append("       from review  ");
		            sql.append("       order by r_no desc ");	            
		            sql.append(" limit " + startRow + "," + recordPerPage) ;
		          } else {
		            //검색을 하는 경우
			          sql.append(" select r_no,r_subject,r_content,m_id,poster,r_date,r_readcnt,score,c_code");
			          sql.append("      from review  ");
		            
		            String search="";
		            if(col.equals("r_subject")) { //제목
		              search += " WHERE r_subject LIKE '%" + word + "%'";
		            } else if(col.equals("r_content")) { //내용
		              search += " WHERE r_content LIKE '%" + word + "%'";
		            } else if(col.equals("m_id")) { //작성자
		              search += " WHERE m_id LIKE '%" + word + "%'";
		            } else if(col.equals("c_code")) { //코드	            	
		            	search += " WHERE c_code LIKE '%" + word + "%'";
			        } else if(col.equals("sub_cont")) { //제목, 내용
		              search += " WHERE r_subject LIKE '%" + word + "%'";
		              search += " OR r_content LIKE '%" + word + "%'";
		            }//if end
		            
		            sql.append(search);        
		            
		            sql.append("      order by r_no desc ");	 
		            sql.append(" limit " + startRow + "," + recordPerPage) ;
		          }//if end
		          
		          PreparedStatement pstmt=con.prepareStatement(sql.toString());
		          ResultSet rs=pstmt.executeQuery();
		          if(rs.next()){
		            list=new ArrayList<ReviewDTO>();
		            do{
		              ReviewDTO dto=new ReviewDTO();	              
		              dto.setR_no(rs.getInt("r_no"));
		              dto.setR_subject(rs.getString("r_subject"));
		              dto.setR_content(rs.getString("r_content"));
		              dto.setM_id(rs.getString("m_id"));
		              dto.setPoster(rs.getString("poster"));
		              dto.setR_date(rs.getString("r_date"));
		              dto.setR_readcnt(rs.getInt("r_readcnt"));
		              dto.setScore(rs.getInt("score"));
		              dto.setC_code(rs.getString("c_code"));
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
		            sql.append(" FROM review ");	            
					
					//검색을 했을 때 나타는 리스트에서 복사
					if(word.trim().length()>=1){ //검색어가 존재한다 라는 의미 = where 조건절로서 선택할 것을 찾아주기
						String search="";
			            if(col.equals("r_subject")) { //제목
			              search += " WHERE r_subject LIKE '%" + word + "%'";
			            } else if(col.equals("r_content")) { //내용
			              search += " WHERE r_content LIKE '%" + word + "%'";
			            } else if(col.equals("m_id")) { //작성자
			              search += " WHERE m_id LIKE '%" + word + "%'";
			            } else if(col.equals("c_code")) { //작성자
				              search += " WHERE c_code LIKE '%" + word + "%'";
				        } else if(col.equals("sub_cont")) { //제목, 내용
			              search += " WHERE r_subject LIKE '%" + word + "%'";
			              search += " OR r_content LIKE '%" + word + "%'";
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
	
	public ReviewDTO read(int r_no) {
		ReviewDTO dto=null;
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append(" select r_no,r_subject,r_content,m_id,r_date,r_readcnt,score,c_code,poster ");
			sql.append(" from review ");
			sql.append(" where r_no=? ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, r_no);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				dto=new ReviewDTO();
				dto.setR_no(rs.getInt("r_no"));
				dto.setR_subject(rs.getString("r_subject"));
				dto.setR_content(rs.getString("r_content"));
				dto.setM_id(rs.getString("m_id"));
				dto.setR_date(rs.getString("r_date"));
				dto.setR_readcnt(rs.getInt("r_readcnt"));
				dto.setScore(rs.getInt("score"));
				dto.setC_code(rs.getString("c_code"));
				dto.setPoster(rs.getString("poster"));
			}
		}catch(Exception e) {System.out.println("정보 불러오기 실패!!"+e);}
		return dto;
	}//read() end
	
	public void incrementCnt(int r_no){
		try{
			Connection con=DBOpen.getConnection();
			StringBuilder sql =new StringBuilder();
			sql.append(" UPDATE review SET ");
			sql.append(" r_readcnt=r_readcnt+1 ");
			sql.append(" WHERE r_no=? ");
			PreparedStatement pstmt= con.prepareStatement(sql.toString());
			pstmt.setInt(1,r_no);
			pstmt.executeUpdate();	
		}catch(Exception e){System.out.println("조회수 증가 실패"+e);}
			
		}//incrementCnt() end
	
	public int update(ReviewDTO dto) {
		int cnt=0;
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql= new StringBuilder();
			sql.append(" update review set score=?,r_subject=?,m_id=?,poster=?,r_content=?,c_code=? ");
			sql.append(" where r_no=?	");	
				
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, dto.getScore());
			pstmt.setString(2, dto.getR_subject());
			pstmt.setString(3, dto.getM_id());
			pstmt.setString(4, dto.getPoster());
			pstmt.setString(5, dto.getR_content());
			pstmt.setString(6, dto.getC_code());
			pstmt.setInt(7, dto.getR_no());
			cnt=pstmt.executeUpdate();
		}catch(Exception e) {System.out.println("수정 실패"+e);}
		return cnt;
	}//update() end
	
	public int delete(ReviewDTO dto,String basePath) {
		int cnt=0;
		try {
			//삭제하고자 하는 파일명을 가져온다
			String filename="";
			ReviewDTO oldDTO=read(dto.getR_no());
			if(oldDTO!=null){
				filename=oldDTO.getPoster();
			}
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append(" delete from review where r_no=? ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, dto.getR_no());
			cnt=pstmt.executeUpdate();
			if(cnt==1){	//테이블에서 행삭제가 성공했으므로
				//첨부된 파일도 삭제해줘야함
			Utility.deleteFile(basePath,filename);
			}//if end
		}catch(Exception e) {System.out.println("삭제 실패"+e);}
		return cnt;
	}//delete() end
	
	public int duplecateID(String m_id){
		int cnt=0;
		try{
			Connection con=DBOpen.getConnection();
			StringBuilder sql= new StringBuilder();
			sql.append(" select count(m_id) as cnt ");
			sql.append(" from mem_inform ");
			sql.append(" where m_id=? ");
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, m_id);
			ResultSet rs= pstmt.executeQuery();
			if(rs.next()){
				cnt=rs.getInt("cnt");
			}
		}catch(Exception e){System.out.println("아이디 중복 확인 실패"+e);}
		return cnt;
	}
	
	public ReviewDTO ID(int r_no){
		ReviewDTO dto=null;
		try{
			Connection con=DBOpen.getConnection();
			StringBuilder sql= new StringBuilder();
			sql.append(" select m_id ");
			sql.append(" from review ");
			sql.append(" where r_no=? ");
			PreparedStatement pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, r_no);
			ResultSet rs= pstmt.executeQuery();
			if(rs.next()){
				dto=new ReviewDTO();
				dto.setM_id(rs.getString("m_id"));;
			}
		}catch(Exception e){System.out.println("아이디 중복 확인 실패"+e);}
		return dto;
	}
}
