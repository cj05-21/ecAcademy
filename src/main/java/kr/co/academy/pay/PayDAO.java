package kr.co.academy.pay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import DBPKG.DBOpen;
import kr.co.academy.classes.ClassDTO;

public class PayDAO {
	
	public ArrayList<PayDTO> list(String m_id){
	  	ArrayList<PayDTO> list=null;
	      try{ 
	        Connection con = DBOpen.getConnection();
	        StringBuilder sql = new StringBuilder();
	        sql.append(" select AA.ap_no,AA.w_code,AA.m_id,BB.c_code,BB.c_prod,AA.tc_name,BB.c_price,BB.c_start,AA.p_sts ");
	        sql.append(" from apply as AA join class as BB ");
	        sql.append(" on AA.w_code=BB.w_code ");
	        sql.append(" where AA.m_id=? ");
	        PreparedStatement pstmt = con.prepareStatement(sql.toString());
	        pstmt.setString(1, m_id);
	        ResultSet rs = pstmt.executeQuery();
	        if(rs.next()){
	          list = new ArrayList<PayDTO>();
	          do {
	            PayDTO dto = new PayDTO();
	            dto.setAp_no(rs.getString("ap_no"));
	            dto.setW_code(rs.getString("w_code"));
	            dto.setM_id(rs.getString("m_id"));
	            dto.setC_code(rs.getString("c_code"));
	            dto.setC_prod(rs.getString("c_prod"));
	            dto.setTc_name(rs.getString("tc_name"));
	            dto.setC_price(rs.getInt("c_price"));
	            dto.setC_start(rs.getString("c_start"));
	            dto.setP_sts(rs.getString("p_sts"));
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
	
	public PayDTO receipt(String m_id, String w_code) {
		PayDTO dto=null;
	      try{
	        Connection con = DBOpen.getConnection();
	        StringBuilder sql = new StringBuilder();
	        sql.append(" select CC.ap_no,CC.m_id,CC.m_name,CC.w_code,CC.tc_name,CC.ap_pay,CC.ap_date,CC.p_sts,DD.c_prod,DD.c_price ");
	        sql.append(" from( ");
	        sql.append("     select aa.ap_no,aa.m_id,bb.m_name,aa.w_code,aa.tc_name,aa.ap_pay,aa.ap_date,aa.p_sts ");
	        sql.append("     from apply as aa join mem_inform as bb ");
	        sql.append("     on aa.m_id=bb.m_id) as CC join class as DD ");
	        sql.append(" on CC.w_code=DD.w_code  ");
	        sql.append(" where CC.m_id=? and CC.w_code=? ");
	        
	        PreparedStatement pstmt = con.prepareStatement(sql.toString());
	        pstmt.setString(1, m_id);
	        pstmt.setString(2, w_code);
	        
	        ResultSet rs = pstmt.executeQuery();
	        if(rs.next()){
	          do {	     
	            dto=new PayDTO();
	            dto.setAp_no(rs.getString("ap_no"));
	            dto.setM_id(rs.getString("m_id"));
	            dto.setM_name(rs.getString("m_name"));
	            dto.setW_code(rs.getString("w_code"));
	            dto.setTc_name(rs.getString("tc_name"));
	            dto.setAp_pay(rs.getString("ap_pay"));
	            dto.setAp_date(rs.getString("ap_date"));
	            dto.setC_prod(rs.getString("c_prod"));
	            dto.setC_price(rs.getInt("c_price"));
	          } while(rs.next());
	        }else{
	          dto = null;
	        }//if end
	      }catch(Exception e){
	        System.out.println("영수증 상세보기 실패:"+e);
	      }//try end
	      return dto;
	}//receipt() end
	/*
		public PayDTO list(String m_id) {
			PayDTO dto=null;
			try {
				Connection con=DBOpen.getConnection();
				StringBuilder sql=new StringBuilder();
				sql.append(" select p_no, p_sts, w_code, c_code, m_id, tc_name, c_price, c_start ");
                sql.append(" from (select CC.p_no p_no, CC.p_sts p_sts, CC.w_code w_code, DD.c_code c_code, CC.m_id m_id, CC.tc_name tc_name, DD.c_price c_price, DD.c_start c_start ");
				sql.append(" from(select AA.p_no, AA.p_sts, AA.m_id, BB.tc_name,AA.w_code  ");
				sql.append("         from(select p.p_no, p.p_sts, m.m_id,p.tc_name,p.w_code ");
				sql.append("              from pay p join mem_inform m ");
				sql.append("              on p.m_id=m.m_id)AA join teacher BB ");
				sql.append("         on AA.tc_name=BB.tc_name ");
				sql.append("     ) CC join class DD ");
				sql.append(" on CC.w_code=DD.w_code) ");
				sql.append(" where m_id='123123' ");
				PreparedStatement pstmt=con.prepareStatement(sql.toString());
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					dto=new PayDTO();
					dto.setP_no(rs.getInt("p_no"));
					dto.setP_sts(rs.getString("p_sts"));
					dto.setW_code(rs.getString("w_code"));
					dto.setC_code(rs.getString("c_code"));
					dto.setM_id(rs.getString("m_id"));
					dto.setTc_name(rs.getString("tc_name"));
					dto.setC_price(rs.getInt("c_price"));
					dto.setC_start(rs.getString("c_start"));
				}
			}catch(Exception e) {System.out.println("실패"+e);}
			return dto;
		}
		*/
}//class end
