package com.diego.venda.model;

import java.io.Serializable;
import java.util.Objects;

public class ItemId implements Serializable {

	private int idVenda;
	private String codigoProduto;
	
	public ItemId() {
	}
	
	public ItemId(int idVenda, String codigoProduto) {
		this.idVenda = idVenda;
		this.codigoProduto = codigoProduto;
	}
	
	@Override
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }
        if(o == null || getClass() != o.getClass()) {
        	return false;
        }
        ItemId itemId = (ItemId) o;
        return idVenda == itemId.idVenda &&
        		codigoProduto.equals(itemId.codigoProduto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVenda, codigoProduto);
    }
}
