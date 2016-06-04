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

import model.Clerk;

public class ClerkList {
public static ArrayList<Clerk> staff = new ArrayList<Clerk>();
	
	public ArrayList<Clerk> getStaff() {
		return staff;
	}
	public static void setStaff(ArrayList<Clerk> staff) {
		ClerkList.staff = staff;
	}
	public ClerkList() throws Exception {
		super();
		Path path = Paths.get("staff.ser");

		if (Files.exists(path)) {
			staff=readStaff();
		}
		else {
			writeStaff();
		}
	}
	public void addClerkToList(Clerk clerk) {
		staff.add(clerk);
		
	}
	
	public void writeStaff() {
		try {
			// write object to file
			FileOutputStream fos = new FileOutputStream("staff.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(staff);
			oos.close();

			// read object from file.out.println("One:" + result.getOne() + ", Two:" + result.getTwo());

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Clerk> readStaff() throws Exception {
		try {
			FileInputStream fis = new FileInputStream("staff.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<Clerk> staff = (ArrayList<Clerk>) ois.readObject();
			ois.close();
			return staff;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	
	}
}
