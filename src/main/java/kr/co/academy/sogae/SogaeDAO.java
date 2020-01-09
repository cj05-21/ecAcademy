package kr.co.academy.sogae;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBPKG.DBOpen;

public class SogaeDAO {	
	public int create(SogaeDTO dto){
		  
		  int cnt = 0;
	      try {

	        Connection con = DBOpen.getConnection();
	        StringBuilder sql = new StringBuilder();
	        sql.append(" INSERT INTO sogae( img_code, img_a, img_b, img_c, img_d ) ");
	        sql.append(" VALUES((SELECT NVL(MAX(img_code),0)+1 as img_code FROM sogae ALIAS_FOR_SUBQUERY), ?, ?, ?, ? )"); 
	        PreparedStatement pstmt = con.prepareStatement(sql.toString());  
	        pstmt.setString(1, dto.getImg_a());
	        pstmt.setString(2, dto.getImg_b());
	        pstmt.setString(3, dto.getImg_c());
	        pstmt.setString(4, dto.getImg_d());
	       
	        cnt = pstmt.executeUpdate();
	        
	        System.out.println(cnt);
	      } catch (Exception e) {
	    	  
	          System.out.println("행추가실패:" + e);
	      }//try end
	      return cnt;
	  }//create end
  
  public SogaeDTO list(){
  	SogaeDTO dto = null;
      try{
        Connection con = DBOpen.getConnection();
        StringBuilder sql = new StringBuilder();
        
        sql.append(" SELECT img_code, img_a, img_b, img_c, img_d ");
        sql.append(" FROM sogae");
        sql.append(" ORDER BY img_code desc");
        PreparedStatement pstmt = con.prepareStatement(sql.toString());
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
        	dto = new SogaeDTO();
            dto.setImg_code(rs.getInt("img_code"));
            dto.setImg_a(rs.getString("img_a"));
            dto.setImg_b(rs.getString("img_b"));
            dto.setImg_c(rs.getString("img_c"));
            dto.setImg_d(rs.getString("img_d"));
        }else{
          dto = null;
        }//if end
      }catch(Exception e){
        System.out.println("목록실패:"+e);
      }//try end
      return dto;
  }//list() end
  
	
	}//class end
