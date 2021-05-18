package com.company.Model2_Board.user;

/**
 * DO/DAO 패턴
 * 	=> DO(Data Object)
 * 	 	데이터베이스의 데이터(즉 테이블의 행)를 객채화하는 클래스 구조이다.
 * 		즉 데이터를 하나의 객채로 관리할 목적으로 만들어 둔 클래스 객채이다.
 * 		DO 클래스에는 필드, 각 필드당 get/set 메소드가 한쌍으로 정의되어 있어야 한다.
 * 
 *  ▼ 반장님 설명
 *  DO클래스에는 테이블과 대응할 수 있는 필드 관련 기능만 존재.
	DAO 클래스에는 데이터베이스 접속과 관련된 정보와 입력, 출력, 삭제 기능을 구현.
	데이터와 비즈니스 로직을 분리하기 때문에 유지보수에 유리하다는 장점이 있음.
	DAO 패턴이라고 불리기도 하고 MVC 패턴과 함께 사용됨.
 */

public class UserDO {
	//필드(프로퍼티, 중간저장소)
	private String id, password, name, role;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
