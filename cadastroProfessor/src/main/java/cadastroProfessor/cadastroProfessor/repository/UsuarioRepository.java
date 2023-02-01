package cadastroProfessor.cadastroProfessor.repository;

import org.springframework.data.repository.CrudRepository;

import cadastroProfessor.cadastroProfessor.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String> {

	Usuario findByLogin(String login);
	
}