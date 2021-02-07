package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.CarMember_dto;

public class CarMember_dao {
	
	
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//회원 조회_이름,회원등록번
	public ArrayList<CarMember_dto> getNameList (String gubun, String no){
		ArrayList<CarMember_dto> arr3 = new ArrayList();
		String query = "select id, name, address, tel, age, reg_date\r\n" + 
					" from b13_bookmember\r\n" + 
					" where	"+gubun+" like '%"+no+"%'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);
				String Name = rs.getString(2);
				String address = rs.getString(3);
				String tel = rs.getString(4);
				int age = rs.getInt(5);
				String regDate = rs.getString(6);
				
				
				CarMember_dto dto = new CarMember_dto(id,Name,address,tel,age,regDate);
				arr3.add(dto);
			}
		
			
			
		}catch(SQLException se) {
			System.out.println(" getNameList() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" getNameList() 오류 ");
		}finally {
			common.close(connection, ps, rs);
		}
		
		return arr3;
				
	}

	
	

}
