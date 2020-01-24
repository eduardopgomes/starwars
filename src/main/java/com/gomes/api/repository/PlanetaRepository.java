package com.gomes.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.gomes.api.model.Planeta;

public interface PlanetaRepository extends MongoRepository<Planeta, String> {

	@Query("{name : ?0}")
	Planeta buscarPorNome(String nome);
}
