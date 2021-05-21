package com.company.view.controller;

public class ViewResolver {
	//필드선언
	public String prefix; //접두사
	public String suffix; //접미사
	
	//setter 메소드 
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	/**
	 * [예] 포워딩할 때 => ./getBoardList.jsp
	 * ./   => 접두사
	 * viewName => getBoardList
	 * .jsp => 접미사
	 */
	//사용자 정의 메소드 구현
	public String getView(String viewName) {
		
		//		./ + getBoardList + .jsp
		return prefix + viewName + suffix;
	}
	
}
