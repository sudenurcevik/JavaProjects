import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RatingAppManagement {

	private static Stack<Game> gameStack = new Stack<>();
	private static Stack<Movie> movieStack = new Stack<>();

	private static MyQueue<MovieCritic> movieCriticsQueue = new MyQueue<>(3);
	private static MyQueue<GameCritic> gameCriticsQueue = new MyQueue<>(5);

	private static ArrayList<MovieCritic> movieCritics = new ArrayList<>();
	private static ArrayList<GameCritic> gameCritics = new ArrayList<>();

	private static ArrayList<Movie> ratedMovies = new ArrayList<>();
	private static ArrayList<Game> ratedGames = new ArrayList<>();

	public static void createContentStack() throws FileNotFoundException {
		ArrayList<String> lineStrings = FileIO.read();
		for (String string : lineStrings) {
			String[] line = string.split(",");
			switch (line[1]) {
			case "0":
				movieStack.push(new Movie(Integer.parseInt(line[0]), line[2], Integer.parseInt(line[3]),
						Integer.parseInt(line[4]), Double.parseDouble(line[5])));

				break;
			case "1":
				gameStack.push(new IndefiniteGame(Integer.parseInt(line[0]), line[2], Integer.parseInt(line[3]),
						Double.parseDouble(line[4])));
				break;

			case "2":
				gameStack.push(new StoryGame(Integer.parseInt(line[0]), line[2], Integer.parseInt(line[3]),
						Double.parseDouble(line[4])));
				break;
			case "3":
				gameStack.push(new CasualGame(Integer.parseInt(line[0]), line[2], Integer.parseInt(line[3]),
						Double.parseDouble(line[4])));
				break;

			default:
				break;
			}
		}

	}

	public static void createCritics() {

		movieCritics.add(new MovieCritic(0.1, "1.Movie Critic"));
		movieCritics.add(new MovieCritic(-0.2, "2.Movie Critic"));
		movieCritics.add(new MovieCritic(0.3, "3.Movie Critic"));

		gameCritics.add(new GameCritic(5, "1.Game Critic"));
		gameCritics.add(new GameCritic(9, "2.Game Critic"));
		gameCritics.add(new GameCritic(-3, "3.Game Critic"));
		gameCritics.add(new GameCritic(2, "4.Game Critic"));
		gameCritics.add(new GameCritic(-7, "5.Game Critic"));

	}

	public static void giveAssignment() { // to give each assignment to each critics

		for (MovieCritic movieCritic : movieCritics) {
			if (!movieStack.isEmpty() && movieCritic.getCurrentMovie() == null) {

				Movie moviePopped = movieStack.pop();
				System.out.println(movieCritic.getName() + " works on (#" + moviePopped.getName() + ")");
				movieCritic.setCurrentMovie(moviePopped);
			}

		}

		for (GameCritic gameCritic : gameCritics) {
			if (!gameStack.isEmpty() && gameCritic.getCurrentGame() == null) {
				Game gamePopped = gameStack.pop();
				System.out.println(gameCritic.getName() + " works on (#" + gamePopped.getName() + ")");
				gameCritic.setCurrentGame(gamePopped);
			}
		}

	}

	public static void nextDay() { // to empty queue when skip to the next day, also to add the rated contents to
									// appropriate arraylists

		while (!movieCriticsQueue.isEmpty()) {

			MovieCritic tempCritic = movieCriticsQueue.dequeue();

			if (tempCritic.getCurrentMovie() != null) {
				System.out
						.println(tempCritic.getName() + " evaluated (#" + tempCritic.getCurrentMovie().getName() + ")");
				ratedMovies.add(tempCritic.getCurrentMovie());
				tempCritic.setCurrentMovie(null);
				movieCritics.add(tempCritic);

			}
		}

		while (!gameCriticsQueue.isEmpty()) {

			GameCritic tempCritic = gameCriticsQueue.dequeue();

			if (tempCritic.getCurrentGame() != null) {
				System.out
						.println(tempCritic.getName() + " evaluated (#" + tempCritic.getCurrentGame().getName() + ")");
				ratedGames.add(tempCritic.getCurrentGame());
				tempCritic.setCurrentGame(null);
				gameCritics.add(tempCritic);
			}
		}

	}

	public static void evaluation() { // to evaluate assignments, also to add critics that has finished him/her
										// assignment to the queue.

		giveAssignment();
		List<MovieCritic> toBeRemovedMovie = new ArrayList<>();
		List<GameCritic> toBeRemovedGame = new ArrayList<>();
		for (MovieCritic movieCritic : movieCritics) {
			if (movieCritic.getCurrentMovie() != null) {
				movieCritic.calculateRatings();
				movieCriticsQueue.enqueue(movieCritic);
				toBeRemovedMovie.add(movieCritic);
			}

		}
		movieCritics.removeAll(toBeRemovedMovie);

		for (GameCritic gameCritic : gameCritics) {
			if (gameCritic.getCurrentGame() != null) {

				if (gameCritic.getCurrentGame().getClass().getName().equals("IndefiniteGame")) {
					gameCritic.calculateRatings();
					gameCriticsQueue.enqueue(gameCritic);
					toBeRemovedGame.add(gameCritic);
				} else if (gameCritic.getCurrentGame().getClass().getName().equals("StoryGame")) {
					int leftTime = ((StoryGame) gameCritic.getCurrentGame()).getLeftTimeForNextDay();
					if (leftTime - 8 <= 0) {
						gameCritic.calculateRatings();
						gameCriticsQueue.enqueue(gameCritic);
						toBeRemovedGame.add(gameCritic);
					} else if (leftTime > 8) {
						((StoryGame) gameCritic.getCurrentGame()).setLeftTimeForNextDay(leftTime - 8);
					}

				} else if (gameCritic.getCurrentGame().getClass().getName().equals("CasualGame")) {
					CasualGame casualGame = ((CasualGame) gameCritic.getCurrentGame());
					int leftTime = casualGame.getLeftTimeForNextDay();
					int numberOfMatches = 8 / (casualGame.getMatchDuration());
					if (numberOfMatches >= 3) {
						gameCritic.calculateRatings();
						gameCriticsQueue.enqueue(gameCritic);
						toBeRemovedGame.add(gameCritic);
					} else {
						casualGame.setLeftTimeForNextDay(leftTime - casualGame.getMatchDuration() * numberOfMatches);
					}

				}

			}
		}
		gameCritics.removeAll(toBeRemovedGame);
	}

	public static void process() throws FileNotFoundException { // to start program and printing outputs in a proper way

		int index = 0;
		createContentStack();
		createCritics();
		while (index < 5) {
			System.out.println("---------------------------------");

			System.out.println("DAY-" + (index + 1));
			evaluation();
			nextDay();
			index++;
		}

		ratedMovies.sort(null);
		ratedGames.sort(null);
		System.out.println("\n\nRatings:\n\n");
		for (Movie movie : ratedMovies) {
			System.out.println("#" + movie.getName() + "(#" + movie.getYear() + "), "
					+ new DecimalFormat("##.##").format(movie.getResult()).replace(",", "."));
		}
		for (Game game : ratedGames) {
			System.out.println("#" + game.getName() + ", "
					+ new DecimalFormat("##.##").format(game.getResult()).replace(",", "."));
		}

	}

	public static Stack<Game> getGameStack() {
		return gameStack;
	}

	public static void setGameStack(Stack<Game> gameStack) {
		RatingAppManagement.gameStack = gameStack;
	}

	public static Stack<Movie> getMovieStack() {
		return movieStack;
	}

	public static void setMovieStack(Stack<Movie> movieStack) {
		RatingAppManagement.movieStack = movieStack;
	}

}
