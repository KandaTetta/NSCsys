package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NumberingDAO {
	// 接続情報を保持する変数
	private Connection con;

	public NumberingDAO(Connection con) {
		this.con = con;
	}

	public int getNextNo(String tableName) throws SQLException {
		int currentNo = 0;

		// 引数のnullチェック
		if (tableName == null) {
			return -1;
		}

		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;

		try {

			pst1 = con.prepareStatement("SELECT CURRENT_NO FROM NUMBERING WHERE TABLE_NAME=? FOR UPDATE");
			pst2 = con.prepareStatement("UPDATE NUMBERING SET CURRENT_NO=? WHERE TABLE_NAME=?");
			pst1.setString(1, tableName);
			pst2.setString(2, tableName);

			// SQL文の発行
			ResultSet rs = pst1.executeQuery();
			if (rs.next()) {
				currentNo = rs.getInt(1);
				pst1.close();

				// SQL文の発行
				pst2.setInt(1, ++currentNo);
				int i = pst2.executeUpdate();
				if (i != 1) {
					return -1;
				}
				pst2.close();
			} else {
				return -1;
			}

		} catch (SQLException e) {
			System.out.println("SQL実行エラー発生");
			throw e;
		} finally {
			if (pst1 != null) {
				pst1.close();
			}
			if (pst2 != null) {
				pst2.close();
			}
		}
		return currentNo;
	}
}