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

import br.com.projetofinal.entity.Vendedor;
import br.com.projetofinal.service.VendedorService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/vendedor")
public class VendedorController {
	
	@Autowired
	private VendedorService service;
	
	@Operation(
			summary ="Lista de Vendedor ",
			description = " Esse método retorna uma lista de vendedor ")
	@GetMapping
	public ResponseEntity<List<Vendedor>> buscarTodos(){
		List<Vendedor> listaVendedor =  service.buscarVendedor();
		return ResponseEntity.status(HttpStatus.OK).body(listaVendedor);
	}
	@Operation(
			summary ="Buscar Vendedor pelo ID",
			description = " Esse método busca o vendedor ")
	@GetMapping(value ="/{id}")
	public ResponseEntity<Vendedor> procurarPorId(@PathVariable Integer id) {
		Vendedor response = service.procuraPorId(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	@Operation(
	summary ="Cadastrar Vendedor  ",
			description = " Esse método cadastra o vendedor ")
	@PostMapping
	public ResponseEntity<String> cadastrarVendedor(@RequestBody Vendedor vendedor) {
	      String response = service.cadastrarVendedor(vendedor);
	      return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	@Operation(
			summary ="Alterar Vendedor  ",
					description = " Esse método altera o vendedor ")
	@PutMapping(value = "/{id}")
	public ResponseEntity<String> alterarVendedor(@PathVariable Integer id, @RequestBody Vendedor vendedor) {
		String response = service.alterarVendedor(id, vendedor);
		return ResponseEntity.status(200).body(response);
	}
	@Operation(
			summary ="Excluir Vendedor  ",
					description = " Esse método exclui o vendedor ")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluirVendedor(@PathVariable Integer id) {
		service.excluirVendedor(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	
	

}
