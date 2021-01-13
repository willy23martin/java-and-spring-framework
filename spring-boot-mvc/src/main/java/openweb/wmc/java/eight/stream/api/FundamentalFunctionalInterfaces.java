package openweb.wmc.java.eight.stream.api;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FundamentalFunctionalInterfaces {

	private final static void fundamentalFunctionalInterfacesPredicateConsumer() {

		Predicate<Integer> greater = new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				return t >= 100;
			}

		};

		Predicate<Integer> lessThan = ((t) -> t < 1000);

		Predicate<Integer> complexPredicate = greater.and(lessThan);

		Consumer<Integer> consumerA = new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println("The number was read: " + t);
			}

		};

		Consumer<Integer> consumerB = ((t) -> System.out.println(" El siguiente número: " + (t + 1)));

		Consumer<Integer> complexConsumer = consumerA.andThen(consumerB);

		int number = 109;
		int numberB = 99;
		int numberC = 999;
		int numberD = 1001;

		List<Integer> numberList = new LinkedList<Integer>();
		numberList.add(number);
		numberList.add(numberB);
		numberList.add(numberC);
		numberList.add(numberD);

		// Only greater:
		numberList.stream().filter(greater).forEach(complexConsumer);
		;

		System.out.println("========================");

		// Then with less than:
		numberList.stream().filter(complexPredicate).forEach(complexConsumer);
	}

	private final static void fundamentalFunctionalInterfacesFunctionSupplier() {

		int number = 109;
		int numberB = 99;
		int numberC = 999;
		int numberD = 1001;

		List<Integer> numberList = new LinkedList<Integer>();
		numberList.add(number);
		numberList.add(numberB);
		numberList.add(numberC);
		numberList.add(numberD);

		Function<Integer, String> functionA = new Function<Integer, String>() {

			@Override
			public String apply(Integer t) {
				return "The number received was: " + t;
			}
		};

		Function<Integer, Double> functionB = new Function<Integer, Double>() {

			@Override
			public Double apply(Integer t) {
				return Double.parseDouble(t.toString());
			}
		};

		Function<Double, String> functionC = ((d) -> {
			return "The float received was: " + d;
		});

		Function<Integer, String> complexFunction = functionB.andThen(functionC);

		// Simple function:
		numberList.stream().map(functionA).forEach((s) -> System.out.println(s));

		System.out.println("========================");

		// Complex function:
		numberList.stream().map(complexFunction).forEach((s) -> System.out.println(s));

		System.out.println("========================" + "\n SUPPLIER: ");

		Supplier<String> strings = new Supplier<String>() {

			@Override
			public String get() {
				return new String("Supplier-the number is: ");
			}
		};

		numberList.stream().map(complexFunction).forEach((s) -> System.out.println(strings.get() + s));

		System.out.println("========================");

	}

	public static void main(String[] args) {
		fundamentalFunctionalInterfacesPredicateConsumer();
		fundamentalFunctionalInterfacesFunctionSupplier();
	}

}
