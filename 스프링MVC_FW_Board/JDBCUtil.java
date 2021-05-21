package com.company.MVC_FW_Board.common;

import java.sql.*;

/**
 * 
 * JDBCUtil Ŭ������ ��ƿ��Ƽ Ŭ������ ������DAO Ŭ�������� 
 * �����ϴ� Ŭ������ �������� ����ϴ� Ŭ�����̴�. �ѹ� ����� ������ �ٸ�
 * ������Ʈ ���� �� '����' �� �� �ִ�.
 *
 */
public class JDBCUtil {
	static final String driver = "org.h2.Driver";
	static final String url = "jdbc:h2:tcp://localhost/~/test";

	public static Connection getConnection() throws Exception {
		try {
			Class.forName(driver);
			// forName() : �������� Ŭ���� ���ϸ��� ���ڷ� �־��ָ� �̿� �ش��ϴ� Ŭ������ ��ȯ���ݴϴ�.
			// Ŭ������ �����ϱ� ���� Ŭ�����Դϴ�.
			// ������ Ŭ������ ���鶧 Class.forName �� �����ϰ� ���δ�.
			Connection conn = DriverManager.getConnection(url, "sa", null); // h2����
			
			return conn; //BoardDAO, UserDAOŬ������ conn = JDBCUtil.getConnection();�ʿ� ����
																								
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			// e.printStackTrace() = ���� �޼����� �߻� �ٿ����� ã�Ƽ� �ܰ躰�� ������ ����Ѵ�.
		}
		return null;
	}

	// DML �۾�(insert, update, delete) �۾����� �� ȣ���Ͽ� �ڿ� ���� ��Ű�� �޼ҵ�
	public static void close(PreparedStatement pstmt, Connection conn) {
		
		
		if (pstmt != null) {
			try {
				if(!pstmt.isClosed()) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				pstmt=null;
			}
		}
		
		if (conn != null) {
			try {
				if(!conn.isClosed()) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				conn=null;
			}
		}
	}
	// select �۾����� �� ȣ���Ͽ� �ڿ� ���� ��Ű�� �޼ҵ�
	public static void close(ResultSet  rs, PreparedStatement pstmt, Connection conn) {
		if (rs != null) {
			try {
				if(!rs.isClosed()) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				rs=null;
			}
		}
		
		if (pstmt != null) {
			try {
				if(!pstmt.isClosed()) pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				pstmt=null;
			}
		}
		
		if (conn != null) {
			try {
				if(!conn.isClosed()) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				conn=null;
			}
		}
	}
	
}
