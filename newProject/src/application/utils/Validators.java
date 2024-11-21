package application.utils;

import java.util.List;
import java.util.regex.Pattern;

import javafx.scene.control.TextField;

public class Validators {
	
	// Hard coded username and password
//	public static final String CORRECT_USERNAME = "admin";
//	public static final String CORRECT_PASSWORD = "pass123";
	
	private static List<Credentials> credentials = FileOperations.readFromAFile();
	
	// Email pattern
	public static boolean isValid(String text) {
		String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		return Pattern.matches(regex, text);
	}
		
	// Password Match
	public static boolean passCheck(String p1, String p2) {
		if(p1==null || p2==null) {
			return false;
		}
		return p1.equals(p2);
	}
	
	// Email Availability
	public static boolean emailAvailability(String email) {
		for(Credentials cred: credentials)
		{
			if(cred.getEmailID().equalsIgnoreCase(email))
			{
				return true;
			}
		}
		return false;
	}
	
	// Checking if Text Fields are empty or not
	public static boolean emptyFieldCheck(TextField textField) {
		return textField.getText().isEmpty();
	}
	
	// Check wether login credentials are valid or not
	public static boolean isCredentialsValid(String username, String password) {
		for(Credentials cred: credentials) {
			if(cred.getEmailID().equalsIgnoreCase(username) && cred.getPassword().equalsIgnoreCase(password)) {
				return true;
			}
		} return false;
	}
	
	public static int toResetPassword(String email) {
		
		for(Credentials cred: credentials)
		{
			if(cred.getEmailID().equalsIgnoreCase(email)) {
				return cred.getPassword().length();
			}
		}
		return 0;
	}
}