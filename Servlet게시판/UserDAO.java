package com.company.Model2_Board.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	private final String USER_SET = "INSERT INTO USER(id, password, name, role) VALUES(?, ?, ?, ?)";
	
	private final String USER_GET = "SELECT id, password from USER where id=? and password=?";
	
	private final String USER_DEL = "DELETE FROM USER WHERE id=? and password=?";
	//final : ���� ���� �Ұ��� //��ü�� ������ �� ���ڰ����� ������ SQL���� �����ϴµ�, 
	
	//�α��� ����� ��ȸ �޼ҵ� ����
	public UserDO getUser(UserDO userObj) {
		UserDO user = null;
	
		try {
			System.out.println("===> JDBC��getsUser() ���ó��");
			
			conn = JDBCUtil.getConnection();
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
	//-------------ȸ������-----------------------------------------------------------------
	public int setUser(UserDO userObj) {
		System.out.println("===> JDBC��setUser() ���ó��");
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement(USER_SET);
			pstmt.setString(1, userObj.getName());
			pstmt.setString(2, userObj.getId());
			pstmt.setString(3, userObj.getPassword());
			pstmt.setString(4, userObj.getRole());
			
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return -1;
	}
	
	public int delUser(UserDO userObj) {
		System.out.println("===> JDBC��delUser() ���ó��");
		
		try {
			conn = JDBCUtil.getConnection();
			
			pstmt = conn.prepareStatement(USER_DEL);
			pstmt.setString(1, userObj.getId());
			pstmt.setString(2, userObj.getPassword());
		
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
		return -1;
	}
}
