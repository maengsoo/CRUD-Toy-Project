package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.DBConnectionOracle;
import dto.Book_dto;


public class Book_dao {
	
	DBConnectionOracle common = new DBConnectionOracle ();
	Connection connection = null ;
	PreparedStatement ps = null ;
	ResultSet rs = null ;
	
	/**
	 * Create h13_book data
	 * 책 정보등록
	 * @param 책정보가 들어있는 dto
	 * @return 정상적으로 등록되면 1, 실패하면 0
	 */
	public int saveBook(Book_dto dto) {
		int result = 0;
		String query = " insert into b13_book \r\n " + 
				" (no, name, publisher, writer, reg_date, rent_gubun) \r\n " + 
				" VALUES \r\n " + 
				" ('"+dto.getNo()+"', '"+dto.getName()+"', '"+dto.getPublisher()+"', '"+dto.getWriter()+"', '"+dto.getReg_date()+"', '"+dto.getRent_gubun()+"')";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();//insert, update, delete 다가능 쿼리문만 변경해주면 
			
		}catch(SQLException se) {
			System.out.println(" saveBook() query 오류~ : "+query);
		}catch(Exception e) {
			System.out.println(" saveBook() 오류 ~ : ");
		}finally {
			common.close(connection, ps);
		}
		return result;
	}
	
	
	/**
	 * Read h13_book data
	 * 책 정보조회
	 * @param 정보를 조회 할 책이름이나 책번호
	 * @return 조회 된 dto
	 */
	public Book_dto getBookDataView(String book) {
		Book_dto dto = null;
		String query = " select no, name, publisher, writer, reg_date, rent_gubun \r\n " + 
				" from b13_book \r\n " + 
				" where no like '%"+book+"%' or name like '%"+book+"%'";
		
	    try {
            connection= common.getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()) {
               String nn = rs.getString("no");
               String name = rs.getString("name");
               String pulisher = rs.getString("publisher");
               String tel = rs.getString("writer");
               String reg_date = rs.getString("reg_date");
               String rent_gubun = rs.getString("rent_gubun");
               dto = new Book_dto(nn,name,pulisher,tel,reg_date,rent_gubun);
         }
         
      }catch(SQLException se) {
         System.out.println("getBookDataView() query 오류~" +query);
      }catch(Exception e) {
         System.out.println("getBookDataView() 오류");
      }finally {
          common.close(connection, ps, rs);
      }
       return dto;
	}
	
	/**
	 * Update h13_book data
	 * 수정 할 번호와 정보를 가져와서 수정 후 결과값 리턴
	 * @param no
	 * @param name
	 * @param publisher
	 * @param writer
	 * @param reg_date
	 * @return 정상처리됐으면 1, 실패하면 0
	 */
	public int updateBook(String no, String name, String publisher, String writer, String reg_date ) {
		int result = 0;
		String query = " update B13_BOOK \r\n " + 
				" SET NAME = '"+name+"', publisher = '"+publisher+"', writer = '"+writer+"', reg_date = '"+reg_date+"' \r\n " + 
				" WHERE NO = '"+no+"'";

		try {
            connection = common.getConnection();
            ps = connection.prepareStatement(query);
            result = ps.executeUpdate();
         }catch(SQLException se) {
            System.out.println(" updateBook() query 오류~~: " +query);
         }catch(Exception e) {
            System.out.println(" updateBook() 오류~~: ");
         }finally {
            common.close(connection, ps);
         }
		return result;
	}
	
	/**
	 * Delete h13_book data
	 * 책이름이나 번호를 가져와서 삭제
	 * @param book
	 * @return 성공하면 1, 실패하면 0 리턴
	 */
	public int deleteBook(String book) {
		int result = 0;
		String query = " delete from b13_book where no = '"+book+"' or name = '"+book+"' ";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();//insert, update, delete 다가능 쿼리문만 변경해주면 
			
		}catch(SQLException se) {
			System.out.println(" deleteBook() query 오류~ : "+query);
		}catch(Exception e) {
			System.out.println(" deleteBook() 오류 ~ : ");
		}finally {
			common.close(connection, ps);
		}
		return result;
	}
	
	
	public int updateYN(String book_no) {
		int result = 0;
		String query = " update b13_book set rent_gubun = 'Y' where no = '"+book_no+"' ";
		System.out.println(query);
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			result = ps.executeUpdate();//insert, update, delete 다가능 쿼리문만 변경해주면 
			
		}catch(SQLException se) {
			System.out.println(" updateYN() query 오류~ : "+query);
		}catch(Exception e) {
			System.out.println(" updateYN() 오류 ~ : ");
		}finally {
			common.close(connection, ps);
		}
		
		return result;
	}
}
