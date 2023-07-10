package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Dept;
import entity.Emp;

public class EmpDAO {
	// 接続情報を保持する変数
	private Connection con;
	public EmpDAO(Connection con) {
		this.con = con;
	}

	public boolean insert(Emp emp) throws SQLException {
		// 引数のnullチェック
		if (emp == null) {
			return false;
		}

		PreparedStatement pst = null;
		try {
			// SQL文の発行
			pst = con.prepareStatement("INSERT INTO emp VALUES (?,?,?,?)");
			pst.setInt(1, emp.getNo());
			pst.setString(2, emp.getName());
			pst.setDate(3, emp.getSqlHireDate());
			pst.setInt(4, emp.getDept().getNo());

			int ret = pst.executeUpdate();

			if (ret != 1) {
				throw new SQLException();
			}
		} finally {
			if (pst != null) {
				pst.close();
			}
		}
		return true;
	}

	public ArrayList<Emp> findByCondition(String name, Date fromDate,Date toDate) throws SQLException {
		ArrayList<Emp> empList = new ArrayList<Emp>();
		PreparedStatement pst = null;
		try {
			//元のSQL文、何も条件が無ければこのSQLが発行される
			String sql = "SELECT * FROM emp WHERE 1=1 ";

			//プレースフォルダに設定する？の管理するリスト
			ArrayList<String> parameters = new ArrayList<String>();

			//引数のnameが存在していれば条件を追加
			if ((name != null) && !name.isEmpty()) {
				sql += "AND name like ? ";
				parameters.add("name");
			}
			//引数のorderDateが存在していれば条件を追加(toDate以内)
			if (fromDate != null) {
				sql += "AND hire_date >= ? ";
				parameters.add("fromDate");
			}

			//引数のorderDateが存在していれば条件を追加(toDate以内)
			if (toDate != null) {
				sql += "AND hire_date <= ? ";
				parameters.add("toDate");
			}
			//すべて入力条件のチェックが終わったらpreparedStatementオブジェクトの獲得(SQLの準備)
			pst = con.prepareStatement(sql);
			int columnIndex = 0;

			//parametersにnameが追加されいればプレースフォルダに条件をセット
			if (parameters.contains("name")) {
				pst.setString(++columnIndex, "%" + name + "%");
			}

			//parametersにfromDateが追加されいればプレースフォルダに条件をセット
			if (parameters.contains("fromDate")) {
				pst.setDate(++columnIndex, fromDate);
			}

			//parametersにtoDateが追加されいればプレースフォルダに条件をセット
			if (parameters.contains("toDate")) {
				pst.setDate(++columnIndex, toDate);
			}
			ResultSet res = pst.executeQuery();
			DeptDAO deptDAO = new DeptDAO(con);
			// ResultSetの読み込み
			while (res.next()) {
				Emp emp = createEmp(res, deptDAO);
				empList.add(emp);
			}

		} finally {
			if (pst != null) {
				pst.close();
			}
		}
		return empList;
	}



	public Emp findByNo(int no) throws SQLException {
		Emp emp = null;
		PreparedStatement pst = null;
		try {

			// SQL文の発行
			pst = con.prepareStatement("SELECT * FROM emp WHERE no = ?");
			pst.setInt(1, no);
			ResultSet res = pst.executeQuery();
			DeptDAO deptDAO = new DeptDAO(con);
			// ResultSetの読み込み
			if (res.next()) {
				emp = createEmp(res, deptDAO);
			}

		} finally {
			if (pst != null) {
				pst.close();
			}
		}
		return emp;
	}

	private Emp createEmp(ResultSet res, DeptDAO deptDAO) throws SQLException {
		int no = res.getInt("no");
		String name = res.getString("name");
		Date hireDate = res.getDate("hire_Date");
		int deptNo = res.getInt("dept_no");
		Dept dept = deptDAO.findByNo(deptNo);
		Emp emp = new Emp(no, name, hireDate.toLocalDate(), dept);
		return emp;
	}
}