package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.ConnectionManager;
import dao.EmpDAO;
import entity.Emp;

public class EmpSearchToDetailService {

	public Emp findEmp(int no) throws SQLException {
		Emp emp = null;
		Connection con = null;
		try {
			// データベース接続の確立
			con = ConnectionManager.getConnection();
			// EmpDAOのインスタンス化
			EmpDAO empDAO = new EmpDAO(con);
			emp = empDAO.findByNo(no);

		} finally {
			// データベース接続の解放
			if (con != null) {
				con.close();
			}
		}
		return emp;
	}

}
