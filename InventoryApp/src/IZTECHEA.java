import java.util.Random;
import java.util.Scanner;
public class IZTECHEA {

	public static void main(String[] args) {
		String[] products= {"Sofa", "Bed", "Chair", "Dresser", "Table", "Bookcase"};
		Scanner scan= new Scanner (System.in);
		Random randomNum= new Random();
		System.out.println("WELCOME TO IZTECHEA!!");
		System.out.println("Enter the number of random request cycles:");
		int request = scan.nextInt();
		Task tasks= new Task();
		int cycle_num=0;
		while (cycle_num<request) {
			String product="";
			int r1 = randomNum.nextInt(3);
			switch (r1) {
			case 0: {
				int r2 = randomNum.nextInt(6);
				product= products[r2];
				tasks.Manager_Analysist(product,cycle_num+1);
			break;
			}
			case 1: {
				tasks.Storage_Chief(cycle_num+1);
			break;
			}
			case 2: {
				int r2 = randomNum.nextInt(6);
				product= products[r2];
				tasks.Customer(product,cycle_num+1);
			break;
			}
			
			}
			cycle_num++;
			product="";
		}
		System.out.println("\nREPORT: \n");
		tasks.Report();
		
		scan.close();
	}
}