package adt.linkedList;

import java.util.ArrayList;
import java.util.List;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		int size = 0;
		SingleLinkedListNode<T> node = getHead();
		while (!node.isNIL()) {
			size++;
			node = node.getNext();
		}
		return size;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> node = getHead();

		while (!node.isNIL() && !node.getData().equals(element)) {
			node = node.getNext();
		}

		return node.getData();
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			SingleLinkedListNode<T> node = getHead();
			while (!node.isNIL()) {
				node = node.getNext();
			}
			node.setData(element);
			node.setNext(new SingleLinkedListNode<>(null, null));
		}
	}

	@Override
	public void remove(T element) {
		if (element != null) {

			if (getHead().getData().equals(element)) {
				setHead(getHead().getNext());
			} else {
				SingleLinkedListNode<T> node = getHead();
				while (!node.getNext().isNIL() && !node.getNext().getData().equals(element)) {
					node = node.getNext();
				}
				if (!node.getNext().isNIL()) {
					node.setNext(node.getNext().getNext());
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		List<T> arrayList = new ArrayList<>();
		SingleLinkedListNode<T> node = this.getHead();

		while (!node.isNIL()) {
			arrayList.add(node.getData());
			node = node.getNext();
		}

		return (T[]) arrayList.toArray();
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}