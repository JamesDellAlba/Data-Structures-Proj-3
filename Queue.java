/**
 * This class is an implementation of a queue using a double-ended doubly-linked list with data of type Country.
 * Some methods such as intervalDelete() are outside the functionality of a traditional queue
 *
 * @author James Dell'Alba
 * @version 3/9/2020
 */
public class Queue {
	private Link<Country> first;
	private Link<Country> last;

	/**
	 * Default constructor
	 */
	public Queue() {
	}

	/**
	 * Inserts a country at the front of the queue
	 * @param countryToInsert the country that will be inserted
	 */
	public void insertFront(Country countryToInsert) {
		Link<Country> newLink = new Link<>(countryToInsert);
		if (this.isEmpty()) {
			newLink.next = this.first;
			this.first = newLink;
			this.last = this.first;
		} else {
			newLink.next = this.first;
			this.first = newLink;
		}
	}

	/**
	 * Inserts a country at the end of the queue
	 * @param countryToInsert the country that will be inserted
	 */
	public void insertEnd(Country countryToInsert) {
		Link<Country> newLink = new Link<>(countryToInsert);
		if (isEmpty()) {
			this.first = newLink;
			this.last = newLink;
		} else {
			newLink.previous = this.last;
			this.last.next = newLink;
		}
		this.last = newLink;
		this.last.next = null;
	}

	/**
	 * Removes a country from the front of the queue
	 * @return the country at the front
	 */
	public Country removeFront() {
		Country countryToReturn = this.first.getData();
		this.first = this.first.next;
		return countryToReturn;
	}

	/**
	 * Removes a country from the rear of the queue
	 * @return the country at the rear
	 */
	public Country removeEnd() {
		Country countryToReturn = this.last.getData();
		this.last = this.last.previous;
		this.last.next = null;
		return countryToReturn;
	}

	/**
	 * Prints the details of each country in the queue starting at the front and moving toward the rear.
	 */
	public void printQueue() {
		System.out.printf("%-33s %-10s %-20s %-15s %-16s %-10s %-10s\n", "Name", "Code", "Capitol", "Population", "GDP", "GDP/Cap", "Happiness");
		Link<Country> current = this.first;
		while (current != null) {
			current.getData().printCountry();
			current = current.next;
		}
	}

	/**
	 * Checks if the queue is empty
	 * @return true is empty, false if not empty
	 */
	public boolean isEmpty() { //returns true if empty, false if not
		if (this.first == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * checks if the queue is full
	 * @return always false, since this implementation of a queue can never be full
	 */
	public boolean isFull() {
		return false;
	}

	/**
	 * Deletes all countries that have a GDP/Capita between the inputted values.
	 * These may be anywhere inside the queue, not only the front or rear.
	 *
	 * @param lowerbound the lower bound for items to be deleted
	 * @param upperbound the upper bound for items to be deleted
	 * @return true if any items in the interval were deleted
	 */
	public boolean intervalDelete(int lowerbound, int upperbound) {
		Link<Country> previous = this.first;
		Link<Country> current = this.first;
		boolean somethingDeleted = false;

		while (current != null) {
			previous = this.first;
			current = this.first;
			while (current != null) { //traverse queue
				if (current.getData().getGdpPerCapita() > lowerbound && current.getData().getGdpPerCapita() < upperbound) {
					if (current == this.first) { //if item is first in the list
						this.first = this.first.next;
					} else if (current == this.last) { //if item is last in the list
						this.last = this.last.previous;
					} else {
						previous.next = current.next; //delete link
					}
					somethingDeleted = true;
					break;
				}
				previous = current;
				current = current.next;
			}
		}
		return somethingDeleted;
	}
}
