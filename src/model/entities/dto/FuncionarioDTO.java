package model.entities.dto;

import model.entities.Funcionario;

public class FuncionarioDTO {

	private Integer id;
	private String nome;
	private Double salarioBruto;
	private Double salarioLiquido;

	public FuncionarioDTO() {
	}

	public FuncionarioDTO(Funcionario obj) {
		id = obj.getId();
		nome = obj.getNome();
		salarioBruto = obj.getSalarioBruto();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(Double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}

	public Double getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(Double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}

	@Override
	public String toString() {
		return "FuncionarioDTO [id=" + id + ", nome=" + nome + ", salarioBruto=" + salarioBruto + ", salarioLiquido="
				+ salarioLiquido + "]";
	}

}
