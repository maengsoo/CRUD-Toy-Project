package management;

import java.util.ArrayList;
import java.util.Scanner;

import common.Common;
import dao.Book_dao;
import dao.Rent_dao;
import dto.Book_dto;
import dto.Rent_dto;

public class ReturnManagement {
	
	public static void returned() {
		
		Scanner sc = new Scanner(System.in);
		Book_dao bookDao = new Book_dao();
		Rent_dao rentDao = new Rent_dao();

		
		int gubun = 0;
		
		do {
			System.out.println(" 반납 - 반납[1], 반납전체조회[2], 이전[0] ");
			gubun = sc.nextInt();
			
			//반납
			if(gubun == 1) {
				System.out.println("===반납페이지입니다===================");
				System.out.println(" 반납 할 책번호나 이름을 입력해주세요 ");
				System.out.println("==================================");
				String rentReturnName = sc.next();
				
				Book_dto dto = bookDao.getBookDataView(rentReturnName);
			
				if(dto == null) { 
					System.out.println(" 입력하신 정보가 존재하지 않습니다. "); 
					continue;
				}
				if(dto.getRent_gubun().equals("Y")) {
					System.out.println(" 반납 가능 하신 책이 아닙니다.");
					continue;
				}
				if(dto.getRent_gubun().equals("N")) {
					
					System.out.println(dto.getNo());
					System.out.println(dto.getName());
					System.out.println(dto.getPublisher());
					System.out.println(dto.getWriter());
					System.out.println(dto.getReg_date());
					System.out.println("==============================================");
					System.out.println("반납하시겠습니까? 예:Y 아니요:N");
					String updateGubun = sc.next();
					if(updateGubun.equals("Y") || updateGubun.equals("y") || updateGubun.equals("ㅛ")) {
						
						String rentDate = Common.getToday();
						int updateDate = 0;
						updateDate = rentDao.updateDate(rentDate,dto.getNo());
						
						//updateDate가 왜 1말고 다른숫자가 찍히는지 알아내기!
						if(updateDate != 0) {
							int updateBookYN = bookDao.updateYN(dto.getNo());
							
							if(updateBookYN == 1) System.out.println(" 반납 성공하셨습니다. ");
							if(updateBookYN == 0) System.out.println(" 반납 실패하셨습니다. ");
						}
					}
				}
			}
			
			//반납전체조회
			if(gubun == 2) {
				
				ArrayList<Rent_dto> arr = rentDao.getRentAllView();
				
				if(arr == null) System.out.println("목록이 존재하지 않습니다.");
				if(arr != null) {
					
					System.out.println("======================================================");
					System.out.println("no - member_id - book_no - rent_date - return_date");
					System.out.println("======================================================");
					
					for(int i = 0; i < arr.size(); i++) {
						System.out.print(arr.get(i).getNo()+"\t");
						System.out.print(arr.get(i).getMember_id()+"\t");
						System.out.print(arr.get(i).getBook_no()+"\t");
						System.out.print(arr.get(i).getRent_date()+"\t");
						System.out.print(arr.get(i).getReturn_date()+"\n");
					}
					System.out.println("======================================================");

				}
				
				
				
			}
			
		} while(gubun != 0);
	}
}
