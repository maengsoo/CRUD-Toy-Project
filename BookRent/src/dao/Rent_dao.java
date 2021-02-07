package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.Rent_dto;

public class Rent_dao {
	
	
	DBConnectionOracle common = new DBConnectionOracle ();
	Connection connection = null ;
	PreparedStatement ps = null ;
	ResultSet rs = null ;
		
	
/*	public int getCheckMemberId(String memberId) {
		
		int result = 0;
		String query = " select count(*)\r\n " + 
				" from B13_MEMBER\r\n " + 
				" WHERE ID = '"+memberId+"'";
		
		try {
            connection = common.getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            if(rs.next()) {
            	result = rs.getInt(1);
            }
            
		   }catch(SQLException se) {
	            System.out.println(" updateMember() query 오류~~: " +query);
	         }catch(Exception e) {
	            System.out.println(" updateMember() 오류~~: ");
	         }finally {
	            common.close(connection, ps);
	         }		
		
		
		return result;
	}
*/
	
	public int setBookRentGubun(String bookNo) {
		int result = 0;
		String query = " update b13_book set rent_gubun = 'N' where no = '"+bookNo+"' ";
		
		try {
            connection = common.getConnection();
            ps = connection.prepareStatement(query);
            result = ps.executeUpdate();
         }catch(SQLException se) {
            System.out.println(" setBookRentGubun() query 오류~~: " +query);
         }catch(Exception e) {
            System.out.println(" setBookRentGubun() 오류~~: ");
         }finally {
            common.close(connection, ps);
         }
		return result;
	}
	
	
	/**
	 * Create h13_rent data
	 * @param dto
	 * @return 성공하면 1, 실패하면 0
	 */
	public int saveRent(Rent_dto dto) {
		int result = 0;
		String query = " INSERT INTO b13_rent\r\n " + 
					   " (no, member_id, book_no, rent_date, return_date)\r\n " + 
					   " values\r\n" + 
					   " ('"+dto.getNo()+"','"+dto.getMember_id()+"','"+dto.getBook_no()+"','"+dto.getRent_date()+"','"+dto.getReturn_date()+"') ";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();//insert, update, delete 다가능 쿼리문만 변경해주면 
			
		}catch(SQLException se) {
			System.out.println(" saveRent() query 오류~ : "+query);
		}catch(Exception e) {
			System.out.println(" saveRent() 오류 ~ : ");
		}finally {
			common.close(connection, ps);
		}
		return result;
	}
	
	// 번호생성
	public String getRentNo() {
		String maxNo="";
		String query=" select max(no) from b13_Rent ";
		try {
			connection = common.getConnection();
			ps  = connection.prepareStatement(query);
			rs  = ps.executeQuery();
			if(rs.next()) {
				maxNo = rs.getString(1);
			}
			if(maxNo == null) {
				maxNo ="R001";
			} else {
				String n = maxNo.substring(1); 
				int i = Integer.parseInt(n); 
				i = i + 1;
				DecimalFormat df = new DecimalFormat("000");
				String newNo = df.format((double)i);
				maxNo = "R"+newNo; // 
			}
		}catch(SQLException se) {
			System.out.println("getNoticeNo() query 오류: "+query);
		}catch(Exception ee) {
			System.out.println("getNoticeNo() 오류");
		}finally {
			common.close(connection, ps, rs);
		}		
		return maxNo;
	}
	
	//반납일자update
	public int updateDate(String renaDate, String book_no) {
		int result = 0;
		String query = " update b13_rent set return_date = '"+renaDate+"' where book_no = '"+book_no+"' ";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();//insert, update, delete 다가능 쿼리문만 변경해주면 
			
		}catch(SQLException se) {
			System.out.println(" updateDate() query 오류~ : "+query);
		}catch(Exception e) {
			System.out.println(" updateDate() 오류 ~ : ");
		}finally {
			common.close(connection, ps);
		}
		return result;
	}
	/**
	 * 반납전체조회를 위한 dao
	 * 모든 목록을 조회
	 * @return arr리스트
	 */
	
	public ArrayList<Rent_dto> getRentAllView(){
		ArrayList<Rent_dto> arr = new ArrayList<>();
		String query = " select no, member_id, book_no, to_char(rent_date,'yyyy-MM-dd'), to_char(return_date,'yyyy-MM-dd') from b13_rent ";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
			
				String no 		   = rs.getString(1);
				String member_id   = rs.getString(2);
				String book_no 	   = rs.getString(3);
				String rent_date   = rs.getString(4);
				String return_date = rs.getString(5);
				Rent_dto dto = new Rent_dto(no, member_id, book_no, rent_date, return_date);
				arr.add(dto);
			}
			
		}catch(SQLException se) {
			System.out.println(" getListCar() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" getListCar() 오류 ");
		}finally {
			common.close(connection, ps, rs);
		}
		return arr;
	}
	
	//렌트내역조회
/*	public Book_dto searchRentYN(String rentReturnName) {
		Book_dto dto = null;
		String query = " Select no, rent_gubun\r\n " + 
					   " from b13_book\r\n" + 
					   " where no = '"+rentReturnName+"' or name like '%"+rentReturnName+"%' ";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			if(rs.next()) {
				String no 		  = rs.getString(1);
				String rent_gubun = rs.getString(2);
				dto = new Book_dto(no,rent_gubun);
			}
			
		}catch(SQLException se) {
			System.out.println(" searchRentYN() query 오류~ : "+query);
		}catch(Exception e) {
			System.out.println(" searchRentYN() 오류 ~ : ");
		}finally {
			common.close(connection, ps);
		}
		return dto;
	}
*/
	

}