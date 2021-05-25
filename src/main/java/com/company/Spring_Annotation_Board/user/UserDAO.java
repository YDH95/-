package com.company.Spring_Annotation_Board.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.company.Spring_Annotation_Board.common.EncryptUtil;
import com.company.Spring_Annotation_Board.common.JDBCUtil;

public class UserDAO {
	// �����ͺ��̽� ������� ���� ����
	Connection conn = null;
	// Connection - �����ͺ��̽��� �����ϴ� ��ü�Դϴ�.
	PreparedStatement pstmt = null;
	// ��ü�� ������ �� ���ڰ����� ������ SQL���� �����ϴµ�,
	// ���� �������� �����ؾ��� �� ? ��ȣ�� ��ü�� �� �ֽ��ϴ�.
	ResultSet rs = null;
	// ������� ������ �� �ִ�.
	// ����� ���� �� �� ������ �ҷ��� �� �ִ�.
	// �� �࿡�� ���� ������ ���� Ÿ���� ������ �ҷ��� �� �ִ�.
	private final String USER_SET = "INSERT INTO USERS(ID, PASSWORD, PWENCRYPT, NAME, ROLE) VALUES(?, ?, ?, ?, ?)";

	private final String USER_GET = "SELECT id, password, name from USERS where id=? and password=?";

	private final String USER_DEL = "DELETE FROM USERS WHERE id=? and password=?";
	String pwEncrypt;
	// final : ���� ���� �Ұ��� //��ü�� ������ �� ���ڰ����� ������ SQL���� �����ϴµ�,

//---------------�α���--------------------------------------
	public UserDO getUser(UserDO userObj) {
		UserDO user = null;

		try {
			System.out.println("===> JDBC��UserDAO/getsUser() ���ó��");

			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_GET);
			pstmt.setString(1, userObj.getId());
			pstmt.setString(2, userObj.getPassword());
			

			rs = pstmt.executeQuery(); // executeQuery : �������� ResultSet ��ü�� ���� ��ȯ�մϴ�.
										// executeQuery�޼���� �����ͺ��̽����� �����͸� �����ͼ� ��� ������ ��ȯ�մϴ�. �� �޼���� Select �������� �����ϴ� Ư¡��
										// �ֽ��ϴ�.

			if (rs.next()) {// �� �о����
				user = new UserDO();
				user.setId(rs.getString("ID")); // ������ID ����
				user.setPassword(rs.getString("PASSWORD")); // ������PASSWORD ����
				user.setName(rs.getString("NAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			// e.printStackTrace() = ���� �޼����� �߻� �ٿ����� ã�Ƽ� �ܰ躰�� ������ ����Ѵ�.
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return user;
	}

	// -------------ȸ������-----------------------------------------------------------------
	public String setUser(UserDO userObj) {
		System.out.println("===> JDBC��setUser() ���ó��");
		
		try {
			conn = JDBCUtil.getConnection();

			pstmt = conn.prepareStatement(USER_SET);
			pstmt.setString(1, userObj.getId());
			pstmt.setString(2, userObj.getPassword());
			//�Է¹��� �н����带 ��ȣȭ ���� ����° ����ǥ ������ ����
			String plainText = userObj.getPassword();
			pwEncrypt = EncryptUtil.EncryptSHA256(plainText);
			pstmt.setString(3, pwEncrypt);
			pstmt.setString(4, userObj.getName());
			pstmt.setString(5, userObj.getRole());
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return "login.jsp";
	}
//----------------ȸ��Ż��-------------------------------------
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
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
		return -1;
	}
}
