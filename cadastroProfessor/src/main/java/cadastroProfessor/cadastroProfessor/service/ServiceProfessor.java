package cadastroProfessor.cadastroProfessor.service;

import org.springframework.stereotype.Service;

@Service
public class ServiceProfessor {
	
	
	public float calcularSalario(float qtdHorasTrabalhadas, float valorHoraTrabalhada) {
		float salario = (qtdHorasTrabalhadas * valorHoraTrabalhada);
		return salario;
		
	}

}
