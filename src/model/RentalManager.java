package model;

import java.util.Calendar;
import java.util.Date;

import data.RentalList;

public class RentalManager {

	public static void addRental (Date inicio, Date fim, Client client, Vehicle vehicle) throws Exception {
		
			RentalList rentals = new RentalList();
			Rental rental = new Rental(inicio,fim,client,vehicle);
			if (!rentals.getRentals().isEmpty()) { 
				rental.setCode(rentals.getRentals().get(rentals.getRentals().size()-1).getCode()+1);
			}
			else {
				rental.setCode(0);
			}
			float price = calculatePrice(inicio, fim, vehicle.getValor());
			rental.setValue(String.valueOf(price));
			System.out.println(rental.getValue());
			rentals.addRentalToList(rental);
			rentals.writeRentals();
			VehicleManager.setLocado(true, vehicle.getPlaca());
		
		}

	
	public static void removeRental (int code) throws Exception {
		RentalList rentals = new RentalList();
		boolean exists = false;
		for(int i = 0; i < rentals.getRentals().size(); i++) {
			if (rentals.getRentals().get(i).getCode() == code) {
				VehicleManager.setReservado(false, rentals.getRentals().get(i).getVehicle().getPlaca());
				System.out.println(rentals.getRentals().get(i).getVehicle().getPlaca());
				rentals.getRentals().remove(i);
				rentals.writeRentals();		
				exists = true;
			}
		}
		if (exists==false) {
			System.out.println("Locação não encontrada");
			// selecionando da lista sempre vai achar cliente
		}
	}
	
	public static float calculatePrice(Date inicio, Date fim, String value) {
		Calendar calendar1 = Calendar.getInstance();
	    Calendar calendar2 = Calendar.getInstance();
	    calendar1.setTime(inicio);
	    calendar2.setTime(fim);
	    long milliseconds1 = calendar1.getTimeInMillis();
	    long milliseconds2 = calendar2.getTimeInMillis();
	    long diff = milliseconds2 - milliseconds1;
	    long diffDays = diff / (24 * 60 * 60 * 1000);

		return Float.parseFloat(value)*diffDays;
	}
	
	
}
