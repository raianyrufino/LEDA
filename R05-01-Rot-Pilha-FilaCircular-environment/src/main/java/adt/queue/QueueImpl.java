package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		return this.array[0];
	}

	@Override
	public boolean isEmpty() {
		boolean status = false;
		if(this.tail == -1){
			status = true;
		}
		return status;
	}

	@Override
	public boolean isFull() {
		boolean status = false;
		if(this.tail == this.array.length-1){
			status = true;
		}
		return status;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(this.isFull()){
			throw new QueueOverflowException();
		}
		this.tail++;
		this.array[tail] = element;
	}

	private void shiftLeft() {
		for(int i=0; i<=this.tail; i++){
			this.array[i] = this.array[i+1];
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()){
			throw new QueueUnderflowException();
		}
		T value = this.array[tail];
		shiftLeft();
		tail--;
		return value;

	}

}
