
public class GameCritic implements ICritic {

	private Game currentGame;
	private double opinion;
	private String name;

	public GameCritic(double opinion, String name) {

		this.setOpinion(opinion);
		this.setName(name);
	}

	@Override
	public void calculateRatings() {
		double result = 0;
		if (currentGame.getClass().getName().equals("IndefiniteGame")) {
			IndefiniteGame temp = (IndefiniteGame) currentGame;
			result = temp.getAverageRating() + ((10 - temp.getMinimumEvaluationTime()) * 0.25) + this.opinion;
		} else if (currentGame.getClass().getName().equals("StoryGame")) {
			StoryGame temp = (StoryGame) currentGame;
			result = temp.getAverageRating() + (temp.getStoryDuration() * 0.25) + this.opinion;
		} else if (currentGame.getClass().getName().equals("CasualGame")) {
			CasualGame temp = (CasualGame) currentGame;
			result = temp.getAverageRating() + ((temp.getMatchDuration() - 3) * 3) + this.opinion;
		}
		currentGame.setResult(result);
	}

	public Game getCurrentGame() {
		return currentGame;
	}

	public void setCurrentGame(Game currentGame) {
		this.currentGame = currentGame;
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
