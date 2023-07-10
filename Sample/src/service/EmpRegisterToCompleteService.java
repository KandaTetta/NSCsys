package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.ConnectionManager;
import dao.EmpDAO;
import dao.NumberingDAO;
import entity.Emp;

public class EmpRegisterToCompleteService {

	public boolean empRegister(Emp emp)throws SQLException{

		Connection con = null;
		boolean result=false;
		try {
			// データベース接続の確立
			con = ConnectionManager.getConnection();
			// NumberingDAOのインスタンス化
			NumberingDAO numberingDAO = new NumberingDAO(con);
			int no= numberingDAO.getNextNo("Emp");
			//empに取得したnoをセット
			emp.setNo(no);

			// EmpDAOのインスタンス化
			EmpDAO 	empDAO = new EmpDAO(con);

			// データベースに登録
			result = empDAO.insert(emp);

		} finally {
			// データベース接続の解放
			if (con != null) {
				con.close();
			}
		}
		return result;
	}

}
