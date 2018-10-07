package com.devprime.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.devprime.cursomc.services.validation.ClienteCreate;

@ClienteCreate
public class ClienteNewDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preenchimento obrigatorio")
	@Length(min = 5, max = 120, message = "Deve ter entre 5 a 120 caracteres")
	private String nome;

	@NotEmpty(message = "Preenchimento obrigatorio no campo email")
	@Email(message = "Email invalido")
	private String email;

	@NotEmpty(message = "Preenchimento obrigatorio no campo codigo postal")
	@CPF
	private String CodigoPostal;

	private Integer tipoCliente;
	
	@NotEmpty(message = "Preenchimento obrigatorio no campo senha")
	private String senha;

	@NotEmpty(message = "Preenchimento obrigatorio no campo  logradouro")
	private String logradouro;

	@NotEmpty(message = "Preenchimento obrigatorio no campo numero")
	private String numero;

	private String complemento;

	@NotEmpty(message = "Preenchimento obrigatorio no campo  bairro")
	private String bairro;

	@NotEmpty(message = "Preenchimento obrigatorio no campo cep")
	private String cep;

	@NotEmpty(message = "Preenchimento obrigatorio no campo telefone 1")
	private String telefone1;

	private String telefone2;
	private String telefone3;

	private Integer cidadeId;

	public ClienteNewDTO() {
		super();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodigoPostal() {
		return CodigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		CodigoPostal = codigoPostal;
	}

	public Integer getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(Integer tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
	}

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
