package management;

import java.util.Scanner;

import dao.Book_dao;
import dao.Member_dao;
import dao.Rent_dao;
import dto.Book_dto;
import dto.Rent_dto;

public class RentManagement {
	
	public static void rent() {

	Scanner sc 	         = new Scanner(System.in);
	Book_dao bookDao     = new Book_dao();
	Rent_dao rentDao     = new Rent_dao();
	Member_dao memberDao = new Member_dao();
		
	int gubun = 0;
	int ingYN = 0;
	String memberId = "";
		
	do {
		System.out.println(" 렌트 - 렌트[1], 이전[0]");
		gubun = sc.nextInt();
		
		//회원ID 조회
		if(gubun == 1) {
			do {
				System.out.println(" 회원 ID? ");
				memberId = sc.next();
				
				ingYN = memberDao.getCheckMemberId(memberId);
				if(ingYN == 0) System.out.println(" 회원 ID가 존재하지 않습니다 다시 입력해주세요 ");
				
			} while(ingYN == 0);
		}
		if(ingYN == 1) {
			
			System.out.println(" 도서번호나 도서명을 입력해주세요 ");
			String bookData = sc.next();
			
			Book_dto dto = bookDao.getBookDataView(bookData);
			
			if(dto == null) System.out.println(" 입력하신 정보가 존재 하지 않습니다 ");
			if(dto != null) {
				System.out.println(dto.getNo());
				System.out.println(dto.getName());
				System.out.println(dto.getPublisher());
				System.out.println(dto.getWriter());
				System.out.println(dto.getReg_date());
				System.out.println("==============================================");
				System.out.println("빌리시겠습니까? 예:Y 아니요:N");
				String updateGubun = sc.next();
				if(updateGubun.equals("Y") || updateGubun.equals("y") || updateGubun.equals("ㅛ")) {
					
					System.out.println(" 대여날짜  (yyyy-mm-dd?) ");
					String rentDate = sc.next();
					String rentNo = rentDao.getRentNo();
					
					Rent_dto rentDto = new Rent_dto(rentNo, memberId, dto.getNo(), rentDate, "");
					int result = rentDao.saveRent(rentDto);
					
					int updateResult = 0;
					if(result == 1) {
						updateResult = rentDao.setBookRentGubun(dto.getNo());
					}
					if(updateResult == 1) System.out.println(" 대여 성공하셨습니다. ");
					if(updateResult == 0) System.out.println(" 대여 실패하셨습니다. ");
					ingYN = 0;
				}
			}
		}
	} while(gubun != 0);
	}

}
