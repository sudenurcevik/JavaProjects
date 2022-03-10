
public class PriorityQueue<T> {
	
	@SuppressWarnings("unused")
	private int size;
	private int element_num=0;
	private int front = -1;
	private T[] priorityQueue;

	public PriorityQueue(int size) {
		this.size=size;
		@SuppressWarnings("unchecked")
		T[] temp= (T[]) new Object[size];
		priorityQueue= temp;
		
	}
	
	public void add(T newEntry) {
		if (isEmpty()) {
			front++;
			priorityQueue[front]= newEntry;
		}
		else {
			int i;
			Computation comparable_object= (((Computation) newEntry));
			for (i=element_num-1; i>=0;i--) {
				
				if ((comparable_object.getProcess()).getPriority() > (((Computation) priorityQueue[i]).getProcess()).getPriority()){
					priorityQueue[i+1]=priorityQueue[i];
				}
				else {
					break;
				}
				
			}
			priorityQueue[i+1]= newEntry;
			front++;
		}
		element_num++;
	}
	public T remove() throws Exception {
		if (isEmpty()) {
			throw new Exception("Priority Queue is empty...");
		}
		else {
			T temp= priorityQueue[front];
			priorityQueue[front]=null;
			front--;
			element_num--;
			return temp;
		}
		
		
	}
	public T peek() {
		return priorityQueue[front];
	}
	
	public boolean isEmpty() {
		return (this.element_num==0);
	}
	public int getSize() {
		return element_num;
	}
	//public void clear() {}
	
}
