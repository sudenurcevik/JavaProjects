
public class StoryGame extends Game {
	private int storyDuration;
	private int leftTimeForNextDay;

	public StoryGame(int arrivalDay, String name, int storyDuration, double averageRating) {
		super(arrivalDay, name, averageRating);
		this.storyDuration = storyDuration;
		this.leftTimeForNextDay = this.storyDuration;
		// TODO Auto-generated constructor stub
	}

	public int getStoryDuration() {
		return storyDuration;
	}

	public void setStoryDuration(int storyDuration) {
		this.storyDuration = storyDuration;
	}

	public int getLeftTimeForNextDay() {
		return leftTimeForNextDay;
	}

	public void setLeftTimeForNextDay(int leftTimeForNextDay) {
		this.leftTimeForNextDay = leftTimeForNextDay;
	}

}
