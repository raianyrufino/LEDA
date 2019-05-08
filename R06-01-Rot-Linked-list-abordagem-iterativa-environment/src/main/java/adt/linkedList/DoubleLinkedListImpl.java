package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		this.head = new DoubleLinkedListNode<>();
		this.last = (DoubleLinkedListNode<T>) this.head;
	}

	/**
	 * Inserts a new element at the end of the list. Null elements must be
	 * ignored.
	 *
	 * @param element the element to be inserted
	 */
	@Override
	public void insert(T element) {
		if(element != null){
			DoubleLinkedListNode<T> newLast = new DoubleLinkedListNode<>();
			newLast.setData(element);
			newLast.setPrevious(this.getLast());
			newLast.setNext(new DoubleLinkedListNode<>());

			this.getLast().setNext(newLast);

			if(this.getLast().isNIL()){
				this.setHead(newLast);
			}
			this.setLast(newLast);
		}
	}

	/**
	 * Inserts a new element in the first position (head) of the list. The
	 * "head" reference must be updated.
	 *
	 * @param element
	 */
	@Override
	public void insertFirst(T element) {
		if(element != null){
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<>();
			newHead.setData(element);
			newHead.setNext(this.getHead());
			newHead.setPrevious(new DoubleLinkedListNode<>());

			((DoubleLinkedListNode<T>)this.getHead()).setPrevious(newHead);

			if(this.getLast().isNIL()){
				this.setLast(newHead);
			}
			this.setHead(newHead);
		}
	}



	/**
	 * Removes the first element (head) of the list. The "head" reference must
	 * be updated.
	 */
	@Override
	public void removeFirst() {
		if (!this.getHead().isNIL()) {
			this.setHead(this.getHead().getNext());

			if (this.getHead().isNIL()) {
				this.setLast((DoubleLinkedListNode<T>) this.getHead());
			}

			((DoubleLinkedListNode<T>) this.getHead()).setPrevious(new DoubleLinkedListNode<>());
		}
	}

	/**
	 * Removes the last element (last) of the list. The "last" reference must be
	 * updated.
	 */
	@Override
	public void removeLast() {
		if (!this.getLast().isNIL()) {
			this.setLast(this.getLast().getPrevious());

			if (this.getLast().isNIL()) {
				this.setHead(this.getLast());
			}

			this.getLast().setNext(new SingleLinkedListNode<>());
		}
	}

	/**
	 * Removes an element from the list. If the element does not exist the list
	 * is not changed.
	 *
	 * @param element the element to be removed
	 */
	@Override
	public void remove(T element) {
		if (element != null) {
			if (this.getHead().getData().equals(element)) {
				this.removeFirst();
			} else {
				DoubleLinkedListNode<T> head = (DoubleLinkedListNode<T>) this.getHead();

				while (!head.isNIL() && !head.getData().equals(element)) {
					head = (DoubleLinkedListNode<T>) head.getNext();
				}

				if (!head.isNIL()) {
					head.getPrevious().setNext(head.getNext());
					((DoubleLinkedListNode<T>) head.getNext()).setPrevious(head.getPrevious());
				}
			}
		}
	}

	/**
	 * Searches for a given element in the list.
	 *
	 * @param element the element being searched for
	 * @return the element if it is in the list or null, otherwise
	 */
	@Override
	public T search(T element) {
		T elementFound = null;

		if (element != null) {
			DoubleLinkedListNode<T> head = (DoubleLinkedListNode<T>) this.getHead();
			DoubleLinkedListNode<T> last = this.getLast();

			while (!head.equals(last) && !head.getNext().equals(last) && !head.getData().equals(element) && !last.getData().equals(element)) {
				head = (DoubleLinkedListNode<T>) head.getNext();
				last = last.getPrevious();
			}

			if (head.getData().equals(element)) {
				elementFound = head.getData();
			}

			if (last.getData().equals(element)) {
				elementFound = last.getData();
			}
		}

		return elementFound;

	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}