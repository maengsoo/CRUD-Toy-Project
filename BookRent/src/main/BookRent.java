package main;

import java.util.Scanner;

import management.BookManagement;
import management.MemberManagement;
import management.RentManagement;
import management.ReturnManagement;

public class BookRent {

	public static void main(String[] args) {
		
		Scanner sc 	   = new Scanner(System.in);
		int workGubun = 0;
		
		do {
			System.out.println(" 회원관리[1], 도서관리[2], 대여[3], 반납[4], 시스템종료[0] ? ");
			workGubun = sc.nextInt();
			
			if(workGubun == 1) MemberManagement.member();
			if(workGubun == 2) BookManagement.book();
			if(workGubun == 3) RentManagement.rent();
			if(workGubun == 4) ReturnManagement.returned() ;
		
		}while(workGubun != 0);
		
		System.out.println(" 시스템 종료 ");
		sc.close();
	}

}