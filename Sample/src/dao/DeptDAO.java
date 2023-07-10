package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Dept;

public class DeptDAO {
	// 接続情報を保持する変数
	private Connection con;

	public DeptDAO(Connection con) {
		this.con = con;
	}
	public Dept findByNo(int no) throws SQLException {
		Dept dept = null;
		PreparedStatement pst = null;
		try {

			// SQL文の発行
			pst = con.prepareStatement("SELECT * FROM dept WHERE no = ?");
			pst.setInt(1, no);
			ResultSet res = pst.executeQuery();

			// ResultSetの読み込み
			if (res.next()) {
				String name = res.getString("name");
				dept = new Dept(no, name);
			}

		} finally {
			if (pst != null) {
				pst.close();
			}
		}
		return dept;
	}
}