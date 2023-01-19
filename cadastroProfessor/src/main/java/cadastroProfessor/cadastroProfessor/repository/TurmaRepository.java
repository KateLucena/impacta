package cadastroProfessor.cadastroProfessor.repository;

import org.springframework.data.repository.CrudRepository;

import cadastroProfessor.cadastroProfessor.model.Turma;

public interface TurmaRepository extends CrudRepository<Turma, Long>{
	Turma findById(long codigo);

}
