package br.com.projetofinal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projetofinal.entity.Vendedor;



@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Integer>{
	Optional<Vendedor> findByEmail(String email);

}

