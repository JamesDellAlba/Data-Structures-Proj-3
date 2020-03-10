import java.io.File;
import java.util.Scanner;

/**
 * This class creates a stack of countries that have a GDP/Capita that is less than 1000, between 5000 and 20000,
 * or greater than 50000. It then puts those countries into a queue, alternating between inserting at the
 * front and back. Finally, it removes items from the queue (alternating between front and back) and pushes them
 * to the stack.
 *
 * @author James Dell'Alba
 * @version 3/9/2020
 */
public class Project3 {
	public static void main(String[] args) throws java.io.FileNotFoundException {
		Scanner input = new Scanner(System.in);
		String fileName = "";
		do {
			System.out.println("enter the name of the file");
			fileName = input.next();
		} while (!fileName.equals("Countries3.csv"));

		File countries = new File(fileName);
		Scanner fileInput = new Scanner(countries);

		fileInput.useDelimiter(",|\n"); //set the delimiter to comma or newline

		String firstLine = fileInput.nextLine(); //move the cursor past the first line of the file

		//create an array of countries
		Country[] countryArray = new Country[155];
		for (int i = 0; i < 155; i++) {
			//fill the array with Country objects
			String name = fileInput.next();
			String code = fileInput.next();
			String capitol = fileInput.next();
			long population = Double.valueOf(fileInput.next()).longValue();
			long gdp = Double.valueOf(fileInput.next()).longValue();
			long happiness = Double.valueOf(fileInput.next()).longValue();
			countryArray[i] = new Country(name, code, capitol, population, gdp, happiness);
		}

		Stack poorGoodExcellentStack = new Stack();
		for (int i = 0; i < 155; i++) {
			if ((countryArray[i].getGdpPerCapita() < 1000) ||
					((countryArray[i].getGdpPerCapita() > 5000) && (countryArray[i].getGdpPerCapita() < 20000)) ||
					(countryArray[i].getGdpPerCapita() > 50000))
			{
				poorGoodExcellentStack.push(countryArray[i]);
			}
		}
		System.out.println("\nPoor-Good-Excellent Stack:");
		poorGoodExcellentStack.printStack();

		Queue poorGoodExcellentQueue = new Queue();
		int i = 0;
		while (!poorGoodExcellentStack.isEmpty()) {
			if ((i % 2) == 0) {
				poorGoodExcellentQueue.insertFront(poorGoodExcellentStack.pop());
			} else {
				poorGoodExcellentQueue.insertEnd(poorGoodExcellentStack.pop());
			}
			i++;
		}
		System.out.println("\nPoor-Good-Excellent Queue:");
		poorGoodExcellentQueue.printQueue();

		poorGoodExcellentQueue.intervalDelete(50000, 70000);
		System.out.println("\nQueue after deleting countries with GDP/Capita between 50,000 and 70,000:");
		poorGoodExcellentQueue.printQueue();

		i = 0;
		while(!poorGoodExcellentQueue.isEmpty()) {
			if ((i % 2) == 0) {
				poorGoodExcellentStack.push(poorGoodExcellentQueue.removeFront());
			} else {
				poorGoodExcellentStack.push(poorGoodExcellentQueue.removeEnd());
			}
			i++;
		}
		System.out.println("\nStack after pushing items from the queue:");
		poorGoodExcellentStack.printStack();

	}
}