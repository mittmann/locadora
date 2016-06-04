package model;
import java.io.Serializable;

public class Client implements Serializable {
	private static final long serialVersionUID = 1L;
	protected String name;
	protected String cep;
	protected String cpf;
	protected String cnh;
	protected int code;
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	
	
	Client(String name, String cep, String cpf, String cnh) {
		this.name = name;
		this.cep = cep;
		this.cpf = cpf;
		this.cnh = cnh;
	}
	
	Client() {
		this.name = null;
		this.cep = null;
		this.cpf = null;
		this.cnh = null;
	}
}