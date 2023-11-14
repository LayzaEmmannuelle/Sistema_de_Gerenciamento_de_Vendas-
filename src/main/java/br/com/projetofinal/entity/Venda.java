package br.com.projetofinal.entity;

import java.time.LocalDate;
import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;






    @Entity
    public class Venda {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVenda;
	@Column(length = 8, nullable = false)
	private LocalDate data;
	
	
	
	@ManyToOne
	private Cliente	cliente;
	
	@ManyToOne
	private Vendedor vendedor;
	
	private double valorTotalVenda = 0;
	
	@OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemDaVenda> itensVenda ;
	
	

	public Venda () {}
	


	
		
	public Venda(int idVenda, LocalDate data, Cliente cliente, Vendedor vendedor, double valorTotalVenda,
			List<ItemDaVenda> itensVenda) {
		this.idVenda = idVenda;
		this.data = data;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.valorTotalVenda = valorTotalVenda;
		this.itensVenda = itensVenda;
	}

	public double getValorTotalVenda() {
		
		return valorTotalVenda;
	}





	public void setValorTotalVenda(double valorTotalVenda) {
		this.valorTotalVenda = valorTotalVenda;
	}





	public List<ItemDaVenda> getItensVenda() {
		return itensVenda;
	}





	public void setItensVenda(List<ItemDaVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}





	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Vendedor getVendedor() {
		return vendedor;
	}



	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}



	
	
}
