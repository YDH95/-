package com.company.Model2_Board.user;

import java.sql.*;
import com.company.Model2_Board.common.JDBCUtil;

public class UserDAO {
	// �����ͺ��̽� ������� ���� ����
	Connection conn = null; 
	//Connection - �����ͺ��̽��� �����ϴ� ��ü�Դϴ�.
	PreparedStatement pstmt = null;
	//��ü�� ������ �� ���ڰ����� ������ SQL���� �����ϴµ�, 
	//���� �������� �����ؾ��� �� ? ��ȣ�� ��ü�� �� �ֽ��ϴ�.
	ResultSet rs = null;
	//������� ������ �� �ִ�.
	//����� ���� �� �� ������ �ҷ��� �� �ִ�.
	//�� �࿡�� ���� ������ ���� Ÿ���� ������ �ҷ��� �� �ִ�.
	
	private final String USER_GET = "SELECT id, password from USER where id=? and password=?";
	//final : ���� ���� �Ұ��� //��ü�� ������ �� ���ڰ����� ������ SQL���� �����ϴµ�, 
	
	//�α��� ����� ��ȸ �޼ҵ� ����
	public  UserDO getUser(UserDO userObj) {
		UserDO user = null;
	
		try {
			System.out.println("===> JDBC��getsUser() ���ó��");
			
			conn = com.company.Model2_Board.common.JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_GET);
			pstmt.setString(1, userObj.getId());
			pstmt.setString(2, userObj.getPassword());
			
			rs = pstmt.executeQuery(); //executeQuery : �������� ResultSet ��ü�� ���� ��ȯ�մϴ�.
									   //executeQuery�޼���� �����ͺ��̽����� �����͸� �����ͼ� ��� ������ ��ȯ�մϴ�. �� �޼���� Select �������� �����ϴ� Ư¡�� �ֽ��ϴ�.

			if (rs.next()) {//�� �о����
				user = new UserDO();
				user.setId(rs.getString("ID")); //������ID ���� 
				user.setPassword(rs.getString("PASSWORD")); //������PASSWORD ����
			}
		}catch(Exception e){
			e.printStackTrace();
			// e.printStackTrace() = ���� �޼����� �߻� �ٿ����� ã�Ƽ� �ܰ躰�� ������ ����Ѵ�.
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return user;
	}
}
