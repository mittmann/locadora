package model;

import java.util.Calendar;
import java.util.Date;

import data.FinishedRentalList;
import data.RentalList;

public class FinishedRentalManager {
		
	public static void addFinishedRental (Rental rental) throws Exception {
		
		FinishedRentalList rentals = new FinishedRentalList();
		rentals.addFinishedRentalToList(rental);
		rentals.writeFinishedRentals();
		VehicleManager.setLocado(false, rental.getVehicle().getPlaca());
	}

}
