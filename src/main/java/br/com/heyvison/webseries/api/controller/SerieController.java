package br.com.heyvison.webseries.api.controller;

import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.heyvison.webseries.api.model.Serie;
import br.com.heyvison.webseries.api.service.SerieService;

@RestController
@RequestMapping("/serie")
public class SerieController {
	
	@Autowired
	private SerieService serieService; 
	
	@Autowired
	private ModelMapper modelMapper;

	/**
	* Método responsável por persistir os dados na tabela [SERIE]
	* 
	* @param Serie
	* @return Serie
	*/
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Serie salvarSerie(@RequestBody Serie serie) {
		return serieService.salvarSerie(serie);
	}
	
	/**
	* Método responsável por buscar uma serie pelo ID
	* 
	* @param Integer id
	* @return Optional<Serie>
	*/
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Serie> buscarSerieId(@PathVariable Integer id) {
		return serieService.findById(id);
	}
	
	/**
	* Método responsável por buscar todas as series
	* 
	* @param Serie
	* @return Serie
	*/
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<Serie> buscarTodasSeries() {
		return serieService.findAll();
	}
	
	/**
	* Método responsável por deletar uma serie
	* 
	* @param Serie
	* @return Serie
	*/
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deletarSerie(@PathVariable Integer id) {
		serieService.deletarSerie(id);
	}
	
	/**
	* Método responsável por atualizar uma serie
	* 
	* @param Integer id, Serie
	* @return void
	*/
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void atualizarSerie(@PathVariable Integer id, @RequestBody Serie serie) {
		serieService.findById(id).map(serieBase -> {
          try {
            modelMapper.map(serie, serieBase);

            serieService.salvarSerie(serieBase);
          } catch (Exception e) {
            e.printStackTrace();
          }
          return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Serie não encontrada, verifique o id informado."
        ));
	}	
}
