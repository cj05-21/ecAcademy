package kr.co.academy.mypage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBPKG.DBOpen;

public class MyPageDAO {
	
	public MypageDTO select(String m_id) {
		MypageDTO dto= new MypageDTO();
		try {  
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append(" select m_pw, m_email, m_phone, m_job, ref_acount, ref_name"); 
			sql.append(" from mem_inform");
			sql.append(" WHERE m_id=? ");
        
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			
			pstmt.setString(1, m_id);

			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				dto.setM_pw(rs.getString("m_pw"));
				dto.setM_email(rs.getString("m_email"));
				dto.setM_phone(rs.getString("m_phone"));
				dto.setM_job(rs.getString("m_job"));
				dto.setRef_acount(rs.getString("ref_acount"));
				dto.setRef_name(rs.getString("ref_name"));
//				dto.setRef_acount(rs.getString("ref_acount"));
//				dto.setRef_name(rs.getString("ref_name"));
			}else{
				
			}//if 

		}catch(Exception e) {
			System.out.println("마이페이지 회원정보 불러오기 실패,, : " + e);
		}//try end    
      return dto;
		
	}//select() end
	
	
	public int m_pw_update(String m_id, String m_pw) {
		int cnt=0;
		try {  
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append(" UPDATE mem_inform "); 
			sql.append(" SET m_pw=? ");
			sql.append(" WHERE m_id=? ");
        
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			
			pstmt.setString(1, m_pw);
			pstmt.setString(2, m_id);
			cnt=pstmt.executeUpdate();

		}catch(Exception e) {
			System.out.println("수정 실패 : " + e);
		}//try end    
      return cnt;
	}//m_pw_update end
	
	public int mem_update(MypageDTO dto){
		int cnt=0;
		 try {    
	          Connection con=DBOpen.getConnection();
	          StringBuilder sql=new StringBuilder();
	          sql.append(" UPDATE mem_inform "); 
	          sql.append(" SET m_name=? ");
	          sql.append(" ,m_email=? ");
	          sql.append(" ,m_phone=? ");
	          sql.append(" ,m_job=? ");
	          sql.append(" ,ref_acount=? ");
	          sql.append(" ,ref_name=? ");
	          sql.append(" WHERE m_id=? ");
	          
	          PreparedStatement pstmt=con.prepareStatement(sql.toString());
	          pstmt.setString(1, dto.getM_name());
	          pstmt.setString(2, dto.getM_email());
	          pstmt.setString(3, dto.getM_phone());
	          pstmt.setString(4, dto.getM_job());
	          pstmt.setString(5, dto.getRef_acount());
	          pstmt.setString(6, dto.getRef_name());
	          pstmt.setString(7,dto.getM_id());
	          cnt=pstmt.executeUpdate();

	        }catch(Exception e) {
	          System.out.println("회원정보 수정 실패, , , : " + e);
	        }//try end    
	        return cnt;
	}//updateProc() end
	
	public int mem_delete(String m_id, String m_pw){
		int cnt=0;
		try{
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append(" update mem_inform ");
			sql.append(" set m_level='X' ");
			sql.append(" where m_id=? and m_pw=? ");
			PreparedStatement pstmt= con.prepareStatement(sql.toString());
			pstmt.setString(1,m_id );
			pstmt.setString(2,m_pw);
			
			cnt=pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println("탈퇴 실패 ~!");
		}//try end
		
		return cnt;
	}//memberDelete() end
	
	}//class end

