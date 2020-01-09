package kr.co.academy.wish;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBPKG.DBOpen;
import kr.co.academy.classes.ClassDTO;

public class WishDAO {
	
	public int winsert(String m_id,int w_code) {
		int cnt=0;
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append(" insert into wishlist(wlist, w_code, m_id)  ");
			sql.append(" values((SELECT ifnull(MAX(wlist),0)+1 as wlist FROM wishlist ALIAS_FOR_SUBQUERY), ?, ?) ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, w_code);
			pstmt.setString(2, m_id);
			cnt=pstmt.executeUpdate();
		}catch(Exception e) {System.out.println("수정 실패"+e);}
		return cnt;
	}//delete() end

		public ArrayList<WishDTO> list(String m_id){
			ArrayList<WishDTO> list=null;
		      try{
		        Connection con = DBOpen.getConnection();
		        StringBuilder sql = new StringBuilder();

		        sql.append(" select wlist,m_id,w_code,c_price,c_prod,c_start, tc_name ");
		        sql.append(" from (select B.wlist, B.m_id,B.w_code,B.c_price,B.c_prod,T.tc_name,B.c_start ");
		        sql.append(" 	   from( ");
		        sql.append(" 			select A.wlist,Me.m_id,A.w_code,A.c_price,A.c_prod,A.c_start ");
		        sql.append(" 			from ( select W.wlist,W.m_id, C.w_code,C.c_price,C.c_prod,C.c_start ");
		        sql.append(" 			       from wishlist as W join class as C");
		        sql.append(" 					on W.w_code = C.w_code) as A join mem_inform as Me ");
		        sql.append(" 			on A.m_id =  Me.m_id) as B join teacher as T ");
		        sql.append(" 		on B.w_code=T.w_code)as F ");
		        sql.append(" where m_id=? ");
		        sql.append(" ORDER BY wlist desc ");
		        
		        PreparedStatement pstmt = con.prepareStatement(sql.toString());
		        pstmt.setString(1, m_id);
		        ResultSet rs = pstmt.executeQuery();
		        if(rs.next()){
		        	list= new ArrayList<WishDTO>();
		          do {
		            WishDTO dto = new WishDTO();
		        	
		            dto.setWlist(rs.getInt("wlist"));
		            dto.setM_id(rs.getString("m_id"));
		            dto.setW_code(rs.getInt("w_code"));		          
		            dto.setC_prod(rs.getString("c_prod"));		   
		            dto.setC_price(rs.getInt("c_price"));
		            dto.setC_start(rs.getString("c_start"));
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
		

		public int delete(WishDTO dto) {
			int cnt=0;
			try {
				Connection con=DBOpen.getConnection();
				StringBuilder sql=new StringBuilder();
				sql.append(" delete from wishlist where wlist=? ");
				PreparedStatement pstmt=con.prepareStatement(sql.toString());
				pstmt.setInt(1, dto.getWlist());
				cnt=pstmt.executeUpdate();
			}catch(Exception e) {System.out.println("수정 실패"+e);}
			return cnt;
		}//delete() end

}//class end
