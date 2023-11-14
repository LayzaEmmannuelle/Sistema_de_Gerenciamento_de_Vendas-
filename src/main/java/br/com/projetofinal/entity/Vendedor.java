package br.com.projetofinal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vendedor{


	/**
	 * 
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVendedor;
	@Column(length = 40, nullable = false)
	private String nome;
	@Column(length = 40, nullable = false, unique = true)
	private String email;
	@Column(length = 14, nullable = false, unique = true )
	private String cpf;
	
	
	public Vendedor() {}
	
	public Vendedor(int idVendedor, String cpf, String nome, String email) {
		super();
		this.idVendedor = idVendedor;
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		
	}

	public int getIdVendedor() {
		return idVendedor;
	}

	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	
	
	
	

}

