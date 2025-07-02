package Collections.Map;

public class Person {
	private String name;
	private Double salary;

	public Person(String name, Double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public Double getSalary() {
		return salary;
	}

	public static Person fromString(String input) {
		String[] data = input.split(" ");

		if (data.length != 2) {
			return null;
		}

		return new Person(data[0], Double.parseDouble(data[1]));
	}
}
