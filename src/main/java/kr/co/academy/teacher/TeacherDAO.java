package kr.co.academy.teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBPKG.DBOpen;
import oracle.jdbc.proxy.annotation.Pre;

public class TeacherDAO {
	public int insert(TeacherDTO dto) {
		int cnt=0;
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			
			sql.append(" INSERT INTO teacher (tc_no, m_level, tc_name, m_id, poster, w_code) ");
			sql.append(" VALUES ((SELECT IFNULL(MAX(tc_no), 0)+1 as tc_no FROM teacher ALIAS_FOR_SUBQUERY), 'B',?,?,?,?) ");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());

			pstmt.setString(1, dto.getTc_name());
			pstmt.setString(2, dto.getM_id());
			pstmt.setString(3, dto.getPoster());			
			pstmt.setInt(4, dto.getW_code());
			
			cnt=pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("행 추가 실패 : "+e);
		}//try end
		return cnt;
	}//insert() end 

	public int duplecateID(String m_id) {
		int cnt=0;
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			
			sql.append(" SELECT count(m_id) as cnt ");
			sql.append(" FROM teacher ");
			sql.append(" WHERE m_id=? ");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, m_id);
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				cnt=rs.getInt("cnt");
			}
		}catch(Exception e) {
			System.out.println("강사이름 중복확인 실패 : "+e);
		}//try end
		return cnt;
	}//duplecateID end
	
	public int duplecateName(String tc_name) {
		int cnt=0;
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			
			sql.append(" SELECT count(tc_name) as cnt ");
			sql.append(" FROM teacher ");
			sql.append(" WHERE tc_name=? ");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, tc_name);
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				cnt=rs.getInt("cnt");
			}
		}catch(Exception e) {
			System.out.println("강사이름 중복확인 실패 : "+e);
		}//try end
		return cnt;
	}//duplecateID end
	
	public ArrayList<TeacherDTO> list1(){
		ArrayList<TeacherDTO> list = null;
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
		
			sql.append(" SELECT F.tc_no, F.c_code, F.tc_name, F.c_prod ");
			sql.append(" FROM (SELECT T.tc_no AS tc_no, C.c_code AS c_code, T.tc_name AS tc_name, C.c_prod AS c_prod ");
			sql.append(" 	   FROM teacher AS T join class AS C ");
			sql.append(" 	   ON T.w_code=C.w_code)as F ");
			sql.append(" WHERE F.c_code='TOEIC' ");
			sql.append(" ORDER BY tc_name ");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<TeacherDTO>();
				do {
				TeacherDTO dto=new TeacherDTO();
				dto.setTc_no(rs.getInt("tc_no"));
				dto.setC_code(rs.getString("c_code"));
				dto.setTc_name(rs.getString("tc_name"));
				dto.setC_prod(rs.getString("c_prod"));
				list.add(dto);
			}while(rs.next());
		}else {
			list=null;
		}//if end	
		}catch(Exception e) {
			System.out.println("목록 가져오기 실패 : "+e);
		}
		return list;
	}//list1 end
	
	public ArrayList<TeacherDTO> list2(){
		ArrayList<TeacherDTO> list = null;
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			
			sql.append(" SELECT F.tc_no, F.c_code, F.tc_name, F.c_prod ");
			sql.append(" FROM (SELECT T.tc_no AS tc_no, C.c_code AS c_code, T.tc_name AS tc_name, C.c_prod AS c_prod ");
			sql.append(" 	   FROM teacher AS T join class AS C ");
			sql.append(" 	   ON T.w_code=C.w_code)as F ");
			sql.append(" WHERE F.c_code='TOEFL' ");
			sql.append(" ORDER BY tc_name ");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<TeacherDTO>();
				do {
				TeacherDTO dto=new TeacherDTO();
				dto.setTc_no(rs.getInt("tc_no"));
				dto.setC_code(rs.getString("c_code"));
				dto.setTc_name(rs.getString("tc_name"));
				dto.setC_prod(rs.getString("c_prod"));
				list.add(dto);
			}while(rs.next());
		}else {
			list=null;
		}//if end	
		}catch(Exception e) {
			System.out.println("목록 가져오기 실패 : "+e);
		}
		return list;
	}//list2 end
	
	public ArrayList<TeacherDTO> list3(){
		ArrayList<TeacherDTO> list = null;
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			
			sql.append(" SELECT F.tc_no, F.c_code, F.tc_name, F.c_prod ");
			sql.append(" FROM (SELECT T.tc_no AS tc_no, C.c_code AS c_code, T.tc_name AS tc_name, C.c_prod AS c_prod ");
			sql.append(" 	   FROM teacher AS T join class AS C ");
			sql.append(" 		ON T.w_code=C.w_code)as F ");
			sql.append(" 		WHERE F.c_code='TEPS' ");
			sql.append(" ORDER BY tc_name ");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<TeacherDTO>();
				do {
				TeacherDTO dto=new TeacherDTO();
				dto.setTc_no(rs.getInt("tc_no"));
				dto.setC_code(rs.getString("c_code"));
				dto.setTc_name(rs.getString("tc_name"));
				dto.setC_prod(rs.getString("c_prod"));
				list.add(dto);
			}while(rs.next());
		}else {
			list=null;
		}//if end	
		}catch(Exception e) {
			System.out.println("목록 가져오기 실패 : "+e);
		}
		return list;
	}//list3 end
	
	public ArrayList<TeacherDTO> list4(){
		ArrayList<TeacherDTO> list = null;
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			
			sql.append(" SELECT F.tc_no, F.c_code, F.tc_name, F.c_prod ");
			sql.append(" FROM (SELECT T.tc_no AS tc_no, C.c_code AS c_code, T.tc_name AS tc_name, C.c_prod AS c_prod ");
			sql.append(" 	   FROM teacher AS T join class AS C ");
			sql.append(" ON T.w_code=C.w_code)as F ");
			sql.append(" WHERE F.c_code='OPIC' ");
			sql.append(" ORDER BY tc_name ");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<TeacherDTO>();
				do {
				TeacherDTO dto=new TeacherDTO();
				dto.setTc_no(rs.getInt("tc_no"));
				dto.setC_code(rs.getString("c_code"));
				dto.setTc_name(rs.getString("tc_name"));
				dto.setC_prod(rs.getString("c_prod"));
				list.add(dto);
			}while(rs.next());
		}else {
			list=null;
		}//if end	
		}catch(Exception e) {
			System.out.println("목록 가져오기 실패 : "+e);
		}
		return list;
	}//list4 end
	
	public int delete(int tc_no) {
		int cnt=0;
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			
			sql.append(" DELETE FROM teacher ");
			sql.append(" WHERE tc_no=? ");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, tc_no);
			
			cnt=pstmt.executeUpdate();
					
		}catch(Exception e) {
			System.out.println("삭제 실패 : "+e);
		}//try end
		return cnt;
	}//delete() end
	
	public TeacherDTO read(int tc_no) {
		TeacherDTO dto=null;
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
				
			sql.append(" SELECT F.tc_no, F.poster, F.m_id, F.tc_name, F.c_code, F.c_prod, F.m_email ");
			sql.append(" FROM (SELECT TT.tc_no AS tc_no, TT.m_id AS m_id, TT.poster AS poster, TT.tc_name AS tc_name, C.c_code AS c_code, C.c_prod AS c_prod, TT.m_email AS m_email ");
			sql.append(" 	   FROM (SELECT T.tc_no, T.m_id, T.poster, T.tc_name, T.w_code, M.m_email ");
			sql.append(" 			 FROM teacher AS T join mem_inform AS M ");
			sql.append(" 			 ON T.m_id=M.m_id) AS TT join class AS C ");
			sql.append(" 			 ON TT.w_code=C.w_code)as F ");
			sql.append(" WHERE F.tc_no=? ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, tc_no);
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				dto=new TeacherDTO();
				dto.setTc_no(rs.getInt("tc_no"));
				dto.setPoster(rs.getString("poster"));
				dto.setM_id(rs.getString("m_id"));
				dto.setTc_name(rs.getString("tc_name"));
				dto.setC_code(rs.getString("c_code"));
				dto.setC_prod(rs.getString("c_prod"));
				dto.setM_email(rs.getString("m_email"));
				
			}else {
				dto=null;
			}			
			
		}catch(Exception e) {
			System.out.println("읽어오기 실패 : "+e);
		}//try end
		return dto;
	}//read() end
	
	public int update(TeacherDTO dto) {
		int cnt=0;
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			
			//수정 시, where의 hidden 넘겨주는 것 잊지말기!!!!
			sql.append(" UPDATE	teacher ");
			sql.append(" SET tc_name=?, poster=?, w_code=? ");
			sql.append(" WHERE tc_no=? ");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getTc_name());
			pstmt.setString(2, dto.getPoster());
			pstmt.setInt(3, dto.getW_code());
			pstmt.setInt(4, dto.getTc_no());
			
			cnt=pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("수정 실패 : "+e);
		}
		return cnt;
	}//update() end
	
	
	
	public ArrayList<TeacherDTO> li() {
		ArrayList<TeacherDTO>list=null;
		TeacherDTO dto=new TeacherDTO();
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append(" SELECT w_code,c_prod ");
			sql.append(" FROM class ");
			sql.append(" ORDER BY w_code ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<TeacherDTO>();
				do {
					dto=new TeacherDTO();
					//위에서 객체생성을 해줬더라도, 아래에서 데이터를 새롭게 넣어줄때는 객체생성을 해 줘야 한다
					dto.setW_code(rs.getInt("w_code"));
					dto.setC_prod(rs.getString("c_prod"));
					list.add(dto);
				}while(rs.next());
			}
			
		}catch(Exception e) {System.out.println("실패"+e);}
		return list;
	}
}//class end
 