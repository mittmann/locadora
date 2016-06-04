package model;

import java.io.Serializable;

public class Clerk implements Serializable{
	protected String name;
	protected String cpf;
	protected String cep;
	protected String userType;
	protected String username;
	protected String password;
	
	
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Clerk(String name, String cpf, String cep, String username, String password, String userType) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.cep = cep;
		this.username = username;
		this.password = password;
		this.userType = userType;
	}
	
	public Clerk() {
		this.name = null;
		this.cpf = null;
		this.cep = null;
		this.username = null;
		this.password = null;
		this.userType = null;
	}
	
	
	
}
