package mybatis.service;

/**
 * [��~üũ��]
 * FactoryService Ŭ���� �ۼ��ϱ� ���� 
 * WebContent/WEB-INF/lib ������ mybatis-3.5.5.jar ������ �־� �д�.
 * �׷��� SqlSessionFactory �������̽��� import �ȴ�.
 */

/**
 * Mybatis�� �̿��Ͽ� DAO�� �����Ϸ��� SqlSession ��ü�� �ʿ��ϴ�.
 * �׷��� �� SqlSession ��ü�� �������� SqlSessionFactory ��ü�� �ʿ��ϴ�.
 * 
 * ��� Mybatis ���ø����̼��� SqlSessionFactory �ν��Ͻ��� ����Ѵ�.
 * SqlSessionFactory �ν��Ͻ��� SqlSessionFactoryBuilder�� ����Ͽ� ���� �� �ִ�.
 */

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FactoryService {
	private static SqlSessionFactory factory;
	
	static {
		try {
			//���� Mybatis ���� ������ config.xml ���Ϸκ��� ���� ������ �о���̱� ���� 
			//�Է� ��Ʈ���� �����ؾ� �Ѵ�.
			Reader reader = Resources.getResourceAsReader("mybatis/config/config.xml");
			
			//�׸��� ���� �Է� ��Ʈ���� ���� config.xml ������ �о� SqlSessionFactory ��ü�� �����Ѵ�.
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}
