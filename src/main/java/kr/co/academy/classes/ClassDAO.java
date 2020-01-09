package kr.co.academy.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DBPKG.DBOpen;
import kr.co.academy.teacher.TeacherDTO;

public class ClassDAO {	
	public int create(ClassDTO dto){
		  int cnt = 0;
	      try {
	        Connection con = DBOpen.getConnection();
	        StringBuilder sql = new StringBuilder();
	        sql.append(" INSERT INTO class(w_code, c_code, c_prod, c_det, c_book, c_price, c_image, c_max, c_test, c_date, c_datend, c_start, c_end ) ");
	        sql.append(" VALUES((SELECT ifnull(MAX(w_code),0)+1 as w_code FROM class ALIAS_FOR_SUBQUERY), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"); 
	        PreparedStatement pstmt = con.prepareStatement(sql.toString());  
	        pstmt.setString(1, dto.getC_code());
	        pstmt.setString(2, dto.getC_prod());
	        pstmt.setString(3, dto.getC_det());
	        pstmt.setString(4, dto.getC_book());
	        pstmt.setInt(5, dto.getC_price());
	        pstmt.setString(6, dto.getC_image());
	        pstmt.setInt(7, dto.getC_max());
	        pstmt.setString(8, dto.getC_test());
	        pstmt.setString(9, dto.getC_date());
	        pstmt.setString(10, dto.getC_datend());
	        pstmt.setString(11, dto.getC_start());
	        pstmt.setString(12, dto.getC_end());
	        cnt = pstmt.executeUpdate();
	      } catch (Exception e) {
	          System.out.println("행추가실패:" + e);
	      }//try end
	      return cnt;
	  }//create end
  
	public ArrayList<ClassDTO> list1(){
	  	ArrayList<ClassDTO> list=null;
	      try{
	        Connection con = DBOpen.getConnection();
	        StringBuilder sql = new StringBuilder();
	        
	        sql.append(" SELECT A.w_code, A.c_code, A.c_prod,A.c_det, A.tc_name,A.c_price, A.c_start ");
	       	sql.append(" FROM (select  CL.w_code, CL.c_code, CL.c_prod,CL.c_det, TC.tc_name,CL.c_price, CL.c_start ");
	        sql.append(" FROM class as CL left join teacher as TC");
	       	sql.append(" on CL.w_code = TC.w_code");
	        sql.append(" order by CL.w_code desc)as A ");
	        sql.append(" WHERE A.c_code='TOEIC' ");
	        PreparedStatement pstmt = con.prepareStatement(sql.toString());
	        ResultSet rs = pstmt.executeQuery();
	        if(rs.next()){
	          list = new ArrayList<ClassDTO>();
	          do {
	            ClassDTO dto = new ClassDTO();
	            dto.setW_code(rs.getInt("w_code"));
	            dto.setC_code(rs.getString("c_code"));
	            dto.setC_prod(rs.getString("c_prod"));
	            dto.setC_det(rs.getString("c_det"));
	            dto.setTc_name(rs.getString("tc_name"));
	            dto.setC_price(rs.getInt("c_price"));
	            dto.setC_start(rs.getString("c_start"));
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
	  
	  public ArrayList<ClassDTO> list2(){
		  	ArrayList<ClassDTO> list=null;
		      try{
		        Connection con = DBOpen.getConnection();
		        StringBuilder sql = new StringBuilder();
		        
		        sql.append(" SELECT B.w_code, B.c_code, B.c_prod,B.c_det, B.tc_name,B.c_price, B.c_start ");
		       	sql.append(" FROM (select  CL.w_code, CL.c_code, CL.c_prod,CL.c_det, TC.tc_name,CL.c_price, CL.c_start ");
		       	sql.append(" FROM class as CL left join teacher as TC");
		       	sql.append(" on CL.w_code = TC.w_code");
		        sql.append(" order by CL.w_code desc)as B ");
		        sql.append(" WHERE B.c_code='TOEFL' ");
		        PreparedStatement pstmt = con.prepareStatement(sql.toString());
		        ResultSet rs = pstmt.executeQuery();
		        if(rs.next()){
		          list = new ArrayList<ClassDTO>();
		          do {
		            ClassDTO dto = new ClassDTO();
		            dto.setW_code(rs.getInt("w_code"));
		            dto.setC_code(rs.getString("c_code"));
		            dto.setC_prod(rs.getString("c_prod"));
		            dto.setC_det(rs.getString("c_det"));
		            dto.setTc_name(rs.getString("tc_name"));
		            dto.setC_price(rs.getInt("c_price"));
		            dto.setC_start(rs.getString("c_start"));
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
	  
	  public ArrayList<ClassDTO> list3(){
		  	ArrayList<ClassDTO> list=null;
		      try{
		        Connection con = DBOpen.getConnection();
		        StringBuilder sql = new StringBuilder();
		        
		        sql.append(" SELECT C.w_code, C.c_code, C.c_prod,C.c_det, C.tc_name,C.c_price, C.c_start ");
		       	sql.append(" FROM (select  CL.w_code, CL.c_code, CL.c_prod,CL.c_det, TC.tc_name,CL.c_price, CL.c_start ");
		       	sql.append(" FROM class as CL left join teacher as TC");
		       	sql.append(" on CL.w_code = TC.w_code");
		        sql.append(" order by CL.w_code desc)as C ");
		        sql.append(" 		WHERE C.c_code='TEPS' ");
		        PreparedStatement pstmt = con.prepareStatement(sql.toString());
		        ResultSet rs = pstmt.executeQuery();
		        if(rs.next()){
		          list = new ArrayList<ClassDTO>();
		          do {
		            ClassDTO dto = new ClassDTO();
		            dto.setW_code(rs.getInt("w_code"));
		            dto.setC_code(rs.getString("c_code"));
		            dto.setC_prod(rs.getString("c_prod"));
		            dto.setC_det(rs.getString("c_det"));
		            dto.setTc_name(rs.getString("tc_name"));
		            dto.setC_price(rs.getInt("c_price"));
		            dto.setC_start(rs.getString("c_start"));
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
	  
	  public ArrayList<ClassDTO> list4(){
		  	ArrayList<ClassDTO> list=null;
		      try{
		        Connection con = DBOpen.getConnection();
		        StringBuilder sql = new StringBuilder();
		        
		        sql.append(" SELECT D.w_code, D.c_code, D.c_prod,D.c_det, D.tc_name,D.c_price, D.c_start ");
		       	sql.append(" FROM (select  CL.w_code, CL.c_code, CL.c_prod,CL.c_det, TC.tc_name,CL.c_price, CL.c_start ");
		       	sql.append(" FROM class as CL left join teacher as TC");
		       	sql.append(" on CL.w_code = TC.w_code");
		        sql.append(" order by CL.w_code desc)as D ");
		        sql.append(" WHERE D.c_code='OPIC' ");
		        PreparedStatement pstmt = con.prepareStatement(sql.toString());
		        ResultSet rs = pstmt.executeQuery();
		        if(rs.next()){
		          list = new ArrayList<ClassDTO>();
		          do {
		            ClassDTO dto = new ClassDTO();
		            dto.setW_code(rs.getInt("w_code"));
		            dto.setC_code(rs.getString("c_code"));
		            dto.setC_prod(rs.getString("c_prod"));
		            dto.setC_det(rs.getString("c_det"));
		            dto.setTc_name(rs.getString("tc_name"));
		            dto.setC_price(rs.getInt("c_price"));
		            dto.setC_start(rs.getString("c_start"));
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
  
  
  public ClassDTO read (int w_code) {
  	ClassDTO dto=null;
  	try {
  		Connection con=DBOpen.getConnection();
  		StringBuilder sql= new StringBuilder();  

  		sql.append(" SELECT E.w_code, E.c_code, E.c_prod, E.c_det, E.c_book, E.c_price, E.c_image, E.c_max, E.c_test, E.c_date, E.c_datend, E.c_start, E.c_end, E.tc_name ");
  		sql.append(" FROM(SELECT CL.w_code, CL.c_code, CL.c_prod, CL.c_det, CL.c_book, CL.c_price, CL.c_image, CL.c_max, CL.c_test, CL.c_date, CL.c_datend, CL.c_start, CL.c_end, TC.tc_name ");
  		sql.append(" 	  FROM class as CL left join teacher as TC ");
  		sql.append(" 	  on CL.w_code = TC.w_code)as E ");
  		sql.append(" WHERE E.w_code= ? ");
  		PreparedStatement pstmt = con.prepareStatement(sql.toString());
  		pstmt.setInt(1, w_code);
  		ResultSet rs= pstmt.executeQuery();
  		if(rs.next()) {
  			dto = new ClassDTO();
  			dto.setW_code(rs.getInt("w_code"));
  			dto.setC_code(rs.getString("c_code"));
  			dto.setC_prod(rs.getString("c_prod"));
  			dto.setC_det(rs.getString("c_det"));
  			dto.setC_book(rs.getString("c_book"));
  			dto.setC_price(rs.getInt("c_price"));
  			dto.setC_image(rs.getString("c_image"));
  			dto.setC_max(rs.getInt("c_max"));
  			dto.setC_test(rs.getString("c_test"));
  			dto.setC_date(rs.getString("c_date"));
  			dto.setC_datend(rs.getString("c_datend"));
  			dto.setC_start(rs.getString("c_start"));
  			dto.setC_end(rs.getString("c_end"));	
  			dto.setTc_name(rs.getString("tc_name"));
  		}//if end
  	}catch(Exception e) {
  		System.out.println("상세보기 실패:"+e);
  	}//try end
  	return dto;
  }//read end
  
  public int update(ClassDTO dto) {
      int cnt = 0;
      try {
        Connection con = DBOpen.getConnection();
        StringBuilder sql = new StringBuilder();
        sql.append(" UPDATE class ");
        sql.append(" SET c_code=?, c_prod=?, c_det=?, c_book=?, c_price=?, c_image=?, c_max=?, c_test=?, c_date=?, c_datend=?, c_start=?, c_end=? ");
        sql.append(" WHERE w_code=? ");
        PreparedStatement pstmt = con.prepareStatement(sql.toString());
        pstmt.setString(1, dto.getC_code());
        pstmt.setString(2, dto.getC_prod());
        pstmt.setString(3, dto.getC_det());
        pstmt.setString(4, dto.getC_book());
        pstmt.setInt(5, dto.getC_price());
        pstmt.setString(6, dto.getC_image());
        pstmt.setInt(7, dto.getC_max());
        pstmt.setString(8, dto.getC_test());
        pstmt.setString(9, dto.getC_date());
        pstmt.setString(10, dto.getC_datend());
        pstmt.setString(11, dto.getC_start());
        pstmt.setString(12, dto.getC_end());
        pstmt.setInt(13, dto.getW_code());
        
        cnt = pstmt.executeUpdate();
      } catch (Exception e) {
          System.out.println("수정실패:" + e);
      }//try end
      return cnt;
  }//update() end 
  

	public int delete(ClassDTO dto) {
		int cnt=0;
		try {
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append(" delete from class where w_code=? ");
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, dto.getW_code());
			cnt=pstmt.executeUpdate();
		}catch(Exception e) {System.out.println("수정 실패"+e);}
		return cnt;
	}//delete() end

//페이징+검색 list------------------------------------------------------------------------------------------
	public ArrayList<ClassDTO> list(String col, String word, int nowPage, int recordPerPage){
        ArrayList<ClassDTO> list=null;
        
        // 페이지당 출력할 레코드 갯수 (10개를 기준)
        // 1 page : WHERE r>=1 AND r<=10
        // 2 page : WHERE r>=11 AND r<=20
        // 3 page : WHERE r>=21 AND r<=30
        int startRow = ((nowPage-1) * recordPerPage);
        int endRow   = nowPage * recordPerPage;
        
        try{
            Connection con=DBOpen.getConnection();
            StringBuilder sql=new StringBuilder();
          
          word = word.trim(); //검색어의 좌우 공백 제거
          
          if(word.length()==0) { //검색을 하지 않는 경우
            sql.append(" select  CL.w_code as w_code, CL.c_code as c_code, CL.c_prod as c_prod, TC.tc_name as tc_name, CL.c_price as c_price, CL.c_start as c_start ");
            sql.append("      FROM class as CL left join teacher as TC ");
            sql.append("      on CL.w_code = TC.w_code ");
            sql.append("      order by w_code asc,c_start  ");
            sql.append(" limit " + startRow + "," + recordPerPage) ;
          } else {
            //검색을 하는 경우
              sql.append(" select  CL.w_code as w_code, CL.c_code as c_code, CL.c_prod as c_prod, TC.tc_name as tc_name, CL.c_price as c_price, CL.c_start as c_start");
              sql.append("      FROM class as CL left join teacher as TC ");
              sql.append("      on CL.w_code = TC.w_code ");
            
            String search="";
            if(col.equals("tc_name")) { //강사명
              search += " WHERE tc_name LIKE '%" + word + "%'";
            } else if(col.equals("c_prod")) { //강좌명
              search += " WHERE c_prod LIKE '%" + word + "%'";
            } else if(col.equals("c_start")) { //시작날짜
              search += " WHERE c_start LIKE '%" + word + "%'";
            } else if(col.equals("name_prod")) { //강사명, 강좌명
              search += " WHERE tc_name LIKE '%" + word + "%'";
              search += " OR c_prod LIKE '%" + word + "%'";
            }//if end
            
            sql.append(search);        
            
            sql.append("      order by w_code asc,c_start  ");
            sql.append(" limit " + startRow + "," + recordPerPage) ;
          }//if end
          
          PreparedStatement pstmt=con.prepareStatement(sql.toString());
          ResultSet rs=pstmt.executeQuery();
          if(rs.next()){
            list=new ArrayList<ClassDTO>();
            do{
              ClassDTO dto=new ClassDTO();
              dto.setW_code(rs.getInt("w_code"));
              dto.setC_code(rs.getString("c_code"));
              dto.setC_prod(rs.getString("c_prod"));
              dto.setTc_name(rs.getString("tc_name"));
              dto.setC_price(rs.getInt("c_price"));
              dto.setC_start(rs.getString("c_start"));
              list.add(dto);
            }while(rs.next());
          }//if end
          
        }catch(Exception e) {
          System.out.println("목록 페이징 실패: "+e);
        }   
        return list;
      }//list() end  
	
	
	public int count (String col, String word){  
		int cnt=0;
		try{
			Connection con=DBOpen.getConnection();
			StringBuilder sql=new StringBuilder();
			
			sql.append(" SELECT count(*) AS cnt ");
			sql.append(" from (select  CL.w_code, CL.c_code, CL.c_prod, TC.tc_name, CL.c_price, CL.c_start ");
			sql.append("       FROM class as CL left join teacher as TC ");
            sql.append("       on CL.w_code = TC.w_code) as CNT ");
			
			//검색을 했을 때 나타는 리스트에서 복사
			if(word.trim().length()>=1){ //검색어가 존재한다 라는 의미 = where 조건절로서 선택할 것을 찾아주기
				String search="";
	            if(col.equals("tc_name")) { //강사명
	              search += " WHERE tc_name LIKE '%" + word + "%'";
	            } else if(col.equals("c_prod")) { //강좌명
	              search += " WHERE c_prod LIKE '%" + word + "%'";
	            } else if(col.equals("c_start")) { //시작날짜
	              search += " WHERE c_start LIKE '%" + word + "%'";
	            } else if(col.equals("name_prod")) { //강사명, 강좌명
	              search += " WHERE tc_name LIKE '%" + word + "%'";
	              search += " OR c_prod LIKE '%" + word + "%'";
	            }//if end
				
				sql.append(search);
				
			}// if end
			
			PreparedStatement pstmt=con.prepareStatement(sql.toString());
			ResultSet rs=pstmt.executeQuery(); //select 이기 때문에 resultset에 query문을 담아야 함
			if(rs.next()){
					cnt=rs.getInt("cnt");
			}//if end						
		}catch(Exception e){
			System.out.println("글 개수 카운팅 실패 : "+e);
		}//try end
		return cnt; 
	}//count end
}//class end
