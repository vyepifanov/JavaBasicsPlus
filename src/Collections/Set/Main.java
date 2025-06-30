package Collections.Set;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Set<String> regs = new HashSet<>();

		while (true) {
			String name = scan.nextLine();
			if (name.equals("end")) {
				break;
			}

			if (regs.add(name)) {
				System.out.println("OK");
			} else {
				int i = 1;
				String newName;
				do {
					newName = name + i;
					i++;
				} while (regs.contains(newName));

				regs.add(newName);
				System.out.println(newName);
			}
		}
	}

	public void treeSetTaskProduct() {
		Scanner scan = new Scanner(System.in);
		SortedSet<Product> items = new TreeSet<>();

		while (true) {
			String input = scan.nextLine();
			if (input.equals("end")) {
				break;
			}
			items.add(Product.fromString(input));
		}

		for (Product item : items) {
			System.out.println(item);
		}
	}
	
	public void treeSetTask() {
		Scanner scan = new Scanner(System.in);
		SortedSet<String> dict = new TreeSet<>((a, b) -> b.compareTo(a));

		while (true) {
			String input = scan.nextLine();
			if (input.equals("end")) {
				break;
			}

			input = input.replaceAll("[^a-zA-Zа-яА-Я]", " ");
			dict.addAll(Arrays.asList(input.split(" ")));
		}

		for (String item : dict) {
			System.out.println(item);
		}
	}

	public void surnameSetTask() {
		Scanner scan = new Scanner(System.in);
		Set<String> set = new HashSet<>();

		while (true) {
			String input = scan.nextLine();
			if (input.equals("end")) {
				break;
			}

			String[] parts = input.split(" ");
			if (parts.length != 2) {
				continue;
			}

			set.add(parts[0]);
		}

		System.out.println(set.size());
	}
}
