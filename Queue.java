public class Queue {
	private Link<Country> first;
	private Link<Country> last;

	public Queue() {
	}

	public void insertFront(Country countryToInsert) {
		Link<Country> newLink = new Link<>(countryToInsert);
		newLink.next = this.first;
		this.first = newLink;
	}

	public void insertEnd(Country countryToInsert) {
		Link<Country> newLink = new Link<>(countryToInsert);
		if (isEmpty()) {
			this.first = newLink;
		} else {
			this.last.next = newLink;
		}
		this.last = newLink;
	}

	public Country removeFront() {
		Country countryToReturn = this.first.getData();
		this.first = this.first.next;
		return countryToReturn;
	}

	public Country removeEnd() {
		Link<Country> current = this.first;
		Link<Country> previous = this.first;
		while(current != this.last) {
			previous = current;
			current = current.next;
		}
		this.last = previous;
		return previous.getData();
	}

	public void printQueue() {
		System.out.printf("%-33s %-10s %-20s %-15s %-16s %-10s %-10s\n", "Name", "Code", "Capitol", "Population", "GDP", "GDP/Cap", "Happiness");
		Link<Country> current = this.first;
		while(current.next != null) {
			current.getData().printCountry();
			current = current.next;
		}
	}

	public boolean isEmpty() { //returns true if empty, false if not
		if (this.first == null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFull() {
		return false;
	}

	public boolean intervalDelete(int lowerbound, int upperbound) {
		Link<Country> previous = this.first;
		Link<Country> current = this.first.next;
		boolean somethingDeleted = false;

		while(current.next != null) {
			while (current.getData().getGdpPerCapita() < lowerbound || current.getData().getGdpPerCapita() > upperbound) {
				previous = current;
				current = current.next;
			}
			while (current.getData().getGdpPerCapita() > lowerbound && current.getData().getGdpPerCapita() < upperbound) {
				if (current == this.first) {
					this.first = this.first.next;
				} else {
					previous.next = current.next;
				}
				previous = current;
				current = current.next;
				somethingDeleted = true;
			}
		}

		return somethingDeleted;
	}

}
