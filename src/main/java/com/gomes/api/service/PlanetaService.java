package com.gomes.api.service;

import java.util.List;

import com.gomes.api.model.Planeta;

public interface PlanetaService {

	public List<Planeta> listarTodos();
	
	public Planeta buscarPorNome(String Nome);
	
	public Planeta buscarPorId(String id);
	
	public void remover(String id);
	
	public Planeta adicionar(Planeta planeta);
}
