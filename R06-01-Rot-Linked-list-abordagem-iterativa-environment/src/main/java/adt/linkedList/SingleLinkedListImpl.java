package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		boolean status = false;
		if(head.isNIL()){
			status = true;
		}
		return status;
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> aux = this.head;
		while(!aux.isNIL()){
			size += 1;
			aux = aux.next;
		}
		return size;

	}

	@Override
	public T search(T element) {
		T value = null;
		if(!isEmpty()) {
			SingleLinkedListNode<T> aux = this.head;
			while (!aux.isNIL()){
				if(aux.getData().equals(element)){
					value = aux.getData();
				}
				aux = aux.getNext();
			}
		}
		return value;
	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> auxHead = this.head;
		if(this.head.isNIL()){
			SingleLinkedListNode<T> newHead = new SingleLinkedListNode<>(element, new SingleLinkedListNode<>());
			newHead.next = this.head;
			head = newHead;
		} else {
			while (!auxHead.next.isNIL()){
				auxHead = auxHead.next;
			}
			SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>(element, new SingleLinkedListNode<>());
			newNode.next = auxHead.next;
			auxHead.next = newNode;
		}
	}

	@Override
	public void remove(T element) {
		if(isEmpty()){
			if(this.head.getData().equals(element)){
				this.head = head.next;
			}
		} else {
			SingleLinkedListNode<T> aux = this.head;
			SingleLinkedListNode<T> previous = null;
			while (!aux.isNIL() && aux.data != element) {
				previous = aux;
				aux = aux.next;
			}
			if (!aux.isNIL()) {
				previous.next = aux.next;
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] list = (T[]) new Object[size()];
		if (!isEmpty()) {
			SingleLinkedListNode<T> aux = this.head;
			int i = 0;
			while (!aux.isNIL()) {
				list[i] = aux.data;
				aux = aux.next;
				i += 1;
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
