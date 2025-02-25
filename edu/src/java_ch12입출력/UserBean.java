package java_ch12입출력;

import java.io.Serializable;

public class UserBean implements Serializable{
	
	//클래스에 변화가 있을때 어떻게 실행될지 예상이 안됨 > 버전을 붙여서 변화가 있기전과 있은후를 구분해 오류방지
	private static final long serialVersionUID = 2L; 
	private String id;
	private String name;
	private String tel;
	private String address;
	
	public UserBean() {
	}

	public UserBean(String id, String name, String tel, String address) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public void test() {
		
	}
	
	@Override
	public String toString() {
		return "UserBean [id=" + id + ", name= " + name + ", tel=" + tel+ ", address=" + address + "]";
	}
	

}
