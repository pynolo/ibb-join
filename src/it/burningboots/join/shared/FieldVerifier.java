package it.burningboots.join.shared;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldVerifier {

	private static final String emailRegExp = "^([\\w_!#\\$%&'\\*\\+\\-/=\\?\\^`\\{\\|\\}~\\.])+@([\\w\\-\\.]+\\.)+[\\w]{2,8}$";
	//private static final String emailRegExp = "^([a-zA-Z0-9_\\-\\.])+@([\\w\\-\\.]+\\.)+[A-Z]{2,6}$";
	private static final Pattern emailPattern = Pattern.compile(emailRegExp, Pattern.CASE_INSENSITIVE);
	private static final String nameRegExp = "^([a-zA-Z\\s])+$";
	private static final Pattern namePattern = Pattern.compile(nameRegExp, Pattern.CASE_INSENSITIVE);
	
	public static void validateName(String name) throws ValidationException {
		if (name == null) {
			throw new ValidationException("Please enter your name / Inserisci il tuo nome per favore");
		} else {
			Matcher matcher = namePattern.matcher(name);
			if (!matcher.matches()) {
				throw new ValidationException("Please enter only alphanumeric values for your name / Inserisci solo numeri e lettere per favore");
			}
		}
	}
	
	public static void validateEmailName(String email) throws ValidationException {
		if (email == null) {
			throw new ValidationException("Please enter your email / Inserisci la tua email");
		} else {
			Matcher matcher = emailPattern.matcher(email);
			if (!matcher.matches()) {
				throw new ValidationException("Please enter a valid email / Inserisci un'email valida per favore");
			}
		}
	}
	
}
