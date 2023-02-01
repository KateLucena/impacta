package cadastroProfessor.cadastroProfessor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cadastroProfessor.cadastroProfessor.model.Professor;
import cadastroProfessor.cadastroProfessor.model.Turma;
import cadastroProfessor.cadastroProfessor.repository.ProfessorRepository;
import cadastroProfessor.cadastroProfessor.repository.TurmaRepository;


@Controller
public class TurmaControllerMono {
	
	@Autowired
	TurmaRepository turmaRepository;
	
	@Autowired
	ProfessorRepository professorRepository;
	
	@RequestMapping("/listarTurma")
	public ModelAndView listarTurmaMetodo() {

		ModelAndView modelAndViewTurma = new ModelAndView("listarTurma");
		Iterable<Turma> turmas = turmaRepository.findAll();



		modelAndViewTurma.addObject("turmas", turmas);


		return modelAndViewTurma;
	}
	

	@RequestMapping(value ="/cadastrarTurma/{codigo}", method = RequestMethod.GET)
	public ModelAndView cadastrarTurmaMetodo(@PathVariable("codigo") long codigo) {
		Professor professor = professorRepository.findById(codigo);
		ModelAndView modelAndViewProfessor = new ModelAndView("cadastrarTurma");
		modelAndViewProfessor.addObject("professor", professor);
		
		return modelAndViewProfessor;
			
	}
	


	@RequestMapping(value="/cadastrarTurma/{codigo}", method=RequestMethod.POST)
	public String cadastrarTurmaMetodoPost(Turma turma, @PathVariable("codigo") long codigo) {

		turma.setProfessor(professorRepository.findById(codigo));

		turmaRepository.save(turma);

		return "redirect:/listarTurma";
	}

	

}
