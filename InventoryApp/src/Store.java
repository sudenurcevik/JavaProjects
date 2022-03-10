
public class Store<T> implements IStack<T> {
	private int size;
	private int MaxSize;
	private T[] Stack;
	@SuppressWarnings("unchecked")
	
	public Store() {
		
		this.size=0;
		this.MaxSize=2;

		T[] temp= (T[]) new Object[MaxSize];
	    Stack= temp;
	    
       }
	
	public T[] getStack() {
		return Stack;
	}

	public void setStack(T[] stack) {
		Stack = stack;
	}

	public void push(T object) {
		if (size==Stack.length) {
			doubleCapacity();
		}
		Stack[size]=object;
		size++;
	}
	public T pop() {
		if(size==0) {
			throw new ArrayIndexOutOfBoundsException();
			
		}
		T result=Stack[size-1];
		Stack[size-1]=null;
		size--;
		return result;
	}
	public T peek() {
		if(size==0) {
			throw new ArrayIndexOutOfBoundsException();
			
		}
		T result=Stack[size-1];
		
		return result;
		
	}
	public int size() {
		return size;
	}
	public int capacity() {
		return Stack.length;
	}
	
	public boolean isEmpty() {
		if(size==0) {
			return true;
			
					
		}
		else {
			return false;
		}
	}
	
	public T get_eleman(int index) {
		
		return Stack[index];
		
	}		

	@SuppressWarnings("unchecked")
	private void doubleCapacity() {
		int newCapacity=2*Stack.length;
		T[] NewStack= (T[]) new Object[newCapacity];
		for(int i=0; i<Stack.length; i++) {
			NewStack[i]=Stack[i];
		}
		Stack=NewStack;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
}	
