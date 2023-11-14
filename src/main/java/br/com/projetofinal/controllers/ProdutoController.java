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
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value="/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;

	
	@Operation(
			summary ="Lista de Produtos ",
			description = "Esse método retorna uma lista de produtos")
	@GetMapping
	public ResponseEntity<List<Produto>> buscarProduto(){
		List<Produto>listadeProduto = service.buscarProduto();
		return ResponseEntity.status(HttpStatus.OK).body(listadeProduto);
	}
	@Operation(
			summary ="Lista de Produtos pelo ID ",
			description = "Esse método busca o produtos pelo ID")
	@GetMapping(value ="/{id}")
	public ResponseEntity<Produto> procuraPorId(@PathVariable Integer id) {
		Produto response = service.procuraPorId(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	@Operation(
			summary ="Cadastrar Produtos ",
			description = "Esse método cadastra produtos")
	@PostMapping
	public ResponseEntity<String> cadastrarProduto(@RequestBody Produto produto) {
		String response = service.cadastrarProduto(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	@Operation(
			summary ="Alterar Produtos ",
			description = "Esse método altera o produto")
	@PutMapping(value= "/{idProduto}")
	public ResponseEntity<String> alterarProduto(@PathVariable Integer idProduto, @RequestBody Produto produto) {
	String response = service.alterarProduto(idProduto, produto);
	return ResponseEntity.status(200).body(response);
	}
	@Operation(
			summary ="Deletar Produtos ",
			description = "Esse método deleta o produto")
	@DeleteMapping(value="/{idProduto}")
	public ResponseEntity<Void> excluiProduto(@PathVariable Integer idProduto) {
	service.excluirProduto(idProduto);
	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
