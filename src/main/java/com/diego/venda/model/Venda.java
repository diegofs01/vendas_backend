package com.diego.venda.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Venda {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Timestamp dataVenda;
	
	@ManyToOne
	private Cliente cliente;
	
	@Transient
	private Set<Item> itens;
	
	private double valorTotal;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Timestamp getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Timestamp dataVenda) {
		this.dataVenda = dataVenda;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Set<Item> getItens() {
		return itens;
	}
	public void setItens(Set<Item> itens) {
		this.itens = itens;
	}
	
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
