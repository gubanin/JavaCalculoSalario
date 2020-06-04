package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.DescontoDao;
import model.db.DB;

public class DescontoDaoJDBC implements DescontoDao {

	@Override
	public Double buscarDescontoPorFuncionarioId(Integer id) {
		Double valorTotalDesconto = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DB.getconnection();
			ps = conn.prepareStatement(
					"select sum(valorDesconto) as valorTotalDesconto from desconto where id_funcionario = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				valorTotalDesconto = rs.getDouble("valorTotalDesconto");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			DB.closeConnection(conn, ps, rs);
		}
		return valorTotalDesconto;

	}

}
