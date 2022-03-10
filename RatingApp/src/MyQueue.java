
public class MyQueue<T> implements IQueue<T> {

	private int front = 0;
	private int rear = -1;
	private int size, maxQueueSize;
	private T[] Queue;

	@SuppressWarnings("unchecked")

	public MyQueue(int maxQueueSize) {

		front = 0;
		rear = -1;
		size = 0;
		this.maxQueueSize = maxQueueSize;
		T[] temp = (T[]) new Object[maxQueueSize];
		Queue = temp;

	}

	public void enqueue(T object) {
		if (rear == maxQueueSize - 1) {
			int j = 0;
			for (int i = front; i <= rear; i++) {
				Queue[j++] = Queue[i];
			}
			front = 0;
			rear = size - 1;
		}
		Queue[++rear] = object;
		size++;

	}

	public T dequeue() {
		T element = Queue[front];
		Queue[front] = null;
		front++;
		size--;
		return element;

	}

	public boolean isEmpty() {
		return (size == 0);
	}

	public boolean isFull() {
		return (size == maxQueueSize);
	}

	public int size() {
		return size;
	}

	public T peek() {

		return Queue[front];

	}

	public T get_eleman_by_index(int index) {

		return Queue[index];
	}

	public int getFront() {
		return front;

	}

	public int getRear() {
		return rear;

	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

}
