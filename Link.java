public class Link<E> {
	public Link<E> next;
	private E data;

	public Link() {
	}

	public Link(E data) {
		this.data = data;
	}

	public Link<E> getNext() {
		return next;
	}

	public E getData() {
		return this.data;
	}

}
