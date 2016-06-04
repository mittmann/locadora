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

import model.Reservation;
	
	
public class ReservationList {


public static ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	
	public ArrayList<Reservation> getReservations() {
		return reservations;
	}
	public static void setReservations(ArrayList<Reservation> reservations) {
		ReservationList.reservations = reservations;
	}
	public ReservationList() throws Exception {
		super();
		Path path = Paths.get("reservations.ser");

		if (Files.exists(path)) {
			reservations=readReservations();
		}
		else {
			writeReservations();
		}
	}
	public void addReservationToList(Reservation reservation) {
		reservations.add(reservation);
		
	}
	
	public void writeReservations() {
		try {
			// write object to file
			FileOutputStream fos = new FileOutputStream("reservations.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(reservations);
			oos.close();

			// read object from file.out.println("One:" + result.getOne() + ", Two:" + result.getTwo());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Reservation> readReservations() throws Exception {
		try {
			FileInputStream fis = new FileInputStream("reservations.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<Reservation> reservations = (ArrayList<Reservation>) ois.readObject();
			ois.close();
			return reservations;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	
	}
}
