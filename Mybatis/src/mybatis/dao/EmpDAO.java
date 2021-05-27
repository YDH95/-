package mybatis.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import mybatis.service.FactoryService;
import mybatis.vo.EmpVO;

/**
 * 
 * Mybatis ��� ���� �� �ϳ���
 * DAO�κ��� SQL���� �и��ϴ� ���̴�.
 * �и��� SQL���� SQL mapper ���Ͽ� �ۼ��ϸ� DAO ������  SqlSession ��ü��
 * SQL mapper ������ �����ϰ� �ȴ�. 
 *
 */

public class EmpDAO {
	public static List<EmpVO> getTotal() {	
		
		//�̹� �����Ǿ� �ִ� factory�� �̿��Ͽ� SqlSession�� ����.
		SqlSession ss = FactoryService.getFactory().openSession();
		
		List<EmpVO> list = ss.selectList("emp.total");
		
		ss.close();
		return list;
	}
	
	public static int add(String empno, String ename, String position) {
		
		//mapper�� ȣ���� �� Map ������ �����ؾ� �ϹǷ� Map ����
		Map<String, String> map = new Hashtable<String, String>();
		
		map.put("empno", empno);
		map.put("ename", ename);
		map.put("position", position);
		
		SqlSession ss = FactoryService.getFactory().openSession(true);
		
		int cnt = ss.insert("emp.add", map);
		ss.close();
		return cnt;
	}
}