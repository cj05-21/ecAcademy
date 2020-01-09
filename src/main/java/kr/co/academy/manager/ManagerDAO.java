package kr.co.academy.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBPKG.DBOpen;
import kr.co.academy.attend.AttendDTO;

public class ManagerDAO {
	public ManagerDTO read(String m_id) {
		ManagerDTO dto=null;
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
				dto=new ManagerDTO();
				dto.setM_level(rs.getString("m_level"));
				dto.setM_id(rs.getString("m_id"));
				dto.setM_name(rs.getString("m_name"));
				dto.setM_job(rs.getString("m_job"));
				dto.setM_email(rs.getString("m_email"));
				dto.setM_phone(rs.getString("m_phone"));
			}//if end
		}catch(Exception e){
			System.out.println("읽어오기 실패"+e);
		}//try end
		
		return dto;
	}//read() end
	
	public ArrayList<ManagerDTO> read() {
		ArrayList<ManagerDTO> list=null;
		try{
			Connection con=DBOpen.getConnection();
			StringBuilder sql= new StringBuilder();
			sql.append(" select m_level,m_id,m_name,m_job,m_email,m_phone ");
			sql.append(" from mem_inform ");
			sql.append(" order by m_level ");
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()==true){
				list=new ArrayList<ManagerDTO>();
				do {
				ManagerDTO dto=new ManagerDTO();
				dto.setM_level(rs.getString("m_level"));
				dto.setM_id(rs.getString("m_id"));
				dto.setM_name(rs.getString("m_name"));
				dto.setM_job(rs.getString("m_job"));
				dto.setM_email(rs.getString("m_email"));
				dto.setM_phone(rs.getString("m_phone"));
				list.add(dto);
				}while(rs.next());
			}//if end
		}catch(Exception e){
			System.out.println("읽어오기 실패"+e);
		}//try end
		return list;
	}//read() end
	
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
	        sql.append("         on AA.m_id=BB.m_id) as CC join class as  DD ");
	        sql.append("     on CC.w_code=DD.w_code) as EE join  teacher as FF ");
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
	
	public int update(String m_id,String m_level) {
		int cnt=0;
		try{
			Connection con=DBOpen.getConnection();
			StringBuilder sql= new StringBuilder();
			sql.append(" update mem_inform set ");
			sql.append(" m_level=? ");
			sql.append(" where m_id=? ");		
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setString(1, m_level);
			pstmt.setString(2, m_id);
			cnt=pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("로그인 실패"+e);
		}//try end
		return cnt;
	}//read() end
}
