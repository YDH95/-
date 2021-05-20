package com.company.couplingtest;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		//1. 스프링 컨테이너 구동
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		/*
		 * factory로 파싱할 때는 AbstractApplicationContext를 이용하고
		 * xml파일을 담을 때는 GenericXmlApplicationContext를 이용하는 구나 하고 가볍게 넘어가면 된다.
		 */
		//2. 스프링 컨테이너로부터 객체를 요청한다.
		TV tv = (TV)factory.getBean("tv"); //applicationContext.xml에 bean id를부름
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		//3. 스프링 컨테이너 종료
		factory.close();
		
		
	}

}
