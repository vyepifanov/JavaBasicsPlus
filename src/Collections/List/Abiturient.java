package Collections.List;

public class Abiturient implements Comparable {
	private String surname;
	private String name;
	private int mark1;
	private int mark2;
	private int mark3;

	public Abiturient(String surname, String name, int mark1, int mark2, int mark3) {
		this.surname = surname;
		this.name = name;
		this.mark1 = mark1;
		this.mark2 = mark2;
		this.mark3 = mark3;
	}

	public String getSurname() {
		return surname;
	}

	public String getName() {
		return name;
	}

	public double average() {
		return (mark1 + mark2 + mark3) / 3.;
	}

	@Override
	public int compareTo(Object o) {
		Abiturient other = (Abiturient) o;
		int surnameCompare = this.surname.compareTo(other.getSurname());
		int nameCompare = this.name.compareTo(other.getName());

		return surnameCompare != 0 ? surnameCompare : nameCompare;
	}

	@Override
	public String toString() {
		return String.format("%s;%s;%d;%d;%d;%.1f", surname, name, mark1, mark2, mark3, average());
	}
}
