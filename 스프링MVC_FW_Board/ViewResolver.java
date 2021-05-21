package com.company.view.controller;

public class ViewResolver {
	//�ʵ弱��
	public String prefix; //���λ�
	public String suffix; //���̻�
	
	//setter �޼ҵ� 
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	/**
	 * [��] �������� �� => ./getBoardList.jsp
	 * ./   => ���λ�
	 * viewName => getBoardList
	 * .jsp => ���̻�
	 */
	//����� ���� �޼ҵ� ����
	public String getView(String viewName) {
		
		//		./ + getBoardList + .jsp
		return prefix + viewName + suffix;
	}
	
}
