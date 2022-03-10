
public class MovieCritic implements ICritic {
	private Movie currentMovie;
	private double opinion;
	private String name;

	public MovieCritic(double opinion, String name) {
		super();
		this.opinion = opinion;
		this.name = name;
	}

	@Override
	public void calculateRatings() {

		double result = currentMovie.getAverageRating() + ((currentMovie.getDuration() - 150) * 0.01)
				- ((2021 - currentMovie.getYear()) * 0.01) + this.opinion;
		currentMovie.setResult(result);
	}

	public Movie getCurrentMovie() {
		return currentMovie;
	}

	public void setCurrentMovie(Movie currentMovie) {
		this.currentMovie = currentMovie;
	}

	public double getOpinion() {
		return opinion;
	}

	public void setOpinion(double opinion) {
		this.opinion = opinion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
