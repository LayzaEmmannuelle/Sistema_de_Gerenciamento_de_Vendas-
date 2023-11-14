package br.com.projetofinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetofinal.entity.ItemDaVenda;
import br.com.projetofinal.entity.Venda;
import br.com.projetofinal.exceptions.NaoEncontradoException;
import br.com.projetofinal.repository.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository repository;
	
	ItemDaVenda item = new ItemDaVenda();
	
	public List<Venda> buscarVenda(){
		item.getIdItemDaVenda();
		return repository.findAll();
	}
	public Venda procuraPorId(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new NaoEncontradoException("ID inválido! Venda não encontrada."));
	}
	
	public String cadastrarVenda(Venda venda) {
		repository.save(venda);
		return "Venda incluída com sucesso.";
	}
	
	public String alterarVenda(Integer idVenda, Venda venda) {
		Venda response = repository.findById(idVenda).get();
		
		
		response.setData(venda.getData());
		response.setCliente(venda.getCliente());
		response.setVendedor(venda.getVendedor());
		response.setItensVenda(venda.getItensVenda());
		response.setValorTotalVenda(venda.getValorTotalVenda());
		
		
		
		
		
		repository.save(response);
		return "Venda alterada com sucesso.";
		}

	public String excluirVenda(Integer idVenda) {
		Venda response = repository.findById(idVenda).get();
		repository.delete(response);
		return "Venda excluída com sucesso.";
		}

}
