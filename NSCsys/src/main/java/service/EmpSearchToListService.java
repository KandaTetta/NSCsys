package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ConnectionManager;
import dao.EmpDAO;
import entity.Emp;

public class EmpSearchToListService {

	public ArrayList<Emp> findEmpList(String word, Date fromDate, Date toDate) throws SQLException {
		ArrayList<Emp> list = null;
		Connection con = null;
		try {
			// データベース接続の確立
			con = ConnectionManager.getConnection();
			// EmpDAOのインスタンス化
			EmpDAO empDAO = new EmpDAO(con);
			list = empDAO.findByCondition(word, fromDate, toDate);

		} finally {
			// データベース接続の解放
			if (con != null) {
				con.close();
			}
		}
		return list;
	}

}
