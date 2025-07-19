package Streams;

public class Student {
	private String name;
	private int age;
	private double avg;

	public Student(String name, int age, double avg) {
		this.name = name;
		this.age = age;
		this.avg = avg;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getAvg() {
		return avg;
	}

	@Override
	public String toString() {
		return name + ';' + age + ';' + avg;
	}
}
