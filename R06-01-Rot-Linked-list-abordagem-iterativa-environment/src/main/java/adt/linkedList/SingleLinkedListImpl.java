package adt.linkedList;

import com.sun.corba.se.spi.ior.ObjectKey;
import org.omg.CORBA.Object;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head == null;
	}

	@Override
	public int size() {
		int size = 0;
		if(!this.head.isNIL()){
			size++;
		}
		return size;
	}

	@Override
	public T search(T element) {
		T elementFound = null;
		if(element != null){
			SingleLinkedListNode<T> aux = this.head;
			while (!aux.isNIL()) {
				if (element.equals(aux)) {
					elementFound = aux.getData();
				}
				aux = aux.next;
			}
		}
		return elementFound;
	}

	@Override
	public void insert(T element) {
		if(isEmpty()){
			//add no comeco
			SingleLinkedListNode<T> newHead = null;
			newHead.setData(element);
			newHead.next = this.head.next;
		} else {
			if(element != null){
				SingleLinkedListNode<T> aux = this.head;
				while(!aux.next.isNIL()){
					aux = aux.next;
				}
				SingleLinkedListNode<T> newNode = new SingleLinkedListNode<>(element, new SingleLinkedListNode<>());
				newNode.next = aux.next;
				aux.next = newNode;
			}
		}
	}

	@Override
	public void remove(T element) {
		if(isEmpty()){
			if(this.head.getData().equals(element)){
				this.head = this.head.next;
			}
		} else {
			SingleLinkedListNode<T> previous = null;
			SingleLinkedListNode<T> aux = this.head;
			while (!aux.isNIL() && !aux.getData().equals(element)){
				previous = aux;
				aux = aux.next;
			}
			if(!aux.isNIL()) {
				previous.next = aux.next;
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] list = (T[]) new Object[size()];
		if(!isEmpty()){
			SingleLinkedListNode<T> aux = this.head;
			int i = 0;
			while (!aux.isNIL()){
				list[i] = aux.getData();
				i++;
				aux = aux.next;
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