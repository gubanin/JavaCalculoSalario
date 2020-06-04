package model.dao;

import java.util.List;

import model.entities.Funcionario;

public interface FuncionarioDao {

	List<Funcionario> findAll();
}
