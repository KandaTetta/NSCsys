package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class MasterDAO {
	// 接続情報を保持する変数
	private Connection con;

	public MasterDAO(Connection con) {
		this.con = con;
	}

	public HashMap<Integer, String>  findDeptMap() throws SQLException {
		HashMap<Integer, String> deptMap = new HashMap<Integer, String>();
		PreparedStatement pst = null;
		try {

			// SQL文の発行
			pst = con.prepareStatement("SELECT * FROM dept ");
			ResultSet res = pst.executeQuery();

			// ResultSetの読み込み
			while (res.next()) {
				int no = res.getInt("no");
				String name = res.getString("name");
				deptMap.put(no,name);
			}
		} finally {
			if (pst != null) {
				pst.close();
			}
		}
		return deptMap;

	}
	public HashMap<Integer, String> findBranchMap()  {

		HashMap<Integer, String> branchMap = new HashMap<>();
		branchMap.put(1,"東京支店");
		branchMap.put(2,"大阪支店");
		branchMap.put(3,"名古屋支店");

		return branchMap;
	}
}