package cadastroProfessor.cadastroProfessor.repository;

import org.springframework.data.repository.CrudRepository;

import cadastroProfessor.cadastroProfessor.model.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, Long>{
	Professor findById(long codigo);

}
