package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	public RecursiveSingleLinkedListImpl(T data, RecursiveSingleLinkedListImpl<T> next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public boolean isEmpty() {
		boolean status = false;
		if(this.data == null){
			status = true;
		}
		return status;
	}

	@Override
	public int size() {
		if(this.data == null){
			return 0;
		}
		return this.next.size();

	}

	@Override
	public T search(T element) {
		if(isEmpty()){
			return null;
		}

		if(this.data.equals(element)){
			return this.data;
		}
		return this.next.search(element);

	}

	@Override
	public void insert(T element) {
		if(isEmpty()){
			this.data = element;
			this.next = new RecursiveSingleLinkedListImpl<>();
		} else {
			this.next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if(!isEmpty() && element != null){
			if(this.data.equals(element)){
				this.data = this.next.data;
				this.next = this.next.next;
			} else {
				this.next.remove(element);
			}
		}

	}

	@Override
	public T[] toArray() {
		T[] saida = (T[]) new Object[this.size()];
		buildArray(saida, 0, this);
		return saida;
	}

	private void buildArray(T[] array, int pos, RecursiveSingleLinkedListImpl<T> node) {
		if (!node.isEmpty()) {
			array[pos] = node.getData();
			buildArray(array, ++pos, node.getNext());
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
