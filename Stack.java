/**
 * <p>
 * This class is an implementation of a stack using a double-ended singly-linked list with links of type Country.
 * Even though the links have a data field "previous", its value is always null and never contains a reference
 * to the previous link, which makes this a singly-linked list.</p>
 * <p>
 * The top of the stack is represented by the first of the list, and the bottom of the stack is the
 * last of the list.</p>
 *
 * @author James Dell'Alba
 * @version 3/9/2020
 */
public class Stack {
	private Link<Country> first;
	private Link<Country> last;

	/**
	 * Default constructor
	 */
	public Stack() {
	}

	/**
	 * Removes an item from the top of the stack (represented by the first of the list) and returns it.
	 * This method is O(1)
	 * @return the item from the top of the stack
	 */
	public Country pop() {
		Country countryToReturn = this.first.getData();
		this.first = this.first.next;
		return countryToReturn;
	}

	/**
	 * Inserts an item to the top of the stack (represented by the first of the list)
	 * This method is O(1)
	 * @param countryToInsert the country that will be inserted
	 */
	public void push(Country countryToInsert) {
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
	 * Removes an item from the bottom of the stack and returns it.
	 * This method is irrelevant to the implementation of a stack, but I chose not to delete it because it is
	 * fully functional and I may use it in a future implementation.
	 * @return the item that was removed
	 */
	public Country deleteRear() {
		if (!isEmpty()) {
			if (this.first != this.last) {
				Country countryToReturn = null;
				Link<Country> current = this.first;
				Link<Country> previous = this.first;
				while (current.next != null) { //traverse linked list
					previous = current;
					current = current.next;
				}
				countryToReturn = current.getData();
				this.last = previous;
				this.last.next = null;
				return countryToReturn;
			} else {
				Country countryToReturn = this.last.getData();
				this.last = null;
				this.first = null;
				return countryToReturn;
			}
		} else {
			return null;
		}
	}

	/**
	 * Inserts an item to the bottom of the stack (represented by the last of the list)
	 * This method is irrelevant to the implementation of a stack, but I chose not to delete it because it is
	 * fully functional and I may use it in a future implementation.
	 * @param countryToInsert The country that will be inserted
	 */
	public void insertRear(Country countryToInsert) {
		Link<Country> newLink = new Link<>(countryToInsert);
		if (isEmpty()) {
			this.first = newLink;
		} else {
			this.last.next = newLink;
		}
		this.last = newLink;
		this.last.next = null;
	}

	/**
	 * Checks to see if the stack is empty
	 * @return true if it is empty, false if not
	 */
	public boolean isEmpty() {
		if (this.first == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks to see if the stack is full
	 * @return always false, because this implementation of a stack can never be full
	 */
	public boolean isFull() {
		return false;
	}

	/**
	 * Prints the details of each country in the stack, starting from the top (first) and moving toward the bottom (last)
	 */
	public void printStack() {
		System.out.printf("%-33s %-10s %-20s %-15s %-16s %-10s %-10s\n", "Name", "Code", "Capitol", "Population", "GDP", "GDP/Cap", "Happiness");
		Link<Country> current = this.first;
		while (current != null) {
			current.getData().printCountry();
			current = current.next;
		}
	}
}
