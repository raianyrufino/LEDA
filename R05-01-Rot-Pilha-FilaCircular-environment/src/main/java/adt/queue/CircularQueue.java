package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(isFull()){
			throw new QueueOverflowException();
		}
		if(this.head == this.tail){
			this.head = 0;
			this.tail = 0;
			this.array[0] = element;
		} else {
			this.tail = (this.tail+1)%this.elements;
		}
		this.elements++;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()){
			throw new QueueUnderflowException();
		}
		T value = this.head();
		if(this.head == this.tail) {
			this.head = -1;
			this.tail = -1;
		} else {
			this.head = (this.head+1)%this.elements;
		}
		return value;
	}

	@Override
	public T head() {
		return this.array[head];
	}

	@Override
	public boolean isEmpty(){
		boolean status = false;
		if(this.tail == -1 && this.head == -1){
			status = true;
		}
		return status;
	}

	@Override
	public boolean isFull() {
		boolean status = false;
		if((this.tail+1)%this.elements == this.head){
			status = true;
		}
		return status;
	}
}
