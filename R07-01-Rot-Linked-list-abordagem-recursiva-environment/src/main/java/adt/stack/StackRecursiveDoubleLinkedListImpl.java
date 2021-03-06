package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.RecursiveDoubleLinkedListImpl;

public class StackRecursiveDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackRecursiveDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new RecursiveDoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(isFull()){
			throw new StackOverflowException();
		}
		if(element != null){
			this.top.insertFirst(element);
			this.size++;
		}


	}

	@Override
	public T pop() throws StackUnderflowException {
		if(!isEmpty()){
			T value = this.top();
			this.top.removeFirst();
			this.size--;
			return value;
		}
		throw new StackUnderflowException();
	}

	@Override
	public T top() {
		if(!isEmpty()){
			return ((RecursiveDoubleLinkedListImpl<T>) this.top).getData();
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		boolean status = false;
		if(this.top.size() == -1){
			status = true;
		}
		return status;
	}

	@Override
	public boolean isFull() {
		boolean status = false;
		if(this.top.size() == this.size){
			status = true;
		}
		return status;
	}

}
