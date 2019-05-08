package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl(T data, RecursiveSingleLinkedListImpl<T> next,
										 RecursiveDoubleLinkedListImpl<T> previous) {
		super(data, next);
		this.previous = previous;
	}

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insertFirst(T element) {
		if(this.isEmpty()){
			insert(element);
		} else {
			RecursiveDoubleLinkedListImpl aux = new RecursiveDoubleLinkedListImpl<T>(this.data, ((RecursiveDoubleLinkedListImpl<T>) this.next), this);
			this.data = element;
			this.next = aux;
		}
	}

	@Override
	public void removeFirst() {
		if(!isEmpty()){
			if(this.previous.isEmpty()){
				this.data = this.next.data;
				this.next = this.next.next;
				if(this.next != null){
					((RecursiveDoubleLinkedListImpl<T>) this.next).previous = this;
				}
			}
		}
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			if (isEmpty()) {
				this.data = element;
				this.next = new RecursiveDoubleLinkedListImpl<T>(null, null, this);
				if (this.previous == null) {
					this.previous = new RecursiveDoubleLinkedListImpl<T>(null, this, null);
				}
			} else {
				this.next.insert(element);
			}
		}
	}

	@Override
	public void removeLast() {
		if(!isEmpty()){
			if(this.next.isEmpty()){
				this.data = null;
				this.next = null;
			} else {
				((RecursiveDoubleLinkedListImpl<T>) this.next).removeLast();
			}
		}

	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
