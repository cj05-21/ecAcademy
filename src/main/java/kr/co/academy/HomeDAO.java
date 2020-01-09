package kr.co.academy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBPKG.DBOpen;

public class HomeDAO {

		public ArrayList<HomeDTO> mainreview() {
			ArrayList<HomeDTO> list=null;
			try {
				Connection con=DBOpen.getConnection();
				StringBuilder sql=new StringBuilder();
				sql.append("   select r_subject,r_content,m_id,poster,r_date,r_readcnt,score,c_code ");
				sql.append("   from review ");
				sql.append("   order by r_readcnt desc ");
				 sql.append(" limit 0, 3") ;
				PreparedStatement pstmt=con.prepareStatement(sql.toString());
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					list=new ArrayList<HomeDTO>();
					do{
					HomeDTO dto=new HomeDTO();
					dto.setR_subject(rs.getString("r_subject"));
					dto.setR_readcnt(rs.getInt("r_readcnt"));
					dto.setR_content(rs.getString("r_content"));
					dto.setM_id(rs.getString("m_id"));
					dto.setPoster(rs.getString("poster"));
					dto.setR_date(rs.getString("r_date"));
					dto.setScore(rs.getInt("score"));
					dto.setC_code(rs.getString("c_code"));
					dto.setR_date(rs.getString("r_date"));
					list.add(dto);
					}while(rs.next());
				}
			}catch(Exception e) {System.out.println("불러오기 실패"+e);}
			return list;
		}
		
		public ArrayList<HomeDTO> mainclass(){
			ArrayList<HomeDTO> list=null;
			//classDTO 객체지정
			HomeDTO dto=new HomeDTO();
			try {
				Connection con=DBOpen.getConnection();
				StringBuilder sql=new StringBuilder();
				
				sql.append(" select w_code, poster, c_prod, tc_name, c_price ");
				sql.append(" from (select C.w_code as w_code, T.poster as poster, C.c_prod as c_prod, T.tc_name as tc_name, C.c_price as c_price, C.c_date as c_date ");
				sql.append(" 	   FROM class as C join teacher as T ");
				sql.append(" 	   on C.w_code=T.w_code ");
				sql.append(" order by c_date desc, tc_name asc )as F "); //날짜를 최신순으로 나열하고 날짜가 겹칠 경우, 이름순으로
				sql.append(" limit 0,6 ") ;
				
				PreparedStatement pstmt=con.prepareStatement(sql.toString());
				ResultSet rs=pstmt.executeQuery();
				
				if(rs.next()) {
					list=new ArrayList<HomeDTO>();
					do {
						dto=new HomeDTO();
						dto.setW_code(rs.getInt("w_code"));
						dto.setPoster(rs.getString("poster"));
						dto.setC_prod(rs.getString("c_prod"));
						dto.setTc_name(rs.getString("tc_name"));
						dto.setC_price(rs.getInt("c_price"));
						list.add(dto);
					}while(rs.next());
				}
			}catch (Exception e) {
				System.out.println("최신 강의 불러오기 실패 : "+e);
			}
			return list;

		}
}
