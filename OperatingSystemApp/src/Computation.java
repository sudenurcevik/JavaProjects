
public class Computation {
	
	private int id;
	private IProcess process;
	private int occupation;
	
	public Computation(IProcess data, int occupation,int id) {
		this.process = (IProcess) data;
		this.occupation = occupation;
		this.id=id;
	}


	public String toString() {
		return " P"+id+","+ getProcess().toString()+","+occupation+"ns ";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public IProcess getProcess() {
		return process;
	}
	public void setProcess(IProcess process) {
		this.process = process;
	}
	public int getOccupation() {
		return occupation;
	}
	public void setOccupation(int occupation) {
		this.occupation = occupation;
	}
	
}
