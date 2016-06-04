package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import model.Rental;

public class RentalList {
public static ArrayList<Rental> rentals = new ArrayList<Rental>();
	
	public ArrayList<Rental> getRentals() {
		return rentals;
	}
	public static void setRentals(ArrayList<Rental> rentals) {
		RentalList.rentals = rentals;
	}
	public RentalList() throws Exception {
		super();
		Path path = Paths.get("rentals.ser");

		if (Files.exists(path)) {
			rentals=readRentals();
		}
		else {
			writeRentals();
		}
	}
	public void addRentalToList(Rental rental) {
		rentals.add(rental);
		
	}
	
	public void writeRentals() {
		try {
			// write object to file
			FileOutputStream fos = new FileOutputStream("rentals.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(rentals);
			oos.close();

			// read object from file.out.println("One:" + result.getOne() + ", Two:" + result.getTwo());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Rental> readRentals() throws Exception {
		try {
			FileInputStream fis = new FileInputStream("rentals.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<Rental> rentals = (ArrayList<Rental>) ois.readObject();
			ois.close();
			return rentals;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	
	}
}
