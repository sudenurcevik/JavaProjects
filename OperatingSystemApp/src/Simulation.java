import java.util.Random;


public class Simulation {
	
	LinkedList<IProcess> processList= new LinkedList<>();
	PriorityQueue<Computation> priorityQueue;
	int sim_num,process_num;
	
	public Simulation(int process_num,int sim_num) {
		
		PriorityQueue<Computation> PriorityQueue= new PriorityQueue<Computation>(process_num);
		priorityQueue=PriorityQueue;
		int random_priority,random_occupation;
		int id=1;
		this.process_num=process_num;
		this.sim_num=sim_num;
		Random random= new Random();
		
		while (process_num>0) {
			
			random_priority=1+random.nextInt(3);		
			IProcess process = new Process(random_priority);
			processList.insert(process);
			process_num--;
			
		while(processList.getHead()!=null){
			random_occupation= 1+random.nextInt(11);
			Computation computation = new Computation(processList.remove().data,random_occupation,id);
			priorityQueue.add(computation);
			id++;
		}	
			
		}
		
	}
	
	@SuppressWarnings("unused")
	public void Display() throws Exception {
		
		int counter_h = 0,counter_n=0,counter_l=0,counter_total=0;
		int num_h=0, num_n=0,num_l=0,num_total=1;
		String showString="";
		while(priorityQueue.getSize()>1) {
			
			Computation temp= priorityQueue.remove();
			String type= temp.getProcess().getType();
			showString+= temp.toString() + "<-";
			counter_total+= temp.getOccupation();
			
			if (type==priorityQueue.peek().getProcess().getType()) {
				if (type=="High") {
					counter_h+=temp.getOccupation();
					num_h+=1;
				}
				else if (type=="Normal") {
					counter_n+=temp.getOccupation();
					num_n+=1;
				}
				else if (type=="Low") {
					counter_l+=temp.getOccupation();
					num_l+=1;
				}
			}
			else {
				String next_element = priorityQueue.peek().getProcess().getType();
				if (next_element=="Normal") {
					counter_n=counter_total;
					num_h+=1;
				}
				else if(next_element=="Low") {
					counter_l=counter_total;
					if (temp.getProcess().getType()=="High") {
						num_h++;
					}
					else if (temp.getProcess().getType()=="Normal") {
						num_n++;
					}
				}
			}
			num_total+=1;
		}
		Computation last_element = priorityQueue.remove();
		showString+= last_element.toString();
		switch (last_element.getProcess().getType()) {
		case "High": {
			num_h+=1;
			break;
		}
		case "Normal": {
			num_n+=1;
			break;
		}
		case "Low": {
			num_l+=1;
			break;
		}
		}
		System.out.println("Simulation Number: "+sim_num + 
							"\nComputation Queue: "+showString+
							"\nTotal numbers of computations : "+process_num+
							"\n\nTotal waiting time: "+counter_total+
							"\nAverage waiting time: "+(counter_total/process_num)+
							"\n\nTotal number of computations for High: "+num_h+
							"\nTotal number of computations for Normal: "+num_n+
							"\nTotal number of computations for Low: "+num_l+
							"\n\nTotal waiting time for High: "+ counter_h);
		if (num_h==0) {
			System.out.println("Average waiting time for High: "+0);
		}
		else {
			System.out.println("Average waiting time for High: "+(counter_h/num_h));
		}
		System.out.println("\n\nTotal waiting time for Normal: "+counter_n);
		if (num_n==0) {
			System.out.println("Average waiting time for Normal: "+0);
		}
		else {
			System.out.println("Average waiting time for Normal: "+(counter_n)/num_n);
		}
		System.out.println("\n\nTotal waiting time for Low: "+counter_l);
		if (num_l==0) {
			System.out.println("Average waiting time for Low: "+0);
		}
		else {
			System.out.println("Average waiting time for Low: "+(counter_l/num_l));
		}
		
		System.out.println("\n\n\n*****\n\n\n");					
							
	}
	
	
}