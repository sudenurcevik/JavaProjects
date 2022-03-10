
public class Movie implements Comparable<Movie> {
	private String name;
	private int arrivalDay;
	private int year;
	private int duration;
	private double averageRating;
	private double result;

	public Movie(int arrivalDay, String name, int year, int duration, double averageRating) {
		this.name = name;
		this.arrivalDay = arrivalDay;
		this.year = year;
		this.duration = duration;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	@Override
	public int compareTo(Movie o) { // to compare movies in order to their names.
		int result = 0;
		if (o instanceof Movie) {
			Movie otherMovie = (Movie) o;
			result = this.name.compareTo(otherMovie.getName());
		}

		return result;
	}

}
