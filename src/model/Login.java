package model;

import data.ClerkList;

public class Login {

	public static String checkUsernameAndPassword(String username, String password) throws Exception {
		ClerkList staff = new ClerkList();
		for (int i = 0;i<staff.getStaff().size();i++) {
			if (username.equals(staff.getStaff().get(i).getUsername())){
				if (password.equals(staff.getStaff().get(i).getPassword())) {
					return staff.getStaff().get(i).getUserType();
				}
			}
		}
		return "Error";
	}
}
