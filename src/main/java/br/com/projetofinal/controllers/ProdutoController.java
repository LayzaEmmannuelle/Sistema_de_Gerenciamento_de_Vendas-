package br.com.projetofinal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.projetofinal.entity.Produto;
import br.com.projetofinal.service.ProdutoService;

@RestController
@RequestMapping(value="/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;

	
	
	@GetMapping
	public ResponseEntity<List<Produto>> buscarProduto(){
		List<Produto>listadeProduto = service.buscarProduto();
		return ResponseEntity.status(HttpStatus.OK).body(listadeProduto);
	}
	@GetMapping(value ="/{id}")
	public ResponseEntity<Produto> procuraPorId(@PathVariable Integer id) {
		Produto response = service.procuraPorId(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PostMapping
	public ResponseEntity<String> cadastrarProduto(@RequestBody Produto produto) {
		String response = service.cadastrarProduto(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping(value= "/{idProduto}")
	public ResponseEntity<String> alterarProduto(@PathVariable Integer idProduto, @RequestBody Produto produto) {
	String response = service.alterarProduto(idProduto, produto);
	return ResponseEntity.status(200).body(response);
	}
	
	@DeleteMapping(value="/{idProduto}")
	public ResponseEntity<Void> excluiProduto(@PathVariable Integer idProduto) {
	service.excluirProduto(idProduto);
	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
