package com.company.Model2_Board.user;

/**
 * DO/DAO ����
 * 	=> DO(Data Object)
 * 	 	�����ͺ��̽��� ������(�� ���̺��� ��)�� ��äȭ�ϴ� Ŭ���� �����̴�.
 * 		�� �����͸� �ϳ��� ��ä�� ������ �������� ����� �� Ŭ���� ��ä�̴�.
 * 		DO Ŭ�������� �ʵ�, �� �ʵ�� get/set �޼ҵ尡 �ѽ����� ���ǵǾ� �־�� �Ѵ�.
 * 
 *  �� ����� ����
 *  DOŬ�������� ���̺�� ������ �� �ִ� �ʵ� ���� ��ɸ� ����.
	DAO Ŭ�������� �����ͺ��̽� ���Ӱ� ���õ� ������ �Է�, ���, ���� ����� ����.
	�����Ϳ� ����Ͻ� ������ �и��ϱ� ������ ���������� �����ϴٴ� ������ ����.
	DAO �����̶�� �Ҹ��⵵ �ϰ� MVC ���ϰ� �Բ� ����.
 */

public class UserDO {
	//�ʵ�(������Ƽ, �߰������)
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
