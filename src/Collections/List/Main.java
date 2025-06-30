package Collections.List;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<Request> requests = new ArrayList<>();
		int counter = 0;

		while (true) {
			String input = scan.nextLine();
			if (input.equals("end")) {
				break;
			}

			String[] parts = input.split(" ");
			if (parts.length != 2) {
				continue;
			}

			try {
				String name = parts[0];
				int priority = Integer.parseInt(parts[1]);
				requests.add(new Request(name, priority, counter++));
			} catch (NumberFormatException e) {}
		}

		Collections.sort(requests, new Comparator<Request>() {
			@Override
			public int compare(Request r1, Request r2) {
				if (r1.getPriority() != r2.getPriority()) {
					return Integer.compare(r2.getPriority(), r1.getPriority());
				} else {
					return Integer.compare(r1.getOrder(), r2.getOrder());
				}
			}
		});

		for (Request request : requests) {
			System.out.println(request.getName() + " " + request.getPriority());
		}
	}

	public void mySimpleQueue() {
		MySimpleQueue<Integer> queue = new MySimpleQueue<>();
		Scanner scan = new Scanner(System.in);
		String buf = scan.nextLine();
		String[] parts = buf.split(" +");
		for (String item : parts) {
			try {
				queue.add(Integer.parseInt(item));
			}catch(NumberFormatException ex){
				//пропускаем неверный элемент
			}
		}
		System.out.println("Исходная очередь:");
		queue.print();
		buf = scan.nextLine();
		switch (Integer.parseInt(buf)) {
			case 1:
				MySimpleQueue<Integer> list2 = queue.reverse();
				System.out.println("Результат:");
				list2.print();
				break;
			case 2:
				int size = queue.size();
				System.out.println("Количество элементов: " + size);
				break;
			case 3:
				Integer result = queue.middleNode();
				System.out.println("Средний элемент: " + result);
				break;
		}
	}

	public void myQueueTask() {
		MyQueue<Integer> queue = new MyQueue<>();
		Scanner scan = new Scanner(System.in);
		String buf = scan.nextLine();
		String[] parts = buf.split(" ");
		for (String item : parts) {
			queue.add(Integer.parseInt(item));
		}
		System.out.println("Исходная очередь:");
		queue.print();
		buf = scan.nextLine();
		switch (Integer.parseInt(buf)) {
			case 1:
				MyQueue<Integer> list2 = queue.reverse();
				System.out.println("Результат:");
				list2.print();
				break;
			case 2:
				int start = scan.nextInt();
				int finish = scan.nextInt();
				MyQueue<Integer> list3 = queue.reverse(start, finish);
				System.out.println("Результат:");
				if (list3 != null) {
					list3.print();
				} else {
					System.out.println("Ошибочные данные!");
				}
				break;
			case 3:
				int result = queue.middleNode();
				System.out.println("Средний элемент: " + result);
				break;
		}
	}

	public void numbersListTask() {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> numbers = new ArrayList<>();

		while (true) {
			String input = scan.nextLine();
			if (input.equals("end")) {
				break;
			}
			try {
				int number = Integer.parseInt(input);
				numbers.add(number);
			} catch (NumberFormatException e) {}
		}

		if (numbers.isEmpty()) {
			System.out.println("List is empty");
			return;
		}

		int first = numbers.get(0);
		int last = numbers.get(numbers.size() - 1);
		int middleIndex = numbers.size() / 2;
		numbers.set(middleIndex, first + last);

		System.out.println(numbers.toString());
	}

	public void commodityTask() {
		Scanner scan = new Scanner(System.in);
		List<Commodity> belarusCommodities = new ArrayList<>();
		List<Commodity> otherCommodities = new ArrayList<>();

		while (true) {
			String input = scan.nextLine();
			if (input.equals("end")) {
				break;
			}
			try {
				Commodity commodity = Commodity.fromString(input);
				if (commodity.getCountry().equals("Беларусь")) {
					belarusCommodities.add(commodity);
				} else {
					otherCommodities.add(commodity);
				}
			} catch (IllegalArgumentException e) {}
		}

		if (belarusCommodities.isEmpty()) {
			System.out.println("Список товаров из Беларуси пуст");
		} else {
			Collections.sort(belarusCommodities);
			for (Commodity c : belarusCommodities) {
				System.out.println(c);
			}
		}

		System.out.println();

		if (otherCommodities.isEmpty()) {
			System.out.println("Список товаров из других стран пуст");
		} else {
			otherCommodities.sort((c1, c2) -> c2.getPrice() - c1.getPrice());
			for (Commodity c : otherCommodities) {
				System.out.println(c);
			}
		}
	}

	public void taskAbiturient() {
		Scanner scan = new Scanner(System.in);

		List<Abiturient> arr = new ArrayList<Abiturient>();
		String buffer = scan.nextLine();
		while (!buffer.equals("end")) {
			try {
				String[] data = buffer.split("#");
				Abiturient a = new Abiturient(data[0], data[1],
						Integer.parseInt(data[2]),
						Integer.parseInt(data[3]),
						Integer.parseInt(data[4]));
				arr.add(a);
			} catch (Exception ex) {}

			buffer = scan.nextLine();
		}

		if (arr.isEmpty()) {
			System.out.println("Список пуст");
		} else {
			Collections.sort(arr);
			for (Abiturient a : arr) {
				System.out.println(a);
			}
			System.out.println();

			Collections.sort(arr, new Comparator<Abiturient>() {
				@Override
				public int compare(Abiturient o1, Abiturient o2) {
					return -Double.compare(o1.average(), o2.average());
				}
			});
			for (Abiturient a : arr) {
				System.out.println(a);
			}
		}
	}
}
