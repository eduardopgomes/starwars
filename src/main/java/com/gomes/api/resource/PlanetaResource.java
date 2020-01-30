package com.gomes.api.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gomes.api.event.RecursoCriadoEvent;
import com.gomes.api.model.Planeta;
import com.gomes.api.repository.PlanetaRepository;

@RestController
@RequestMapping("/planetas")
public class PlanetaResource {
	
	@Autowired
	private PlanetaRepository planetaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;

	
	@GetMapping
	private List<Planeta> listar(){
		return planetaRepository.findAll();
	}
	
	@PostMapping
	private ResponseEntity<Planeta> criar(@Valid @RequestBody Planeta planeta, HttpServletResponse response){
		Planeta planetaSalvo = planetaRepository.save(planeta);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, planetaSalvo.getId()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(planetaSalvo);
	}

	
	@PostMapping("/{name}")
	private ResponseEntity<Planeta> buscarPeloNome(@RequestBody String name) {
		Planeta planetaEncontrada = planetaRepository.buscarPorNome(name);
		if (planetaEncontrada != null) {
			return ResponseEntity.ok(planetaEncontrada);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/{id}")
	private ResponseEntity<Planeta> buscarPorId(@RequestBody String id) {
		Optional<Planeta> planetaEncontrada = planetaRepository.findById(id);
		if (planetaEncontrada != null) {
			return ResponseEntity.ok(planetaEncontrada.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable String id) {
		
		Optional<Planeta> planetaRecuperado = planetaRepository.findById(id);
		
		planetaRepository.delete(planetaRecuperado.get());
	}
}
