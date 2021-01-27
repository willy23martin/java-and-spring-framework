package openweb.wmc.java.eight.concurrency;

import java.util.List;
import java.util.Map;

public class CustomSynchronizedThreads extends Thread {

	private Map<String, List<String>> phoneNumberClassification;

	private int threadIdentifier;

	private SynchronizedLogic synchronizedLogic;

	public CustomSynchronizedThreads(int threadIdentifier, SynchronizedLogic synchronizedLogic) {
		this.synchronizedLogic = synchronizedLogic;
		this.threadIdentifier = threadIdentifier;
	}

	@Override
	public void run() {
		 this.phoneNumberClassification = this.synchronizedLogic.classifyPhoneNumbers(threadIdentifier);
		 System.out.println(this.phoneNumberClassification.toString()); 
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

}
