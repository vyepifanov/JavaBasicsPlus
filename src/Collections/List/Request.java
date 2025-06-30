package Collections.List;

public class Request {
	private String name;
	private int priority;
	private int order;

	public Request(String name, int priority, int order) {
		this.name = name;
		this.priority = priority;
		this.order = order;
	}

	public int getPriority() {
		return priority;
	}

	public int getOrder() {
		return order;
	}

	public String getName() {
		return name;
	}
}
