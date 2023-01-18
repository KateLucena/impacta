package cadastroProfessor.cadastroProfessor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cadastroProfessor.cadastroProfessor.model.Professor;
import cadastroProfessor.cadastroProfessor.repository.ProfessorRepository;
import cadastroProfessor.cadastroProfessor.service.ServiceProfessor;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProfessorController {
	
	@Autowired
	
	ProfessorRepository professorRepository;
	
	
	@GetMapping("/professores")
	public List<Professor> listarProfessores(){
		List<Professor> listaProfessores = (List<Professor>) professorRepository.findAll(); 
		return listaProfessores;
	}
	
	@PostMapping("/cadastrarProfessor")
	public void cadastrarProfessor(@RequestBody Professor professor) {
		
		ServiceProfessor salario = new ServiceProfessor();
		professor.setSalario(salario.calcularSalario(professor.getQtdHorasTrabalhadas(), professor.getValorHoraTrabalhada()));
		professorRepository.save(professor);
	}

	@GetMapping("/professor/{codigo}")
	public Professor procurarProfessor(@PathVariable long codigo) {

		Professor professor = professorRepository.findById(codigo);

		return professor;
	}

	@DeleteMapping("/professorDeletar/{codigo}")
	public void deletarProfessor(@PathVariable long codigo) {
		Professor professor = professorRepository.findById(codigo);

		professorRepository.delete(professor);


	}

	@PutMapping("/editarProfessor")
	public void editarProfessor(@RequestBody Professor professor) {

		professorRepository.save(professor);

	}
	
}
