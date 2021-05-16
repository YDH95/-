package board;


import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.JDBCUtil;

public class BoardDAO {
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
	
	
	//전체 게시글 목록 조회 메소드 구현
	public List<BoardDO> getBoardList(String searchField, String searchText) {
		System.out.println("===> getBoardList처리");
		
		List<BoardDO> boardList = new ArrayList<BoardDO>();
		
		try {
			conn = JDBCUtil.getConnection();
			
			String where = "";
			
			//[중요]
			if((searchField != null) && (searchText != null)) {
				where = " WHERE "+searchField +" LIKE '%"+searchText+"%'";
			}
			//전체 게시글 목록 조회인 경우
			String Condition_SQL = "SELECT * FROM BOARD"+where+" order by seq desc";
			
			pstmt = conn.prepareStatement(Condition_SQL);
			rs = pstmt.executeQuery();
			
			//검색한 레코드가 하나 이상이기 떄문에
			while(rs.next()) {
				BoardDO board = new BoardDO();
				
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				System.out.println(board.getTitle());
				boardList.add(board);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return boardList;
	}
	//------------------------------------------------------------
	
	//insertBoard() 메소드 구현
	public void insertBoard(BoardDO boardDO) {
		System.out.println("===> insertBoard처리");
		
		try {
			conn = JDBCUtil.getConnection();
			
			String BOARD_INSERT = "INSERT INTO BOARD(seq, title, writer, content) "
					+ "VALUES((select nvl(max(seq),0)+1"
					+ "from board),?,?,?)";
			//NVL(MAX( [컬럼] ) , [치환할 값]) + 1
			//NVL함수를 사용하는 이유는 MAX해서 가져와야할 컬럼에 0이 
			//처음에 들어있는경우 에러가 떨어지기 때문입니다.
			
			pstmt = conn.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, boardDO.getTitle());
			pstmt.setString(2, boardDO.getWriter());
			pstmt.setString(3, boardDO.getContent());
			
			pstmt.executeUpdate(); //DML 작업 할 경우 executeUpdate() 메소드 호출
			//수행결과로 Int 타입의 값을 반환합니다.
			//SELECT 구문을 제외한 다른 구문을 수행할 때 사용되는 함수입니다.
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	//-------------------------------------------------------------------
	public BoardDO getBoard(BoardDO boardDO) {
		System.out.println("===> getBoard() 기능 처리");
	
		BoardDO board = null;
		try {
			conn = JDBCUtil.getConnection();
			
			//[중요] 해당 게시글의 조회수(cnt)를 1증가 시키는 작업을 먼저 처리한다.
			String UPDATE_CNT = "UPDATE BOARD set cnt=cnt+1 where seq=?";
			
			pstmt = conn.prepareStatement(UPDATE_CNT);
			pstmt.setInt(1, boardDO.getSeq());
			pstmt.executeUpdate();
			
			//게시글번호 조건에 맞는 해당 게시글 가져오기
			String BOARD_GET = "SELECT * FROM BOARD WHERE seq=?";
			pstmt = conn.prepareStatement(BOARD_GET);
			pstmt.setInt(1, boardDO.getSeq());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board = new BoardDO();
				
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return board;

	}
	
	//----------------------------------------------------------
	public void updateBoard(BoardDO boardDO) {
		System.out.println("===> updateBoard() 기능 처리");
		
		try {
			conn = JDBCUtil.getConnection();
			
			String BOARD_UPDATE = "UPDATE BOARD SET title=?, writer=?, content=? where seq=?";

			pstmt = conn.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, boardDO.getTitle());
			pstmt.setString(2, boardDO.getWriter());
			pstmt.setString(3, boardDO.getContent());
			pstmt.setInt(4, boardDO.getSeq());
		
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	//------------------------------------------------------------
	public void deleteBoard(BoardDO boardDO) {
		System.out.println("===> deleteBoard() 기능 처리");
		
		try {
			conn = JDBCUtil.getConnection();
			
			String DELETE_BOARD = "DELETE FROM BOARD WHERE seq=?";
			pstmt = conn.prepareStatement(DELETE_BOARD);
			
			pstmt.setInt(1, boardDO.getSeq());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	//-------------------------------------------------------------
}
