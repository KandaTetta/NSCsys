package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dao.ConnectionManager;
import dao.MasterDAO;
import entity.Dept;

public class InitService {

	public HashMap<String, HashMap<Integer, String>> init() throws SQLException {

		Connection con = null;
		ArrayList<Dept> DeptList = null;
		HashMap<String, HashMap<Integer, String>> masterMap = new HashMap<String, HashMap<Integer, String>>();
		try {
			// データベース接続の確立
			con = ConnectionManager.getConnection();

			// MasterDAOのインスタンス化
			MasterDAO MasterDAO = new MasterDAO(con);

			// データベースから部署を検索
			HashMap<Integer, String> deptMap = MasterDAO.findDeptMap();
			// データベースから支社を検索
			HashMap<Integer, String> branchMap = MasterDAO.findBranchMap();

			/*
			 * Map<String,HashMap>に
			 *	Stringのkeyと
			 *  HashMap<Integer,String>の値を登録
			*/
			masterMap.put("deptMap", deptMap);
			masterMap.put("branchMap", branchMap);

		} finally {
			// データベース接続の解放
			if (con != null) {
				con.close();
			}
		}
		return masterMap;
	}

}
