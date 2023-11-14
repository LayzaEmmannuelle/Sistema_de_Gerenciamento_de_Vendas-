package br.com.projetofinal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.projetofinal.entity.Produto;
import br.com.projetofinal.exceptions.NaoEncontradoException;
import br.com.projetofinal.repository.ProdutoRepository;


@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	
	
	
	public List<Produto> buscarProduto(){
		
		return repository.findAll();
	}
	
	public Produto procuraPorId(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new NaoEncontradoException("ID inválido! Produto não encontrado."));
	}
	
	public String cadastrarProduto(Produto produto) {
		repository.save(produto);
		return "Produtos incluído com sucesso.";
	}
	
	public String alterarProduto(Integer idProduto, Produto produto) {
		Produto response = repository.findById(idProduto).get();
		
		response.setNome(produto.getNome());
		response.setPreco(produto.getPreco());
		response.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque());
		
		
		repository.save(response);
		return "Produto alterado com sucesso.";
		}

	public String excluirProduto(Integer idProduto) {
		Produto response = repository.findById(idProduto).get();
		repository.delete(response);
		return "Produto excluído com sucesso.";
		}
}
