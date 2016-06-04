package model;

import data.VehicleList;

public class VehicleManager {
	public static void addVehicle(String marca, String placa, String modelo, String cor, String ano, String filial, String km, String valor) throws Exception {
		VehicleList vehicles = new VehicleList();
		boolean exists = false;
		for(int i = 0; i < vehicles.getVehicles().size(); i++) {
			if (vehicles.getVehicles().get(i).getPlaca().equals(placa)) {
				exists = true;
			}
		}  

		if (exists == false){
			Vehicle vehicle = new Vehicle(marca,placa,modelo,cor,ano,filial,km,valor);
			vehicles.addVehicleToList(vehicle);
			vehicles.writeVehicles();
		}
		
		else {
			System.out.println("Veículo já cadastrado");
		}
	}
	
	public static void setReservado(Boolean reservado,String placa) throws Exception {
		VehicleList vehicles = new VehicleList();
		boolean exists = false;
		for(int i = 0; i < vehicles.getVehicles().size(); i++) {
			if (vehicles.getVehicles().get(i).getPlaca().equals(placa)) {
					vehicles.getVehicles().get(i).setReservado(reservado);
					vehicles.writeVehicles();
					exists = true;
			}
		}
	}
	public static void setLocado(Boolean locado,String placa) throws Exception {
		VehicleList vehicles = new VehicleList();
		boolean exists = false;
		for(int i = 0; i < vehicles.getVehicles().size(); i++) {
			if (vehicles.getVehicles().get(i).getPlaca().equals(placa)) {
					vehicles.getVehicles().get(i).setLocado(locado);
					vehicles.writeVehicles();
					exists = true;
			}
		}
		
	}
	
	
	public static void updateVehicle(String marca, String placa, String modelo, String cor, String ano, String filial, String km, String valor, String placaOriginal) throws Exception {
		VehicleList vehicles = new VehicleList();
		if (placaOriginal.equals(placa)) {
			for(int i = 0; i < vehicles.getVehicles().size(); i++) {
				if (vehicles.getVehicles().get(i).getPlaca().equals(placaOriginal)) {	
					vehicles.getVehicles().get(i).setMarca(marca);
					vehicles.getVehicles().get(i).setPlaca(placa);
					vehicles.getVehicles().get(i).setModelo(modelo);
					vehicles.getVehicles().get(i).setCor(cor);
					vehicles.getVehicles().get(i).setAno(ano);
					vehicles.getVehicles().get(i).setFilial(filial);
					vehicles.getVehicles().get(i).setValor(valor);
					vehicles.writeVehicles();
					return;
				}
			}
		}
		
		else {
			boolean exists2 = false;
			for(int i = 0; i < vehicles.getVehicles().size(); i++) {
				if (vehicles.getVehicles().get(i).getPlaca().equals(placa)) {
					exists2 = true;
				}
			} 
			if (!exists2) {
				for(int i = 0; i < vehicles.getVehicles().size(); i++) {
					if (vehicles.getVehicles().get(i).getPlaca().equals(placaOriginal)) {	
						vehicles.getVehicles().get(i).setMarca(marca);
						vehicles.getVehicles().get(i).setPlaca(placa);
						vehicles.getVehicles().get(i).setModelo(modelo);
						vehicles.getVehicles().get(i).setCor(cor);
						vehicles.getVehicles().get(i).setAno(ano);
						vehicles.getVehicles().get(i).setFilial(filial);
						vehicles.getVehicles().get(i).setValor(valor);
						vehicles.writeVehicles();
						return;
					}
				}
			}
		}
		
		
		/*boolean exists = false;
		boolean exists2 = false;
		for(int i = 0; i < vehicles.getVehicles().size(); i++) {
			if (vehicles.getVehicles().get(i).getPlaca().equals(placa)) {
				exists2 = true;
			}
		} 
		if (!exists2) {
			for(int i = 0; i < vehicles.getVehicles().size(); i++) {
				if (vehicles.getVehicles().get(i).getPlaca().equals(placaOriginal)) {	
					vehicles.getVehicles().get(i).setMarca(marca);
					vehicles.getVehicles().get(i).setPlaca(placa);
					vehicles.getVehicles().get(i).setModelo(modelo);
					vehicles.getVehicles().get(i).setCor(cor);
					vehicles.getVehicles().get(i).setAno(ano);
					vehicles.getVehicles().get(i).setFilial(filial);
					vehicles.getVehicles().get(i).setValor(valor);
					vehicles.writeVehicles();
					exists = true;
				}
			}
			
			if (exists==false) {
				System.out.println("Veiculo não encontrado");
				// selecionando da lista sempre vai achar vehicle
			}
		
		}
		
		else {
			System.out.println("Veiculo já cadastrado");

		}*/
		
		
		
	}
	
	public static void removeVehicle(String placa) throws Exception {
		VehicleList vehicles = new VehicleList();
		boolean exists = false;
		for(int i = 0; i < vehicles.getVehicles().size(); i++) {
			if (vehicles.getVehicles().get(i).getPlaca().equals(placa)) {
					vehicles.getVehicles().remove(i);
					vehicles.writeVehicles();
					System.out.println("TESTEEEEE");
					exists = true;
			}
		}
		if (exists==false) {
			System.out.println("Veiculo não encontrado");
			// selecionando da lista sempre vai achar vehicle
		}
		
		
	}
	
}
