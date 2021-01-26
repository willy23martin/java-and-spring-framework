package openweb.wmc.java.eight.concurrency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CustomRunnable implements Runnable {

	public static final String[] PHONE_NUMBER_TYPES = {"HOME", "CELL", "NOT DEFINED FORMAT"};
	
	private Map<String, List<String>> phoneNumberClassification;
	
	private int threadIdentifier;
	
	private List<String> contactPhoneNumbers;
	
	public CustomRunnable(int threadIdentifier, List<String> contactPhoneNumbers) {
		this.contactPhoneNumbers = contactPhoneNumbers;
		List<String> homePhoneNumbers = new ArrayList<String>();
		List<String> cellPhoneNumbers = new LinkedList<String>();
		List<String> notDefinedFormatePhoneNumbers = new ArrayList<String>();
		this.phoneNumberClassification = new HashMap<String, List<String>>();
		this.phoneNumberClassification.put(PHONE_NUMBER_TYPES[0], homePhoneNumbers);
		this.phoneNumberClassification.put(PHONE_NUMBER_TYPES[1], cellPhoneNumbers);
		this.phoneNumberClassification.put(PHONE_NUMBER_TYPES[2], notDefinedFormatePhoneNumbers);
		this.threadIdentifier = threadIdentifier;
	}
	
	@Override
	 public void run() {
		 if(this.contactPhoneNumbers.isEmpty()) {
			 System.out.println(this.phoneNumberClassification.toString());
		 } else {
			 this.classifyPhoneNumbers(this.contactPhoneNumbers);
			 System.out.println(this.phoneNumberClassification.toString());
		 }
	 }
	
	/**
	 * Classifies phone numbers in three different categories.
	 * @param contactPhoneNumbers
	 * @return phoneNumberClassification updated.
	 */
	private Map<String, List<String>> classifyPhoneNumbers(List<String> contactPhoneNumbers){
		Iterator<String> iter = contactPhoneNumbers.iterator();
		while(iter.hasNext()) {
			String phoneNumber = iter.next();
			if(phoneNumber.length() == 10) {
				System.out.println("Thread " + this.threadIdentifier + " - classified " + phoneNumber + " as: " + PHONE_NUMBER_TYPES[1]);
				List<String> homePhoneNumbers = this.phoneNumberClassification.get(PHONE_NUMBER_TYPES[1]);
				homePhoneNumbers.add(phoneNumber);
				this.phoneNumberClassification.put(PHONE_NUMBER_TYPES[1], homePhoneNumbers);
			} else if(phoneNumber.length() == 7) {
				System.out.println("Thread " + this.threadIdentifier + " - classified " + phoneNumber + " as: " + PHONE_NUMBER_TYPES[0]);
				List<String> homePhoneNumbers = this.phoneNumberClassification.get(PHONE_NUMBER_TYPES[0]);
				homePhoneNumbers.add(phoneNumber);
				this.phoneNumberClassification.put(PHONE_NUMBER_TYPES[0], homePhoneNumbers);
			} else {
				System.out.println("Thread " + this.threadIdentifier + " - classified " + phoneNumber + " as: " + PHONE_NUMBER_TYPES[2]);
				List<String> homePhoneNumbers = this.phoneNumberClassification.get(PHONE_NUMBER_TYPES[2]);
				homePhoneNumbers.add(phoneNumber);
				this.phoneNumberClassification.put(PHONE_NUMBER_TYPES[2], homePhoneNumbers);
			}
		}
		System.out.println("=========================\n");
		return this.phoneNumberClassification;
	}

	public Map<String, List<String>> getPhoneNumberClassification() {
		return phoneNumberClassification;
	}

	public void setPhoneNumberClassification(Map<String, List<String>> phoneNumberClassification) {
		this.phoneNumberClassification = phoneNumberClassification;
	}

	public int getThreadIdentifier() {
		return threadIdentifier;
	}

	public void setThreadIdentifier(int threadIdentifier) {
		this.threadIdentifier = threadIdentifier;
	}
	
	
	
}
