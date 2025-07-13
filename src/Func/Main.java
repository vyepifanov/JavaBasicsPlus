package Func;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		HashMap<Integer, Double> map = new HashMap<>();

		while (true) {
			String input = scan.nextLine();
			if (input.equals("end")) {
				break;
			}

			String[] data = input.split(" ");
			if (data.length > 2) {
				continue;
			} else if (data.length == 2) {
				map.put(Integer.parseInt(data[0]), Double.parseDouble(data[1]));
			} else {
				int key = Integer.parseInt(data[0]);
				map.computeIfAbsent(key, k -> (double) factorial(k));
			}

		}

		map.forEach((k, v) -> System.out.printf("%d:%.1f%n", k, v));
	}

	private static long factorial(int n) {
		if (n == 0) return 1;
		long result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}

	public void complexSortTask() {
		Scanner scan = new Scanner(System.in);
		ArrayList<Purchase> arr = new ArrayList<>();

		while (true) {
			String input = scan.nextLine();
			if (input.equals("end")) {
				break;
			}

			String[] data = input.split(";");
			Purchase p = new Purchase(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
			arr.add(p);
		}

		Comparator<Purchase> letterComp = (o1, o2) -> o1.getName().compareTo(o2.getName());
		Comparator<Purchase> finalComp = letterComp.thenComparing((o1, o2) -> o2.getCost() - o1.getCost());

		arr.sort(finalComp);
		arr.forEach(p -> System.out.println(p));
	}

	public void firstPurchaseTask() {
		Scanner scan = new Scanner(System.in);
		ArrayList<Purchase> arr = new ArrayList<>();

		while (true) {
			String input = scan.nextLine();
			if (input.equals("end")) {
				break;
			}

			String[] data = input.split(";");
			Purchase p = new Purchase(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
			arr.add(p);
		}

		Optional<Purchase> first = findFirst(arr, p -> p.getName().startsWith("М"));
		Optional<Purchase> second = findFirst(arr, p -> p.getCost() > 1000);
		System.out.printf("Первая покупка на букву М: %s%n",
				first.orElseGet(() -> new Purchase("Покупка не найдена", 0, 0)));
		System.out.printf("Первая покупка со стоимостью больше 1000: %s%n",
				second.orElseGet(() -> new Purchase("Покупка не найдена", 0, 0)));
	}

	public static Optional<Purchase> findFirst(List<Purchase> arr, Predicate<Purchase> pred) {
		for (Purchase p : arr) {
			if (pred.test(p)) {
				return Optional.of(p);
			}
		}
		return Optional.empty();
	}

	public void supplierExample() {
		Scanner scan = new Scanner(System.in);
		StringSupplier ss = new StringSupplier(scan.nextLine());

		for (int i = 0; i < 5; i++) {
			System.out.println(ss.get());
		}
	}

	public void consumerExample() {
		Scanner scan = new Scanner(System.in);
		ArrayList<Purchase> arr = new ArrayList<>();

		while (true) {
			String input = scan.nextLine();
			if (input.equals("end")) {
				break;
			}

			String[] data = input.split(";");
			Purchase p = new Purchase(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
			arr.add(p);
		}

		Consumer<Purchase> priceInc = p -> p.setPrice((int)(p.getPrice() * 1.05));
		arr.forEach(priceInc);
		arr.forEach(p -> System.out.println(p));
	}

	public void removePurchase() {
		Scanner scan = new Scanner(System.in);
		ArrayList<Purchase> arr = new ArrayList<>();

		while (true) {
			String input = scan.nextLine();
			if (input.equals("end")) {
				break;
			}

			String[] data = input.split(";");
			Purchase p = new Purchase(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
			arr.add(p);
		}

		arr.removeIf(p -> p.getAmount() > 3);
		arr.sort((o1, o2) -> o2.getCost() - o1.getCost());
		for (Purchase p : arr) {
			System.out.println(p);
		}
	}

	public void filterPurchase() {
		Scanner scan = new Scanner(System.in);
		ArrayList<Purchase> arr = new ArrayList<>();

		while (true) {
			String input = scan.nextLine();
			if (input.equals("end")) {
				break;
			}

			String[] data = input.split(";");
			Purchase p = new Purchase(data[0], Integer.parseInt(data[1]), Integer.parseInt(data[2]));
			arr.add(p);
		}
		String filterName = scan.nextLine();

		printFilter(arr, p -> p.getName().equals(filterName));
		System.out.println();
		printFilter(arr, p -> p.getCost() >= 2000);
		System.out.println();
		printFilter(arr, p -> p.getCost() < 200);
		System.out.println();
		printFilter(arr, p -> p.getName().startsWith("А"));
	}

	public static void printFilter(List<Purchase> arr, Predicate<Purchase> pred) {
		int count = 0;

		for (Purchase p : arr) {
			if (pred.test(p)) {
				System.out.println(p);
				count++;
			}
		}

		if (count == 0) {
			System.out.println("Error");
		}
	}
}
