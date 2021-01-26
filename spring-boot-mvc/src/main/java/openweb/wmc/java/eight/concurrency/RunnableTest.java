package openweb.wmc.java.eight.concurrency;

import java.util.Arrays;
import java.util.List;

public class RunnableTest {

	public static void main(String[] args) {
		List<String> contactPhoneNumbersSetA = Arrays.asList("0183333333", "0333636", "06894656", "06894657");
		List<String> contactPhoneNumbersSetB = Arrays.asList("03535","03529", "0130085656", "0956564");
		List<String> contactPhoneNumbersSetC = Arrays.asList("0125650408", "0857474","0857475",  "00000000");
		
		Thread phoneNumberClassificationSetA = new Thread(new CustomRunnable(1, contactPhoneNumbersSetA));
		phoneNumberClassificationSetA.start();
		
	    Thread phoneNumberClassificationSetB = new Thread(new CustomRunnable(2, contactPhoneNumbersSetB));
		phoneNumberClassificationSetB.start();
		
		Thread phoneNumberClassificationSetC = new Thread(new CustomRunnable(3, contactPhoneNumbersSetC));
		phoneNumberClassificationSetC.start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Custom separated Thread 1 - excecuted"); 				
			}
		}).start();
		
		new Thread(()-> System.out.println("Custom separated Thread 2 - excecuted as a lambda expression")).start();		
	}

}
