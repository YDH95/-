package com.company.MVC_FW_Board.common;

import java.sql.*;

/**
 * 
 * JDBCUtil 클래스는 유틸리티 클래스로 각각의DAO 클래스에서 
 * 접근하는 클래스로 공통으로 사용하는 클래스이다. 한번 만들어 놓으면 다른
 * 프로젝트 개발 시 '재사용' 할 수 있다.
 *
 */
public class JDBCUtil {
	static final String driver = "org.h2.Driver";
	static final String url = "jdbc:h2:tcp://localhost/~/test";

	public static Connection getConnection() throws Exception {
		try {
			Class.forName(driver);
			// forName() : 물리적인 클래스 파일명을 인자로 넣어주면 이에 해당하는 클래스를 반환해줍니다.
			// 클래스를 조사하기 위한 클래스입니다.
			// 변수로 클래스를 만들때 Class.forName 은 유용하게 쓰인다.
			Connection conn = DriverManager.getConnection(url, "sa", null); // h2연결
			
			return conn; //BoardDAO, UserDAO클래스에 conn = JDBCUtil.getConnection();쪽에 리턴
																								
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			// e.printStackTrace() = 에러 메세지의 발생 근원지를 찾아서 단계별로 에러를 출력한다.
		}
		return null;
	}

	// DML 작업(insert, update, delete) 작업종료 시 호출하여 자원 해제 시키는 메소드
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
	// select 작업종료 시 호출하여 자원 해제 시키는 메소드
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
