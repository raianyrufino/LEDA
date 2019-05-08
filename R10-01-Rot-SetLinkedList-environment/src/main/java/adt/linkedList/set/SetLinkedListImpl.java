package adt.linkedList.set;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class SetLinkedListImpl<T> extends SingleLinkedListImpl<T> implements SetLinkedList<T> {

	@Override
	public void removeDuplicates() {
		SingleLinkedListNode<T> nodeI = getHead();
		SingleLinkedListNode<T> nodeJ;
		SingleLinkedListNode<T> nodeJPrevious;
		while (!nodeI.isNIL()) {
			nodeJ = nodeI.getNext();
			nodeJPrevious = nodeI;
			while (!nodeJ.isNIL()) {
				if (nodeJ.getData().equals(nodeI.getData())) {
					nodeJPrevious.setNext(nodeJ.getNext());
					nodeJ = nodeJ.getNext();
				} else {
					nodeJPrevious = nodeJ;
					nodeJ = nodeJ.getNext();
				}
			}
			nodeI = nodeI.getNext();
		}
	}

	@Override
	public SetLinkedList<T> union(SetLinkedList<T> otherSet) {
		SetLinkedListImpl<T> newSet = new SetLinkedListImpl<>();
		SingleLinkedListNode<T> node = getHead();

		while (!node.isNIL()) {
			newSet.insert(node.getData());
			node = node.getNext();
		}

		node = ((SetLinkedListImpl)otherSet).getHead();
		while (!node.isNIL()) {
			newSet.insert(node.getData());
			node = node.getNext();
		}

		newSet.removeDuplicates();
		return newSet;

	}

	@Override
	public SetLinkedList<T> intersection(SetLinkedList<T> otherSet) {
		SetLinkedListImpl<T> intersection = new SetLinkedListImpl<>();

		SingleLinkedListNode<T> node = getHead();
		while (!node.isNIL()) {
			if (contains(otherSet, node.getData())) {
				intersection.insert(node.getData());
			}
			node = node.getNext();
		}
		intersection.removeDuplicates();
		return intersection;
	}

	private boolean contains (SetLinkedList<T> set, T element) {
		SingleLinkedListNode<T> node = ((SetLinkedListImpl)set).getHead();
		boolean contains = false;
		while (!node.isNIL()) {
			if (node.getData().equals(element)) {
				contains = true;
				break;
			}
			node = node.getNext();
		}
		return contains;
	}

	@Override
	public void concatenate(SetLinkedList<T> otherSet) {
		if (!isEmpty()) {
			SingleLinkedListNode<T> node = getHead().getNext();
			SingleLinkedListNode<T> previous = getHead();
			while (!node.isNIL()) {
				previous = node;
				node = node.getNext();
			}
			previous.setNext(((SetLinkedListImpl) otherSet).getHead());
		} else {
			setHead(((SetLinkedListImpl)otherSet).getHead());
		}
		removeDuplicates();
	}

}