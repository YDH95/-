package mybatis.service;

/**
 * [꼭~체크요]
 * FactoryService 클래스 작성하기 전에 
 * WebContent/WEB-INF/lib 폴더에 mybatis-3.5.5.jar 파일을 넣어 둔다.
 * 그래야 SqlSessionFactory 인터페이스가 import 된다.
 */

/**
 * Mybatis를 이용하여 DAO를 구현하려면 SqlSession 객체가 필요하다.
 * 그런데 이 SqlSession 객체를 얻으려면 SqlSessionFactory 객체가 필요하다.
 * 
 * 모든 Mybatis 애플리케이션은 SqlSessionFactory 인스턴스를 사용한다.
 * SqlSessionFactory 인스턴스는 SqlSessionFactoryBuilder를 사용하여 만들 수 있다.
 */

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class FactoryService {
	private static SqlSessionFactory factory;
	
	static {
		try {
			//먼저 Mybatis 설정 파일인 config.xml 파일로부터 설정 정보를 읽어들이기 위한 
			//입력 스트림을 생성해야 한다.
			Reader reader = Resources.getResourceAsReader("mybatis/config/config.xml");
			
			//그리고 나서 입력 스트림을 통해 config.xml 파일을 읽어 SqlSessionFactory 객체를 생성한다.
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
