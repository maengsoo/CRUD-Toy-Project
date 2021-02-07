package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBConnectionOracle;
import dto.Member_dto;

public class Member_dao {
	
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null ;
	PreparedStatement ps = null ;
	ResultSet rs = null ;
	
	/**
	 * Create h13_bookmember data
	 * 회원 정보등록
	 * @param 회원정보가 들어있는 dto
	 * @return 정상적으로 등록되면 1, 실패하면 0
	 */
	public int saveMember(Member_dto dto) {
		
		int result = 0;
		String query =" insert into  b13_bookmember\r\n " + 
				" (id, name, address, tel, age, reg_date)\r\n " + 
				" values\r\n" + 
				" ('"+dto.getId()+"', '"+dto.getName()+"', '"+dto.getAddress()+"', '"+dto.getTel()+"',"+dto.getAge()+",'"+dto.getReg_date()+"') ";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();//insert, update, delete 다가능 쿼리문만 변경해주면 
			
		}catch(SQLException se) {
			System.out.println(" saveMember() query 오류~ : "+query);
		}catch(Exception e) {
			System.out.println(" saveMember() 오류 ~ : ");
		}finally {
			common.close(connection, ps);
		}
		
		return result;
		
	}
	
	/**
	 * Read h13_bookmember data
	 * 회원 정보조회
	 * @param 정보를 조회 할 회원이름이나 회원번호
	 * @return 조회 된 dto
	 */
	public Member_dto getMemberView(String no) {
		Member_dto dto = null;
		String query = " select id, name, address, tel, age, reg_date\r\n " + 
					   " from B13_BOOKMEMBER\r\n " + 
				       " WHERE ID = '"+no+"' OR NAME = '"+no+"' ";
	    try {
            connection= common.getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()) {
               String nn 	   = rs.getString("id");
               String name     = rs.getString("name");
               String address  = rs.getString("address");
               String tel      = rs.getString("tel");
               int age 		   = rs.getInt("age");
               String reg_date = rs.getString("reg_date");
               dto = new Member_dto(nn,name,address,tel,age,reg_date);
         }
         
      }catch(SQLException se) {
         System.out.println("getMemberView() query 오류~" +query);
      }catch(Exception e) {
         System.out.println("getMemberView() 오류");
      }finally {
          common.close(connection, ps, rs);
      }
       return dto;
		
	}
	
	/**
	 * Update h13_bookmember data
	 * 수정 할 번호와 정보를 가져와서 수정 후 결과 값 리턴
	 * @param no
	 * @param name
	 * @param address
	 * @param tel
	 * @param age
	 * @return 정상처리됐으면1, 실패하면 0
	 */
	public int updateMember(String no, String name, String address, String tel, int age) {
		int result = 0;
		String query = " update B13_BOOKMEMBER\r\n " + 
				" SET NAME = '"+name+"', address = '"+address+"', tel = '"+tel+"', AGE = "+age+" \r\n " + 
				" WHERE ID = '"+no+"'";
		
		try {
            connection = common.getConnection();
            ps = connection.prepareStatement(query);
            result = ps.executeUpdate();
         }catch(SQLException se) {
            System.out.println(" updateMember() query 오류~~: " +query);
         }catch(Exception e) {
            System.out.println(" updateMember() 오류~~: ");
         }finally {
            common.close(connection, ps);
         }
         return result;
	}
	
	/**
	 * Delete h13_bookmember data
	 * 회원이름이나 회원번호를 가져와서 삭제
	 * @param no
	 * @return 성공하면 1, 실패하면 0 리턴
	 */
	public int deleteMember(String no) {
		int result = 0;
	
		String query = "delete from b13_bookmember where id = '"+no+"' or name = '"+no+"'";
	
 		try {
            connection = common.getConnection();
            ps = connection.prepareStatement(query);
            result = ps.executeUpdate();
         }catch(SQLException se) {
            System.out.println(" deleteMember() query 오류~~: " +query);
         }catch(Exception e) {
            System.out.println(" deleteMember() 오류~~: ");
         }finally {
            common.close(connection, ps);
         }
 		
 		return result;	

	}
	
	public int getCheckMemberId(String id) {
		int result = 0;
		String query = " select id from b13_bookmember where id = '"+id+"' ";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();//insert, update, delete 다가능 쿼리문만 변경해주면 
			
		}catch(SQLException se) {
			System.out.println(" getCheckMemberId() query 오류~ : "+query);
		}catch(Exception e) {
			System.out.println(" getCheckMemberId() 오류 ~ : ");
		}finally {
			common.close(connection, ps);
		}
		
		return result;
	}
}
