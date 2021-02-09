package management;

import java.util.Scanner;

import dao.Member_dao;
import dto.Member_dto;
import main.BookRent;

public class MemberManagement extends BookRent{
	
	
	public static void member() {
		
		Scanner sc = new Scanner(System.in);
		Member_dao dao = new Member_dao();
		
		int gubun = 0;
		int gubun2 = 0;

		//회원관리
		do {
			System.out.println("=====MemberManagement Page===================================");
			System.out.println(" 회원조회[1], 등록[2], 수정[3], 삭제[4], 이전[0] ? ");
			System.out.println("=============================================================");

			gubun = sc.nextInt();
			
			if(gubun == 1) {
				

				do{
					System.out.println("회원 ID로 조회[1], 회원 이름으로 조회[2], 이전[0]");
					gubun2 = sc.nextInt();
					
					//회원 ID로 조회
					if(gubun2 == 1) {
						System.out.println(" 검색하실 ID를 입력하시오 ");
						String memberId = sc.next();
						Member_dto dto = dao.getMemberView(memberId);
						
						if(dto == null) System.out.println(memberId+"검색하신 회원 ID가 존재하지 않습니다");
						if(dto != null) {
							System.out.println("사번 : "+dto.getId());
							System.out.println("이름 : "+dto.getName());
							System.out.println("주소 : "+dto.getAddress());
							System.out.println("전화번호 : "+dto.getTel());
							System.out.println("나이 : "+dto.getAge());
							System.out.println("가입날짜 : "+dto.getReg_date());
						}
					}
					
					//회원 이름 조회
					if(gubun2 == 2) {
						System.out.println(" 검색하실 회원이름을 입력하시오 : ");
						String memberName = sc.next();
						Member_dto dto = dao.getMemberView(memberName);
						
						if(dto == null) System.out.println(memberName+"검색하신 회원이름이 존재하지 않습니다");
						if(dto != null) {
							System.out.println("사번 : "+dto.getId());
							System.out.println("이름 : "+dto.getName());
							System.out.println("주소 : "+dto.getAddress());
							System.out.println("전화번호 : "+dto.getTel());
							System.out.println("나이 : "+dto.getAge());
							System.out.println("가입날짜 : "+dto.getReg_date());
						}
					}
					
				}while(gubun2 != 0);
			}
			
			//회원등록
			if(gubun == 2) {
				System.out.println("등록하실 이름은?");
				String name = sc.next();
				
				System.out.println("등록하실 아이디는?");
				String id = sc.next();
				
				System.out.println("등록하실 주소는?");
				String address = sc.next();
				
				System.out.println("전화번호는?");
				String tel = sc.next();
				
				System.out.println("나이는?");
				int age = sc.nextInt();
				
				System.out.println("가입날짜는?");
				String reg_date = sc.next();
				
				Member_dto dto = new Member_dto(id, name, address, tel, age, reg_date);
				int result = dao.saveMember(dto);
				
				if(result == 1) System.out.println(" 등록 되었습니다.");
				if(result == 0) System.out.println(" 등록 실패. ");
			}
		
			//회원수정
			if(gubun == 3) {
				System.out.print(" 수정 할 사번이나 이름을 입력하시오 : ");
				String no = sc.next();
				Member_dto dto = dao.getMemberView(no);
				
				if(dto == null) System.out.println(no+" 수정 할 정보가 존재하지 않습니다");
				if(dto != null){
					System.out.println("사번 : "+dto.getId());
					System.out.println("이름 : "+dto.getName());
					System.out.println("주소 : "+dto.getAddress());
					System.out.println("전화번호 : "+dto.getTel());
					System.out.println("나이 : "+dto.getAge());
					System.out.println("가입날짜 : "+dto.getReg_date());
					System.out.println("==============================================");
					System.out.println("수정하시겠습니까? 예:Y 아니요:N");
					String updateGubun = sc.next();
					if(updateGubun.equals("Y") || updateGubun.equals("y") || updateGubun.equals("ㅛ")) {
					
						no = dto.getId();
						
						System.out.println(dto.getName() +" -> 성명 ? ");   
                        String name = sc.next();
                        System.out.println(dto.getAddress() +" -> 주소? ?");      
                        String address = sc.next();
                        System.out.println(dto.getTel() +" -> 전화번호 ? ");
                        String tel = sc.next();
                        System.out.println(dto.getAge() +" -> 나이 ? ");                     
                        int age = sc.nextInt();
                        
                        int result = dao.updateMember(no, name, address, tel, age);
                        if(result == 1) System.out.println("=====수정완료=================");
                        if(result == 0) System.out.println("=====수정오류================="); 
					}
				}
			}
			
			//회원삭제
			if(gubun == 4) {
				System.out.print("삭제 하실 회원번호나 이름을 입력하시오 : ");
				String no = sc.next();
				Member_dto dto = dao.getMemberView(no);
				
				if(dto == null) System.out.println(no+"삭제 할 정보가 존재하지 않습니다");
				if(dto != null) {
					
					System.out.println("사번 : "+dto.getId());
					System.out.println("이름 : "+dto.getName());
					System.out.println("주소 : "+dto.getAddress());
					System.out.println("전화번호 : "+dto.getTel());
					System.out.println("나이 : "+dto.getAge());
					System.out.println("가입날짜 : "+dto.getReg_date());
					System.out.println("==============================================");
					System.out.println("삭제하시겠습니까? 예:Y 아니요:N");
					String updateGubun = sc.next();

					if(updateGubun.equals("Y") || updateGubun.equals("y") || updateGubun.equals("ㅛ")) {
					
						int result = dao.deleteMember(no);
						if(result == 1)System.out.println("=====삭제완료=================");
                        if(result == 0)System.out.println("=====삭제오류================="); 
					}
				}
			}
		}while(gubun != 0);
	}
}