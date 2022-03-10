
public class Process implements IProcess {

	String Type;
	int Priority;
	
	public Process(int priority) {
		this.Priority=priority;
		switch (priority) {
		case 1: {
			
			Type="High";
			break;
		}
		case 2 :{
			Type="Normal";
			break;
		}
		case 3: {
			Type="Low";
			break;
		}
		}
	}
	
	@Override
	public String getType() {
		return Type;
	}

	@Override
	public int getPriority() {
		return Priority;
	}

	@Override
	public String toString() {
		
		return Type;
		
	}
}
