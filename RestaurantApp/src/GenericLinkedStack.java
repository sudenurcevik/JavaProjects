import java.util.NoSuchElementException;

public class GenericLinkedStack<T> {

	private Node<T> top = null;

	private static class Node<T> {
		private T data;
		private Node<T> next = null;

		Node(T element) {
			data = element;
		}
	}

	public void push(T element) {
		Node<T> newItem = new Node<T>(element);

		if (top == null) {
			top = newItem;
		} else {

			newItem.next = top;
			top = newItem;
		}

	}

	public T pop() {
		if (top == null) {
			throw new NoSuchElementException("The stack is empty.");
		}

		T output = top.data;
		top = top.next;

		return output;
	}

	public T peek() {
		if (top == null) {
			throw new NoSuchElementException("The stack is empty.");
		}
		return top.data;
	}

	public boolean isEmpty() {
		return top == null;
	}
}