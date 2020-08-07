package com.diego.venda.model;

import java.sql.Date;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	private String cpf;
	private String nome;
	private Date dataNascimento;
	private String sexo;
	private String cep;
	private String logradouro;
	private int numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;	
	private double saldo;
	private boolean ativo;

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}

	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public boolean validar() {
		int digito = 0, soma = 0;
		String ufList[] = {"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"};
		
		this.cpf = this.cpf.replace(".-", "");
		
		//comprimento
		if(this.cpf.length() != 11) {
			System.out.println("tamanho do cpf invalido");
			return false;
		}
		
		//todos numeros iguais
		if( this.cpf.equals("00000000000") ||
			this.cpf.equals("11111111111") ||
			this.cpf.equals("22222222222") ||
			this.cpf.equals("33333333333") ||
			this.cpf.equals("44444444444") ||
			this.cpf.equals("55555555555") ||
			this.cpf.equals("66666666666") ||
			this.cpf.equals("77777777777") ||
			this.cpf.equals("88888888888") ||
			this.cpf.equals("99999999999")
		  ) {
			System.out.println("cpf com numeros iguais");
			return false;
		}
		
		//1º digito
		for (int i = 0; i < 9; i++) {
			soma += Character.getNumericValue(this.cpf.charAt(i)) * (10 - i);
		}
		digito = 11 - (soma % 11);
		if(digito == 10 || digito == 11) {
			digito = 0;
		}
		if(digito != Character.getNumericValue(this.cpf.charAt(9))) {
			System.out.println("1º digito invalido");
			return false;
		}
		
		//2º digito
		soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Character.getNumericValue(this.cpf.charAt(i)) * (11 - i);
        }
        digito = 11 - (soma % 11);
        if(digito == 10 || digito == 11) {
            digito = 0;
        }
        if(digito != Character.getNumericValue(this.cpf.charAt(10))) {
			System.out.println("2º digito invalido");
            return false;
        }
        
        //nome nao pode ser nulo ou "vazio"
        if(this.nome == null || this.nome.length() <= 0) {
			System.out.println("nome: " + this.nome + " nulo ou vazio");
        	return false;
        }
        
        //dataNascimento nao pode ser nulo
        if(this.dataNascimento == null) {
			System.out.println("data de nascimento nulo");
        	return false;
        }
        
        //Masculino ou Feminino senao false
        if(!this.sexo.equals("Masculino") && !this.sexo.equals("Feminino")) {
			System.out.println("sexo " + this.sexo + " invalido");
        	return false;
        }
        
        //cep tem que ter 8 caracteres e nao pode ser nulo
        this.cep = this.cep.replace("-", "");
        if(this.cep == null || this.cep.length() != 8) {
			System.out.println("cep nulo ou invalido");
        	return false;
        }
        
        //logradouro nao pode ser nulo ou sem caracteres
        if(this.logradouro == null || this.logradouro.length() <= 0) {
			System.out.println("logradouto nulo ou invalido (qtd caracteres invalidos)");
        	return false;
        }
        
        //numero da casa, 0 = sem numero
        if(this.numero < 0) {
			System.out.println("numero menor que zero");
        	return false;
        }
        
        //complemento pode ser vazio mas nao nulo
        if(this.complemento == null || this.complemento.length() < 0) {
			System.out.println("complemento nulo ou invalido (qtd caracteres invalidos)");
        	return false;
        }
        
        //bairro nao pode ser nulo ou sem caracteres
        if(this.bairro == null || this.bairro.length() <= 0) {
			System.out.println("bairro nulo ou invalido (qtd caracteres invalidos)");
        	return false;
        }
        
        //cidade nao pode ser nulo ou sem caracteres
        if(this.cidade == null || this.cidade.length() <= 0) {
			System.out.println("cidade nulo ou invalido (qtd caracteres invalidos)");
        	return false;
        }
        
        //UF nao pode ser nulo, tem que ter 2 caracteres
        if(this.uf == null || this.uf.length() != 2) {
			System.out.println("uf nulo ou invalido");
        	return false;
        }
        //e tem que ser um estado valido
        if(!Arrays.asList(ufList).contains(this.uf)) {
			System.out.println("uf nao existente");
        	return false;
        }
        
        //saldo nao pode ser negativo ou zero
        if(saldo <= 0) {
			System.out.println("saldo menor que zero");
        	return false;
        }
		
		return true;
	}
	
}
