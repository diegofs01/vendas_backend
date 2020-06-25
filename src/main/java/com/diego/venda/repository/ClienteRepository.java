package com.diego.venda.repository;

import org.springframework.data.repository.CrudRepository;

import com.diego.venda.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, String> {
		
}