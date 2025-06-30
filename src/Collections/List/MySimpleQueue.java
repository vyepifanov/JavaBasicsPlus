package Collections.List;

public class MySimpleQueue<E> {
	private ListNode<E> begin = null;
	private ListNode<E> end = null;

	public MySimpleQueue() {

	}

	public MySimpleQueue(ListNode<E> begin, ListNode<E> end) {
		this.begin = begin;
		this.end = end;
	}

	public class ListNode<E> {
		private E val;
		private ListNode next;

		ListNode() {
		}

		ListNode(E val) {
			this.val = val;
		}

		ListNode(E val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public void add(E el) {
		ListNode<E> node = new ListNode<>(el, null);
		if (end == null) {
			end = node;
			begin = node;
			return;
		}
		end.next = node;
		end = node;
	}

	public E get() {
		if (begin == null) return null;
		E tmp = begin.val;
		begin = begin.next;

		return tmp;
	}

	public void print() {
		if (begin == null) {
			System.out.println("Queue is empty");
			return;
		}
		ListNode item = begin;
		while (item != null) {
			System.out.print(item.val + " ");
			item = item.next; //переходим к следующему элементу
		}
		System.out.println();
	}

	public void clear() {
		begin = null;
		end = null;
	}

	public MySimpleQueue<E> reverse() {
		MySimpleQueue<E> reversedQueue = new MySimpleQueue<>();

		ListNode<E> current = begin;
		ListNode<E> prev = null;
		ListNode<E> next = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		reversedQueue.begin = end;
		reversedQueue.end = begin;

		return reversedQueue;
	}

	public int size() {
		int count = 0;
		ListNode<E> current = begin;
		while (current != null) {
			count++;
			current = current.next;
		}

		return count;
	}

	public E middleNode() {
		if (begin == null) return null;

		ListNode<E> slow = begin, fast = begin;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return  slow.val;
	}
}
