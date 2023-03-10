package cadastroProfessor.cadastroProfessor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cadastroProfessor.cadastroProfessor.model.Professor;
import cadastroProfessor.cadastroProfessor.repository.ProfessorRepository;
import cadastroProfessor.cadastroProfessor.service.ServiceProfessor;

@Controller
public class ProfessorControllerMono {
	
	@Autowired
	ProfessorRepository professorRepository;
	
	
	@RequestMapping("/")
	public ModelAndView listarProfessorMetodo() {

		ModelAndView modelAndViewProfessor = new ModelAndView("listarProfessor");
		Iterable<Professor> professores = professorRepository.findAll();



		modelAndViewProfessor.addObject("professores", professores);


		return modelAndViewProfessor;
	}

	@RequestMapping("/cadastrarProfessor")
	public String cadastrarProfessorMetodo() {

		return "cadastrarProfessor";
	}


	@RequestMapping(value="/cadastrarProfessor", method=RequestMethod.POST)
	public String cadastrarProfessorMetodoPost(Professor professor) {


		ServiceProfessor serviceProfessor = new ServiceProfessor();

		professor.setSalario(serviceProfessor.calcularSalario(professor.getQtdHorasTrabalhadas(), professor.getValorHoraTrabalhada()));

		professorRepository.save(professor);



		return "redirect:/";
	}
	
	@RequestMapping("/deletarProfessor")
	public String deletarProfessor(long codigo) {
		Professor professor = professorRepository.findById(codigo);

		professorRepository.delete(professor);

		return "redirect:/";
	}
	
	@RequestMapping(value ="/{codigo}", method = RequestMethod.GET)
	public ModelAndView editarProfessorMetodo(@PathVariable("codigo") long codigo) {
		Professor professor = professorRepository.findById(codigo);
		ModelAndView modelAndViewProfessor = new ModelAndView("editarProfessor");
		modelAndViewProfessor.addObject("professor", professor);
		
		return modelAndViewProfessor;
			
	}
	
	@RequestMapping(value ="/{codigo}", method = RequestMethod.POST)
	public String editarProfessorPost(Professor professor) {
		
		ServiceProfessor serviceProfessor = new ServiceProfessor();
		
		professor.setSalario(serviceProfessor.calcularSalario(professor.getQtdHorasTrabalhadas(), professor.getValorHoraTrabalhada()));
		
		professorRepository.save(professor);
		
		return "redirect:/";
	}

}
