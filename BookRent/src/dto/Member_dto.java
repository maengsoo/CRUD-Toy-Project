package dto;

public class Member_dto {

	String name, id, address, tel, reg_date;
	int age;
	
	public Member_dto (String id, String name, String address, String tel, int age, String reg_date) {
		super();
		this.name = name;
		this.id = id;
		this.address = address;
		this.tel = tel;
		this.reg_date = reg_date;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}

	public String getAddress() {
		return address;
	}

	public String getTel() {
		return tel;
	}

	public String getReg_date() {
		return reg_date;
	}

	public int getAge() {
		return age;
	}
	
}
