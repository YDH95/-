package com.company.couplingtest;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		//1. ������ �����̳� ����
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		/*
		 * factory�� �Ľ��� ���� AbstractApplicationContext�� �̿��ϰ�
		 * xml������ ���� ���� GenericXmlApplicationContext�� �̿��ϴ� ���� �ϰ� ������ �Ѿ�� �ȴ�.
		 */
		//2. ������ �����̳ʷκ��� ��ü�� ��û�Ѵ�.
		TV tv = (TV)factory.getBean("tv"); //applicationContext.xml�� bean id���θ�
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		//3. ������ �����̳� ����
		factory.close();
		
		
	}

}
