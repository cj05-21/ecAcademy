package kr.co.academy.apply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;

import DBPKG.DBOpen;

public class ApplyDAO {
	
	//관리자 회원 부르는 함수
	public ApplyDTO read(String m_id) {
		ApplyDTO dto=null;
		try{
			Connection con=DBOpen.getConnection();
			StringBuilder sql= new StringBuilder();
			sql.append(" select m_level,m_id,m_name,m_job,m_email,m_phone ");
			sql.append(" from mem_inform ");
			sql.append(" where m_id=? ");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, m_id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()==true){
				dto=new ApplyDTO();
				dto.setM_level(rs.getString("m_level"));
				dto.setM_id(rs.getString("m_id"));
				dto.setM_name(rs.getString("m_name"));
				dto.setM_job(rs.getString("m_job"));
				dto.setM_email(rs.getString("m_email"));
				dto.setM_phone(rs.getString("m_phone"));
			}//if end
		}catch(Exception e){
			System.out.println("로그인 실패"+e);
		}//try end
		
		return dto;
	}//read() end	
	public ApplyDTO read(int w_code) {
		ApplyDTO dto=null;
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append(" select BB.w_code, BB.c_prod, BB.c_start, BB.c_price, BB.tc_name");
			sql.append(" from (select AA.w_code as w_code, AA.c_prod as c_prod, AA.c_start as c_start, AA.c_price as c_price, AA.tc_name as tc_name ");
			sql.append(" 		from (select T.tc_name, C.w_code, C.c_prod, C.c_start, C.c_price ");
			sql.append(" 				from teacher as T join class as C ");
			sql.append(" 		on T.w_code=C.w_code) as AA ) as BB ");
			sql.append(" where BB.w_code= ? ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, w_code);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				dto=new ApplyDTO();
				dto.setC_prod(rs.getString("c_prod"));
				dto.setC_start(rs.getString("c_start"));
				dto.setC_price(rs.getInt("c_price"));
				dto.setTc_name(rs.getString("tc_name"));
				dto.setW_code(rs.getInt("w_code"));
			}			
		}catch(Exception e) {
			System.out.println("읽어오기 실패 : "+e);
		}//try end
		return dto;
	}//read()end
	
	public ArrayList<ApplyDTO> list(){
		ArrayList<ApplyDTO> list=null;
		ApplyDTO dto=new ApplyDTO();
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append(" select CC.ap_no,CC.p_sts,CC.tc_name,CC.m_id,CC.m_name,CC.m_email,DD.c_prod,DD.c_max,DD.c_start,DD.c_end ");
			sql.append(" from( ");
			sql.append("     select AA.ap_no,AA.p_sts,AA.tc_name,AA.w_code,BB.m_id,BB.m_name,BB.m_email ");
			sql.append("     from apply as AA join mem_inform as  BB ");
			sql.append("     on AA.m_id=BB.m_id) as CC join class as DD ");
			sql.append(" on  CC.w_code=DD.w_code "); 
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				list=new ArrayList<ApplyDTO>();
				do {
					dto=new ApplyDTO();
					dto.setAp_no(rs.getString("ap_no"));
					dto.setP_sts(rs.getString("p_sts"));
					dto.setTc_name(rs.getString("tc_name"));
					dto.setC_prod(rs.getString("c_prod"));
					dto.setC_start(rs.getString("c_start"));
					dto.setC_end(rs.getString("c_end"));
					dto.setC_max(rs.getInt("c_max"));
					dto.setM_id(rs.getString("m_id"));
					dto.setM_name(rs.getString("m_name"));
					dto.setM_email(rs.getString("m_email"));
					list.add(dto);
				}while(rs.next());
			}
		}catch(Exception e){
			System.out.println("목록 가져오기 실패 : "+e);
		}//try end
		return list;
	}//list()end
	
	public HashMap<String, Integer> insert(ApplyDTO dto) {
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		int cnt=0;
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			String ap_no="";
			sql.append(" SELECT IFNULL(MAX(ap_no), 1000000)+1 as ap_no from apply ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				ap_no=rs.getString(1);
			}else{
				ap_no="0";
			}//if end
			sql.delete(0, sql.length());
			sql.append(" INSERT INTO apply (ap_no, m_id, w_code, tc_name, ap_pay, ap_date) ");
			sql.append(" VALUES (?, ?, ?, ?, ? , now()) ");
			
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, ap_no);
			pstmt.setString(2, dto.getM_id());
			pstmt.setInt(3, dto.getW_code());
			pstmt.setString(4, dto.getTc_name());
			pstmt.setString(5, dto.getAp_pay());
			cnt=pstmt.executeUpdate();		
			
			map.put("ap_no", new Integer(ap_no));
			map.put("cnt", new Integer(cnt));
			
		}catch(Exception e) {
			System.out.println("수강신청 실패 : "+e);
		}
		return map;
	}
	
	public int update(ApplyDTO dto) {
		int cnt=0;
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append(" UPDATE apply ");
			sql.append(" SET p_sts='진행' ");
			sql.append(" WHERE ap_no=? ");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getAp_no());
			cnt=pstmt.executeUpdate();
					
		}catch(Exception e) {
			System.out.println("진행불가 : "+e);
		}
		return cnt;
	}
	
	public String line(String m_id, int w_code) {
		String ap_no="";
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append(" SELECT ap_no ");
			sql.append(" FROM apply ");
			sql.append(" WHERE m_id=? AND w_code=? ");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, m_id);
			pstmt.setInt(2, w_code);
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				ApplyDTO dto=new ApplyDTO();
				dto.setAp_no(rs.getString("ap_no"));
				ap_no=dto.getAp_no();
			}	
		} catch (Exception e) {
			System.out.println("ap_no 받기 실패 : " +e);
		}
		return ap_no;
	}
	
	public ApplyDTO jumun(String ap_no) {
		ApplyDTO dto=null;
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append(" select d.ap_no, d.c_prod, d.c_price, d.ap_date  ");
			sql.append(" from (select A.ap_no AS ap_no, A.w_code AS w_code, A.ap_date AS ap_date, C.c_prod AS c_prod, C.c_price AS c_price ");
			sql.append(" 	   from apply AS A join class AS C ");
			sql.append(" 	   on A.w_code=C.w_code) as d ");
			sql.append(" WHERE d.ap_no=? ");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, ap_no);
			
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				dto=new ApplyDTO();
				dto.setAp_no(rs.getString("ap_no"));
				dto.setC_prod(rs.getString("c_prod"));
				dto.setC_price(rs.getInt("c_price"));
				dto.setAp_date(rs.getString("ap_date"));
				
			}else {
				dto=null;
			}
			
		}catch(Exception e) {
			System.out.println("목록 불러오기 실패 : "+ e);
		}
		return dto;
	}
}//class end
