package dto;

public class Book_dto {
	String no, name, publisher, writer, reg_date, rent_gubun;

	//기본생성자
	public Book_dto(String no, String name, String publisher, String writer, String reg_date, String rent_gubun) {
	
		this.no = no;
		this.name = name;
		this.publisher = publisher;
		this.writer = writer;
		this.reg_date = reg_date;
		this.rent_gubun = rent_gubun;
	}
	
	//반납할때 조회하기 위한 생성자
	public Book_dto(String no, String rent_gubun) {
		super();
		this.no = no;
		this.rent_gubun = rent_gubun;
	}



	public String getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getWriter() {
		return writer;
	}

	public String getReg_date() {
		return reg_date;
	}

	public String getRent_gubun() {
		return rent_gubun;
	}
	
}
