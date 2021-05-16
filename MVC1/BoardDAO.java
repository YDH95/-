package board;


import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import common.JDBCUtil;

public class BoardDAO {
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
	
	
	//��ü �Խñ� ��� ��ȸ �޼ҵ� ����
	public List<BoardDO> getBoardList(String searchField, String searchText) {
		System.out.println("===> getBoardListó��");
		
		List<BoardDO> boardList = new ArrayList<BoardDO>();
		
		try {
			conn = JDBCUtil.getConnection();
			
			String where = "";
			
			//[�߿�]
			if((searchField != null) && (searchText != null)) {
				where = " WHERE "+searchField +" LIKE '%"+searchText+"%'";
			}
			//��ü �Խñ� ��� ��ȸ�� ���
			String Condition_SQL = "SELECT * FROM BOARD"+where+" order by seq desc";
			
			pstmt = conn.prepareStatement(Condition_SQL);
			rs = pstmt.executeQuery();
			
			//�˻��� ���ڵ尡 �ϳ� �̻��̱� ������
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
	
	//insertBoard() �޼ҵ� ����
	public void insertBoard(BoardDO boardDO) {
		System.out.println("===> insertBoardó��");
		
		try {
			conn = JDBCUtil.getConnection();
			
			String BOARD_INSERT = "INSERT INTO BOARD(seq, title, writer, content) "
					+ "VALUES((select nvl(max(seq),0)+1"
					+ "from board),?,?,?)";
			//NVL(MAX( [�÷�] ) , [ġȯ�� ��]) + 1
			//NVL�Լ��� ����ϴ� ������ MAX�ؼ� �����;��� �÷��� 0�� 
			//ó���� ����ִ°�� ������ �������� �����Դϴ�.
			
			pstmt = conn.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, boardDO.getTitle());
			pstmt.setString(2, boardDO.getWriter());
			pstmt.setString(3, boardDO.getContent());
			
			pstmt.executeUpdate(); //DML �۾� �� ��� executeUpdate() �޼ҵ� ȣ��
			//�������� Int Ÿ���� ���� ��ȯ�մϴ�.
			//SELECT ������ ������ �ٸ� ������ ������ �� ���Ǵ� �Լ��Դϴ�.
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	//-------------------------------------------------------------------
	public BoardDO getBoard(BoardDO boardDO) {
		System.out.println("===> getBoard() ��� ó��");
	
		BoardDO board = null;
		try {
			conn = JDBCUtil.getConnection();
			
			//[�߿�] �ش� �Խñ��� ��ȸ��(cnt)�� 1���� ��Ű�� �۾��� ���� ó���Ѵ�.
			String UPDATE_CNT = "UPDATE BOARD set cnt=cnt+1 where seq=?";
			
			pstmt = conn.prepareStatement(UPDATE_CNT);
			pstmt.setInt(1, boardDO.getSeq());
			pstmt.executeUpdate();
			
			//�Խñ۹�ȣ ���ǿ� �´� �ش� �Խñ� ��������
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
		System.out.println("===> updateBoard() ��� ó��");
		
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
		System.out.println("===> deleteBoard() ��� ó��");
		
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
