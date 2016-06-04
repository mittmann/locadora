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

public class FinishedRentalList {
	
	
	public static ArrayList<Rental> finishedRentals = new ArrayList<Rental>();

	public ArrayList<Rental> getFinishedRentals() {
		return finishedRentals;
	}
	public static void setFinishedRentals(ArrayList<Rental> finishedRentals) {
		FinishedRentalList.finishedRentals = finishedRentals;
	}
	public FinishedRentalList() throws Exception {
		super();
		Path path = Paths.get("finishedRentals.ser");

		if (Files.exists(path)) {
			finishedRentals=readFinishedRentals();
		}
		else {
			writeFinishedRentals();
		}
	}
	public void addFinishedRentalToList(Rental finishedRental) {
		finishedRentals.add(finishedRental);
		
	}
	
	public void writeFinishedRentals() {
		try {
			// write object to file
			FileOutputStream fos = new FileOutputStream("finishedRentals.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(finishedRentals);
			oos.close();

			// read object from file.out.println("One:" + result.getOne() + ", Two:" + result.getTwo());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Rental> readFinishedRentals() throws Exception {
		try {
			FileInputStream fis = new FileInputStream("finishedRentals.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<Rental> finishedRentals = (ArrayList<Rental>) ois.readObject();
			ois.close();
			return finishedRentals;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	
	}
}
