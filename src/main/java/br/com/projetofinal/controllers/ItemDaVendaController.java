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

@RestController
@RequestMapping(value="/itemDaVenda")
public class ItemDaVendaController {

	
	@Autowired
	private ItemDaVendaService service;

	
	@GetMapping
	public ResponseEntity<List<ItemDaVenda>> buscarItemDaVenda(){
		List<ItemDaVenda>listaItemDaVenda = service.buscarItemDaVenda();
		return ResponseEntity.status(HttpStatus.OK).body(listaItemDaVenda);
	}
	@GetMapping(value ="/{id}")
	public ResponseEntity<ItemDaVenda> procuraPorId(@PathVariable Integer id) {
	   ItemDaVenda response = service.procuraPorId(id);
	   return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PostMapping
	public ResponseEntity<String> cadastrarItemDaVenda(@RequestBody ItemDaVenda item) {
		String response = service.cadastrarItemDaVenda(item);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping(value= "/{idItemDaVenda}")
	public ResponseEntity<String> alterarItemDaVenda(@PathVariable Integer idItemDaVenda, @RequestBody ItemDaVenda item) {
	String response = service.alterarItemDaVenda(idItemDaVenda, item);
	return ResponseEntity.status(200).body(response);
	}
	
	@DeleteMapping(value="/{idItemDaVenda}")
	public ResponseEntity<Void> excluiItemDaVenda(@PathVariable Integer idItemDaVenda) {
	service.excluirItemDaVenda(idItemDaVenda);
	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
