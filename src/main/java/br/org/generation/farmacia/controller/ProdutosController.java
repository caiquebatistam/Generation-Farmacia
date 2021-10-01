package br.org.generation.farmacia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.farmacia.model.Produtos;
import br.org.generation.farmacia.repository.ProdutosRepository;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") // liberar o acesso para o front
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	private ProdutosRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Produtos>> getAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produtos> getById(@PathVariable long id)
	{
		return repository.findById(id) .map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produtos>> getByNome(@PathVariable String nome)
	{
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Produtos> post(@RequestBody Produtos produtos)
	{
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(produtos));
	}
	
	
	@PutMapping
	public ResponseEntity<Produtos> put(@RequestBody Produtos produtos)
	{
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(produtos));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id)
	{
		repository.deleteById(id);
	}
	

}
