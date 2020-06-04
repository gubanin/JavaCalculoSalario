package model.teste;

import java.util.List;

import model.entities.dto.FuncionarioDTO;
import model.service.FuncionarioService;

public class TestService {

	public static void main(String[] args) {

		FuncionarioService service = new FuncionarioService();

		List<FuncionarioDTO> f = service.calcularSalarioLiquido();
		System.out.println("Salario liquido dos funcionarios " + f);
	}
}
