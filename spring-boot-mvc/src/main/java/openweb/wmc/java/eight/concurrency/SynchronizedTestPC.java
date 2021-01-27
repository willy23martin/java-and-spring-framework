package openweb.wmc.java.eight.concurrency;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedTestPC {

	public static void main(String[] args) {
		List<String> contactPhoneNumbersSet = new ArrayList<String>();
				
		SynchronizedLogicPC synchronizedLogic = new SynchronizedLogicPC(contactPhoneNumbersSet);
		
		CustomSynchronizedThreadsPC producer = new CustomSynchronizedThreadsPC(1, synchronizedLogic, true);
		producer.start();
		
		CustomSynchronizedThreadsPC consumer = new CustomSynchronizedThreadsPC(2, synchronizedLogic, false);
		consumer.start();
		
	}
	
}
