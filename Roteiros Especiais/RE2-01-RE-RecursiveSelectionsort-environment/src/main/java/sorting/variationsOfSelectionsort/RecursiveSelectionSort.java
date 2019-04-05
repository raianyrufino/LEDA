package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex){
			int smaller = leftIndex;
			for(int i=smaller; i<array.length;i++){
				if(array[i].compareTo(array[smaller]) < 0){
					smaller = i;
				}
			}
			Swap(array, leftIndex, smaller);
			sort(array, leftIndex+1);
		}
	}

	private static void Swap(T[] array, int k, int smaller) {
		T temp = array[k];
		array[k] = array[smaller];
		array[smaller] = temp;
	}

}
