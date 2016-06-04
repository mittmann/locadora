package model;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import data.ClerkList;

public class ClerkManager {

	public static void addClerk(String name, String cep, String cpf, String userType, String username, String password) throws Exception {
		ClerkList staff = new ClerkList();
		boolean exists = false;
		for(int i = 0; i < staff.getStaff().size(); i++) {
			if (staff.getStaff().get(i).getUsername().equals(username) || staff.getStaff().get(i).getCpf().equals(cpf)) {
				exists = true;
			}
		}  

		if (exists == false){
			Clerk clerk = new Clerk(name,cep,cpf,username,password,userType);
			staff.addClerkToList(clerk);
			staff.writeStaff();
		}
		
		else {
			System.out.println("Funcionario j� cadastrado");
		}
	}
	
	public static Boolean checkEmpty() {
		 Path path = Paths.get("staff.ser");

		if (Files.exists(path)) {
			return false;
		}
		return true;
	}
	
	public static void updateClerk(String name, String cep, String cpf, String userType, String username, String password, String oldCpf, String oldUsername) throws Exception {
		ClerkList staff = new ClerkList();
		
		
		if (oldCpf.equals(cpf)) {
			if (oldUsername.equals(username)) {
				for(int i = 0; i < staff.getStaff().size(); i++) {
					if (staff.getStaff().get(i).getCpf().equals(oldCpf)) {	
						staff.getStaff().get(i).setName(name);
						staff.getStaff().get(i).setUserType(userType);
						staff.getStaff().get(i).setCep(cep);
						staff.getStaff().get(i).setCpf(cpf);
						staff.getStaff().get(i).setUsername(username);
						staff.getStaff().get(i).setPassword(password);
						staff.writeStaff();
						return;
					}	
				}
			}
			else {
					boolean exists = false;
					for(int i = 0; i < staff.getStaff().size(); i++) {
						if (staff.getStaff().get(i).getUsername().equals(username)) {
							exists = true;
						}
					}
					if (!exists) {
						for(int i = 0; i < staff.getStaff().size(); i++) {
							if (staff.getStaff().get(i).getCpf().equals(oldCpf)) {	
								staff.getStaff().get(i).setName(name);
								staff.getStaff().get(i).setUserType(userType);
								staff.getStaff().get(i).setCep(cep);
								staff.getStaff().get(i).setCpf(cpf);
								staff.getStaff().get(i).setUsername(username);
								staff.getStaff().get(i).setPassword(password);
								staff.writeStaff();
								return;
							}	
						}
					}
					//printa erro
				}
		}	
		
		else if (oldUsername.equals(username)) {
			if (!oldCpf.equals(cpf)) {
					boolean exists = false;
					for(int i = 0; i < staff.getStaff().size(); i++) {
						if (staff.getStaff().get(i).getCpf().equals(cpf)) {
							exists = true;
						}
					}
					if (!exists) {
						for(int i = 0; i < staff.getStaff().size(); i++) {
							if (staff.getStaff().get(i).getCpf().equals(oldCpf)) {	
								staff.getStaff().get(i).setName(name);
								staff.getStaff().get(i).setUserType(userType);
								staff.getStaff().get(i).setCep(cep);
								staff.getStaff().get(i).setCpf(cpf);
								staff.getStaff().get(i).setUsername(username);
								staff.getStaff().get(i).setPassword(password);
								staff.writeStaff();
								return;
							}	
						}
					}
					//printa erro
				}
		}
		
		else {
			boolean exists = false;
			for(int i = 0; i < staff.getStaff().size(); i++) {
				if (staff.getStaff().get(i).getCpf().equals(cpf) || staff.getStaff().get(i).getUsername().equals(username)) {
					exists = true;
				}
			}
			if (!exists) {
				for(int i = 0; i < staff.getStaff().size(); i++) {
					if (staff.getStaff().get(i).getCpf().equals(oldCpf)) {	
						staff.getStaff().get(i).setName(name);
						staff.getStaff().get(i).setUserType(userType);
						staff.getStaff().get(i).setCep(cep);
						staff.getStaff().get(i).setCpf(cpf);
						staff.getStaff().get(i).setUsername(username);
						staff.getStaff().get(i).setPassword(password);
						staff.writeStaff();
						return;
					}	
				}
			}
		}
		
	}
	
	public static void removeClerk(String cpf) throws Exception {
		ClerkList staff = new ClerkList();
		boolean exists = false;
		for(int i = 0; i < staff.getStaff().size(); i++) {
			if (staff.getStaff().get(i).getCpf().equals(cpf)) {
					staff.getStaff().remove(i);
					staff.writeStaff();
					// CUIDAR QUANDO FOR REMOVER CLIENTE, VERIFICAR PENDENCIAS
					exists = true;
			}
		}
		if (exists==false) {
			System.out.println("Funcionario n�o encontrado");
			// selecionando da lista sempre vai achar cliente
		}
		
		
	}
	
}
