package com.diego.venda.controller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.diego.venda.model.Item;
import com.diego.venda.model.Venda;
import com.diego.venda.repository.ItemRepository;
import com.diego.venda.repository.VendaRepository;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/api/venda")
public class VendaController {
	@Autowired
	private VendaRepository vendaRepository;
	@Autowired
	private ItemRepository itemRepository;
	
	@PostMapping(path="/novo")
	public @ResponseBody String addVenda(@RequestBody Venda venda) {
		
		System.out.println(venda.getDataVenda() + " - " + venda.getDataVenda().toLocalDateTime());
		
		vendaRepository.save(venda);
		
		for(Item i: venda.getItens()) {
			i.setIdVenda(venda.getId());
			itemRepository.save(i);
		}
		
		return "Venda salvo com Sucesso";
	}
	
	@GetMapping(path="/")
	public @ResponseBody Iterable<Venda> getVendas() {
		Iterable<Venda> vendas = vendaRepository.findAll();
		
		for(Venda v: vendas) {
			Set<Item> itens = new HashSet<Item>();
			for(Item i: itemRepository.findItemsByVenda(v.getId())) {
				itens.add(i);
			}
			v.setItens(itens);
		}	
		return vendas;
	}
	
	@GetMapping(path="/{id}")
	public @ResponseBody Optional<Venda> getVendaById(@PathVariable("id") int id) {
		Optional<Venda> venda = vendaRepository.findById(id);
		
		if(venda.isPresent()) {
			Set<Item> itens = new HashSet<Item>();
			for(Item i: itemRepository.findItemsByVenda(venda.get().getId())) {
				itens.add(i);
			}
			
			venda.get().setItens(itens);
		}
		
		return venda;
	}
	
	@PutMapping(path="/editar") 
	public @ResponseBody String updateVenda(@RequestBody Venda venda) { 
		vendaRepository.save(venda);
		return "Venda atualizado";
	}
	
	@DeleteMapping(path="/excluirItem/{idItem}")
	public @ResponseBody void excluirItem(@PathVariable("idItem") int idItem) { 
		itemRepository.deleteItemById(idItem);
	}
}
