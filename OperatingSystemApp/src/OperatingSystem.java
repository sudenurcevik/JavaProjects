
public class OperatingSystem {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		
		Simulation simulation1=new Simulation(3, 1);
		Simulation simulation2=new Simulation(5, 2);
		Simulation simulation3=new Simulation(10, 3);
		
		
		LinkedList<Simulation> simulationList = new LinkedList<Simulation>();
		
		simulationList.insert(simulation1);
		simulationList.insert(simulation2);
		simulationList.insert(simulation3);
		Node<Simulation> tempNode= simulationList.getHead();
		
		while (tempNode.next!=null) {
			tempNode.data.Display();
			tempNode=tempNode.next;
		}
		tempNode.data.Display();
 	}

}
