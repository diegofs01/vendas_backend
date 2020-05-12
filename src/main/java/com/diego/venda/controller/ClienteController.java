package com.diego.venda.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.diego.venda.ClienteRepository;
import com.diego.venda.model.Cliente;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	@Autowired
	private ClienteRepository clientRepository;
	
	@PostMapping(path="/novo")
	public @ResponseBody String addCliente(@RequestBody Cliente cliente) {
		clientRepository.save(cliente);
		return "Cliente Salvo";
	}
	
	@GetMapping(path="/busca")
	public @ResponseBody Iterable<Cliente> getClientes() {
		return clientRepository.findAll();
	}
	
	@GetMapping(path="/busca/{id}")
	public @ResponseBody Optional<Cliente> getClienteByCPF(@RequestParam("cpf") String cpf) {
		return clientRepository.findById(cpf);
	}
	
	@PutMapping(path="/editar") 
	public @ResponseBody String updateCliente(@RequestBody Cliente cliente) { 
		clientRepository.save(cliente);
		return "Cliente atualizado";
	}
	 
}
