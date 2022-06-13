package br.com.heyvison.webseries.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.heyvison.webseries.api.model.Usuario;
import br.com.heyvison.webseries.api.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired	
	private UsuarioRepository usuarioRepository;
	
	/**
	* Metódo responsável por persistir os dados na tabela [Usuario]
	* 
	* @param Usuario
	* @return Usuario
	*/
	public Usuario salvarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

}
