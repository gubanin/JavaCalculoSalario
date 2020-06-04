package model.teste;

import java.util.List;

import model.dao.DescontoDao;
import model.dao.impl.DescontoDaoJDBC;
import model.dao.impl.FuncionarioDaoJDBC;
import model.entities.Funcionario;

public class TesteConexao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DescontoDao dDao = new DescontoDaoJDBC();
		FuncionarioDaoJDBC fDao = new FuncionarioDaoJDBC();

		List<Funcionario> list = fDao.findAll();
		for (Funcionario funcionario : list) {
			System.out.println(funcionario);
		}

		Double d = dDao.buscarDescontoPorFuncionarioId(1);
		System.out.println(d);

	}
}
