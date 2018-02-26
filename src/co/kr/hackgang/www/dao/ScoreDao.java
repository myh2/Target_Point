package co.kr.hackgang.www.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Vector;

import co.kr.hackgang.www.vo.ScoreVo;
import co.kr.hackgang.www.util.JdbcUtil;

public class ScoreDao {

	private static Connection conn = JdbcUtil.getConnection();

	private static String selectsql = "select * from score";
	static final String INSERT = "INSERT INTO score VALUES(?,?)";
	static final String DELETE = "delete from score where B_USER = ?";

	public static Vector<Vector> selectAll() {
		Vector<Vector> rowData = new Vector<>();
		/*
		 * rowData.add(new Vector<>(Arrays.asList(new Object[]{1, "name",
		 * "1111"}))); rowData.add(new Vector<>(Arrays.asList(new Object[]{2,
		 * "name", "2222"}))); rowData.add(new Vector<>(Arrays.asList(new
		 * Object[]{3, "name", "3333"}))); rowData.add(new
		 * Vector<>(Arrays.asList(new Object[]{4, "name", "4444"})));
		 * rowData.add(new Vector<>(Arrays.asList(new Object[]{5, "name",
		 * "5555"}))); rowData.add(new Vector<>(Arrays.asList(new Object[]{6,
		 * "name", "6666"})));
		 */
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectsql);
			while (rs.next()) {
				Vector<Object> v = new Vector<>();
				v.add(rs.getString(1));
				v.add(rs.getString(2));

				rowData.add(v);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}

		return rowData;
	}

	public static int insertScore(ScoreVo scoreVo) {
		String user = scoreVo.getUser();
		int score = scoreVo.getScore();

		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = null;
		int cnt = 0;

		try {
			pstmt = conn.prepareStatement(INSERT);
			pstmt.setString(1, user);
			pstmt.setInt(2, score);
			cnt = pstmt.executeUpdate();
			/*if (cnt > 0) {
				System.out.println("입력 성공!");
			}*/
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(null, pstmt, conn);
		}
		return cnt;
	}

	public static void deleteScore(ScoreVo scoreVoDel) {
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement pstmt = null;
		int cnt = 0;

		try {
			pstmt = conn.prepareStatement(DELETE);
			pstmt.setString(1, scoreVoDel.getUser());
			cnt = pstmt.executeUpdate();
			/*if(cnt>0){
				System.out.println("삭제 성공!");
			}else{
				System.out.println("삭제할 데이터 없음!");
			}*/
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//JdbcUtil.close(rs);
			JdbcUtil.close(null, pstmt, conn);
		}

	}

}
