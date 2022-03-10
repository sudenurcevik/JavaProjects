import java.util.Comparator;
import java.util.Iterator;

public class BinarySearchTree<T> {

	private Comparator<T> cmp;
	private BinaryNode<T> root = null;
	private TreeIterator iterator;

	public BinarySearchTree() {
		super();
	}

	public BinarySearchTree(T value) {
		super();
		root = new BinaryNode<T>(value);
	}

	public BinarySearchTree(BinaryNode<T> newRoot) {
		super();
		root = newRoot;
	}

	public BinarySearchTree(Comparator<T> cmp) {
		super();
		this.cmp = cmp;
		this.iterator = new TreeIterator();

	}

	public T get(T key) {
		BinaryNode<T> node = root;
		while (node != null) {
			if (this.cmp.compare(key, node.getData()) == 0) {
				return node.getData();
			}
			if (this.cmp.compare(key, node.getData()) < 0) {
				node = node.getLeftChild();
			} else {
				node = node.getRightChild();
			}
		}
		return null;
	}

	public void add(T value) {
		root = add(value, root);
	}

	protected BinaryNode<T> add(T value, BinaryNode<T> node) {
		if (node == null) {
			return new BinaryNode<T>(value);
		}
		if (this.cmp.compare(value, node.getData()) == 0) {

			value = node.getData();

		} else {
			if (this.cmp.compare(value, node.getData()) < 0) {
				node.setLeftChild(add(value, node.getLeftChild()));
			} else {
				node.setRightChild(add(value, node.getRightChild()));
			}
		}
		return node;
	}

	public void remove(T key) {
		root = remove(key, root);
	}

	protected BinaryNode<T> remove(T value, BinaryNode<T> node) {
		if (node == null) {
			return null;
		}
		if (this.cmp.compare(value, node.getData()) == 0) {
			if (node.getLeftChild() == null) {
				return node.getRightChild();
			} else if (node.getRightChild() == null) {
				return node.getLeftChild();
			} else {

				T replacement = getRightmost(node.getLeftChild());

				BinaryNode<T> newNode = new BinaryNode<T>(replacement, remove(replacement, node.getLeftChild()),
						node.getRightChild());
				return newNode;
			}
		} else {
			if (this.cmp.compare(value, node.getData()) < 0) {

				node.setLeftChild(remove(value, node.getLeftChild()));
			} else {
				node.setRightChild(remove(value, node.getRightChild()));
			}
		}
		return node;
	}

	protected T getRightmost(BinaryNode<T> node) {
		assert (node != null);
		BinaryNode<T> right = node.getRightChild();
		if (right == null) {
			return node.getData();
		} else {
			return getRightmost(right);
		}
	}

	public Iterator<T> InOrderIterator() {
		TreeIterator.InOrderIterator<T> inOrderIterator = iterator.new InOrderIterator<>(root);

		return inOrderIterator;

	}

	public Iterator<T> PreOrderIterator() {
		TreeIterator.PreOrderIterator<T> PreOrderIterator = iterator.new PreOrderIterator<>(root);

		return PreOrderIterator;

	}

	public Iterator<T> PostOrderIterator() {
		TreeIterator.PostOrderIterator<T> postOrderIterator = iterator.new PostOrderIterator<>(root);

		return postOrderIterator;
	}

	public Iterator<T> LevelOrderIterator() {

		TreeIterator.LevelOrderIterator<T> levelOrderIterator = iterator.new LevelOrderIterator<>(root);

		return levelOrderIterator;
	}

	public void AscendingPrinter() {
		Iterator<T> inorderIterator = this.InOrderIterator();
		while (inorderIterator.hasNext()) {
			System.out.println(inorderIterator.next());
		}
	}

	public void DescendingPrinter() {
		GenericLinkedStack<T> printerStack = new GenericLinkedStack<>();
		Iterator<T> inorderIterator = this.InOrderIterator();
		while (inorderIterator.hasNext()) {
			printerStack.push(inorderIterator.next());
		}
		while (!printerStack.isEmpty()) {
			System.out.println(printerStack.pop());
		}
	}

	public void IteratorPrinter(Iterator<T> itt) {
		while (itt.hasNext()) {
			System.out.println(itt.next());
		}
	}

	public String toString() {
		return toString(root);
	}

	protected String toString(BinaryNode<T> node) {
		if (node == null) {
			return "";
		}
		return node.getData().toString() + "(" + toString(node.getLeftChild()) + ", " + toString(node.getRightChild())
				+ ")";
	}

}