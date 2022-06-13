package br.com.heyvison.webseries.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.heyvison.webseries.api.model.Serie;

public interface SerieRepository extends JpaRepository<Serie, Integer>{

}
