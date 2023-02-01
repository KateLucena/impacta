package cadastroProfessor.cadastroProfessor.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigo;
	
	private String nome;
	
	private int idade;
	
	private String matricula;
	
	private float qtdHorasTrabalhadas;
	
	private float valorHoraTrabalhada;
	
	private float salario;
	
	@OneToMany
	private List<Turma> turma;
	
	

	public List<Turma> getTurma() {
		return turma;
	}

	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}

	public float getQtdHorasTrabalhadas() {
		return qtdHorasTrabalhadas;
	}

	public void setQtdHorasTrabalhadas(float qtdHorasTrabalhadas) {
		this.qtdHorasTrabalhadas = qtdHorasTrabalhadas;
	}

	public float getValorHoraTrabalhada() {
		return valorHoraTrabalhada;
	}

	public void setValorHoraTrabalhada(float valorHoraTrabalhada) {
		this.valorHoraTrabalhada = valorHoraTrabalhada;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

}
