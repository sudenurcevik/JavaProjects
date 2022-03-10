import java.io.FileNotFoundException;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
	
		

		FileReader yeniFileReader = new FileReader();
		String[] aStrings = yeniFileReader.read();

		Comparators comparator = new Comparators();
		Comparators.PriceComparator priceComparator = comparator.new PriceComparator();
		Comparators.StockComparator stockComparator = comparator.new StockComparator();
		Comparators.DeliveryComparator deliveryComparator = comparator.new DeliveryComparator();
		Comparators.RatingComparator ratingComparator = comparator.new RatingComparator();

		BinarySearchTree<Restaurant> treeRating = new BinarySearchTree<Restaurant>(ratingComparator);
		BinarySearchTree<Restaurant> treeDelivery = new BinarySearchTree<Restaurant>(deliveryComparator);
		BinarySearchTree<Food> treePrice = new BinarySearchTree<Food>(priceComparator);
		BinarySearchTree<Food> treeStock = new BinarySearchTree<Food>(stockComparator);

		int index = 1;
		while (aStrings.length != index) {

			String[] item = aStrings[index].split(",");
			Restaurant restaurant = new Restaurant(item[3], (Double.parseDouble(item[4])), item[5],
					(Integer.parseInt(item[6])));
			Orderable foodOrderable = new Food(item[0], (Double.parseDouble(item[1])), (Integer.parseInt(item[2])),
					restaurant);

			treeRating.add(restaurant);
			treeDelivery.add(restaurant);
			treePrice.add((Food) foodOrderable);
			treeStock.add((Food) foodOrderable);
			index++;

		}
		

		Iterator<Food> iter = treePrice.InOrderIterator();
		Iterator<Food> iter2 = treeStock.InOrderIterator();
		Iterator<Restaurant> iter3 = treeRating.InOrderIterator();
		Iterator<Restaurant> iter4 = treeDelivery.InOrderIterator();
		Iterator<Food> iter5 = treeStock.InOrderIterator();
		Iterator<Food> iter6 = treeStock.InOrderIterator();

		System.out.println("\n\n------------------------1------------------------");
		treeRating.DescendingPrinter();
		System.out.println("\n\n------------------------2------------------------");
		treePrice.AscendingPrinter();

		System.out.println("\n\n------------------------3------------------------");
		GenericLinkedStack<Restaurant> restaurantObject = new GenericLinkedStack<>();
		Restaurant comparedObject = new Restaurant("trial", 0, "trial", 100);
		restaurantObject.push(comparedObject);
		while (iter4.hasNext()) {
			Restaurant temp4 = iter4.next();
			if ((temp4.getCuisine().equals(" Pizza"))
					&& (temp4.getDeliveryTime() < restaurantObject.peek().getDeliveryTime())) {
				restaurantObject.pop();
				restaurantObject.push(temp4);
			}
		}
		System.out.println(restaurantObject.peek().getName() + "      " + restaurantObject.pop().getDeliveryTime());
		System.out.println("\n\n------------------------4------------------------");
		GenericLinkedStack<Food> FoodObject = new GenericLinkedStack<>();
		Orderable compOrderable = new Food("trivial", 0, 10, comparedObject);
		FoodObject.push((Food) compOrderable);
		while (iter6.hasNext()) {
			Food temp6 = iter6.next();
			if ((temp6.getRestaurant().getCuisine().equals(" Coffee"))
					&& (temp6.getStock() > FoodObject.peek().getStock())) {
				FoodObject.pop();
				FoodObject.push(temp6);
			}

		}
		System.out.println(FoodObject.peek().getName() + "       " + FoodObject.pop().getStock());

		System.out.println("\n\n------------------------5------------------------");
		while (iter.hasNext()) {
			Food temp = iter.next();
			if (temp.getPrice() > 80) {
				System.out.println(temp.Tostring());
				treePrice.remove(temp);
				treeStock.remove(temp);
			}

		}

		System.out.println("\n\n------------------------6------------------------");
		while (iter3.hasNext()) {
			Restaurant temp3 = iter3.next();
			if (temp3.getRating() < 8) {
				System.out.println(temp3.ToString());
				treeRating.remove(temp3);
				treeDelivery.remove(temp3);
			}

		}
		System.out.println("\n\n------------------------7------------------------");
		System.out.println("Prices in FoodBSTs are updated.");

		while (iter2.hasNext()) {
			Food temp2 = iter2.next();
			temp2.updatePrice(Math.round(temp2.getPrice() * 6 / 5));
		}

		System.out.println("\n\n------------------------8------------------------");
		System.out.println("Stocks in FoodBSTs are updated.");

		while (iter5.hasNext()) {
			Food temp5 = iter5.next();
			temp5.updateStock(Math.round(temp5.getStock() / 2));
		}
		System.out.println("\n\n------------------------9------------------------");

		treeRating.DescendingPrinter();

		System.out.println("\n\n------------------------10------------------------");
		treePrice.AscendingPrinter();

	}

}
