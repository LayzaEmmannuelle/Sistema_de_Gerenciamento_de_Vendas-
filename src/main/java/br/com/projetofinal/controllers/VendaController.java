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

import br.com.projetofinal.entity.Venda;
import br.com.projetofinal.service.VendaService;


@RestController
@RequestMapping(value="/venda")
public class VendaController {

	@Autowired
	private VendaService service;

	@GetMapping
	public ResponseEntity<List<Venda>> buscarVenda(){
		List<Venda> listaVenda = service.buscarVenda();
		return ResponseEntity.status(HttpStatus.OK).body(listaVenda);
	}
	@GetMapping(value ="/{id}")
	public ResponseEntity<Venda> procuraPorId(@PathVariable Integer id) {
		Venda response = service.procuraPorId(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PostMapping
	public ResponseEntity<String> cadastrarVenda(@RequestBody Venda venda) {
		String response = service.cadastrarVenda(venda);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PutMapping(value= "/{idVenda}")
	public ResponseEntity<String> alterarVenda(@PathVariable Integer idVenda, @RequestBody Venda venda) {
	String response = service.alterarVenda(idVenda, venda);
	return ResponseEntity.status(200).body(response);
	}
	
	@DeleteMapping(value="/{idVenda}")
	public ResponseEntity<Void> excluiVenda(@PathVariable Integer idVenda) {
	service.excluirVenda(idVenda);
	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}