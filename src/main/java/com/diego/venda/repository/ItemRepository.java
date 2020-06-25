package com.diego.venda.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.diego.venda.model.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {

	@Query(value = "SELECT * FROM item WHERE id_venda = ?1", nativeQuery = true)
	Iterable<Item> findItemsByVenda(int id_venda);
	
}
