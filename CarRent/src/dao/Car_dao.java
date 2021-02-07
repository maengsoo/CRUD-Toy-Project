package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.DBConnectionOracle;
import dto.CarInfo_dto;

public class Car_dao {
	DBConnectionOracle common = new DBConnectionOracle();
	Connection connection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
		//등록
		public int saveCar(String no, String modelName, String carNumber, String carMade, String carMadeYm, 
				String autoYn, String optionYn, String accidentYn, String fuelType, String importDate) {
			int result = 0;
			String query = "insert into c13_car\r\n" + 
					"(no,model_name,car_number,car_made,car_made_ym,auto_yn,option_yn,accident_yn,fuel_type,import_date)\r\n" + 
					"values\r\n" + 
					"('"+no+"','"+modelName+"','"+carNumber+"','"+carMade+"','"+carMadeYm+"','"+autoYn+"','"+optionYn+"','"+accidentYn+"','"+fuelType+"','"+importDate+"')";
			
			
			try {
				connection = common.getConnection();
				ps = connection.prepareStatement(query);
				result = ps.executeUpdate();
				
				
				
			}catch(SQLException se) {
				System.out.println(" saveCar() query 오류 " + query);
			}catch(Exception e) {
				System.out.println(" saveCar() 오류 ");
			}finally {
				common.close(connection, ps);
			}
			
			return result;
		}	
		
		//조회
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
		
		//전체조회
		public ArrayList<CarInfo_dto> allView (){
			ArrayList<CarInfo_dto> arr = new ArrayList<>();
			String query = " select a.no, a.model_name, a.car_number, c.made_name, a.car_made_ym, a.auto_yn, a.option_yn, a.accident_yn, b.fuel_name, \r\n" + 
					" to_char(a.import_date,'yyyy-MM-dd'), a.rent_gubun \r\n" + 
					" from c13_car a, car_common_fuel b, car_common_made c \r\n" + 
					" where a.car_made = c.made_code and \r\n" + 
					" a.fuel_type = b.fuel_type \r\n";
			
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
		
		//수정조회 디버깅이유찾
		public CarInfo_dto getCarInfoView(String no) {
			CarInfo_dto dto = null;
			String query = " select no, model_name, car_number, car_made, car_made_ym, auto_yn, option_yn,  \n " + 
					"         accident_yn, fuel_type, to_char(import_date,'yyyy-MM-dd'), rent_gubun  \n " + 
					"  from C13_CAR \n " + 
					" where NO = '"+no+"'";
			
			try {
	            connection= common.getConnection();
	            ps = connection.prepareStatement(query);
	            rs = ps.executeQuery();
	            
	            while(rs.next()) {
	               String nn = rs.getString("no");
	               String name = rs.getString("model_name");
	               String number = rs.getString("car_number");
	               String made = rs.getString("car_made");
	               String madeYn = rs.getString("car_made_ym");
	               String auto = rs.getString("auto_yn");
	               String option = rs.getString("option_yn");
	               String accident = rs.getString("accident_yn");
	               String fuel = rs.getString("fuel_type");
	               String impor = rs.getString("to_char(import_date,'yyyy-MM-dd')");
	               String rent_gubun = rs.getString("rent_gubun");
	               dto = new CarInfo_dto(nn, name, number, made, madeYn, auto,
	            		   				 option, accident, fuel, impor, rent_gubun);
	               
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
		
		//수정
		public int updateCarInfo(String no, String modelName, String carNumber, String carMade, String carMadeYm, 
				String autoYn, String optionYn, String accidentYn, String fuelType, String importDate) {
			int result = 0;
			String query = " UPDATE  C13_car \n " + 
					" SET  model_name = '"+modelName+"', car_number = '"+carNumber+"', car_made = '"+carMade+"', car_made_ym = '"+carMadeYm+"', auto_yn = '"+autoYn+"',  \n " + 
					"        option_yn = '"+optionYn+"', accident_yn = '"+accidentYn+"', fuel_type = '"+fuelType+"', import_date = '"+importDate+"' \n " + 
					" where no = '"+no+"'";
			
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
		
		//삭제
		public int deledeCarInfo(String no) {
			int result = 0;
			
			String query = "delete from C13_CAR where no = '"+no+"'";
			
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
	
	

}
