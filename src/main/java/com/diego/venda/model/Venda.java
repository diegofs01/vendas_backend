package com.diego.venda.model;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Venda {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	private Timestamp dataVenda;
	
	private String cpfCliente;
	
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
	
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
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
