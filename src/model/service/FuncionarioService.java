package model.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.dao.DescontoDao;
import model.dao.FuncionarioDao;
import model.dao.impl.DescontoDaoJDBC;
import model.dao.impl.FuncionarioDaoJDBC;
import model.entities.Funcionario;
import model.entities.dto.FuncionarioDTO;

public class FuncionarioService {

	public List<FuncionarioDTO> calcularSalarioLiquido() {

		FuncionarioDao fDao = new FuncionarioDaoJDBC();
		DescontoDao dDao = new DescontoDaoJDBC();

		List<FuncionarioDTO> listaDTO = new ArrayList<>();

		List<Funcionario> lista = fDao.findAll();
		if (lista == null) {
			throw new RuntimeException("Funcionarios nao encontrado");
		}

		for (Funcionario f : lista) {
			FuncionarioDTO dto = new FuncionarioDTO(f);
			Double valorTotalDesconto = dDao.buscarDescontoPorFuncionarioId(f.getId());
			Double salarioLiquido = f.getSalarioBruto() - valorTotalDesconto;
			dto.setSalarioLiquido(salarioLiquido);

			listaDTO.add(dto);
		}

		comparatorSalarioLiquidoEmOrdemDescrescente(listaDTO);

		return listaDTO;

	}

	private void comparatorSalarioLiquidoEmOrdemDescrescente(List<FuncionarioDTO> listaDTO) {
		Collections.sort(listaDTO, new Comparator<FuncionarioDTO>() {

			@Override
			public int compare(FuncionarioDTO o1, FuncionarioDTO o2) {
				return o2.getSalarioLiquido().compareTo(o1.getSalarioLiquido());
			}
		});
	}
}
