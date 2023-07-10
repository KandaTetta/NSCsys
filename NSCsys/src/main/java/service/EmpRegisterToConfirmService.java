package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.ConnectionManager;
import dao.DeptDAO;
import entity.Dept;

public class EmpRegisterToConfirmService {


	public Dept findDept(int no)throws SQLException{

		Connection con = null;
		Dept dept = null;
		try {
			// データベース接続の確立
			con = ConnectionManager.getConnection();

			// DeptDAOのインスタンス化
			DeptDAO DeptDAO = new DeptDAO(con);

			// データベースから部署を検索
			dept = DeptDAO.findByNo(no);

		} finally {
			// データベース接続の解放
			if (con != null) {
				con.close();
			}
		}
		return dept;
	}

}

