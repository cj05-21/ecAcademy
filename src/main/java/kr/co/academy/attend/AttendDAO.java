package kr.co.academy.attend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBPKG.DBOpen;
import kr.co.academy.apply.ApplyDTO;

public class AttendDAO {
	public ArrayList<AttendDTO> list(){
	  	ArrayList<AttendDTO> list=null;
	      try{
	        Connection con = DBOpen.getConnection();
	        StringBuilder sql = new StringBuilder();
	        sql.append(" select EE.ap_no,EE.m_id,EE.w_code,EE.p_sts,EE.m_name,EE.c_prod,EE.c_start,EE.c_end,FF.tc_name ");
	        sql.append(" from( ");
	        sql.append("     select CC.ap_no,CC.m_id,CC.w_code,CC.tc_name,CC.p_sts,CC.m_name,DD.c_prod,DD.c_start,DD.c_end ");
	        sql.append("     from( ");
	        sql.append("         select AA.ap_no,AA.m_id,AA.w_code,AA.tc_name,AA.p_sts,BB.m_name ");
	        sql.append("        from apply as AA join mem_inform as BB ");
	        sql.append("         on AA.m_id=BB.m_id) as CC join class as DD ");
	        sql.append("     on CC.w_code=DD.w_code) as EE join teacher as FF ");
	        sql.append(" on EE.tc_name=FF.tc_name ");
	        sql.append(" where EE.p_sts='진행' ");
	        
	        PreparedStatement pstmt = con.prepareStatement(sql.toString());
	        ResultSet rs = pstmt.executeQuery();
	        if(rs.next()){
	          list = new ArrayList<AttendDTO>();
	          do {
	            AttendDTO dto = new AttendDTO();
	            dto.setAtt_no(rs.getInt("ap_no"));
	            dto.setM_id(rs.getString("m_id"));
	            dto.setW_code(rs.getInt("w_code"));
	            dto.setP_sts(rs.getString("p_sts"));
	            dto.setM_name(rs.getString("m_name"));
	            dto.setC_prod(rs.getString("c_prod"));
	            dto.setC_start(rs.getString("c_start"));
	            dto.setC_end(rs.getString("c_end"));
	            dto.setTc_name(rs.getString("tc_name"));
	            list.add(dto);
	          } while(rs.next());
	        }else{
	          list = null;
	        }//if end
	      }catch(Exception e){
	        System.out.println("목록실패:"+e);
	      }//try end
	      return list;
	  }//list() end
	
	public AttendDTO confirm(String m_id,int w_code,String attend_date) {
		AttendDTO dto=null;
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append(" select attend_date ");
			sql.append(" from attend ");
			sql.append(" where m_id=? AND w_code=?");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, m_id);
			pstmt.setInt(2, w_code);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				dto=new AttendDTO();
				dto.setAttend_date(rs.getString("attend_date"));
			}
		}catch(Exception e) {System.out.println("확인 실패"+e);}
		return dto;
	}//confirm() end
	
	public void insert(String m_id,String tc_name,int w_code,String attend_date,String p_sts) {
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append(" insert into attend (att_no,m_id,tc_name,w_code,attend_date,p_sts) "); 
			sql.append(" values ((select ifnull(max(att_no),0)+1 from attend ALIAS_FOR_SUBQUERY ),?,?,?,?,?) ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, m_id);
			pstmt.setString(2, tc_name);
			pstmt.setInt(3, w_code);
			pstmt.setString(4, attend_date);
			pstmt.setString(5, p_sts);
			pstmt.executeUpdate();
		}catch(Exception e) {System.out.println("출석 실패"+e);}
	}//insert() end
	/*
	public ArrayList<AttendDTO> check(String m_id,String w_code){
	  	ArrayList<AttendDTO> list=null;
	      try{
	        Connection con = DBOpen.getConnection();
	        StringBuilder sql = new StringBuilder();
	        sql.append(" select att_no,m_id,tc_name,w_code,attend_date,p_sts ");
	        sql.append(" from attend ");
	        sql.append(" where m_id=? and w_code=? ");
	        PreparedStatement pstmt = con.prepareStatement(sql.toString());
	        pstmt.setString(1,m_id );
	        pstmt.setString(2,w_code );
	        ResultSet rs = pstmt.executeQuery();
	        if(rs.next()){
	          list = new ArrayList<AttendDTO>();
	          do {
	            AttendDTO dto = new AttendDTO();
	           
	            list.add(dto);
	          } while(rs.next());
	        }else{
	          list = null;
	        }//if end
	      }catch(Exception e){
	        System.out.println("목록실패:"+e);
	      }//try end
	      return list;
	  }//list() end
	*/
	
	  
	 
	public ArrayList<AttendDTO> check(String attend_date){
	  	ArrayList<AttendDTO> list=null;
	      try{
	        Connection con = DBOpen.getConnection();
	        StringBuilder sql = new StringBuilder();
	        sql.append(" select CC.att_no,CC.m_id,CC.w_code,CC.m_name,CC.attend_date,DD.c_prod,DD.c_start,DD.c_end,CC.tc_name ");
	        sql.append(" from( ");
	        sql.append("     select AA.att_no,BB.m_id,AA.w_code,BB.m_name,AA.attend_date,AA.tc_name ");
	        sql.append("    from attend as AA join mem_inform as BB ");
	        sql.append("    on AA.m_id=BB.m_id) as CC join class as  DD ");
	        sql.append(" on CC.w_code=DD.w_code ");
	        sql.append(" where CC.attend_date=? ");
	        PreparedStatement pstmt = con.prepareStatement(sql.toString());
	        pstmt.setString(1, attend_date);
	        ResultSet rs = pstmt.executeQuery();
	        if(rs.next()){
	          list = new ArrayList<AttendDTO>();
	          do {
	            AttendDTO dto = new AttendDTO();
	            dto.setAtt_no(rs.getInt("att_no"));
	            dto.setM_id(rs.getString("m_id"));
	            dto.setW_code(rs.getInt("w_code"));
	            dto.setM_name(rs.getString("m_name"));
	            dto.setAttend_date(rs.getString("attend_date"));
	            dto.setC_prod(rs.getString("c_prod"));
	            dto.setC_start(rs.getString("c_start"));
	            dto.setC_end(rs.getString("c_end"));
	            dto.setTc_name(rs.getString("tc_name"));
	            list.add(dto);
	          } while(rs.next());
	        }else{
	          list = null;
	        }//if end
	      }catch(Exception e){
	        System.out.println("목록실패:"+e);
	      }//try end
	      return list;
	  }//list() end
	  
	//----------------------------------------------------------------------
		//관리자 회원 부르는 함수
		public AttendDTO read(String m_id) {
			AttendDTO dto=null;
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
					dto=new AttendDTO();
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
}
