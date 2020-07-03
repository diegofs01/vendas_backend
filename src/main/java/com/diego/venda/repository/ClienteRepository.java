package com.diego.venda.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.diego.venda.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, String> {
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("UPDATE Cliente c SET c.ativo = ?1 WHERE c.cpf = ?2")
	void setAtivo(boolean ativo, String cpf);

	@Query(value = "SELECT * FROM cliente WHERE ativo = true", nativeQuery = true)
	Iterable<Cliente> listaClientesAtivos();
	
	@Query(value = "SELECT saldo FROM cliente WHERE cpf = ?1", nativeQuery = true)
	double consultarSaldo(String cpf);
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("UPDATE Cliente c SET c.saldo = ?1 WHERE c.cpf = ?2")
	void atualizarSaldo(double novoSaldo, String cpf);
	
}