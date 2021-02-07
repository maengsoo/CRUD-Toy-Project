package management;

import java.util.Scanner;

import dao.Book_dao;
import dto.Book_dto;

public class BookManagement {
	
	public static void book() {
		
		Scanner sc 	   = new Scanner(System.in);
		Book_dao dao  = new Book_dao();

		int gubun = 0;
		
		do {
		System.out.println("도서 - 조회[1], 등록[2], 수정[3], 삭제[4], 이전[0]");
		gubun = sc.nextInt();
		
			//도서조회
			if(gubun == 1) {
				System.out.println(" 조회하실 도서번호나 도서명을 입력해주시오 : ");
				String book = sc.next();
				
				Book_dto dto = dao.getBookDataView(book);
				
				if(dto == null) System.out.println(book+" 검색하신 정보가 존재하지 않습니다");
				if(dto != null) {
					System.out.println("책번호 : "+dto.getNo());
					System.out.println("책이름 : "+dto.getName());
					System.out.println("출판사 : "+dto.getPublisher());
					System.out.println("저자명 : "+dto.getWriter());
					System.out.println("등록날짜 : "+dto.getReg_date());
					System.out.println("대여가능여부 : "+dto.getRent_gubun());
				}
			}
			
			//도서등록
			if(gubun == 2) {
				
				System.out.println(" 등록하실 도서번호는 ex[K000]?");
				String no = sc.next();
				
				System.out.println(" 등록하실 도서명은? ");
				String name = sc.next();
				
				System.out.println(" 등록하실 출판사명은? ");
				String publisher = sc.next();
				
				System.out.println(" 등록하실 저자명은? ");
				String writer = sc.next();
				
				System.out.println(" 등록 날짜는? ex[2020-01-01] ");
				String reg_date = sc.next();	
				
				String rent_gubun  = "Y";
				
				Book_dto dto = new Book_dto(no, name, publisher, writer, reg_date, rent_gubun);
				int result = dao.saveBook(dto);
				
				if(result == 1) System.out.println(" 등록 되었습니다.");
				if(result == 0) System.out.println(" 등록 실패. ");
			}
			
			//도서수정
			if(gubun == 3) {
				System.out.println(" 수정하실 도서번호나 도서명을 입력해주시오  ");
				String no = sc.next();
				Book_dto dto = dao.getBookDataView(no);
				
				if(dto == null) System.out.println(no+"수정 할 정보가 존재하지 않습니다");
				if(dto != null) {
					System.out.println("책번호 : "+dto.getNo());
					System.out.println("책이름 : "+dto.getName());
					System.out.println("출판사 : "+dto.getPublisher());
					System.out.println("저자명 : "+dto.getWriter());
					System.out.println("등록날짜 : "+dto.getReg_date());
					System.out.println("대여가능여부 : "+dto.getRent_gubun());
				
					System.out.println("==============================================");
					System.out.println("수정하시겠습니까? 예:Y 아니요:N");
					String updateGubun = sc.next();
					if(updateGubun.equals("Y") || updateGubun.equals("y") || updateGubun.equals("ㅛ")) {
					
						no = dto.getNo();
						
						System.out.println(" 도서명 : "+dto.getName()+" -> ");   
	                    String name = sc.next();
	                    System.out.println(" 출판사 : "+dto.getPublisher()+" -> ");      
	                    String publisher = sc.next();
	                    System.out.println(" 저자명 : "+dto.getWriter()+" -> ");
	                    String writer = sc.next();
	                    System.out.println(" 등록날짜 : "+dto.getReg_date()+" -> ");                     
	                    String reg_date = sc.next();
	                    
	                    int result = dao.updateBook(no, name, publisher, writer, reg_date);
	                    if(result == 1) System.out.println("=====수정완료=================");
	                    if(result == 0) System.out.println("=====수정오류================="); 
					}
				}
			}
			
			//도서삭제
			if(gubun == 4) {
				System.out.println(" ===삭제 페이지 입니다.======================");
				System.out.println(" 삭제 하 실 도서명이나 도서번호를 입력해주세요. ");
				String book = sc.next();
				Book_dto dto = dao.getBookDataView(book);
				
				if(dto == null) System.out.println(book+" 검색하신 정보가 존재하지 않습니다");
				if(dto != null) {
					System.out.println("책번호 : "+dto.getNo());
					System.out.println("책이름 : "+dto.getName());
					System.out.println("출판사 : "+dto.getPublisher());
					System.out.println("저자명 : "+dto.getWriter());
					System.out.println("등록날짜 : "+dto.getReg_date());
					System.out.println("대여가능여부 : "+dto.getRent_gubun());
					System.out.println("=============================================");
					System.out.println("삭제하시겠습니까? 예:Y 아니요:N");
					String updateGubun = sc.next();
	
					if(updateGubun.equals("Y") || updateGubun.equals("y") || updateGubun.equals("ㅛ")) {
					
						int result = dao.deleteBook(book);
						if(result == 1)System.out.println("=====삭제완료=================");
	                    if(result == 0)System.out.println("=====삭제오류================="); 
					}
				}
			}
		}while(gubun != 0);
		
	
	}

}
