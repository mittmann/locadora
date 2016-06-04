package model;

import java.io.Serializable;
import java.util.Date;

public class Reservation implements Serializable {

	protected int code;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	protected Date inicio;
	protected Date fim;
	protected Client client;
	protected Vehicle vehicle;
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFim() {
		return fim;
	}
	public void setFim(Date fim) {
		this.fim = fim;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Reservation(Date inicio, Date fim, Client client, Vehicle vehicle) {
		super();
		this.inicio = inicio;
		this.fim = fim;
		this.client = client;
		this.vehicle = vehicle;
	}
	public Reservation() {
		super();
	}
	
	
}
