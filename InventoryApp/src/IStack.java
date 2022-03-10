
public interface IStack<T> {
	
	public void push(T object);
	public T pop();
	public T peek();
	public boolean isEmpty();
	public void clear();
}
