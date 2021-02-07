package main;

import java.util.ArrayList;
import java.util.Scanner;

import dao.CarMember_dao;
import dao.CarRent_dao;
import dao.Car_dao;
import dto.CarInfo_dto;
import dto.CarMember_dto;
import dto.CarRent_dto;


public class CarRent {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Car_dao carDao = new Car_dao();
		CarRent_dao rentDao = new CarRent_dao();
		CarMember_dao memberDao = new CarMember_dao();
		
		int workGubun = 0;
		
		do {
			System.out.println("===main==============================================================================================");
			System.out.println(" 차량 - 관리[1]  렌트[2]  회원[3]    시스템종료[0] ");
			System.out.println("=====================================================================================================");
 			workGubun = sc.nextInt();
 			if (workGubun == 1) {
 				int gubun = 0;
 				do {
 					System.out.println("===관리===============================================================================================");
 					System.out.println(" 차량 조회[1], 차량 등록[2], 차량정보 수정[3], 차량정보 삭제[4], 이전[0] ");
 					System.out.println("=====================================================================================================");
 					gubun = sc.nextInt();
 					//조회
 					if(gubun == 1) {
 						System.out.println("===조회===============================================================================================");
 						System.out.println(" 차량번호로 조회[1], 제조사로 조회[2], 모델명으로 조회[3], 전체조회[9], 종료[0]");
 						System.out.println("=====================================================================================================");
 						int searchGubun = sc.nextInt();
 						
 						do {
 							if(searchGubun == 1) {
 								System.out.println(" 차량번호를 입력해시오 (00가0000) ");
 								System.out.print(" 입력 : ");
 								String carNumber = sc.next();
 								ArrayList<CarInfo_dto> arr = carDao.getListCar("a.car_number", carNumber);
 								
 								System.out.println("=====================================================================================================");
 								System.out.println("등록번호\t차럄이름\t차량번호\t제조사\t연식\t자동/수동\t풀옵/기본\t사고이력\t연료\t입고날짜");
 								System.out.println("-----------------------------------------------------------------------------------------------------");
 								
 								for(int k = 0; k < arr.size(); k++) {
 	 								System.out.print(arr.get(k).getNo()+"\t");
 	 								System.out.print(arr.get(k).getModel_name()+"\t");
 	 								System.out.print(arr.get(k).getCar_number()+"\t");
 	 								System.out.print(arr.get(k).getCar_made()+"\t");
 	 								System.out.print(arr.get(k).getCar_made_yn()+"\t");
 	 								System.out.print(arr.get(k).getAuto_yn()+"\t");
 	 								System.out.print(arr.get(k).getOption_yn()+"\t");
 	 								System.out.print(arr.get(k).getAccident_yn()+"\t");
 	 								System.out.print(arr.get(k).getFuel_type()+"\t");
 	 								System.out.print(arr.get(k).getImport_date()+"\t");
 	 								System.out.print(arr.get(k).getRent_gubun()+"\n");
 	 							}
 	 							break;
 	 							
 							}else if(searchGubun == 2) {
 	 							System.out.println(" 제조사를 입력하시오. 현대[10]  기아[20]  르노삼성[30]  쌍용[40]  쉐보레[50]  벤츠[60]  BMW[70]  아우디[80]  테슬라[90]");
 	 							String carMade = sc.next();
 	 							ArrayList<CarInfo_dto> arr = carDao.getListCar("car_made", carMade);
 	 							
 	 							System.out.println("=====================================================================================================");
 	 							System.out.println("등록번호\t차럄이름\t차량번호\t제조사\t연식\t자동/수동\t풀옵/기본\t사고이력\t연료\t입고날짜");
 	 							System.out.println("-----------------------------------------------------------------------------------------------------");
 	 							
 	 							for(int k = 0; k < arr.size(); k++) {
 	 								System.out.print(arr.get(k).getNo()+"\t");
 	 								System.out.print(arr.get(k).getModel_name()+"\t");
 	 								System.out.print(arr.get(k).getCar_number()+"\t");
 	 								System.out.print(arr.get(k).getCar_made()+"\t");
 	 								System.out.print(arr.get(k).getCar_made_yn()+"\t");
 	 								System.out.print(arr.get(k).getAuto_yn()+"\t");
 	 								System.out.print(arr.get(k).getOption_yn()+"\t");
 	 								System.out.print(arr.get(k).getAccident_yn()+"\t");
 	 								System.out.print(arr.get(k).getFuel_type()+"\t");
 	 								System.out.print(arr.get(k).getImport_date()+"\t");
 	 								System.out.print(arr.get(k).getRent_gubun()+"\n");
 	 							}
 	 							break;
 	 							
 	 						}else if(searchGubun == 3) {
 	 							System.out.println(" 모델명을 입력하시오. ");
 	 							String modelName = sc.next();
 	 							ArrayList<CarInfo_dto> arr = carDao.getListCar("model_name", modelName);
 	 							
 	 							System.out.println("=====================================================================================================");
 	 							System.out.println("등록번호\t차럄이름\t차량번호\t제조사\t연식\t자동/수동\t풀옵/기본\t사고이력\t연료\t입고날짜");
 	 							System.out.println("-----------------------------------------------------------------------------------------------------");
 	 							
 	 							for(int k = 0; k < arr.size(); k++) {
 	 								System.out.print(arr.get(k).getNo()+"\t");
 	 								System.out.print(arr.get(k).getModel_name()+"\t");
 	 								System.out.print(arr.get(k).getCar_number()+"\t");
 	 								System.out.print(arr.get(k).getCar_made()+"\t");
 	 								System.out.print(arr.get(k).getCar_made_yn()+"\t");
 	 								System.out.print(arr.get(k).getAuto_yn()+"\t");
 	 								System.out.print(arr.get(k).getOption_yn()+"\t");
 	 								System.out.print(arr.get(k).getAccident_yn()+"\t");
 	 								System.out.print(arr.get(k).getFuel_type()+"\t");
 	 								System.out.print(arr.get(k).getImport_date()+"\t");
 	 								System.out.print(arr.get(k).getRent_gubun()+"\n");
 	 							}
 	 							break;
 	 							
 	 						}else if(searchGubun == 9) {
 	 							ArrayList<CarInfo_dto> arr = carDao.allView();
 	 							System.out.println("=====================================================================================================");
 	 							System.out.println("등록번호\t차럄이름\t차량번호\t제조사\t연식\t자동/수동\t풀옵/기본\t사고이력\t연료\t입고날짜");
 	 							System.out.println("-----------------------------------------------------------------------------------------------------");
 	 							
 	 							for(int k = 0; k < arr.size(); k++) {
 	 								System.out.print(arr.get(k).getNo()+"\t");
 	 								System.out.print(arr.get(k).getModel_name()+"\t");
 	 								System.out.print(arr.get(k).getCar_number()+"\t");
 	 								System.out.print(arr.get(k).getCar_made()+"\t");
 	 								System.out.print(arr.get(k).getCar_made_yn()+"\t");
 	 								System.out.print(arr.get(k).getAuto_yn()+"\t");
 	 								System.out.print(arr.get(k).getOption_yn()+"\t");
 	 								System.out.print(arr.get(k).getAccident_yn()+"\t");
 	 								System.out.print(arr.get(k).getFuel_type()+"\t");
 	 								System.out.print(arr.get(k).getImport_date()+"\t");
 	 								System.out.print(arr.get(k).getRent_gubun()+"\n");
 	 							}
 	 							break;
 	 							
 	 							
 	 						}
 							
 							
 						}while(searchGubun != 0);
 					//등록
 					}else if(gubun == 2) {
 						
 						System.out.println("===등록 페이지=============================================================================================");
 						
 						System.out.println(" 등록할 차량의 등록번호를 입력하시오. ");
 						String no = sc.next();
 					
 						System.out.println(" 등록할 차량의 모델명을 입력하시오. ");
 						String modelName = sc.next();
 						
 						System.out.println(" 등록할 차량의 번호를 입력하시오.(00가0000) ");
 						String carNumber = sc.next();
 						
 						System.out.println(" 등록할 차량의 제조사를 입력하시오. 현대[10]  기아[20]  르노삼성[30]  쌍용[40]  쉐보레[50]  벤츠[60]  BMW[70]  아우디[80]  테슬라[90] ");
 						String carMade = sc.next();
 						
 						System.out.println(" 등록할 차량의 연식를 입력하시오.(yyyymm) ");
 						String carMadeYm = sc.next();
 						
 						System.out.println(" 등록할 차량은 자동인가요? 스틱인가요? 자동[Y] 스틱[N] ");
 						String autoYn = sc.next();
 						
 						System.out.println(" 등록할 차량은 풀옵션인가요? 일반 옵션인가요? 풀옵션[Y] 일반옵션[N] ");
 						String optionYn = sc.next();
 						
 						System.out.println(" 등록할 차량의 사고이력 여부를 입력하시오. 있으면[Y] 없으면[N] ");
 						String accidentYn = sc.next();
 						
 						System.out.println(" 등록할 차량의 연료는 무엇입니까? 가솔린[1]  디젤[2]  LPG[3]  전기[4]  ");
 						String fuelType = sc.next();
 						
 						System.out.println(" 등록할 차량의 입고 날짜를 입력하시오.(yyyy-mm-dd) ");
 						String importDate = sc.next();
 						
 						System.out.println("==================================================================================================");
 						
 						int result = carDao.saveCar(no,modelName,carNumber,carMade,carMadeYm,autoYn,optionYn,accidentYn,fuelType,importDate);
 						
 						if(result == 1) {
 							System.out.println(" 등록 완료 ");
 						}else {
 							System.out.println(" 등록 실패 ");
 						}
 						
 					//수정
 					}else if(gubun == 3) {
 						System.out.println("수정 할 등록번호를 입력하시오");
 						System.out.println("ex.(C001) 입력 : ");
 						String no = sc.next();
 						CarInfo_dto dto = carDao.getCarInfoView(no);
// 						System.out.println(no);
// 						ArrayList<CarInfo_dto> arr = dao.getListCar("no", no);
// 						
// 						System.out.println("등록번호\t차럄이름\t차량번호\t제조사\t연식\t자동/수동\t풀옵/기본\t사고이력\t연료\t입고날짜");
// 						System.out.print("============================================================================");
// 						
// 						for(int k = 0; k < arr.size(); k++) {
//								System.out.print(arr.get(k).getNo()+"\t");
//								System.out.print(arr.get(k).getModel_name()+"\t");
//								System.out.print(arr.get(k).getCar_number()+"\t");
//								System.out.print(arr.get(k).getCar_made()+"\t");
//								System.out.print(arr.get(k).getCar_made_yn()+"\t");
//								System.out.print(arr.get(k).getAuto_yn()+"\t");
//								System.out.print(arr.get(k).getOption_yn()+"\t");
//								System.out.print(arr.get(k).getAccident_yn()+"\t");
//								System.out.print(arr.get(k).getFuel_type()+"\t");
//								System.out.print(arr.get(k).getImport_date()+"\t");
//								System.out.print(arr.get(k).getRent_gubun()+"\n");
//							}
//							break;
// 						
 					if(dto == null) {
 						System.out.println(no+" 수정 할 정보가 존재하지 않습니다 ");
 					}else {
 						System.out.println("===수정 페이지==============================================================================================");
 						System.out.println("등록번호\t차럄이름\t차량번호\t제조사\t연식\t자동/수동\t풀옵/기본\t사고이력\t연료\t입고날짜\t대여가능");
 						System.out.println("---------------------------------------------------------------------------------------------------------"); 						
 						System.out.print(dto.getNo()+"\t");
 						System.out.print(dto.getModel_name()+"\t");
 						System.out.print(dto.getCar_number()+"\t");
 						System.out.print(dto.getCar_made()+"\t");
 						System.out.print(dto.getCar_made_yn()+"\t");
 						System.out.print(dto.getAuto_yn()+"\t");
 						System.out.print(dto.getOption_yn()+"\t");
 						System.out.print(dto.getAccident_yn()+"\t");
 						System.out.print(dto.getFuel_type()+"\t");
 						System.out.print(dto.getImport_date()+"\t");
 						System.out.print(dto.getRent_gubun()+"\n");
 						
 						System.out.println("=========================================================================================================");
						System.out.println("수정하시겠습니까? 예:Y 아니요:N");
						String updateGubun = sc.next();
						
						if(updateGubun.equals("Y") || updateGubun.equals("y") || updateGubun.equals("ㅛ")) {
							
							no = dto.getNo();
							
							System.out.println("===수정 페이지======================================================================================");
							
							System.out.print("( 모델명 )"+dto.getModel_name()+"\t -> : ");
							String name = sc.next();
	 						System.out.print("( 차넘버 )"+dto.getCar_number()+"\t -> : ");
	 						String number = sc.next();
	 						System.out.println(" 현대[10]  기아[20]  르노삼성[30] ");
	 						System.out.println(" 쌍용[40]  쉐보레[50]  벤츠[60] ");
	 						System.out.println(" BMW[70]  아우디[80]  테슬라[90] ");
	 						System.out.print("( 제조사 )"+dto.getCar_made()+"\t -> : ");
	 						String made = sc.next();
	 						System.out.print("(연식 ex(200101)) "+dto.getCar_made_yn()+"\t -> : ");
	 						String made_yn = sc.next();
	 						System.out.print("( 자동 : Y 수동 : N ) "+ dto.getAuto_yn()+"\t -> : ");
	 						String auto_yn = sc.next();
	 						System.out.print("( 옵션 : Y 옵션x : N ) "+dto.getOption_yn()+"\t -> : ");
	 						String option = sc.next();
	 						System.out.print("( 무사고 : Y 사고 : N ) "+dto.getAccident_yn()+"\t -> : ");
	 						String accident = sc.next();
	 						System.out.println(" 가솔린[1]  디젤[2]  LPG[3]  전기[4] ");
	 						System.out.print("( 연료 ) "+dto.getFuel_type()+"\t -> : ");
	 						String fuel = sc.next();
	 						System.out.print("( 입고날짜 ) "+dto.getImport_date()+"\t -> : ");
	 						String impor = sc.next();
	 						
	 						int result = carDao.updateCarInfo(no, name, number, made, made_yn, auto_yn, option, accident, fuel, impor);
	 							
	 							if(result ==1) {
		                        	System.out.println("===수정완료===================");
		                         }else {
		                        	System.out.println("===수정오류==================="); 
		                         }
							
						}
 					} 
 						
 					//삭제
 					}else if(gubun == 4) {
 						System.out.println("삭제 할 등록번호를 입력하시오");
 						System.out.println("ex.(C001) 입력 : ");
 						String no = sc.next();
 						CarInfo_dto dto = carDao.getCarInfoView(no);
 						
 						if(dto == null) {
							System.out.println(" 등록번호 "+no+"\t삭제 할 정보가 존재하지 않습니다");
						}else {
							System.out.println("===삭제 페이지===================================================================================================");
							System.out.println("등록번호\t차럄이름\t차량번호\t제조사\t연식\t자동/수동\t풀옵/기본\t사고이력\t연료\t입고날짜\t대여가능");
							System.out.println("--------------------------------------------------------------------------------------------------------------");	 						System.out.print(dto.getNo()+"\t");
	 						System.out.print(dto.getModel_name()+"\t");
	 						System.out.print(dto.getCar_number()+"\t");
	 						System.out.print(dto.getCar_made()+"\t");
	 						System.out.print(dto.getCar_made_yn()+"\t");
	 						System.out.print(dto.getAuto_yn()+"\t");
	 						System.out.print(dto.getOption_yn()+"\t");
	 						System.out.print(dto.getAccident_yn()+"\t");
	 						System.out.print(dto.getFuel_type()+"\t");
	 						System.out.print(dto.getImport_date()+"\t");
	 						System.out.print(dto.getRent_gubun()+"\n");
	 						
	 						System.out.println("==============================================================================================================");
							System.out.println("삭제하시겠습니까? 예:Y 아니요:N");
							String updateGubun = sc.next();
							
							if(updateGubun.equals("Y") || updateGubun.equals("y") || updateGubun.equals("ㅛ")) {
								
								int result = carDao.deledeCarInfo(no);
								
								if(result ==1) {
		                        	System.out.println("=====삭제완료=================");
		                         }else {
		                        	System.out.println("=====삭제오류================="); 
		                         }
								
							}
							
						}
 						
 					}
 					
 					
 					
 					
 					
 				}while(gubun != 0);
 			//대여
 			}else if(workGubun  == 2) {
 				
 				System.out.println(" 대여[1], 반납[2], 이력[3] 이전[0]");
 				int gubun = sc.nextInt();
 				
 				
 				
 				
 				do {
 				
 				if(gubun ==1) {
 				
 				System.out.println("===대여가능차량==========================================================================================");
 					
 				String yn = "y";
 				
 					ArrayList<CarInfo_dto> arr = rentDao.rentAllView(yn);
 					ArrayList<CarRent_dto> arr1 = new ArrayList<>();
					System.out.println("등록번호\t차럄이름\t차량번호\t제조사\t연식\t자동/수동\t풀옵/기본\t사고이력\t연료\t입고날짜\t대여가능여부");
					System.out.println("-----------------------------------------------------------------------------------------------------");
					
					for(int k = 0; k < arr.size(); k++) {
						System.out.print(arr.get(k).getNo()+"\t");
						System.out.print(arr.get(k).getModel_name()+"\t");
						System.out.print(arr.get(k).getCar_number()+"\t");
						System.out.print(arr.get(k).getCar_made()+"\t");
						System.out.print(arr.get(k).getCar_made_yn()+"\t");
						System.out.print(arr.get(k).getAuto_yn()+"\t");
						System.out.print(arr.get(k).getOption_yn()+"\t");
						System.out.print(arr.get(k).getAccident_yn()+"\t");
						System.out.print(arr.get(k).getFuel_type()+"\t");
						System.out.print(arr.get(k).getImport_date()+"\t");
						System.out.print(arr.get(k).getRent_gubun()+"\n");
					}
					 
					
					System.out.println("=====================================================================================================");
					
					System.out.println(" 대여시겠습니까? 대여[1], 이전[0]");
					int rentGubun = sc.nextInt();
					
					if(rentGubun == 1) {
					System.out.println(" 어떤차량을 대여하시겠습니다? ");
					System.out.print(" 등록번호를 입력해주시오 :  ");
					String no = sc.next();
					
					 arr = rentDao.getListCar("no", no);
					
					System.out.println("=====================================================================================================");
						System.out.println("등록번호\t차럄이름\t차량번호\t제조사\t연식\t자동/수동\t풀옵/기본\t사고이력\t연료\t입고날짜\t대여가능여부");
						System.out.println("-----------------------------------------------------------------------------------------------------");
						
						for(int k = 0; k < arr.size(); k++) {
							System.out.print(arr.get(k).getNo()+"\t");
							System.out.print(arr.get(k).getModel_name()+"\t");
							System.out.print(arr.get(k).getCar_number()+"\t");
							System.out.print(arr.get(k).getCar_made()+"\t");
							System.out.print(arr.get(k).getCar_made_yn()+"\t");
							System.out.print(arr.get(k).getAuto_yn()+"\t");
							System.out.print(arr.get(k).getOption_yn()+"\t");
							System.out.print(arr.get(k).getAccident_yn()+"\t");
							System.out.print(arr.get(k).getFuel_type()+"\t");
							System.out.print(arr.get(k).getImport_date()+"\t");
							System.out.print(arr.get(k).getRent_gubun()+"\n");
						}
						
 						System.out.println("=========================================================================================================");
						System.out.println("대여하시겠습니까? 예:Y 아니요:N");
						String updateGubun = sc.next();
						
						if(updateGubun.equals("Y") || updateGubun.equals("y") || updateGubun.equals("ㅛ")) {
							System.out.println("-----------------------------------------------------------------------------------------------------");
							int result = rentDao.updateCarRentYn(no);
							String rent_no = "";
							
							
							
								arr1 = rentDao.getCarListRent();
									if (arr1.size() == 0) {
										rent_no = "R0001";
									} else {
										rent_no = rentDao.selectDBNo();
										rent_no = rentDao.getNo(rent_no);
									}
									
									System.out.println(" 고객정보를 입력해주시오. ");
									System.out.println(" 고객번호 또는 성함으로 조회 가능합니다.");
									System.out.println(" 고객번호로 조회 후 대여[1], 성함으로 조회 후 대여[2] ");
									int gubun1 = sc.nextInt();
									
									String member_no = "";
									
									if(gubun1 == 1) {
										System.out.println(" 고객번호를 입력해주시오. ");
										String id = sc.next();
										ArrayList<CarMember_dto> memberArr = memberDao.getNameList("id", id);
										
										System.out.println("=====================================================================================================");
										System.out.println("고객번호\t이름\t주소\t전화번호\t나이\t가입날짜");
										System.out.println("-----------------------------------------------------------------------------------------------------");
										
		 	 							for(int k = 0; k < memberArr.size(); k++) {
		 	 								System.out.print(memberArr.get(k).getId()+"\t");
		 	 								System.out.print(memberArr.get(k).getName()+"\t");
		 	 								System.out.print(memberArr.get(k).getAddress()+"\t");
		 	 								System.out.print(memberArr.get(k).getTel()+"\t");
		 	 								System.out.print(memberArr.get(k).getAge()+"\t");
		 	 								System.out.print(memberArr.get(k).getReg_date()+"\n");
		 	 							
		 	 								member_no = memberArr.get(k).getId();
		 	 							}
		 	 							
		 	 						System.out.println(" 고객정보가 맞으신가요? ");
		 	 						
		 	 							
		 	 							
									} else if (gubun1 == 2 ) {
										System.out.println(" 고객성함을 입력해주시오. ");
										String name = sc.next();
										ArrayList<CarMember_dto> memberArr = memberDao.getNameList("name", name);
										
										System.out.println("=====================================================================================================");
										System.out.println("고객번호\t이름\t주소\t전화번호\t나이\t가입날짜");
										System.out.println("-----------------------------------------------------------------------------------------------------");
										
		 	 							for(int k = 0; k < memberArr.size(); k++) {
		 	 								System.out.print(memberArr.get(k).getId()+"\t");
		 	 								System.out.print(memberArr.get(k).getName()+"\t");
		 	 								System.out.print(memberArr.get(k).getAddress()+"\t");
		 	 								System.out.print(memberArr.get(k).getTel()+"\t");
		 	 								System.out.print(memberArr.get(k).getAge()+"\t");
		 	 								System.out.print(memberArr.get(k).getReg_date()+"\n");
		 	 								
		 	 								member_no = memberArr.get(k).getId();
		 	 							}
		 	 							
		 	 						System.out.println(" 고객정보가 맞으신가요? ");
										
										
									}
									
									
									
									
									System.out.println(" 언제부터 빌리시겠습니까? ");
									System.out.println(" ex) 2020-01-01 : ");
									String rent_date = sc.next();
									
									System.out.println("-----------------------------------------------------------------------------------------------------");
									
									System.out.println(" 언제까지 반납하시겠습니까? ");
									System.out.println(" ex) 2020-01-01 : ");
									String return_day = sc.next();
									
									String return_date = "";
									
									int result1 = rentDao.saveCarRent(rent_no, member_no, no, rent_date, return_day, return_date);
									
									
									if(result1 ==1) {
			                        	System.out.println("=====삽입완료=================");
			                         }else {
			                        	System.out.println("=====삽입오류================="); 
			                         }
							
							if(result ==1) {
	                        	System.out.println("=====대여완료=================");
	                         }else {
	                        	System.out.println("=====대여오류================="); 
	                         }
							
						}
						
					}
					
 				}
 				}while(gubun != 0);
					
 				
 				
 			}else if(workGubun  == 3) {
 				
 				int gubun = 0;
 				
 				do {
 	 				System.out.println("===반납가능차량==========================================================================================");
 	 				
 	 				String yn = "n";
 	 				
 					ArrayList<CarInfo_dto> arr = rentDao.rentAllView(yn);
 					ArrayList<CarRent_dto> arr1 = new ArrayList<>();
					System.out.println("등록번호\t차럄이름\t차량번호\t제조사\t연식\t자동/수동\t풀옵/기본\t사고이력\t연료\t입고날짜\t대여가능여부");
					System.out.println("-----------------------------------------------------------------------------------------------------");
					
					for(int k = 0; k < arr.size(); k++) {
						System.out.print(arr.get(k).getNo()+"\t");
						System.out.print(arr.get(k).getModel_name()+"\t");
						System.out.print(arr.get(k).getCar_number()+"\t");
						System.out.print(arr.get(k).getCar_made()+"\t");
						System.out.print(arr.get(k).getCar_made_yn()+"\t");
						System.out.print(arr.get(k).getAuto_yn()+"\t");
						System.out.print(arr.get(k).getOption_yn()+"\t");
						System.out.print(arr.get(k).getAccident_yn()+"\t");
						System.out.print(arr.get(k).getFuel_type()+"\t");
						System.out.print(arr.get(k).getImport_date()+"\t");
						System.out.print(arr.get(k).getRent_gubun()+"\n");
					}
					 
					
					System.out.println("=====================================================================================================");
					
					System.out.println(" 반납하시겠습니까? 반납[1], 이전[0]");
					gubun = sc.nextInt();
					
					if(gubun == 1) {
					System.out.println(" 어떤차량을 반납ㄴ하시겠습니다? ");
					System.out.print(" 등록번호를 입력해주시오 :  ");
					String no = sc.next();
					
					 arr = rentDao.getListCar("no", no);
					
					System.out.println("=====================================================================================================");
						System.out.println("등록번호\t차럄이름\t차량번호\t제조사\t연식\t자동/수동\t풀옵/기본\t사고이력\t연료\t입고날짜\t대여가능여부");
						System.out.println("-----------------------------------------------------------------------------------------------------");
						
						for(int k = 0; k < arr.size(); k++) {
							System.out.print(arr.get(k).getNo()+"\t");
							System.out.print(arr.get(k).getModel_name()+"\t");
							System.out.print(arr.get(k).getCar_number()+"\t");
							System.out.print(arr.get(k).getCar_made()+"\t");
							System.out.print(arr.get(k).getCar_made_yn()+"\t");
							System.out.print(arr.get(k).getAuto_yn()+"\t");
							System.out.print(arr.get(k).getOption_yn()+"\t");
							System.out.print(arr.get(k).getAccident_yn()+"\t");
							System.out.print(arr.get(k).getFuel_type()+"\t");
							System.out.print(arr.get(k).getImport_date()+"\t");
							System.out.print(arr.get(k).getRent_gubun()+"\n");
						}
						
 						System.out.println("=========================================================================================================");
						System.out.println("반납하시겠습니까? 예:Y 아니요:N");
						String updateGubun = sc.next();
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
					}
					
					
 					
 					
 					
 					
 				}while(gubun != 0);
 				
 			}else if(workGubun  == 4) {
 				
 			}
 			
			
			
			
		}while(workGubun != 0 );
		
		
		

	}

}
