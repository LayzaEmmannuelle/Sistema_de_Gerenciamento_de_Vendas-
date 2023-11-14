package br.com.projetofinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetofinal.entity.Cliente;
import br.com.projetofinal.exceptions.NaoEncontradoException;
import br.com.projetofinal.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> buscarCliente(){
		return repository.findAll();
	}
	
	public Cliente procuraPorId(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new NaoEncontradoException("ID inválido! Cliente não encontrado."));
	}
	
	public String cadastrarCliente(Cliente cliente) {
		repository.save(cliente);
		return "Cliente incluído com sucesso.";
	}
	
	public String alterarCliente(Integer idCliente, Cliente cliente) {
		Cliente response = repository.findById(idCliente).get();
		
		response.setNome(cliente.getNome());
		response.setCpf(cliente.getCpf());
		response.setEmail(cliente.getEmail());
		response.setEndereco(cliente.getEndereco());
		
		repository.save(response);
		return "Cliente alterado com sucesso.";
		}

		public String excluirCliente(Integer idCliente) {
			Cliente response = repository.findById(idCliente).get();
			repository.delete(response);
			return "Cliente excluído com sucesso.";
		}
}
