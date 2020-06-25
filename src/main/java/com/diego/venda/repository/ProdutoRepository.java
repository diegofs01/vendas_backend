package com.diego.venda.repository;

import org.springframework.data.repository.CrudRepository;

import com.diego.venda.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, String> {

}
