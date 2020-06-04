package model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {

	public static Connection getconnection() {

		try {
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/cursojse?useSSL=false", "root", "negresco");
		} catch (SQLException e) {
			throw new RuntimeException("Erro de conexao");
		}
	}

	public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
