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
		RecursiveDoubleLinkedListImpl<T> aux = new RecursiveDoubleLinkedListImpl<>();
		aux.data = this.data;
		aux.next = this.next;
		aux.previous = this;
		this.data = element;
		this.next = aux;
	}

	@Override
	public void removeFirst() {
		if(!isEmpty()){
			this.data = this.next.data;
			this.next = this.next.next;
			this.previous = new RecursiveDoubleLinkedListImpl<>();
		}
	}

	@Override
	public void removeLast() {
		if(!isEmpty()){
			if(this.next.isEmpty()){
				this.previous.next = new RecursiveDoubleLinkedListImpl<>();
			} else {
				((RecursiveDoubleLinkedListImpl<T>)this.next).removeLast();
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
