package openweb.wmc.java.eight;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import com.sun.jmx.snmp.Timestamp;

public class JavaAPIUtils {

	private static void stringBuilderTest() {
		long startTime = System.nanoTime();

		StringBuilder message = new StringBuilder("message1");
		for (int i = 0; i < 100; i++) {
			message.append(";message" + String.valueOf(i));
		}

		long endTime = System.nanoTime();

		long duration = (endTime - startTime);
		System.out.println(duration);
		System.out.println("Message: \n" + message);
	}

	private static void stringTest() {
		long startTime = System.nanoTime();

		String message = new String("message1");
		for (int i = 0; i < 100; i++) {
			message += ";message" + String.valueOf(i);
		}

		long endTime = System.nanoTime();

		long duration = (endTime - startTime);
		System.out.println(duration);
		System.out.println("Message: \n" + message);

		System.out.println("=====================");

	}

	public JavaAPIUtils() {
		
	}

	public static void main(String[] args) {
		stringTest();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stringBuilderTest();
		
//		dateManagement();

		System.out.println("Ortography Score: " + AuxiliarClass.ortographyScore(4.3, 3.8, 4.8, 4.6, 5.0));

	}

	private static void dateManagement() {
		System.out.println("====== DATE MANAGEMENT =======");
		// Fecha de hoy:
		LocalDate today = LocalDate.now();
		System.out.println("Today: " + today);
		System.out.println("Year: " + today.getYear());
		System.out.println("Month: " + today.getMonth());
		System.out.println("Day: " + today.getDayOfMonth());
		System.out.println("Day of Week: " + today.getDayOfWeek());

		// Fecha de nacimiento:
		LocalDate birthDate = LocalDate.of(1994, 5, 23);
		System.out.println("Birth date: " + birthDate);

		// Equals:

		if (today.equals(birthDate)) {
			System.out.println("Are the same date.");
		} else {
			System.out.println("Are different");
		}

		System.out.println("====== TIME MANAGEMENT =======");

		// Hour:

		LocalTime now = LocalTime.now();
		System.out.println("Now: " + now);
		now.plusHours(3);
		System.out.println("Now: " + now);
		birthDate = birthDate.plus(1, ChronoUnit.WEEKS);
		System.out.println("Birthdate plus 1 week: " + birthDate);
		birthDate = birthDate.plus(2, ChronoUnit.YEARS);
		System.out.println("Birthdate plus 2 years: " + birthDate);

		if (birthDate.isAfter(today)) {
			System.out.println("Is after today.");
		} else if (birthDate.isBefore(today)) {
			System.out.println("Is before today");
		} else {
			System.out.println("Are equal");
		}

		if (birthDate.isLeapYear()) {
			System.out.println("Is leap year");
		}

		System.out.println("Diferencia entre fechas: \n");
		Period period = Period.between(birthDate, today);
		System.out.println(period);

		// ISO 8601 format date
		String date = "2020-10-10";
		LocalDate isoDate = LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println("Basic ISO Date: " + isoDate);
		LocalDate isoDateII = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		System.out.println("Basic ISO Date II: " + isoDateII);

	}

}
