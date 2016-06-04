package model;

import java.util.ArrayList;

import data.ClerkList;
import data.ClientList;
import data.FinishedRentalList;
import data.RentalList;
import data.ReservationList;
import data.VehicleList;

public class ListsManager {

	public static ArrayList<Clerk> retrieveStaff() throws Exception {
		ClerkList staff = new ClerkList();
		return staff.getStaff();
	}
	public static ArrayList<Client> retrieveClients() throws Exception {
		ClientList clients = new ClientList();
		return clients.getClientes();
	}
	public static ArrayList<Vehicle> retrieveVehicles() throws Exception {
		VehicleList vehicle = new VehicleList();
		return vehicle.getVehicles();
	}
	public static ArrayList<Reservation> retrieveReservations() throws Exception {
		ReservationList reservations = new ReservationList();
		return reservations.getReservations();
	}
	public static ArrayList<Rental> retrieveRentals() throws Exception {
		RentalList rentals = new RentalList();
		return rentals.getRentals();
	}
	
	public static ArrayList<Rental> retrieveFinishedRentals() throws Exception {
		FinishedRentalList finishedRentals = new FinishedRentalList();
		return finishedRentals.getFinishedRentals();
	}
	
}
