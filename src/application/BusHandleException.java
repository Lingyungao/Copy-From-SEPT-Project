package application;

/**
 * This class is working on the customer input validation.
 *
 */
public class BusHandleException {
	// Check Number Only
	private static String regNumOnly = "^[0-9]+$";
	// Check character only
	private static String regLetOnly = "^[a-zA-Z]+$";

	/**
	 * Check Username is valid or not if not match, show error message
	 * 
	 * @param User
	 *            input username.
	 */
	public static boolean BusNameInputCheck(String userInput) throws Exception {
		if (userInput.length() <= 3 || userInput.length() >= 30) {
			System.out.println("Sorry, user name length cannot less than 3 or more than 30");
			return false;
		}
		
		return true;
	}
	
	public static boolean BusDescInputCheck(String userInput) throws Exception {
		if (userInput.length() <= 3 || userInput.length() >= 150) {
			System.out.println("Sorry, user name length cannot less than 3 or more than 150");
			return false;
		}
		return true;
	}


	/**
	 * Check phone number is valid or not if not match, show error message
	 * 
	 * @param User
	 *            input phone number.
	 */
	public static boolean BusFuncPhoneInputCheck(String userInput) throws Exception {
		if (userInput.length() <= 5 || userInput.length() >= 15) {
			System.out.println("Sorry, Phone number length cannot less than 5 or more than 15");
			return false;
		} else if (userInput.matches(regNumOnly) == false) {
			System.out.println("Sorry, you can only input number");
			return false;
		}
		return true;
	}

	/**
	 * Check address is valid or not if not match, show error message
	 * 
	 * @param User
	 *            input address.
	 */
	public static boolean BusFuncAddressInputCheck(String userInput) throws Exception {
		if (userInput.length() <= 15 || userInput.length() >= 150) {
			System.out.println(
					"Sorry, Address length cannot less than 15 or more than 150, and cannot only input number or characters");
			return false;
		} else if (userInput.matches(regNumOnly) != false || userInput.matches(regLetOnly) != false) {
			System.out.println("Sorry, you cannot only input number or characters");
			return false;
		}
		return true;
	}

}