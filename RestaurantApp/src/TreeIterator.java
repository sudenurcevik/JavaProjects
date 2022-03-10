import java.util.Iterator;
import java.util.NoSuchElementException;

public class TreeIterator {
	class InOrderIterator<T> implements Iterator<T> {

		private GenericLinkedStack<BinaryNode<T>> nodeStack;
		private BinaryNode<T> currentNode;

		public InOrderIterator(BinaryNode<T> root) {
			nodeStack = new GenericLinkedStack<BinaryNode<T>>();
			currentNode = root;
		}

		public boolean hasNext() {
			return !nodeStack.isEmpty() || (currentNode != null);
		}

		public T next() {
			BinaryNode<T> nextNode = null;

			while (currentNode != null) {
				nodeStack.push(currentNode);
				currentNode = currentNode.getLeftChild();
			}

			if (!nodeStack.isEmpty()) {
				nextNode = nodeStack.pop();
				assert nextNode != null;

				currentNode = nextNode.getRightChild();
			} else
				throw new NoSuchElementException();

			return nextNode.getData();
		}
	}

	class PostOrderIterator<T> implements Iterator<T> {

		private GenericLinkedStack<BinaryNode<T>> nodeStack;
		private BinaryNode<T> currentNode;
		GenericLinkedStack<T> list = new GenericLinkedStack<>();
		boolean control = false;

		public PostOrderIterator(BinaryNode<T> root) {

			nodeStack = new GenericLinkedStack<BinaryNode<T>>();
			currentNode = root;
			nodeStack.push(currentNode);

		}

		public boolean hasNext() {
			return (!nodeStack.isEmpty() || (currentNode != null)) && !control;
		}

		@Override
		public T next() {

			while (!nodeStack.isEmpty()) {

				currentNode = nodeStack.pop();
				list.push(currentNode.getData());
				if (currentNode.getLeftChild() != null)
					nodeStack.push(currentNode.getLeftChild());
				if (currentNode.getRightChild() != null)
					nodeStack.push(currentNode.getRightChild());

			}

			T valueT = list.pop();
			if (list.isEmpty()) {
				control = true;
			}

			return valueT;
		}

	}

	class PreOrderIterator<T> implements Iterator<T> {

		private GenericLinkedStack<BinaryNode<T>> stack;
		private BinaryNode<T> root;
		LinkedQueue<T> list = new LinkedQueue<>();
		boolean control = false;

		public PreOrderIterator(BinaryNode<T> root) {
			stack = new GenericLinkedStack<BinaryNode<T>>();
			this.root = root;
			stack.push(root);
		}

		public boolean hasNext() {
			return (!stack.isEmpty() || (root != null)) && !control;
		}

		public T next() {

			while (!stack.isEmpty()) {
				root = stack.pop();
				list.enqueue(root.getData());
				if (root.getRightChild() != null)
					stack.push(root.getRightChild());
				if (root.getLeftChild() != null)
					stack.push(root.getLeftChild());
			}

			T valueT = list.dequeue();
			if (list.isEmpty()) {
				control = true;
			}
			return valueT;
		}

	}

	class LevelOrderIterator<T> implements Iterator<T> {
		LinkedQueue<T> result;

		private LinkedQueue<BinaryNode<T>> queue;
		private BinaryNode<T> root;

		boolean control = false;

		public LevelOrderIterator(BinaryNode<T> root) {

			queue = new LinkedQueue<BinaryNode<T>>();
			result = new LinkedQueue<T>();
			this.root = root;
			queue.enqueue(root);
		}

		public boolean hasNext() {
			return (!queue.isEmpty() || (root != null)) && !control;
		}

		public T next() {
			while (!queue.isEmpty()) {
				BinaryNode<T> node = queue.dequeue();
				if (node == null)
					continue;
				result.enqueue(node.getData());
				queue.enqueue(node.getLeftChild());
				queue.enqueue(node.getRightChild());

			}

			T valueT = result.dequeue();
			if (result.isEmpty()) {
				control = true;
			}

			return valueT;
		}

	}

}
