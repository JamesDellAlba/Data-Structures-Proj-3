import java.io.File;
import java.util.Scanner;

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
		Country[] countryArray = new Country[156];
		for(int i = 0; i < 155; i++) {
			//fill the array with Country objects
			String name = fileInput.next();
			String code = fileInput.next();
			String capitol = fileInput.next();
			long population = Double.valueOf(fileInput.next()).longValue();
			long gdp = Double.valueOf(fileInput.next()).longValue();
			long happiness = Double.valueOf(fileInput.next()).longValue();
			countryArray[i] = new Country(name, code, capitol, population, gdp, happiness);
		}

		Queue testQueue = new Queue();
		for (int i = 0; i < 156; i++) {
			testQueue.insertEnd(countryArray[i]);
		}
		testQueue.intervalDelete(0,10000);
		testQueue.printQueue();
	}
}