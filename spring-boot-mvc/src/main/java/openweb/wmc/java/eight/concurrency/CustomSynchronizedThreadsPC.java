package openweb.wmc.java.eight.concurrency;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CustomSynchronizedThreadsPC extends Thread {

	private Map<String, List<String>> phoneNumberClassification;

	private int threadIdentifier;

	private SynchronizedLogicPC synchronizedLogic;

	private boolean isProducer;
	
	private List<String> contacts;
	
	public CustomSynchronizedThreadsPC(int threadIdentifier, SynchronizedLogicPC synchronizedLogic, boolean isProducer) {
		this.synchronizedLogic = synchronizedLogic;
		this.threadIdentifier = threadIdentifier;
		this.isProducer = isProducer;
		this.contacts = new LinkedList<String>();
	}

	@Override
	public void run() {
		  this.executeRoleTest(this.isProducer); 
	}
	
	private void executeRoleTest(boolean isProducer) {
		if(isProducer) {
			for(int i = 20; i<40; i+=2) {
				String contact = "contact"+i;
				this.contacts.add(contact);
			}	
		} else {
			for(int i=0; i<10;i++) {
				this.synchronizedLogic.takeContact(i);
			}
			this.contacts.addAll(this.synchronizedLogic.getContactPhoneNumbersSet());
			System.out.println(this.contacts.toString()); 
		}
	}
	
	public int getThreadIdentifier() {
		return threadIdentifier;
	}

	public void setThreadIdentifier(int threadIdentifier) {
		this.threadIdentifier = threadIdentifier;
	}
	
	public Map<String, List<String>> getPhoneNumberClassification() {
		return phoneNumberClassification;
	}

	public void setPhoneNumberClassification(Map<String, List<String>> phoneNumberClassification) {
		this.phoneNumberClassification = phoneNumberClassification;
	}

	public boolean isProducer() {
		return isProducer;
	}

	public void setProducer(boolean isProducer) {
		this.isProducer = isProducer;
	}
	
	

}
