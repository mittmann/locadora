package model;
import java.util.Scanner;

import data.ClientList;

public class ClientManager {
	public static void addClient(String name, String cep, String cpf, String cnh) throws Exception {
		ClientList clientes = new ClientList();
		boolean exists = false;
		for(int i = 0; i < clientes.getClientes().size(); i++) {
			if (clientes.getClientes().get(i).getCnh().equals(cnh) || clientes.getClientes().get(i).getCpf().equals(cpf)) {
				exists = true;
			}
		}  

		if (exists == false){
			Client cliente = new Client(name,cep,cpf,cnh);
			if (!clientes.getClientes().isEmpty()) { 
				cliente.setCode(clientes.getClientes().get(clientes.getClientes().size()-1).getCode()+1);
			}
			else {
				cliente.setCode(0);
			}
			clientes.addClientToList(cliente);
			clientes.writeClients();
		}
		
		else {
			System.out.println("Usu�rio j� cadastrado");
		}
	}
	
	public static void updateClient(int code,String name,String cpf,String cnh,String cep,String oldCpf,String oldCnh) throws Exception {
		ClientList clientes = new ClientList();		
		
		if (oldCpf.equals(cpf)) {
			if (oldCnh.equals(cnh)) {
				for(int i = 0; i < clientes.getClientes().size(); i++) {
					if (clientes.getClientes().get(i).getCpf().equals(oldCpf)) {	
						clientes.getClientes().get(i).setName(name);
						clientes.getClientes().get(i).setCep(cep);
						clientes.getClientes().get(i).setCpf(cpf);
						clientes.getClientes().get(i).setCnh(cnh);
						clientes.writeClients();
						return;
					}	
				}
			}
			else {
					boolean exists = false;
					for(int i = 0; i < clientes.getClientes().size(); i++) {
						if (clientes.getClientes().get(i).getCnh().equals(cnh)) {
							exists = true;
						}
					}
					if (!exists) {
						for(int i = 0; i < clientes.getClientes().size(); i++) {
							if (clientes.getClientes().get(i).getCpf().equals(oldCpf)) {	
								clientes.getClientes().get(i).setName(name);
								clientes.getClientes().get(i).setCep(cep);
								clientes.getClientes().get(i).setCpf(cpf);
								clientes.getClientes().get(i).setCnh(cnh);
								clientes.writeClients();
								return;
							}	
						}
					}
					System.out.println("ja existe cnh");
				}
		}	
		
		else if (oldCnh.equals(cnh)) {
			if (!oldCpf.equals(cpf)) {
					boolean exists = false;
					for(int i = 0; i < clientes.getClientes().size(); i++) {
						if (clientes.getClientes().get(i).getCpf().equals(cpf)) {
							exists = true;
						}
					}
					if (!exists) {
						for(int i = 0; i < clientes.getClientes().size(); i++) {
							if (clientes.getClientes().get(i).getCpf().equals(oldCpf)) {	
								clientes.getClientes().get(i).setName(name);
								clientes.getClientes().get(i).setCep(cep);
								clientes.getClientes().get(i).setCpf(cpf);
								clientes.getClientes().get(i).setCnh(cnh);
								clientes.writeClients();
								return;
							}	
						}
					}
					System.out.println("ja existe cpf");
				}
		}	
		
		else {
			boolean exists = false;
			for(int i = 0; i < clientes.getClientes().size(); i++) {
				if (clientes.getClientes().get(i).getCpf().equals(cpf) || clientes.getClientes().get(i).getCnh().equals(cnh)) {
					exists = true;
				}
			}
			if (!exists) {
				for(int i = 0; i < clientes.getClientes().size(); i++) {
					if (clientes.getClientes().get(i).getCpf().equals(oldCpf)) {	
						clientes.getClientes().get(i).setName(name);
						clientes.getClientes().get(i).setCep(cep);
						clientes.getClientes().get(i).setCpf(cpf);
						clientes.getClientes().get(i).setCnh(cnh);
						clientes.writeClients();
						return;
					}	
				}
			}
		}
		
	}
	
	
	
	public static void removeClient(int code) throws Exception {
		ClientList clientes = new ClientList();
		boolean exists = false;
		for(int i = 0; i < clientes.getClientes().size(); i++) {
			if (clientes.getClientes().get(i).getCode() == code) {
					clientes.getClientes().remove(i);
					clientes.writeClients();
					// CUIDAR QUANDO FOR REMOVER CLIENTE, VERIFICAR PENDENCIAS
					exists = true;
			}
		}
		if (exists==false) {
			System.out.println("Usu�rio n�o encontrado");
			// selecionando da lista sempre vai achar cliente
		}
		
		
	}
}
