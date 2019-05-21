package adt.linkedList.ordered;

import java.util.Comparator;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListNode;
import adt.linkedList.SingleLinkedListNode;

/**
 * Para testar essa classe voce deve implementar seu comparador. Primeiro
 * implemente todos os métodos requeridos. Depois implemente dois comparadores
 * (com idéias opostas) e teste sua classe com eles. Dependendo do comparador
 * que você utilizar a lista funcionar como ascendente ou descendente, mas a
 * implemntação dos métodos é a mesma.
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class OrderedDoubleLinkedListImpl<T extends Comparable<T>> extends OrderedSingleLinkedListImpl<T> implements
		OrderedLinkedList<T>,DoubleLinkedList<T> {

	private DoubleLinkedListNode<T> last;

	public OrderedDoubleLinkedListImpl(Comparator<T> comparator) {
		super(comparator);
	}
	
	/**
	 * Este método faz sentido apenas se o elemento a ser inserido pode 
	 * realmente ficar na primeira posição (devido a ordem)
	 */
	@Override
	public void insertFirst(T element) {
		if(element != null){
			DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<>();
			DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.head;
			if(aux.getData().compareTo((T) aux.getNext()) < 0){
				newHead.setData(element);
				newHead.setNext(this.getHead());
				newHead.setPrevious(new DoubleLinkedListNode<>());
				((DoubleLinkedListNode<T>) this.getHead()).setPrevious(newHead);

				if(this.getLast().isNIL()){
					this.setLast(newHead);
				}
				this.setHead(newHead);
			}

		}

	}

	@Override
	public void removeFirst() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

	
}
