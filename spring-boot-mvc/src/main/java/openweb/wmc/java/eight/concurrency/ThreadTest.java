package openweb.wmc.java.eight.concurrency;

import java.util.Arrays;
import java.util.List;

public class ThreadTest {

	public static void main(String[] args) {
		List<String> contactPhoneNumbersSetA = Arrays.asList("0183333333", "0333636", "06894656", "06894657");
		List<String> contactPhoneNumbersSetB = Arrays.asList("03535","03529", "0130085656", "0956564");
		List<String> contactPhoneNumbersSetC = Arrays.asList("0125650408", "0857474","0857475",  "00000000");
		
		CustomThread phoneNumberClassificationSetA = new CustomThread(1, contactPhoneNumbersSetA);
		phoneNumberClassificationSetA.start();
		
		CustomThread phoneNumberClassificationSetB = new CustomThread(2, contactPhoneNumbersSetB);
		phoneNumberClassificationSetB.start();
		
		CustomThread phoneNumberClassificationSetC = new CustomThread(3, contactPhoneNumbersSetC);
		phoneNumberClassificationSetC.start();
		
	}

}
