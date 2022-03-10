
public class CasualGame extends Game {
	private int matchDuration;
	private int leftTimeForNextDay; // to calculate the left time if the duration of three match exceeds working
									// hours.

	public CasualGame(int arrivalDay, String name, int matchDuration, double averageRating) {
		super(arrivalDay, name, averageRating);
		this.setMatchDuration(matchDuration);
		this.leftTimeForNextDay = this.matchDuration * 3;

		// TODO Auto-generated constructor stub
	}

	public int getMatchDuration() {
		return matchDuration;
	}

	public void setMatchDuration(int matchDuration) {
		this.matchDuration = matchDuration;
	}

	public int getLeftTimeForNextDay() {
		return leftTimeForNextDay;
	}

	public void setLeftTimeForNextDay(int leftTimeForNextDay) {
		this.leftTimeForNextDay = leftTimeForNextDay;
	}

}
