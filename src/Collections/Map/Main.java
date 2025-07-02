package Collections.Map;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		Map<Integer, Integer> counter = new HashMap<>();
		while (true) {
			String input = scan.next();
			if (input.equals("end")) {
				break;
			}

			Integer number = Integer.parseInt(input);
			int count = 1;
			if (counter.containsKey(number)) {
				count += counter.get(number);
			}
			counter.put(number, count);
		}

		List<Map.Entry<Integer, Integer>> arr = new ArrayList<>(counter.entrySet());
		arr.sort(new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				if (!Objects.equals(o1.getValue(), o2.getValue()))
					return Integer.compare(o2.getValue(), o1.getValue());
				return Integer.compare(o1.getKey(), o2.getKey());
			}
		});

		System.out.println(arr.get(0).getKey());
	}

	public void countReposts() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.nextLine();

		Map<String, Integer> map = new HashMap<>();
		map.put("Polycarp", 0);
		int maxDepth = 0;

		for (int i = 0; i < n; i++) {
			String[] parts = scan.nextLine().split(" reposted ");
			String name1 = parts[0];
			String name2 = parts[1];

			int newDepth = map.get(name2) + 1;
			map.put(name1, newDepth);

			if (newDepth > maxDepth) {
				maxDepth = newDepth;
			}
		}

		System.out.println(maxDepth);
	}

	public void renamesTask() {
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		scan.nextLine();

		Map<String, String> names = new LinkedHashMap<>();
		Map<String, String> nicks = new HashMap<>();

		String oldName = null;
		String newName = null;
		String firstName = null;

		for (int i = 0; i < q; i++) {
			String input = scan.nextLine();
			String[] data = input.split(" ");

			if (data.length != 2) continue;

			oldName = data[0];
			newName = data[1];

			if (nicks.containsKey(oldName)) {
				firstName = nicks.get(oldName);
				names.put(firstName, newName);
				nicks.remove(oldName);
				nicks.put(newName, firstName);
			} else {
				names.put(oldName, newName);
				nicks.put(newName, oldName);
			}
		}

		for (Map.Entry<String, String> entry : names.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

	public void removeDuplicatesTask() {
		Scanner scan = new Scanner(System.in);
		Map<String, String> empls = new LinkedHashMap<>();
		Set<String> duplicates = new HashSet<>();

		while (true) {
			String input = scan.nextLine();
			if (input.equals("end")) {
				break;
			}

			String[] parts = input.split(" ");
			if (parts.length != 2) {
				continue;
			}

			String surname = parts[0];
			String name = parts[1];

			if (empls.containsKey(surname)) {
				duplicates.add(surname);
			} else {
				empls.put(surname, name);
			}
		}

		for (String surname : duplicates) {
			empls.remove(surname);
		}

		List<Map.Entry<String, String>> arr = new ArrayList<>(empls.entrySet());
		Collections.sort(arr, new Comparator<Map.Entry<String, String>>() {
			@Override
			public int compare(Map.Entry<String, String> e1, Map.Entry<String, String> e2) {
				return e1.getKey().compareTo(e2.getKey());
			}
		});

		for (Map.Entry<String, String> el : arr) {
			System.out.println(el.getKey() + " " + el.getValue());
		}
	}

	public void wordCounter() {
		Scanner scan = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<>();

		while (true) {
			String input = scan.nextLine().replaceAll("[^a-zA-Zа-яА-Я]", " ");;
			if (input.equals("end")) {
				break;
			}

			for (String word : input.split("\\s+")) {
				int count = 1;
				if (map.containsKey(word)) {
					count += map.get(word);
				}
				map.put(word, count);
			}
		}

		List<Map.Entry<String, Integer>> arr = new ArrayList<>(map.entrySet());
		arr.sort(new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				if (!Objects.equals(o1.getValue(), o2.getValue()))
					return Integer.compare(o1.getValue(), o2.getValue());
				return o1.getKey().compareTo(o2.getKey());
			}
		});

		int count = 0;
		for (Map.Entry<String, Integer> el : arr) {
			System.out.println(el.getKey() + " " + el.getValue());
			count++;

			if (count >= 10) {
				break;
			}
		}
	}

	public void salarySetTask() {
		Scanner scan = new Scanner(System.in);
		HashMap<String, Double> map = new HashMap<>();

		while (true) {
			String input = scan.nextLine();
			if (input.equals("end")) {
				break;
			}

			String[] data = input.split(" ");
			if (data.length != 2) {
				continue;
			}

			String name = data[0];
			Double salary = Double.parseDouble(data[1]);
			if (map.containsKey(name)) {
				salary += map.get(name);
			}
			map.put(name, salary);
		}

		List<Map.Entry<String, Double>> entries = new ArrayList<>(map.entrySet());
		entries.sort((a, b) -> a.getKey().compareTo(b.getKey()));
		for (Map.Entry<String, Double> entry : entries) {
			System.out.printf("%s %.2f%n", entry.getKey(), entry.getValue());
		}
	}
}
