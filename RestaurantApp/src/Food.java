public class Food implements Orderable {
	private String name;
	private double price;
	private int stock;
	private Restaurant restaurant;

	public Food(String name, double price, int stock, Restaurant restaurant) {
		super();
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.restaurant = restaurant;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	@Override
	public void updatePrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	@Override
	public void updateStock(int stock) {
		this.stock = stock;

	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public int CompareTo_byPrice(Food food) {
		if (this.price > food.price) {
			return 1;
		} else if (this.price < food.price) {
			return -1;

		} else {
			return 0;
		}

	}

	public String toString() {

		int spaceNum = 30 - (getName().length() + 4);
		int spaceNum2 = 15 - (String.valueOf(getPrice())).length();

		String space = "";
		String space2 = "";

		while (spaceNum > 0) {
			space += " ";
			spaceNum--;

		}
		while (spaceNum2 > 0) {
			space2 += " ";
			spaceNum2--;

		}

		return getName() + space + getPrice() + space2 + getStock();
	}

	public String Tostring() {
		int spaceNum = 30 - (getName().length() + 4);
		int spaceNum2 = 15 - (String.valueOf(getPrice())).length();

		String space = "";
		String space2 = "";

		while (spaceNum > 0) {
			space += " ";
			spaceNum--;

		}
		while (spaceNum2 > 0) {
			space2 += " ";
			spaceNum2--;

		}

		return getName() + space + getPrice() + space2 + "Removed";
	}
}
