package br.com.heyvison.webseries.api.controller;

import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.heyvison.webseries.api.model.Usuario;
import br.com.heyvison.webseries.api.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService; 

	/**
	* Metódo responsável por persistir os dados na tabela [USUARIO]
	* 
	* @param Usuario
	* @return Usuario
	*/
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario salvarSerie(@RequestBody Usuario usuario) {
		return usuarioService.salvarUsuario(usuario);
	}
		
}
