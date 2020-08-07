package com.diego.venda.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.diego.venda.model.Cliente;
import com.diego.venda.repository.ClienteRepository;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	@Autowired
	private ClienteRepository clientRepository;
	
	@PostMapping(path="/novo")
	public @ResponseBody HttpStatus addCliente(@RequestBody Cliente cliente) {
		if(cliente == null) {
			return HttpStatus.BAD_REQUEST;//400
		}
		if(clientRepository.existsById(cliente.getCpf())) {
			return HttpStatus.CONFLICT;//409
		}
		if(cliente.validar()) {
			clientRepository.save(cliente);
			return HttpStatus.CREATED;//201
		}
		return HttpStatus.BAD_REQUEST;
	}
	
	@GetMapping(path="/")
	public @ResponseBody Iterable<Cliente> getClientes() {
		return clientRepository.findAll();
	}
	
	@GetMapping(path="/{cpf}")
	public @ResponseBody Optional<Cliente> getClienteByCPF(@PathVariable("cpf") String cpf) {
		return clientRepository.findById(cpf);
	}
	
	@PutMapping(path="/editar") 
	public @ResponseBody HttpStatus updateCliente(@RequestBody Cliente cliente) {
		if(cliente == null) {
			return HttpStatus.BAD_REQUEST;//400
		}
		if(cliente.validar()) {
			clientRepository.save(cliente);
			return HttpStatus.OK;//200
		}
		return HttpStatus.BAD_REQUEST;
	}
	
	@PostMapping(path="/desativar/{cpf}")
	public @ResponseBody HttpStatus desativarCliente(@PathVariable("cpf") String cpf) {
		if(cpf != null) {
			clientRepository.setAtivo(false, cpf);
			return HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
	}
	
	@PostMapping(path="/ativar/{cpf}")
	public @ResponseBody HttpStatus ativarCliente(@PathVariable("cpf") String cpf) {
		if(cpf != null) {
			clientRepository.setAtivo(true, cpf);
			return HttpStatus.OK;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping(path="/ativos")
	public @ResponseBody Iterable<Cliente> getClientesAtivos() {
		return clientRepository.listaClientesAtivos();
	}
	
}
