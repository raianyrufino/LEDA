package adt.linkedList.batch;

import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.DoubleLinkedListNode;
import adt.linkedList.SingleLinkedListNode;
import com.sun.tools.javac.jvm.Gen;
import util.GenericException;

/**
 * Manipula elementos da LinkedList em bloco (batch).
 * 
 * ATENÇÃO: NAO MODIFIQUE NENHUMA OUTRA CLASSE ALEM DESTA !!!!! 
 * 
 * @author campelo
 * @author adalberto
 *
 * @param <T>
 */
public class BatchLinkedListImpl<T> extends DoubleLinkedListImpl<T> implements BatchLinkedList<T> {

	/* 
	 * Nao modifique nem remova este metodo.
	 */
	public BatchLinkedListImpl() {
		head = new DoubleLinkedListNode<T>();
		last = (DoubleLinkedListNode<T>)head;
	}

	@Override
	public void inserirEmBatch(int posicao, T[] elementos) throws GenericException {
		if(posicao < 0 || elementos == null){
			throw new GenericException();
		}
		int position = 0;
		DoubleLinkedListNode<T> aux = (DoubleLinkedListNode<T>) this.head;
		encontrarElemento(position, posicao, (DoubleLinkedListNode<T>) aux.getNext());

		if(position < posicao){
			throw new GenericException();
		}
		aux = ((DoubleLinkedListNode<T>)aux).getPrevious();
		inserirLista(aux, elementos, (DoubleLinkedListNode<T>) aux.getNext());
		this.head = aux;
		this.last = encontrarLast((DoubleLinkedListNode<T>) this.head);

	}

	@Override
	public void removerEmBatch(int posicao, int quantidade) throws GenericException {
		// TODO IMPLEMENTAR seguindo a documentação da interface e remover a linha abaixo
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	private void encontrarElemento(int position, int posicao, DoubleLinkedListNode<T> aux) {
		while (aux.getNext() != null && position != posicao) {
			position += 1;
			aux = (DoubleLinkedListNode<T>) aux.getNext();
		}
	}

	private void inserirLista(DoubleLinkedListNode<T> previous, T[] elementos, DoubleLinkedListNode<T> next) {
		DoubleLinkedListNode<T> prev = previous;
		DoubleLinkedListNode<T> nex = next;
		for (int i = 0; i < elementos.length - 1; i++) {
			((DoubleLinkedListNode<T>) elementos[i]).setPrevious(prev);
			((DoubleLinkedListNode<T>) elementos[i]).setNext((SingleLinkedListNode<T>) elementos[i + 1]);
			prev = (DoubleLinkedListNode<T>) elementos[i];
		}
		((DoubleLinkedListNode<T>) elementos[elementos.length - 1]).setNext(next);
	}

	private DoubleLinkedListNode<T> encontrarLast(DoubleLinkedListNode<T> aux) {
		while (aux.getNext() != null) {
			aux = (DoubleLinkedListNode<T>) aux.getNext();
		}
		return aux;
	}
	
	/* 
	 * NAO MODIFIQUE NEM REMOVA ESTE METODO!!!
	 * 
	 * Use este metodo para fazer seus testes
	 * 
	 * Este metodo monta uma String contendo os elementos do primeiro ao ultimo, 
	 * comecando a navegacao pelo Head
	 */
	public String toStringFromHead() {
		
		String result = "";
		DoubleLinkedListNode<T> aNode = (DoubleLinkedListNode<T>)getHead();
		
		while(!aNode.isNIL()) {
			
			if (!result.isEmpty()) {
				result += " ";
			}
				
			result += aNode.getData();
			aNode = (DoubleLinkedListNode<T>) aNode.getNext();
			
		}
		
		return result;
	}
	
	/* 
	 * NAO MODIFIQUE NEM REMOVA ESTE METODO!!!
	 * 
	 * Use este metodo para fazer seus testes
	 * 
	 * Este metodo monta uma String contendo os elementos do primeiro ao ultimo, 
	 * porem comecando a navegacao pelo Last
	 * 
	 * Este metodo produz o MESMO RESULTADO de toStringFromHead() 
	 * 
	 */
	public String toStringFromLast() {
		
		String result = "";
		DoubleLinkedListNode<T> aNode = getLast();
		
		while(!aNode.isNIL()) {
			
			if (!result.isEmpty()) {
				result = " " + result;
			}
				
			result = aNode.getData() + result;
			aNode = (DoubleLinkedListNode<T>) aNode.getPrevious();
			
		}
		
		return result;
	}
	
	@Override
	public String toString() {
		return toStringFromHead();
	}


}
