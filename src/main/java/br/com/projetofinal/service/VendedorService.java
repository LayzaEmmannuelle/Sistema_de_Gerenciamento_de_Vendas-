package br.com.projetofinal.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import br.com.projetofinal.entity.Vendedor;
import br.com.projetofinal.exceptions.NaoEncontradoException;
import br.com.projetofinal.repository.VendedorRepository;

@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository repository;
	
	public List<Vendedor> buscarVendedor(){
		return repository.findAll();
		
	}
	
	public Vendedor procuraPorId(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new NaoEncontradoException("ID inválido! Vendedor não encontrado."));
	}
	
	public String cadastrarVendedor(Vendedor vendedor) {
		repository.save(vendedor);
		return "Vendedor adicionado com sucesso!";
	}
	
	public String alterarVendedor(Integer idVendedor, Vendedor vendedor) {
		Vendedor response = repository.findById(idVendedor).get();
		
		response.setNome(vendedor.getNome());
		response.setCpf(vendedor.getCpf());
		response.setEmail(vendedor.getNome());
		
		
		repository.save(response);
		return "Vendedor editado com sucesso!";
	}
	
	public String excluirVendedor(Integer id) {
	Vendedor response = repository.findById(id).get();
	repository.delete(response);
	return "Vendedor excluído com sucesso.";
	}
	
}
