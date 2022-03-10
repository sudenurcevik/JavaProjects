import java.lang.reflect.Array;

public class LinkedQueue<T> {
	@SuppressWarnings("hiding")
	private class Node<T> {
		T value;
		Node<T> next;

		Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}
	}

	private int count;
	private Node<T> front;
	private Node<T> rear;

	public LinkedQueue() {
		front = rear = null;
		count = 0;
	}

	public void enqueue(T value) {
		if (rear != null) {
			rear.next = new Node<T>(value, null);
			rear = rear.next;
		} else {
			rear = new Node<T>(value, null);
			front = rear;
		}
		count++;
	}

	public T dequeue() {
		if (isEmpty()) {
			throw new IllegalStateException("Cannot dequeue - Queue is empty");
		}

		T value = front.value;
		front = front.next;
		count--;

		if (front == null) {
			rear = null;
		}

		return value;
	}

	public boolean isEmpty() {
		return front == null;
	}

	public T peek() {
		return front.value;
	}

	public int size() {
		return count;
	}

	public T[] toArray(Class<T> _class) {
		int index = 0;

		@SuppressWarnings("unchecked")
		T[] result = (T[]) (Array.newInstance(_class, this.count));

		while (isEmpty() != true) {
			result[index] = this.dequeue();
			index++;
		}
		return result;
	}
}
