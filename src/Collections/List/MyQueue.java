package Collections.List;

import java.util.*;

public class MyQueue<E> {
	private LinkedList<E> list = new LinkedList<>();

	public void add(E el) {
		list.addLast(el); //добавляем в конец очереди
	}

	public E get() {
		return list.pollFirst(); //извлекаем из начала
	}

	public void print() { //печать очереди от начала к концу
		if (list.isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		for (E item : list) {
			System.out.print(item + " ");
		}
		System.out.println();
	}

	public void clear() { //очистка очереди
		list.clear();
	}

	public MyQueue<E> reverse() {
		MyQueue<E> reversedQueue = new MyQueue<>();
		Iterator<E> iterator = list.descendingIterator();

		while (iterator.hasNext()) {
			reversedQueue.add(iterator.next());
		}

		return reversedQueue;
	}

	public MyQueue<E> reverse(int start, int finish) {
		if (start <= 0 || finish <= 0 || start > list.size() || finish > list.size()) {
			return null;
		}

		int fromIndex = Math.min(start, finish) - 1;
		int toIndex = Math.max(start, finish) - 1;

		LinkedList<E> tempList = new LinkedList<>(this.list);
		MyQueue<E> resultQueue = new MyQueue<>();

		List<E> subList = tempList.subList(fromIndex, toIndex + 1);
		Collections.reverse(subList);

		resultQueue.list = new LinkedList<>(tempList);
		return resultQueue;
	}

	public E middleNode() {
		if (list.isEmpty()) {
			return null;
		}
		int middleIndex = list.size() / 2;
		return list.get(middleIndex);
	}
}
