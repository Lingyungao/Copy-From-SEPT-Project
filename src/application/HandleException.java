package application;

public class HandleException {
	private static String regWrong = "^[a-zA-Z0-9]+$";
	private static String regNumOnly = "^[0-9]+$";
	private static String regLetOnly = "^[a-zA-Z]+$";
	private static String regMail = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
	
	public static void UserNameInputCheck(String userInput) throws Exception {
		if (userInput.length() <= 3 || userInput.length() >= 17) {
			System.out.println("Sorry, user name length cannot less than 3 or more than 17");
			throw new Exception("Sorry, user name length cannot less than 3 or more than 17");
		} else if (userInput.matches(regWrong) == false) {
			System.out.println("Sorry, Only String available");
			throw new Exception("Sorry, Only String available");
		}

	}

	public static void PasswordInputCheck(String userInput) throws Exception {
		if (userInput.length() <= 5) {
			System.out.println("Sorry, password length is too short. The password cannot less than 5 characters.");
			throw new Exception("Sorry, password length is too short. The password cannot less than 5 characters.");
		}else if (userInput.length() >= 17) {
			System.out.println("Sorry, password length is too long. The password cannot more than 17 characters.");
			throw new Exception("Sorry, password length is too long. The password cannot more than 17 characters.");

		}
		else if (userInput.matches(regWrong) == true) {
			System.out.println("Sorry, password format is not valid. Please read the rule.");
			throw new Exception("Sorry, password format is not valid. Please read the rule.");

		}

	}

	public static void UserFuncNameInputCheck1(String userInput) throws Exception {
		if (userInput.length() <= 2 || userInput.length() >= 17) {
			System.out.println("Sorry, first name length cannot less than 3 or more than 17");
			throw new Exception("Sorry, first name length cannot less than 3 or more than 17");
		}
		if (userInput.matches(regLetOnly) == false) {
			System.out.println("Sorry, you can only input characters.");
			throw new Exception("Sorry, you can only input characters.");
		}
	}

	public static void UserFuncPhoneInputCheck(String userInput) throws Exception {
		if (userInput.length() <= 5 || userInput.length() >= 15) {
			System.out.println("Sorry, Phone number length cannot less than 5 or more than 15");
			throw new Exception("Sorry, Phone number length cannot less than 5 or more than 15");
		} else if (userInput.matches(regNumOnly) == false) {
			System.out.println("Sorry, you can only input number");
			throw new Exception("Sorry, you can only input number");
			

		}
	}
	
	public static void EditFuncPhoneInputCheck(int userInput) throws Exception {
		if (userInput <= 50000 || userInput >= 1500000000) {
			System.out.println("Sorry, Phone number length cannot less than 5 or more than 15");
			throw new Exception("Sorry, Phone number length cannot less than 5 or more than 15");
		}
	}
	
	public static void UserFuncAddressInputCheck(String userInput) throws Exception {
		if (userInput.length() <= 15 || userInput.length() >= 150) {
			System.out.println("Sorry, Address length cannot less than 15 or more than 150, and cannot only input number or characters");
			throw new Exception("Sorry, Address length cannot less than 15 or more than 150, and cannot only input number or characters");
		} else if (userInput.matches(regNumOnly) != false || userInput.matches(regLetOnly) != false) {
			System.out.println("Sorry, you cannot only input number or characters");
			throw new Exception("Sorry, you cannot only input number or characters");
			

		}
	}

	public static void UserFuncTestSQL(String empFirst, String empLast, String empPhone) throws Exception {
		if (empFirst.equals("") && empLast.equals("") && empPhone.equals("")) {
			throw new Exception("Employee's information is empty.");
		}

		if (empLast.equals("") && empPhone.equals("")) {
			throw new Exception("Last name and phone number are empty");
		}

		if (empFirst.equals("") && empPhone.equals("")) {
			throw new Exception("First name and phone number are empty.");
		}

		if (empFirst.equals("") && empLast.equals("")) {
			throw new Exception("First name and phone number are empty.");
		}

		if (empFirst.equals("")) {
			throw new Exception("First name is empty.");
		}

		if (empLast.equals("")) {
			throw new Exception("Last name is empty.");
		}

		if (empPhone.equals("")) {
			throw new Exception("Phone number is empty");
		}
	}
	
	public static void EmailInputCheck(String userInput) throws Exception {
		if (userInput.matches(regMail) == false) {
			System.out.println("Sorry, The email is not valid. Please input valid email. e.g: 123@gmail.com");
			throw new Exception("Sorry, The email is not valid. Please input valid email. e.g: 123@gmail.com");
		}

	}

}