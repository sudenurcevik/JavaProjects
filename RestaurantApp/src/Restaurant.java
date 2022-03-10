public class Restaurant {
	private String name;
	private double rating;
	private String cuisine;
	private int deliveryTime;

	public Restaurant(String name, double rating, String cuisine, int deliveryTime) {
		super();
		this.name = name;
		this.rating = rating;
		this.cuisine = cuisine;
		this.deliveryTime = deliveryTime;
	}

	public void updateCuisine(String category) {
		this.cuisine = category;
	}

	public void updateRating(double score) {
		this.rating = score;
	}

	public void updateDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	public String getName() {
		return name;
	}

	public double getRating() {
		return rating;
	}

	public String getCuisine() {
		return cuisine;
	}

	public int getDeliveryTime() {
		return deliveryTime;
	}

	public int CompareTo_byRate(Restaurant restaurant) {
		if (this.rating > restaurant.rating) {
			return 1;
		} else if (this.rating < restaurant.rating) {
			return -1;

		} else {
			return 0;
		}

	}

	public int CompareTo_byDelivery(Restaurant restaurant) {
		if (this.deliveryTime > restaurant.deliveryTime) {
			return 1;
		} else if (this.deliveryTime < restaurant.deliveryTime) {
			return -1;

		} else {
			return 0;
		}

	}

	public String toString() {
		int spaceNum = 38 - (getName().length() + 4);
		String space = "";

		while (spaceNum > 0) {
			space += " ";
			spaceNum--;

		}

		return getName() + space + getRating();
	}

	public String ToString() {
		int spaceNum = 31 - (getName().length() + 4);
		String space = "";

		while (spaceNum > 0) {
			space += " ";
			spaceNum--;

		}
		return getName() + space + getRating() + "           Removed";
	}
}