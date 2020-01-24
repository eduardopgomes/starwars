package com.gomes.api.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gomes.api.model.Planeta;
import com.gomes.api.repository.PlanetaRepository;
import com.gomes.api.service.PlanetaService;

@Service
public class PlanetaServiceImp implements PlanetaService {

	@Autowired
	private PlanetaRepository planetaRepository;
	
	@Override
	public List<Planeta> listarTodos() {

		return this.planetaRepository.findAll();
	}

	@Override
	public Planeta buscarPorNome(String Nome) {
		return null;
//		return this.planetaRepository.findOne(Nome);
	}

	@Override
	public Planeta buscarPorId(String id) {
		return this.planetaRepository.findById(id).get();
	}

	@Override
	public void remover(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Planeta adicionar(Planeta planeta) {
		return this.planetaRepository.save(planeta);
	}

}
