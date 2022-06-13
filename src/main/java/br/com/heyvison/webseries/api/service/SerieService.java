package br.com.heyvison.webseries.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.heyvison.webseries.api.model.Serie;
import br.com.heyvison.webseries.api.repository.SerieRepository;

@Service
public class SerieService {
	
	@Autowired	
	private SerieRepository serieRepository;
	
	/**
	* Método responsável por persistir os dados na tabela [SERIE]
	* 
	* @param Serie
	* @return Serie
	*/
	public Serie salvarSerie(Serie serie) {
		return serieRepository.save(serie);
	}
	
	/**
	* Método responsável por buscar uma serie pelo ID
	* 
	* @param Integer id
	* @return Optional<Serie>
	*/
	public Optional<Serie> findById(Integer id) {
		return serieRepository.findById(id);
	}
	
	/**
	* Método responsável por buscar todas as series
	* 
	* @param Serie
	* @return Serie
	*/
	public List<Serie> findAll() {
		return serieRepository.findAll();
	}
	
	/**
	* Método responsável por deletar uma serie
	* 
	* @param Integer id
	* @return void
	*/
	public void deletarSerie(Integer id) {
	   serieRepository.deleteById(id);
	}

}
