package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		return this.array[top];
	}

	@Override
	public boolean isEmpty() {
		boolean status = false;
		if(this.top == -1){
			status = true;
		}
		return status;
	}

	@Override
	public boolean isFull() {
		boolean status = false;
		if(this.top == this.array.length-1){
			status = true;
		}
		return status;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(isFull()){
			throw new StackOverflowException();
		}
		this.top++;
		this.array[top] = element;
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(isEmpty()){
			throw new StackUnderflowException();
		}
		T value = this.top();
		this.top--;
		return value;
	}

}
