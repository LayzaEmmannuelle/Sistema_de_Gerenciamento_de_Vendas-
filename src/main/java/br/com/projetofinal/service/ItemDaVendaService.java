package br.com.projetofinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.projetofinal.entity.ItemDaVenda;
import br.com.projetofinal.exceptions.NaoEncontradoException;
import br.com.projetofinal.repository.ItemDaVendaRepository;

@Service
public class ItemDaVendaService {

	@Autowired
	private ItemDaVendaRepository repository;
	
	
	
	
	public List<ItemDaVenda> buscarItemDaVenda(){
		
		return repository.findAll();
	}
	public ItemDaVenda procuraPorId(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new NaoEncontradoException("ID invalido! Item da venda não encontrada."));
	}
	
	public String cadastrarItemDaVenda(ItemDaVenda item) {
		repository.save(item);
		
		return "Item da Venda incluída com sucesso.";
	}
	
	public String alterarItemDaVenda(Integer idItemDaVenda, ItemDaVenda item) {
		ItemDaVenda response = repository.findById(idItemDaVenda).get();
		
		response.setProduto(item.getProduto());
		response.setQuantidade(item.getQuantidade());
		response.setVenda(item.getVenda());
		response.setValorTotal(item.getValorTotal());
		
		
	
		repository.save(response);
		return "Item da Venda alterada com sucesso.";
		}

	public String excluirItemDaVenda(Integer idItemDaVenda) {
		ItemDaVenda response = repository.findById(idItemDaVenda).get();
		repository.delete(response);
		return "Item da Venda excluída com sucesso.";
		}
}
