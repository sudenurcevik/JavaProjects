
public interface IQueue<T> {
	
	public void enqueue(T object);
	public T dequeue();
	public boolean isEmpty();
	public boolean isFull();
	public T peek();
	public void clear();
}
