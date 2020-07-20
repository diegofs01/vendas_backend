package com.diego.venda.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.diego.venda.model.Item;

public interface ItemRepository extends CrudRepository<Item, Integer> {

	@Query(value = "SELECT * FROM item WHERE id_venda = ?1", nativeQuery = true)
	Iterable<Item> findItemsByVenda(int id_venda);

	/*
	 * @Modifying(clearAutomatically = true)
	 * 
	 * @Transactional
	 * 
	 * @Query("DELETE FROM item WHERE id_item = ?1") void deleteItemById(int
	 * id_item);
	 */

	/* @Modifying(clearAutomatically = true)
	@Transactional
	@Query("UPDATE Cliente c SET c.ativo = ?1 WHERE c.cpf = ?2")
	void setAtivo(boolean ativo, String cpf); */
	
}
