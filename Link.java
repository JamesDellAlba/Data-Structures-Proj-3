/**
 * This class is a link that holds data of type E as well as references to the next and previous link in the linked list
 *
 * @author James Dell'Alba
 * @version 3/9/2020
 * @param <E> the type of data the link holds
 */
public class Link<E> {
	public Link<E> next;
	public Link<E> previous;
	private E data;

	/**
	 * Default constructor
	 */
	public Link() {
	}

	/**
	 * Constructor that determines the type of link
	 * @param data the data type that this link will hold
	 */
	public Link(E data) {
		this.data = data;
	}

	/**
	 * Getter for the next link
	 * @return a reference to the next link in the linked list
	 */
	public Link<E> getNext() {
		return this.next;
	}

	/**
	 * Getter for the previous link
	 * @return a reference to the previous link in the linked list
	 */
	public Link<E> getPrevious() {
		return this.previous;
	}

	/**
	 * getter for the data of the link
	 * @return data of type E
	 */
	public E getData() {
		return this.data;
	}

}
