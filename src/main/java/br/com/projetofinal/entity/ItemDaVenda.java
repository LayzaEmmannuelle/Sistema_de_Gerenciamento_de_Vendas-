package br.com.projetofinal.entity;





import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;





@Entity
public class ItemDaVenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idItemDaVenda;
	
	@ManyToOne
	private Produto produto;
	
	@ManyToOne
	private Venda venda;
	
	
	

	@Column(length = 6, nullable = false)
	private int quantidade=0 ;
	
	@Column(length = 6, nullable = false)
	private double valorTotal = 0;
	
	
	public ItemDaVenda () {}
	
	public ItemDaVenda(int idItemDaVenda, Produto produto, int quantidade, double valorTotal, Venda venda) {
		this.idItemDaVenda = idItemDaVenda;
		this.produto = produto;
		this.valorTotal = valorTotal;
		this.venda = venda;
	}

	public int getIdItemDaVenda() {
		return idItemDaVenda;
	}

	public void setIdItemDaVenda(int idItemDaVenda) {
		this.idItemDaVenda = idItemDaVenda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	}
			
		
		
	

