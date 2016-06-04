package model;

import java.util.Date;

import data.ReservationList;

public class ReservationManager {

	public static Boolean addReservation (Date inicio, Date fim, Client client, Vehicle vehicle) throws Exception {
		if (checkReservationDays(inicio,fim)) {
			ReservationList reservations = new ReservationList();
			Reservation reservation = new Reservation(inicio,fim,client,vehicle);
			if (!reservations.getReservations().isEmpty()) { 
				reservation.setCode(reservations.getReservations().get(reservations.getReservations().size()-1).getCode()+1);
			}
			else {
				reservation.setCode(0);
			}
			reservations.addReservationToList(reservation);
			reservations.writeReservations();
			VehicleManager.setReservado(true, vehicle.getPlaca());
			System.out.println("criou o bagulho");
			return true;
		}
		System.out.println("não criou o bagulho");
		return false;
	}
	
	public static void removeReservation (int code) throws Exception {
		ReservationList reservations = new ReservationList();
		boolean exists = false;
		for(int i = 0; i < reservations.getReservations().size(); i++) {
			if (reservations.getReservations().get(i).getCode() == code) {
				VehicleManager.setReservado(false, reservations.getReservations().get(i).getVehicle().getPlaca());
				System.out.println(reservations.getReservations().get(i).getVehicle().getPlaca());
				reservations.getReservations().remove(i);
				reservations.writeReservations();		
				exists = true;
			}
		}
		if (exists==false) {
			System.out.println("Reserva não encontrada");
			// selecionando da lista sempre vai achar cliente
		}
	}
	
	public static Boolean checkReservationDays(Date inicio, Date fim) {
		if (inicio.compareTo(fim) <= 0)
			return true;
		return false;
	}
}
