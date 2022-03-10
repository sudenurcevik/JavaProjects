import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
	LinkedQueue<String> test = new LinkedQueue<>();

	public String[] read() {
		try {
			File myObj = new File("CENG112_HW4.csv");

			Scanner myReader = new Scanner(myObj);

			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				test.enqueue(data);
			}

			myReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return test.toArray(String.class);
	}
}
