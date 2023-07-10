package dao;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionManager {
	public static Connection getConnection() {
		Connection con = null;

		try {
			//DataSourceの獲得
			Context c = new InitialContext();
			DataSource ds = (DataSource)c.lookup("java:comp/env/jdbc/sample");

			//データベース接続の確立
			con = ds.getConnection();

		} catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}