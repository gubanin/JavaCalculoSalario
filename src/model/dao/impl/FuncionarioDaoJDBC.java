package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.FuncionarioDao;
import model.db.DB;
import model.entities.Funcionario;

public class FuncionarioDaoJDBC implements FuncionarioDao {

	@Override
	public List<Funcionario> findAll() {
		List<Funcionario> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DB.getconnection();
			ps = conn.prepareStatement("select * from funcionario");
			rs = ps.executeQuery();

			while (rs.next()) {
				Funcionario f = new Funcionario();
				f.setId(rs.getInt("id"));
				f.setNome(rs.getString("nome"));
				f.setSalarioBruto(rs.getDouble("salarioBruto"));
				list.add(f);
			}

		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			DB.closeConnection(conn, ps, rs);
		}
		return list;
	}
}
