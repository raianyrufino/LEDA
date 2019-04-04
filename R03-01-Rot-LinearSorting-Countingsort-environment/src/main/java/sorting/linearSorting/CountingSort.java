package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {

		if (array.length > leftIndex && array != null) {

			Integer[] B = new Integer[rightIndex - leftIndex + 1];

			// Search for the largest element to create a list of its size.
			int max = array[leftIndex];
			for (int i = leftIndex; i <= rightIndex; i++) {
				if (array[i] > max)
					max = array[i];
			}

			// Cumulative array for the number of elements of each element.
			int[] C = new int[max + 1];
			for(int i=leftIndex; i<=rightIndex; i++){
				C[array[i]]++;
			}

			// Sum of elements in the cumulative array.
			for(int i=1; i<=max; i++){
				C[i] += C[i-1];
			}

			//Sort the elements in the auxiliary array(B).
			for(int i=rightIndex; i>=leftIndex; i--){
				C[array[i]]--;
				B[C[array[i]]] = array[i];
			}

			//Assigns the ordered array elements to the original array.
			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = B[i - leftIndex];
			}
		}
	}

}
