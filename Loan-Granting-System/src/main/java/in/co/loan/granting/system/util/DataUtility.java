package in.co.loan.granting.system.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DataUtility {

	public static final String APP_DATE_FORMAT = "MM/dd/yyyy";

	private static final SimpleDateFormat formatter = new SimpleDateFormat(APP_DATE_FORMAT);

	public static String getString(String val) {
		if (DataValidator.isNotNull(val)) {
			return val.trim();
		} else {
			return val;
		}
	}

	public static String getStringData(Object val) {

		if (val != null) {
			return val.toString();
		} else {
			return "";
		}
	}

	public static int getInt(String val) {
		if (DataValidator.isInteger(val)) {
			return Integer.parseInt(val);
		} else {
			return 0;
		}
	}

	public static long getLong(String val) {
		if (DataValidator.isLong(val)) {
			return Long.parseLong(val);
		} else {
			return 0;
		}
	}

	public static Date getDate(String val) {
		Date date = null;
		try {
			date = formatter.parse(val);
		} catch (Exception e) {

		}
		return date;
	}

	public static Date getDate1(String val) {
		Date date = null;

		try {
			date = formatter.parse(val);

		} catch (Exception e) {
		}
		return date;
	}

	public static String getDateString(Date date) {

		try {
			if (date != null) {
				return formatter.format(date);
			} else {
				return "";
			}
		} catch (Exception e) {
			return "";
		}

	}

	public static Date getDate(Date date, int day) {
		return null;
	}

	public static Timestamp getTimestamp(long l) {

		Timestamp timeStamp = null;
		try {
			timeStamp = new Timestamp(l);
		} catch (Exception e) {
			return null;
		}
		return timeStamp;
	}

	public static Timestamp getTimestamp(String cdt) {

		Timestamp timeStamp = null;
		try {
			// timeStamp = new Timestamp((timeFormatter.parse(cdt)).getTime());
		} catch (Exception e) {
			return null;
		}
		return timeStamp;
	}

	public static long getTimestamp(Timestamp tm) {
		try {
			return tm.getTime();
		} catch (Exception e) {
			return 0;
		}
	}

	public static Timestamp getCurrentTimestamp() {
		Timestamp timeStamp = null;
		try {
			timeStamp = new Timestamp(new Date().getTime());
		} catch (Exception e) {
		}
		return timeStamp;

	}

	public static String generatePassword() {
		String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
		String specialCharacters = "!@#$";
		String numbers = "1234567890";
		String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
		String pass = null;
		Random random = new Random();
		int length = 6;
		char[] password = new char[length];

		password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
		password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
		password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
		password[3] = numbers.charAt(random.nextInt(numbers.length()));

		for (int i = 4; i < length; i++) {
			password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));

		}
		return String.copyValueOf(password);
	}

	public static byte[] openFile(String path) {
		byte[] encoded = null;
		try {
			encoded = Files.readAllBytes(Paths.get(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return encoded;
	}

	public static long getRandomBooking() {
		long min = 100000000000L;
		long max = 1000000000000L;
		long b = (long) (Math.random() * (max - min + 1) + min);
		return b;
	}

	public static long getRandomInvoice() {
		long min = 100000L;
		long max = 1000000L;
		long b = (long) (Math.random() * (max - min + 1) + min);
		return b;
	}

	public static String getDayName() {
		Format dateFormat = new SimpleDateFormat("EEE");
		String res = dateFormat.format(new Date());
		return res;
	}

	public static void main(String[] args) {
		DataUtility d = new DataUtility();

		Date date = new Date();
		// System.out.println(getDateString(date));

		// System.out.println(d.getCurrentTimestamp());
		/*
		 * String s1=""; System.out.println(getString("Ravi"));
		 * System.out.println(s1.isEmpty()); System.out.println(getDate("21/01/1994"));
		 * System.out.println(new Date());
		 */
		// System.out.println(getDate("01/21/1998"));

		System.out.println(generatePassword());
	}

}
