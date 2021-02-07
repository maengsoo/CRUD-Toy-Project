package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.CarInfo_dto;
import dto.CarRent_dto;

public class CarRent_dao {
	
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	//렌트가능전체조회
	public ArrayList<CarInfo_dto> rentAllView (String yn){
		ArrayList<CarInfo_dto> arr = new ArrayList<>();
		String query = " select a.no, a.model_name, a.car_number, c.made_name, a.car_made_ym, a.auto_yn, a.option_yn, a.accident_yn, b.fuel_name,\n " + 
				"					to_char(a.import_date,'yyyy-MM-dd'), a.rent_gubun  \n " + 
				"					from c13_car a, car_common_fuel b, car_common_made c \n " + 
				"					where a.car_made = c.made_code and \n" + 
				"					a.fuel_type = b.fuel_type and a.rent_gubun = '"+yn+"' ";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString(1);
				String modelName = rs.getString(2);
				String carNumber = rs.getString(3);
				String carMade = rs.getString(4);
				String carMadeYm = rs.getString(5);
				String autoYn = rs.getString(6);
				String optionYn = rs.getString(7);
				String accidentYn = rs.getString(8);
				String fuelType = rs.getString(9);
				String importDate = rs.getString(10);
				String rentGubun = rs.getString(11);
				
				CarInfo_dto dto = new CarInfo_dto(no,modelName,carNumber,carMade,carMadeYm,autoYn,optionYn,accidentYn,
						fuelType,importDate,rentGubun);
				arr.add(dto);
			}
			

			
			
		}catch(SQLException se) {
			System.out.println(" allView() query 오류 " + query);
		}catch(Exception e) {
			System.out.println(" allView() 오류 ");
		}finally {
			common.close(connection, ps, rs);
		}
		
		
		
		return arr;
	}
	
	//등로번호로 조회
	public ArrayList<CarInfo_dto> getListCar (String gubun, String work){
		ArrayList<CarInfo_dto> arr = new ArrayList<>();
		String query = " select a.no, a.model_name, a.car_number, c.made_name, a.car_made_ym, a.auto_yn, a.option_yn, a.accident_yn, b.fuel_name,\r\n" + 
				"to_char(a.import_date,'yyyy-MM-dd'), a.rent_gubun\r\n" + 
				"from c13_car a, car_common_fuel b, car_common_made c\r\n" + 
				"where a.car_made = c.made_code and\r\n" + 
				"a.fuel_type = b.fuel_type and\r\n" + 
				""+gubun+" like '%"+work+"%'";
		
		try {
			connection = common.getConnection();
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString(1);
				String modelName = rs.getString(2);
				String carNumber = rs.getString(3);
				String carMade = rs.getString(4);
				String carMadeYm = rs.getString(5);
				String autoYn = rs.getString(6);
				String optionYn = rs.getString(7);
				String accidentYn = rs.getString(8);
				String fuelType = rs.getString(9);
				String importDate = rs.getString(10);
				String rentGubun = rs.getString(11);
				
				CarInfo_dto dto = new CarInfo_dto(no,modelName,carNumber,carMade,carMadeYm,autoYn,optionYn,accidentYn,
						fuelType,importDate,rentGubun);
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
	
	//수정
	public int updateCarRentYn(String no) {
		int result = 0;
		String query = " UPDATE C13_CAR set rent_gubun = 'n' where no = '"+no+"' ";
		
		try {
            connection = common.getConnection();
            ps = connection.prepareStatement(query);
            result = ps.executeUpdate();
         }catch(SQLException se) {
            System.out.println(" updateCarRentYn() query 오류~~: " +query);
         }catch(Exception e) {
            System.out.println(" updateCarRentYn() 오류~~: ");
         }finally {
            common.close(connection, ps);
         }
		
		
		
		return result;
	}
	
	//번호 추가 메소드
			public String getNo(String no) {
				DecimalFormat df = new DecimalFormat("000");
				String cutno = no.substring(1);
				int pulsNo = Integer.parseInt(cutno)+1;
				String result = "R"+df.format(pulsNo);
				return result;
			}
			
			//no에서 가장 큰 번호만 조회
	String query="";
			public String selectDBNo() {
				String result = "";
				 query = "select max(rent_no) from c13_carrent";
				try {
					connection = common.getConnection();
					ps = connection.prepareStatement(query);
					rs = ps.executeQuery();
					
					while(rs.next()) {
						String no = rs.getNString(1);
						result = no;
						
					}
				}catch(SQLException se){
					System.out.println(" insertDBNo() query error~ " + query);
				}catch(Exception e) {
					System.out.println(" insertDBNo() error  ~ : ");
				}finally {
					common.close(connection, ps, rs);
				}
				
				return result;
			}
		//카렌트조회	
		public ArrayList<CarRent_dto> getCarListRent(){
			ArrayList<CarRent_dto> arr = new ArrayList<>();
			String query = " select * from C13_CARRENT ";
			
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					
					String rent_no = rs.getString(1);
					String member_no = rs.getString(2);
					String car_no = rs.getString(3);
					String rent_date = rs.getString(4);
					String return_day = rs.getString(5);
					String return_date = rs.getString(6);
					
					
					CarRent_dto dto = new CarRent_dto(rent_no,member_no,car_no,rent_date,return_day,return_date);
					arr.add(dto);
				}
				

				
				
			}catch(SQLException se) {
				System.out.println(" allView() query 오류 " + query);
			}catch(Exception e) {
				System.out.println(" allView() 오류 ");
			}finally {
				common.close(connection, ps, rs);
			}
			
			
			
			return arr;
		}
		
		//등록
		public int saveCarRent(String rent_no, String member_no, String car_no, String rent_date, String return_day, String return_date) {
			int result = 0;
			String query = " insert into C13_CARRENT(rent_no, member_no, car_no, rent_date, return_day, return_date) VALUES ('"+rent_no+"', '"+member_no+"','"+car_no+"','"+rent_date+"', '"+return_day+"', '"+return_date+"') ";
			
			
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				result = ps.executeUpdate();
				
				
				
			}catch(SQLException se) {
				System.out.println(" saveCarRent() query 오류 " + query);
			}catch(Exception e) {
				System.out.println(" saveCarRent() 오류 ");
			}finally {
				common.close(connection, ps);
			}
			
			return result;
		}	

}
