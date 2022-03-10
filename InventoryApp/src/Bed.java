public class Bed implements IProduct {
	public static int counter=0;
	private boolean isStored=false;
	private boolean isManufactured=false;
	private boolean isSold=false;
	
 	@Override
	public boolean isManufactured() {
		// TODO Auto-generated method stub
		return isManufactured;
	}
 	
	@Override
	public boolean isStored() {
		// TODO Auto-generated method stub
		return isStored;
	}

	@Override
	public boolean isSold() {
		// TODO Auto-generated method stub
		return isSold;
	}

	public void setStored(boolean isStored) {
		this.isStored = isStored;
	}

	public void setManufactured(boolean isManufactured) {
		this.isManufactured = isManufactured;
	}

	public void setSold(boolean isSold) {
		this.isSold = isSold;
	}

	public String toString() {
		return "Bed";
	}

}