package br.com.heyvison.webseries.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.heyvison.webseries.api.model.Serie;
import br.com.heyvison.webseries.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
