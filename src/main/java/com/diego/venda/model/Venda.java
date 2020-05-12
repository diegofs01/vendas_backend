package com.diego.venda.model;

import java.sql.Timestamp;
import java.util.List;

public class Venda {
	private int id;
	private Timestamp dataVenda;
	private String cpfCliente;
	private List<Item> itens; //?
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
	
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	}
	
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	
}
