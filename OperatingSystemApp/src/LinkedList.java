
public class LinkedList<T>{
	
    private Node<T> head;
    
    @SuppressWarnings("unchecked")
	public void insert(T data) {
    	
    	Node<T> node = new Node<T>();
    	node.data=data;
    	node.next=null;
    	if (head==null) {
    		head=node;
			
		}
    	else {
			Node<T> n = head;
			while (n.next!=null) {
				
				n=n.next;
			}
			n.next=node;
		}
    	
    }
    
    public Node<T> getHead() {
		return head;
	}
	public void setHead(Node<T> head) {
		this.head = head;
	}
	
	@SuppressWarnings("unchecked")
	public Node<T> remove() {
		Node<T> removed = head;
		head=head.next;
		return removed;
	}
	

}