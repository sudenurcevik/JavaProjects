
public class IndefiniteGame extends Game {
	private int minimumEvaluationTime;

	public IndefiniteGame(int arrivalDay, String name, int minimumEvaluationTime, double averageRating) {
		super(arrivalDay, name, averageRating);
		this.setMinimumEvaluationTime(minimumEvaluationTime);
		// TODO Auto-generated constructor stub
	}

	public int getMinimumEvaluationTime() {
		return minimumEvaluationTime;
	}

	public void setMinimumEvaluationTime(int minimumEvaluationTime) {
		this.minimumEvaluationTime = minimumEvaluationTime;
	}

}
