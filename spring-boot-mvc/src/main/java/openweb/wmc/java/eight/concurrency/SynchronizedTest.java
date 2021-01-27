package openweb.wmc.java.eight.concurrency;

import java.util.Arrays;
import java.util.List;

public class SynchronizedTest {

	public static void main(String[] args) {
		List<String> contactPhoneNumbersSetA = Arrays.asList("0183333333", "0333636", "06894656", "06894657");
				
		SynchronizedLogic synchronizedLogic = new SynchronizedLogic(contactPhoneNumbersSetA);
		
		CustomSynchronizedThreads phoneNumberClassificationSetA = new CustomSynchronizedThreads(1, synchronizedLogic);
		phoneNumberClassificationSetA.start();
		
		CustomSynchronizedThreads phoneNumberClassificationSetB = new CustomSynchronizedThreads(2, synchronizedLogic);
		phoneNumberClassificationSetB.start();
		
	}
	
}
