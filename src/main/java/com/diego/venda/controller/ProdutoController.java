package com.diego.venda.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.diego.venda.model.Produto;
import com.diego.venda.repository.ProdutoRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@PostMapping(path="/novo")
	public @ResponseBody String addProduto(@RequestBody Produto produto) {
		produtoRepository.save(produto);
		return "Produto Salvo";
	}
	
	@GetMapping(path="/")
	public @ResponseBody Iterable<Produto> getProdutos() {
		return produtoRepository.findAll();
	}
	
	@GetMapping(path="/{codigo}")
	public @ResponseBody Optional<Produto> getProdutoByCodigo(@PathVariable("codigo") String codigo) {
		return produtoRepository.findById(codigo);
	}
	
	@PutMapping(path="/editar") 
	public @ResponseBody String updateProduto(@RequestBody Produto produto) { 
		produtoRepository.save(produto);
		return "Produto atualizado";
	}
}
