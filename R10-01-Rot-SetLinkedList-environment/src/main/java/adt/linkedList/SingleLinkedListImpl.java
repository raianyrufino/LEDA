package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		boolean status = false;
		if(this.head.isNIL()){
			status = true;
		}
		return status;
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> aux = this.head;
		while(!aux.isNIL()){
			size++;
			aux = aux.next;
		}
		return size;
	}

	@Override
	public T search(T element) {
		T foundElement = null;
		SingleLinkedListNode<T> aux = this.head;
		while (!aux.isNIL()){
			if(aux.getData().equals(element)) {
				foundElement = aux.getData();
			}
			aux = aux.getNext();
		}
		foundElement = aux.getData();
		return foundElement;
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> aux = this.head;
		if(!isEmpty()){
			SingleLinkedListNode<T> newHead = this.head;
			newHead.next = this.head;
			this.head = newHead;
		} else {
			while (!aux.next.isNIL()){
				aux = aux.next;
			}
			SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>(element, new SingleLinkedListNode<>());
			newNode.next = aux.next;
			aux.next = newNode;
		}
	}

	@Override
	public void remove(T element) {
		if(isEmpty()){
			if(this.head.getData().equals(element)){
				this.head = this.head.next;
			}
		} else {
			SingleLinkedListNode<T> aux = this.head;
			SingleLinkedListNode<T> previous = null;
			while (!aux.isNIL() && aux.data != element){
				previous = aux;
				aux = aux.next;
			}
			if(!aux.isNIL()){
				previous.next = aux.next;
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] list = (T[]) new Object[size()];
		if(!isEmpty()) {
			SingleLinkedListNode<T> aux = this.head;
			int i = 0;
			while (!aux.isNIL()) {
				list[i] = aux.getData();
				aux = aux.next;
				i++;
			}
		}
		return list;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
