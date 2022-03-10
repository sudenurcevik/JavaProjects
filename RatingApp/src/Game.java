
public abstract class Game implements Comparable<Game> {
	private String name;
	private int arrivalDay;
	private double averageRating;
	private double result;

	public Game(int arrivalDay, String name, double averageRating) {

		this.name = name;
		this.arrivalDay = arrivalDay;
		this.averageRating = averageRating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getArrivalDay() {
		return arrivalDay;
	}

	public void setArrivalDay(int arrivalDay) {
		this.arrivalDay = arrivalDay;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(int averageRating) {
		this.averageRating = averageRating;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	@Override
	public int compareTo(Game o) { // to compare games in order to their names
		int result = 0;
		if (o instanceof Game) {
			Game otherGame = (Game) o;
			result = this.name.compareTo(otherGame.getName());
		}

		return result;
	}

}
