import java.util.Comparator;

public class Comparators {
	class PriceComparator implements Comparator<Food> {

		@Override
		public int compare(Food o1, Food o2) {
			if (o1.getPrice() < o2.getPrice()) {
				return -1;
			} else if (o1.getPrice() > o2.getPrice()) {
				return 1;
			} else {
				return 0;
			}

		}

	}

	class RatingComparator implements Comparator<Restaurant> {

		@Override
		public int compare(Restaurant o1, Restaurant o2) {
			if (o1.getRating() < o2.getRating()) {
				return -1;
			} else if (o1.getRating() > o2.getRating()) {
				return 1;
			} else {
				return 0;
			}

		}

	}

	class StockComparator implements Comparator<Food> {

		@Override
		public int compare(Food o1, Food o2) {

			if (o1.getStock() < o2.getStock()) {
				return -1;
			} else if (o1.getStock() > o2.getStock()) {
				return 1;
			} else {
				return 0;
			}

		}

	}

	class DeliveryComparator implements Comparator<Restaurant> {

		@Override
		public int compare(Restaurant o1, Restaurant o2) {
			if (o1.getDeliveryTime() < o2.getDeliveryTime()) {
				return -1;
			} else if (o1.getDeliveryTime() > o2.getDeliveryTime()) {
				return 1;
			} else {
				return 0;
			}

		}

	}

}
