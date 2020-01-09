package kr.co.academy.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBPKG.DBOpen;

public class memberDAO {
	
	//회원정보 insert
	public int insert(memberDTO dto){
		int cnt=0;
		try{
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("  insert into mem_inform(m_level, m_id, m_pw, m_name, m_job, m_email, email_agree, m_phone, phone_agree)");
			sql.append("  values('C',?,?,?,?,?,?,?,?)  ");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getM_id().trim());
			pstmt.setString(2,dto.getM_pw().trim());
			pstmt.setString(3, dto.getM_name().trim());
			pstmt.setString(4,dto.getM_job().trim());
			pstmt.setString(5,dto.getM_email().trim());
			pstmt.setString(6,dto.getEmail_agree().trim());
			pstmt.setString(7,dto.getM_phone().trim());
			pstmt.setString(8,dto.getPhone_agree().trim());
			
			cnt=pstmt.executeUpdate();
			
		}catch(Exception e){
			System.out.println("행추가 실패ㅜ"+e);
		}//try end
		return cnt;
	}//insert() end
	
	//id 중복확인
	public int duplecateId(String m_id){
		int cnt=0;
		try{
			Connection con=DBOpen.getConnection();
			StringBuilder sql= new StringBuilder();
			sql.append(" select count(m_id) as cnt ");
			sql.append(" from mem_inform ");
			sql.append(" where m_id=? ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1,m_id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				cnt=rs.getInt("cnt");
			}
			
		}catch(Exception e){
			System.out.println("아이디 중복 확인 실패~!");
		}
		return cnt;
	}//duplecateId() end
	
	public memberDTO read(String m_id, String m_pw) {
		memberDTO dto=null;
		try{
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new  StringBuilder();
			sql.append(" select m_level ");
			sql.append(" from mem_inform ");
			sql.append(" where m_id=? and m_pw=? ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, m_id);
			pstmt.setString(2, m_pw);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				dto=new memberDTO();
				dto.setM_level(rs.getString("m_level"));
			}
		}catch(Exception e){System.out.println("불러오기 실패"+e);}
		return dto;
	}
	
	//로그인(아이디,비밀번호)
	public int login(String m_id, String m_pw) {
		int res=0;
		try{
			Connection con=DBOpen.getConnection();
			StringBuilder sql= new StringBuilder();
			sql.append(" select count(m_id) as cnt ");
			sql.append(" from mem_inform ");
			sql.append(" where m_id=? and m_pw=? and (m_level='A' or m_level='B' or m_level='C')");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, m_id);
			pstmt.setString(2,m_pw);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()==true){
				res=rs.getInt("cnt");
			}//if end
		}catch(Exception e){
			System.out.println("로그인 실패"+e);
		}//try end
		
		return res;
	}//login() end
	
	
	public memberDTO sessName(String m_id) {
		memberDTO dto= new memberDTO();
		try{
			Connection con=DBOpen.getConnection();
			StringBuilder sql= new StringBuilder();
			sql.append(" select m_name, m_level  ");
			sql.append(" from mem_inform ");
			sql.append(" where m_id=? ");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, m_id);
			
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setM_name(rs.getString("m_name"));
				dto.setM_level(rs.getString("m_level"));
			}//if end

		}catch(Exception e){
			System.out.println("로그인 실패"+e);
		}//try end
		
		return dto;
	}//sessName() end
	
	
	public memberDTO findId(String m_name, String m_email) {
		memberDTO dto= new memberDTO();
		try{
			Connection con=DBOpen.getConnection();
			StringBuilder sql= new StringBuilder();
			sql.append(" select m_id  ");
			sql.append(" from mem_inform ");
			sql.append(" where m_name=? and m_email=?");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, m_name);
			pstmt.setString(2, m_email);
			
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setM_id(rs.getString("m_id"));
			}else {
				dto=null;
			}

		}catch(Exception e){
			System.out.println("아이디 찾아오기"+e);
		}//try end
		
		return dto;
	}//findId() end
	/*
	public memberDTO findAccount(String m_email) {
		
		memberDTO dto= new memberDTO();
		try{
			Connection con=DBOpen.getConnection();
			StringBuilder sql= new StringBuilder();
			sql.append(" select m_id  ");
			sql.append(" from mem_inform ");
			sql.append(" where m_email=?");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, m_email);
			
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setM_id(rs.getString("m_id"));
			}//if end

		}catch(Exception e){
			System.out.println("비번찾기 이메일 실패"+e);
		}//try end
		
		return dto;
	}//findAccount() end
	*/
	public memberDTO find_pw(String m_id, String m_email) {
		memberDTO dto= new memberDTO();
		try{
			Connection con=DBOpen.getConnection();
			StringBuilder sql= new StringBuilder();
			sql.append(" select m_pw  ");
			sql.append(" from mem_inform ");
			sql.append(" where m_id=? and m_email=?");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, m_id);
			pstmt.setString(2, m_email);
			
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setM_pw(rs.getString("m_pw"));
			}else {
				dto=null;
			}
		}catch(Exception e){
			System.out.println("비번찾기 이메일 실패"+e);
		}//try end
		return dto;
	}//find_pw() end
	
}//class end
