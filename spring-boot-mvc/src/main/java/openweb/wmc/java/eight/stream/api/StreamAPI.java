package openweb.wmc.java.eight.stream.api;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class StreamAPI {

	public final static void streamAPITest() {

		// General Consumers:
		Consumer<Integer> integerConsumer = new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println("Number: " + t);
			}
		};

		IntConsumer intConsumer = (t -> System.out.println(t));

		Consumer<String> stringConsumer = (s -> System.out.println("String: " + s));

		// Suppliers:
		Supplier<String> stringSupplier = new Supplier<String>() {

			@Override
			public String get() {
				return "String supplied - " + String.valueOf(new Random().nextInt());
			}
		};

		// Functions:
		Function<String, String> mapper = (s -> "Function applied to: " + s);

		// Stream.of
		Stream<Integer> integerStreamOf = Stream.of(1, 2, 3);
		integerStreamOf.forEach(integerConsumer);

		// IntStream
		IntStream intStream = Arrays.stream(new int[] { 4, 5, 6, 9, 6 });
		intStream.distinct().forEach(intConsumer);

		// Empty Stream
		Stream<String> emptyStream = Stream.empty();
		System.out.println(emptyStream);

		// Infinite Stream with limit
		Stream<Integer> infiniteStreamWithLimit = Stream.iterate(4, t -> t * 6).limit(10);
		infiniteStreamWithLimit.filter(t -> t <= 100).forEach(integerConsumer);

		// Stream from a List:
		Stream<String> streamFromList = Arrays.asList("a", "b", "c").parallelStream();
		streamFromList.skip(1).forEach(stringConsumer);

		// Stream generate:
		Stream<String> streamGenerated = Stream.generate(stringSupplier).limit(20);
		streamGenerated.map(mapper).forEach(stringConsumer);

	}

	public final static void streamAPISearchingMethodsTest() {
		// Predicate:
		Predicate<Integer> predicate = (t -> t < 100);
		// Stream:
		Stream<Integer> integerStreamOf = Stream.of(1, 2, 3, 1020, 120, 210, 211, 102, 92, 92, 90, 91, 81, 82);
		System.out.println(integerStreamOf.toString());
		integerStreamOf.allMatch(predicate);
		System.out.println(integerStreamOf.toString());
		Stream<Integer> integerStreamOfII = Stream.of(1, 2, 3, 1020, 120, 210, 211, 102, 92, 92, 90, 91, 81, 82);
		integerStreamOfII.anyMatch(predicate); // One at least
		System.out.println(integerStreamOfII.toString());
		Stream<Integer> integerStreamOfIII = Stream.of(1, 2, 3, 1020, 120, 210, 211, 102, 92, 92, 90, 91, 81, 82);
		integerStreamOfIII.noneMatch(predicate);
		System.out.println(integerStreamOfIII.toString());
		// Find:
		Stream<Integer> integerStreamOfIV = Stream.of(1, 2, 3, 1020, 120, 210, 211, 102, 92, 92, 90, 91, 81, 82);
		integerStreamOfIV.findAny(); // Use it in parallel streams.
		System.out.println(integerStreamOfIV.toString());
		Stream<Integer> integerStreamOfV = Stream.of(1, 2, 3, 1020, 120, 210, 211, 102, 92, 92, 90, 91, 81, 82);
		integerStreamOfV.findFirst(); // Not used it in parallel Streams.
		System.out.println(integerStreamOfV.toString());
	}

	public static void streamAPIToCalculusAndToSortMethodsTest() {
		// Reduce
		System.out.println("Reduce and Calculus methods:");
		Stream<Integer> integerStreamOfIV = Stream.of(1, 2, 3, 1020, 120, 210, 211, 102, 92, 92, 90, 91, 81, 82);
		System.out.println(integerStreamOfIV.reduce((x, y) -> x + y));
		Stream<Integer> integerStreamOfV = Stream.of(1, 2, 3, 1020, 120, 210, 211, 102, 92, 92, 90, 91, 81, 82);
		System.out.println(integerStreamOfV.reduce(5, Integer::max));
		Stream<Integer> integerStreamOfVI = Stream.of(1, 2, 3, 1020, 120, 210, 211, 102, 92, 92, 90, 91, 81, 82);
		System.out.println(integerStreamOfVI.count());
		Stream<Integer> integerStreamOfVII = Stream.of(1, 2, 3, 1020, 120, 210, 211, 102, 92, 92, 90, 91, 81, 82);
		System.out.println(integerStreamOfVII.min(Comparator.reverseOrder()));
		Stream<Integer> integerStreamOfVIII = Stream.of(1, 2, 3, 1020, 120, 210, 211, 102, 92, 92, 90, 91, 81, 82);
		System.out.println(integerStreamOfVIII.max(Comparator.naturalOrder()));
		System.out.println("");
		// Sorting:
		System.out.println("Sorting methods:");
		Stream<Integer> integerStreamOfIX = Stream.of(1, 2, 3, 1020, 120, 210, 211, 102, 92, 92, 90, 91, 81, 82);
		integerStreamOfIX.sorted().forEach((t) -> System.out.println(t));
		Stream<Integer> integerStreamOfX = Stream.of(1, 2, 3, 1020, 120, 210, 211, 102, 92, 92, 90, 91, 81, 82);
		integerStreamOfX.sorted(Comparator.reverseOrder()).forEach((t) -> System.out.println(t));
	}
	
	public static void streamAPIMapAndFlapTest() {
		// Additional references: https://howtodoinjava.com/java8/java-stream-distinct-examples/
		// Map: data transformation
		System.out.println("Map methods:");
		List<String> contacts = Arrays.asList(
				"Contact A", "Contact B", "Contact C", "Contact D"
		);
		contacts.stream().map(String::toUpperCase).forEach(System.out::println);
		System.out.println("");
		// FlatMap: 
		System.out.println("Flap methods:");
		HashMap<String, List<String>> contactedServices = new HashMap<String, List<String>>();
		List<String> servicesContactedByContactA = Arrays.asList("Service A", "Service B");
		contactedServices.put("Contact A", servicesContactedByContactA);
		List<String> servicesContactedByContactB = Arrays.asList("Service A", "Service B", "Service C");
		contactedServices.put("Contact B", servicesContactedByContactB);
		List<String> servicesContactedByContactC = Arrays.asList("Service C", "Service A");
		contactedServices.put("Contact C", servicesContactedByContactC);
		contactedServices.entrySet().stream()
		.map(Map.Entry::getValue)
		.flatMap(list -> Arrays.stream(list.toArray()))
		.distinct()
		.collect(Collectors.toList())
		.forEach(System.out::println);
		System.out.println("");
	}

	public static void streamAPICollectors() {
		// Collectors:
		System.out.println("Collectors static methods:");
		List<String> contacts = Arrays.asList(
				"Contact 1", "Contact 2", "Contact 3", "Contact 4"
		);
		System.out.println(contacts.stream().map(String::toUpperCase).collect(Collectors.counting()));
		System.out.println(contacts.stream().map(String::toLowerCase).collect(Collectors.joining()));
		
		// Numbers:
		Random randomValue = new Random();
		List<Integer> numbers = randomValue.ints(0,100).limit(25).boxed().collect(Collectors.toList());
		// Basic collectors:
		System.out.println("Total numbers: " + numbers.stream().collect(Collectors.counting()));
		System.out.println("Max value: " + numbers.stream().collect(Collectors.maxBy(Comparator.naturalOrder())).get()); // Optional object.get()
		System.out.println("Summary statistics of numbers: " + numbers.stream().collect(Collectors.summarizingInt(number -> number.intValue())));  
		System.out.println("Average: " + numbers.stream().collect(Collectors.averagingInt(Integer::intValue)));
		
		// Gouping By Collectors - like SQL GROUP BY statement
		OutboundCampaignResults outboundCampaignResults = new OutboundCampaignResults();
		List<OutboundResult> outboundResults = outboundCampaignResults.results();
		Map<String, List<OutboundResult>> wrapUpCodesCount = 
				outboundResults.stream().
				collect(Collectors.groupingBy(OutboundResult::getWrapUpCode));
		System.out.println(wrapUpCodesCount);
		wrapUpCodesCount.entrySet().stream()
		.map(entry -> entry.getKey() + " = " + entry.getValue().size())
		.forEach(System.out::println); 
		System.out.println("");
	}
	
	public static void streamAPIFilters() {
		// Filter: middle operation: deletes elements that do not satisfy the Predicate
		System.out.println("Filters:");
		OutboundCampaignResults outboundCampaignResults = new OutboundCampaignResults();
		Hashtable<String, String> outboundCampaignMap = outboundCampaignResults.getOutboundCampaignResults();
		outboundCampaignMap.entrySet()
		.stream()
		.filter(result -> result.getValue().equals("No Line"))
		.map(result -> result.getKey())
		.forEach(System.out::println);
		System.out.println("");
	}
	
	public static void streamAPIMethodReference() {
		// Method reference:
		System.out.println("Method reference:");
		OutboundCampaignResults outboundCampaignResults = new OutboundCampaignResults();
		List<OutboundResult> outboundResults = outboundCampaignResults.results();
		outboundResults.stream()
		.sorted(OutboundResult::compareTo) // Method reference
		.forEach(System.out::println); 
		System.out.println("");
	}
	
	public static void main(String[] args) {
		streamAPITest();
		streamAPISearchingMethodsTest();
		streamAPIToCalculusAndToSortMethodsTest();
		streamAPIMapAndFlapTest();
		streamAPICollectors(); 
		streamAPIFilters();
		streamAPIMethodReference();
	}

}
