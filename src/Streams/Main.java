package Streams;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		List<Integer> firstNumbers = Arrays.stream(scan.nextLine().split("\\s+"))
				.map(Integer::parseInt)
				.filter(n -> n % 2 == 0)
				.toList();

		List<Integer> secondNumbers = Arrays.stream(scan.nextLine().split("\\s+"))
				.map(Integer::parseInt)
				.filter(Main::isPrime)
				.toList();

		List<Integer> result = Stream.concat(firstNumbers.stream(), secondNumbers.stream())
				.collect(Collectors.toList());

		System.out.println(result);
	}

	private static boolean isPrime(int num) {
		if (num <= 1) return false;
		return IntStream.rangeClosed(2, (int) Math.sqrt(num))
				.noneMatch(i -> num % i == 0);
	}

	public void reverseStringsTask() {
		Scanner scan = new Scanner(System.in);
		List<String> sent1 = List.of(scan.nextLine().split(" "));
		List<String> sent2 = List.of(scan.nextLine().split(" "));

		Stream<String> st1 = sent1.stream().filter(w -> w.startsWith("a"));
		Stream<String> st2 = sent2.stream()
				.filter(w -> w.length() > 4)
				.map(w -> new StringBuffer(w).reverse().toString());

		String result = Stream.concat(st1, st2)
				.reduce((s1, s2) -> s1 + " " + s2)
				.orElse("Empty result");

		System.out.println("|" + result + "|");
	}

	public void getFirstWord() {
		Scanner scan = new Scanner(System.in);
		String[] words = scan.nextLine().split(" ");

		Arrays.stream(words)
				.filter(w -> w.length() > 5)
				.findFirst().ifPresentOrElse(
						System.out::println,
						() -> System.out.println("No")
				);
	}

	public void getPurchaseList() {
		Scanner scan = new Scanner(System.in);
		List<Purchase> purchases = new ArrayList<>();

		while (true) {
			String input = scan.nextLine();
			if (input.equals("end")) {
				break;
			}

			String[] data = input.split(" ");
			String cardNumber = data[0];
			int itemCount = Integer.parseInt(data[1]);

			Purchase purchase = new Purchase(cardNumber);
			for (int i = 0; i < itemCount; i++) {
				String[] itemData = scan.nextLine().split(" ");
				String name = itemData[0];
				int price = Integer.parseInt(itemData[1]);
				double quantity = Double.parseDouble(itemData[2]);

				purchase.addItem(new Commodity(name, price), quantity);
			}
			purchases.add(purchase);
		}

		purchases.stream()
				.flatMap(p -> p.getItems().stream())
				.collect(Collectors.toSet())
				.stream()
				.sorted()
				.forEach(System.out::println);
	}

	public void getBooksList() {
		Scanner scan = new Scanner(System.in);
		Reader currentReader = null;
		ArrayList<Reader> readers = new ArrayList<>();

		while (true) {
			String input = scan.nextLine();
			if (input.equals("end")) {
				if (currentReader != null) {
					readers.add(currentReader);
				}

				break;
			}

			String[] data = input.split(";");
			if (data.length == 1) {
				if (currentReader != null) {
					readers.add(currentReader);
				}

				currentReader = new Reader(input.split(" ")[0], new ArrayList<>());
			} else if (currentReader != null) {
				int number = Integer.parseInt(data[0]);
				String author = data[1];
				String title = data[2];

				currentReader.addBook(new Book(number, author, title));
			} else {
				continue;
			}
		}

		readers.stream()
				.flatMap(r -> r.getBooks().stream())
				.sorted((o1, o2) -> o1.getNumber() - o2.getNumber())
				.forEach(System.out::println);
	}

	public void dogMinCollar() {
		Scanner scan = new Scanner(System.in);
		List<Dog> dogs = new ArrayList<>();

		while (true) {
			String input = scan.nextLine();
			if (input.equals("end")) {
				break;
			}

			String[] data = input.split(" ");
			if (data.length >= 2) {
				String name = data[0];
				String breed = data[1];

				if (data.length == 4) {
					String color = data[2];
					int size = Integer.parseInt(data[3]);
					dogs.add(new Dog(name, breed, new Collar(color, size)));
				} else {
					dogs.add(new Dog(name, breed));
				}
			}
		}

		Optional<Dog> dog = dogs.stream()
				.filter(d -> d.getCollar() != null)
				.min((d1, d2) -> d1.getCollar().getSize() - d2.getCollar().getSize());

		dog.ifPresentOrElse(
				System.out::println,
				() -> System.out.println("Empty data")
		);
	}

	public void dogCollarTask1() {
		Scanner scan = new Scanner(System.in);
		List<Dog> dogs = new ArrayList<>();

		while (true) {
			String input = scan.nextLine();
			if (input.equals("end")) {
				break;
			}

			String[] data = input.split(" ");
			if (data.length >= 2) {
				String name = data[0];
				String breed = data[1];

				if (data.length == 4) {
					String color = data[2];
					int size = Integer.parseInt(data[3]);
					dogs.add(new Dog(name, breed, new Collar(color, size)));
				} else {
					dogs.add(new Dog(name, breed));
				}
			}
		}

		List<Collar> collars = dogs.stream()
				.map(Dog::getCollar)
				.filter(Objects::nonNull)
				.sorted(Comparator.comparingInt(Collar::getSize))
				.collect(Collectors.toList());

		System.out.println(collars);
	}

	public void statisticsTask() {
		Scanner scan = new Scanner(System.in);
		Random gen = new Random(scan.nextLong());

		IntSummaryStatistics stat = gen.ints(0, 1001).limit(10_000).summaryStatistics();
		System.out.println(stat);
	}

	public void concatStringTask() {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> arr = new ArrayList<>();

		while (true) {
			String input = scan.nextLine();
			if (input.equals("end")) {
				break;
			}

			arr.add(input);
		}

		Optional<String> res = arr.stream().reduce((x, y) -> x + " " + y);
		System.out.println(res.orElse("Empty data"));

		Optional<String> longestWord = arr.stream().max(((o1, o2) -> o2.length() - o1.length()));
		longestWord.ifPresentOrElse(
				System.out::println,
				() -> System.out.println("?")
		);
	}

	public void streamFactorial() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		int res = IntStream.rangeClosed(1, n).reduce(1, (x, y) -> x * y);
		System.out.println(res);
	}

	public void getStudentsInfo() {
		Scanner scan = new Scanner(System.in);
		ArrayList<Student> arr = new ArrayList<>();

		while (true) {
			String input = scan.nextLine();
			if (input.equals("end")) {
				break;
			}

			String[] data = input.split(";");
			if (data.length != 3) {
				continue;
			}

			String name = data[0];
			int age = Integer.parseInt(data[1]);
			double avg = Double.parseDouble(data[2]);

			arr.add(new Student(name, age, avg));
		}

		OptionalDouble averageAge = arr.stream().mapToInt(Student::getAge).average();
		OptionalDouble maxAvg = arr.stream().mapToDouble(Student::getAvg).max();
		Optional<Student> student = arr.stream().max((o1, o2) -> (o1.getName().length() - o2.getName().length()));

		System.out.printf("%.0f %.1f%n", averageAge.orElse(20), maxAvg.orElse(0));
		student.ifPresentOrElse(
				System.out::println,
				() -> System.out.println("Empty data")
		);
	}

	public void randomGenTask() {
		Scanner scan = new Scanner(System.in);
		long seed = scan.nextLong();
		Random gen = new Random(seed);

		gen.ints(6, 10, 21).forEach(num -> System.out.print(num + " "));

	}
}
