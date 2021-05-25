package com.company.Spring_Annotation_Board.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.company.Spring_Annotation_Board.common.EncryptUtil;
import com.company.Spring_Annotation_Board.common.JDBCUtil;

public class UserDAO {
	// 데이터베이스 연결관련 변수 선언
	Connection conn = null;
	// Connection - 데이터베이스와 연결하는 객체입니다.
	PreparedStatement pstmt = null;
	// 객체를 생성할 때 인자값으로 실행할 SQL문을 지정하는데,
	// 값을 동적으로 지정해야할 때 ? 기호로 대체할 수 있습니다.
	ResultSet rs = null;
	// 결과값을 저장할 수 있다.
	// 저장된 값을 한 행 단위로 불러올 수 있다.
	// 한 행에서 값을 가져올 때는 타입을 지정해 불러올 수 있다.
	private final String USER_SET = "INSERT INTO USERS(ID, PASSWORD, PWENCRYPT, NAME, ROLE) VALUES(?, ?, ?, ?, ?)";

	private final String USER_GET = "SELECT id, password, name from USERS where id=? and password=?";

	private final String USER_DEL = "DELETE FROM USERS WHERE id=? and password=?";
	String pwEncrypt;
	// final : 변수 변경 불가능 //객체를 생성할 때 인자값으로 실행할 SQL문을 지정하는데,

//---------------로그인--------------------------------------
	public UserDO getUser(UserDO userObj) {
		UserDO user = null;

		try {
			System.out.println("===> JDBC로UserDAO/getsUser() 기능처리");

			conn = JDBCUtil.getConnection();
			pstmt = conn.prepareStatement(USER_GET);
			pstmt.setString(1, userObj.getId());
			pstmt.setString(2, userObj.getPassword());
			

			rs = pstmt.executeQuery(); // executeQuery : 수행결과로 ResultSet 객체의 값을 반환합니다.
										// executeQuery메서드는 데이터베이스에서 데이터를 가져와서 결과 집합을 반환합니다. 이 메서드는 Select 문에서만 실행하는 특징이
										// 있습니다.

			if (rs.next()) {// 값 읽어오기
				user = new UserDO();
				user.setId(rs.getString("ID")); // 설정한ID 저장
				user.setPassword(rs.getString("PASSWORD")); // 설정한PASSWORD 저장
				user.setName(rs.getString("NAME"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			// e.printStackTrace() = 에러 메세지의 발생 근원지를 찾아서 단계별로 에러를 출력한다.
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return user;
	}

	// -------------회원가입-----------------------------------------------------------------
	public String setUser(UserDO userObj) {
		System.out.println("===> JDBC로setUser() 기능처리");
		
		try {
			conn = JDBCUtil.getConnection();

			pstmt = conn.prepareStatement(USER_SET);
			pstmt.setString(1, userObj.getId());
			pstmt.setString(2, userObj.getPassword());
			//입력받은 패스워드를 암호화 시켜 세번째 물음표 값으로 설정
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
//----------------회원탈퇴-------------------------------------
	public int delUser(UserDO userObj) {
		System.out.println("===> JDBC로delUser() 기능처리");

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
