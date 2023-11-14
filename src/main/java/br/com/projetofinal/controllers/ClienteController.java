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

import br.com.projetofinal.entity.Cliente;
import br.com.projetofinal.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value="/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@Operation(
			summary ="Lista de Clientes",
			description = "Esse método retorna uma lista de clientes")
	@GetMapping
	public ResponseEntity<List<Cliente>> buscarCliente(){
		List<Cliente> listaCliente = service.buscarCliente();
		return ResponseEntity.status(HttpStatus.OK).body(listaCliente);
	}
	@Operation(
			summary ="Buscar Clientes pelo ID",
			description = "Esse método retorna clientes pelo ID")
	@GetMapping(value ="/{id}")
	public ResponseEntity<Cliente> porcuraPorId(@PathVariable Integer id) {
	    Cliente response = service.procuraPorId(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
}
	@Operation(
			summary ="Cadastrar Clientes",
			description = "Esse método cadastra clientes ")
	@PostMapping
	public ResponseEntity<String> cadastrarCliente(@RequestBody Cliente cliente) {
		String response = service.cadastrarCliente(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	@Operation(
			summary ="Alterar Clientes ",
			description = "Esse método altera clientes")
	@PutMapping(value= "/{idCliente}")
	public ResponseEntity<String> alterarCliente(@PathVariable Integer idCliente, @RequestBody Cliente cliente) {
	String response = service.alterarCliente(idCliente, cliente);
	return ResponseEntity.status(200).body(response);
	}
	@Operation(
			summary ="Deletar Clientes ",
			description = "Esse método deleta clientes")
	@DeleteMapping(value="/{idCliente}")
	public ResponseEntity<Void> excluirCliente(@PathVariable Integer idCliente) {
	service.excluirCliente(idCliente);
	return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
