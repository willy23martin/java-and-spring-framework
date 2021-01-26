package openweb.wmc.java.eight.concurrency;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {

	public static void main(String[] args) {
		List<String> contactPhoneNumbersSetA = Arrays.asList("0183333333", "0333636", "06894656", "06894657");
		List<String> contactPhoneNumbersSetB = Arrays.asList("03535","03529", "0130085656", "0956564");
		List<String> contactPhoneNumbersSetC = Arrays.asList("0125650408", "0857474","0857475",  "00000000");
		
		System.out.println("Single Thread Pool"); 
		
		ExecutorService  executorSingleThreadPool = Executors.newSingleThreadExecutor();
		
		Future<Map<String, List<String>>> phoneNumberClassificationSetA = executorSingleThreadPool.submit(new CustomCallable(1, contactPhoneNumbersSetA));
		Future<Map<String, List<String>>> phoneNumberClassificationSetB = executorSingleThreadPool.submit(new CustomCallable(2, contactPhoneNumbersSetB));
		Future<Map<String, List<String>>> phoneNumberClassificationSetC = executorSingleThreadPool.submit(new CustomCallable(3, contactPhoneNumbersSetC));
		
		try {
			System.out.println(phoneNumberClassificationSetA.get().toString());
			System.out.println(phoneNumberClassificationSetB.get().toString());
			System.out.println(phoneNumberClassificationSetC.get().toString());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		executorSingleThreadPool.shutdown(); 
		
		System.out.println(""); 
		
		System.out.println("Fixed Thread Pool"); 
		
		ExecutorService  executorFixedThreadPool = Executors.newFixedThreadPool(2); 
		
		phoneNumberClassificationSetA = executorFixedThreadPool.submit(new CustomCallable(1, contactPhoneNumbersSetA));
		phoneNumberClassificationSetB = executorFixedThreadPool.submit(new CustomCallable(2, contactPhoneNumbersSetB));
		phoneNumberClassificationSetC = executorFixedThreadPool.submit(new CustomCallable(3, contactPhoneNumbersSetC));
		
		try {
			System.out.println(phoneNumberClassificationSetA.get().toString());
			System.out.println(phoneNumberClassificationSetB.get().toString());
			System.out.println(phoneNumberClassificationSetC.get().toString());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		executorFixedThreadPool.shutdown();
		
		System.out.println(""); 
		
		
		System.out.println("Cached Thread Pool"); 
		
		ExecutorService  executorCachedThreadPool = Executors.newCachedThreadPool();
		
		phoneNumberClassificationSetA = executorCachedThreadPool.submit(new CustomCallable(1, contactPhoneNumbersSetA));
		phoneNumberClassificationSetB = executorCachedThreadPool.submit(new CustomCallable(2, contactPhoneNumbersSetB));
		phoneNumberClassificationSetC = executorCachedThreadPool.submit(new CustomCallable(3, contactPhoneNumbersSetC));
		
		try {
			System.out.println(phoneNumberClassificationSetA.get().toString());
			System.out.println(phoneNumberClassificationSetB.get().toString());
			System.out.println(phoneNumberClassificationSetC.get().toString());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		executorCachedThreadPool.shutdown(); 
		
		System.out.println(""); 
		
		
	}

}
