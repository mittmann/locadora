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

import model.Vehicle;

public class VehicleList {

		public static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		public ArrayList<Vehicle> getVehicles() {
			return vehicles;
		}
		public static void setVehicles(ArrayList<Vehicle> vehicles) {
			VehicleList.vehicles = vehicles;
		}
		public VehicleList() throws Exception {
			super();
			Path path = Paths.get("vehicles.ser");

			if (Files.exists(path)) {
				vehicles=readVehicles();
			}
			else {
				writeVehicles();
			}
		}
		public void addVehicleToList(Vehicle vehicle) {
			vehicles.add(vehicle);
			
		}
		
		public void writeVehicles() {
			try {
				// write object to file
				FileOutputStream fos = new FileOutputStream("vehicles.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(vehicles);
				oos.close();

				// read object from file.out.println("One:" + result.getOne() + ", Two:" + result.getTwo());

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static ArrayList<Vehicle> readVehicles() throws Exception {
			try {
				FileInputStream fis = new FileInputStream("vehicles.ser");
				ObjectInputStream ois = new ObjectInputStream(fis);
				ArrayList<Vehicle> vehicles = (ArrayList<Vehicle>) ois.readObject();
				ois.close();
				return vehicles;

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		
		}
	}

