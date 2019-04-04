package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

public class RecursiveBubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * Implementação recursiva do bubble sort. Você deve implementar apenas esse
	 * método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	private static void sort(T[] array, int leftIndex, int rightIndex) {

		boolean valid = inputValidation(array, leftIndex, rightIndex);

		if(valid){
			for(int i=leftIndex; i <= rightIndex; i++){
				for(int j=i+1; j <= rightIndex; j++){
					if(array[i].compareTo(array[j]) > 0){
						swap(array, i, j);
					}
				}
			}
			if(rightIndex-1  > 1){
				sort(array, leftIndex, rightIndex-1);
			}
		}
	}

	private static void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	private boolean inputValidation(T[] array, int leftIndex, int rightIndex) {

		if (array == null)
			return false;
		if (array.length == 0)
			return false;
		if (leftIndex < 0 || rightIndex < 0)
			return false;
		if (leftIndex >= rightIndex)
			return false;
		if (rightIndex >= array.length)
			return false;

		return true;
	}
}
