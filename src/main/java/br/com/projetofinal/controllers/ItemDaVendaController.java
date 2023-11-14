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

import br.com.projetofinal.entity.ItemDaVenda;

import br.com.projetofinal.service.ItemDaVendaService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value="/itemDaVenda")
public class ItemDaVendaController {

	
	@Autowired
	private ItemDaVendaService service;

	@Operation(
			summary ="Lista de Item de Venda ",
			description = "Esse método retorna uma lista de item de venda")
	@GetMapping
	public ResponseEntity<List<ItemDaVenda>> buscarItemDaVenda(){
		List<ItemDaVenda>listaItemDaVenda = service.buscarItemDaVenda();
		return ResponseEntity.status(HttpStatus.OK).body(listaItemDaVenda);
	}
	@Operation(
			summary ="Buscar Item de Venda pelo ID ",
			description = "Esse método retorna o item de venda pelo ID")
	@GetMapping(value ="/{id}")
	public ResponseEntity<ItemDaVenda> procuraPorId(@PathVariable Integer id) {
	   ItemDaVenda response = service.procuraPorId(id);
	   return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	@Operation(
			summary ="Cadastrar Item de Venda ",
			description = "Esse método cadastra o item de venda")
	@PostMapping
	public ResponseEntity<String> cadastrarItemDaVenda(@RequestBody ItemDaVenda item) {
		String response = service.cadastrarItemDaVenda(item);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	@Operation(
			summary ="Alterar o Item de Venda ",
			description = "Esse método altera o item de venda")
	@PutMapping(value= "/{idItemDaVenda}")
	public ResponseEntity<String> alterarItemDaVenda(@PathVariable Integer idItemDaVenda, @RequestBody ItemDaVenda item) {
	String response = service.alterarItemDaVenda(idItemDaVenda, item);
	return ResponseEntity.status(200).body(response);
	}
	@Operation(
			summary ="Deletar o Item de Venda ",
			description = "Esse método deleta o item de venda")
	@DeleteMapping(value="/{idItemDaVenda}")
	public ResponseEntity<Void> excluiItemDaVenda(@PathVariable Integer idItemDaVenda) {
	service.excluirItemDaVenda(idItemDaVenda);
	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
