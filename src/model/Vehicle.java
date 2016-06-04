package model;

import java.io.Serializable;

public class Vehicle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String marca;
	protected String placa;
	protected String modelo;
	protected String cor;
	protected String ano;
	protected String filial;
	protected String km;
	protected String valor;
	protected Boolean reservado;
	protected Boolean locado;
	
	public Boolean getReservado() {
		return reservado;
	}
	public void setReservado(Boolean reservado) {
		this.reservado = reservado;
	}
	public Boolean getLocado() {
		return locado;
	}
	public void setLocado(Boolean locado) {
		this.locado = locado;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getFilial() {
		return filial;
	}
	public void setFilial(String filial) {
		this.filial = filial;
	}
	public String getKm() {
		return km;
	}
	public void setKm(String km) {
		this.km = km;
	}
	
	public Vehicle() {
		this.marca = null;
		this.placa = null;
		this.modelo = null;
		this.cor = null;
		this.ano = null;
		this.filial = null;
		this.km = null;
		this.valor = null;
		this.locado = false;
		this.reservado = false;		
	}
	

	
	public Vehicle(String marca, String placa, String modelo, String cor, String ano, String filial, String km, String valor) {
		this.marca = marca;
		this.placa = placa;
		this.modelo = modelo;
		this.cor = cor;
		this.ano = ano;
		this.filial = filial;
		this.km = km;
		this.valor = valor;
		this.locado = false;
		this.reservado = false;
	}	
	
}
