package com.vstl.Generic;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.TimeZone;

public class Utilities {
	Random random = new Random();
	GregorianCalendar gc = new GregorianCalendar();

	// Set Random Name
	public String getRandomName(int intLength) {

		String stringCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZqwertyuiopasdfghjklzxcvbnm";
		String randomstring = "";

		char[] charText = new char[intLength];
		for (int intIndex = 0; intIndex < intLength; intIndex++) {
			charText[intIndex] = stringCharacters.charAt(random.nextInt(stringCharacters.length()));
			randomstring = randomstring + charText[intIndex];
		}
		return randomstring;

	}

	// Get Random Mobile No

	public String getRandomMobileNumber(int intlength) {

		String stringCharacters = "0123456789";
		String stringFirstcharacter = "987";
		String randomstring = "";
		String randomfirst = "";
		int intLength = 9;

		for (int intIndex = 0; intIndex < intLength; intIndex++) {
			int intnumber = (int) Math.floor(Math.random() * stringCharacters.length());
			randomstring += stringCharacters.substring(intnumber, intnumber + 1);
		}
		for (int intIndex = 0; intIndex <= 1; intIndex++) {
			int intfirstnumber = (int) Math.floor(Math.random() * stringFirstcharacter.length());
			randomfirst = stringFirstcharacter.substring(intfirstnumber, intfirstnumber + 1);
		}
		String stringmobileNumber = randomfirst + randomstring;
		return stringmobileNumber;
	}

	// Get Random Password
	public String getRandomPassword(int intLength) {

		String stringUpperCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String stringLowerCharacters = "qwertyuiopasdfghjklzxcvbnm";
		String stringNumber = "0123456789";
		String stringSpecialCharacters = "!@#$%^&*()_+{}[]:;'<>/?,.";
		String stringpassword = stringUpperCharacters + stringLowerCharacters + stringNumber + stringSpecialCharacters;

		char[] password = new char[intLength];

		for (int intIndex = 0; intIndex < intLength; intIndex++) {
			password[intIndex] = stringpassword.charAt(random.nextInt(stringpassword.length()));
			// String stringSetPassword = String.valueOf(password);
		}

		// System.out.println(new String(password));
		String stringSetPassword = new String(password);
		return stringSetPassword;

	}

	// Get Date of Birth
	public String getRandomDate() {
		try {
			String stringRandomDate = "";
			int intDate = (int) (Math.random() * 30);
			if (intDate == 0) {
				stringRandomDate = "7";
			}
			stringRandomDate = String.valueOf(intDate).trim();
			return stringRandomDate;
		} catch (Exception exception) {
			System.out.println("Error Message " + exception.getMessage());
			return null;
		}
	}

	// Month of Date
	public String getRandomMonth() {
		try {
			String stringRandomDate = "";
			int intDate = (int) (Math.random() * 12);
			if (intDate == 0) {
				stringRandomDate = "3";
			}
			stringRandomDate = String.valueOf(intDate).trim();
			return stringRandomDate;
		} catch (Exception exception) {
			System.out.println("Error Message " + exception.getMessage());
			return "";
		}
	}

	// Get Current Date with Zone name
	public String getCurrentSystemDate() {
		LocalDateTime objLocalDate = LocalDateTime.now();
		DateTimeFormatter objDateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

		String formattedDate = objLocalDate.format(objDateTime);
		System.out.println("Current System date and Time is " + formattedDate);
		String defaultTimeZone = TimeZone.getDefault().getID();
		System.out.println(defaultTimeZone);
		return formattedDate;
	}

//Get Time Zones
	public String differentTimeZones(String stringZones) {

		String[] stringTimeZone = TimeZone.getAvailableIDs();

		for (String id : stringTimeZone) {
			System.out.println(id);
		}
		return stringZones;

	}

	public String variousTimeZones(String stringZoneid) {

		ZoneId getzone = ZoneId.of(stringZoneid);

		System.out.println("Selected Zone is " + LocalDateTime.now(getzone));
		return stringZoneid;

	}

	public String getRandomDateYYYYMMDD() {

		int year = randBetween(1900, 2010);
		gc.set(Calendar.YEAR, year);
		int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
		gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
		System.out.println(
				gc.get(Calendar.YEAR) + "-" + (gc.get(Calendar.MONTH) + 1) + "-" + gc.get(Calendar.DAY_OF_MONTH));
		return null;
	}

	public static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

	public String getRandomYear() {

		int intYear = randBetween(1920, 2010);
		gc.set(Calendar.YEAR, intYear);
		String strYear = String.valueOf(gc.get(Calendar.YEAR));

		return strYear;
	}

	public static String getRandomThreeGender() {

		String strRGender;
		if (Math.random() > 0.6)
			strRGender = "Male";
		else if (Math.random() < 0.3)
			strRGender = "Female";
		else
			strRGender = "Custom";
		return strRGender;

	}

	public String getRandomGender() {

		String strGender;
		if (Math.random() > 0.5)
			strGender = "Male";
		else
			strGender = "Female";
		return strGender;

	}

//Get Random Email.

	public String getRandomEmailID(int intLength) {

		String stringCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZqwertyuiopasdfghjklzxcvbnm";
		String randomstring = "";
		String stringSpecialcharacter = "@";
		String stringcom = "gmail.com";

		char[] charText = new char[intLength];
		for (int intIndex = 0; intIndex < intLength; intIndex++) {
			charText[intIndex] = stringCharacters.charAt(random.nextInt(stringCharacters.length()));
			randomstring = randomstring + charText[intIndex];
		}
		return randomstring + stringSpecialcharacter + stringcom;

	}

}
