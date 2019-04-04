package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if (array.length > leftIndex && array != null) {

			Integer[] B = new Integer[rightIndex - leftIndex + 1];

			// Search for the largest and smallest element
			int min = array[leftIndex];
			int max = array[leftIndex];
			for (int i = leftIndex; i <= rightIndex; i++) {
				if (array[i] < min)
					min = array[i];
				if (array[i] > max)
					max = array[i];
			}

			// Cumulative array for the number of elements of each element.
			int[] C = new int[max - min + 1];
			for (int i = leftIndex; i <= rightIndex; i++)
				C[array[i] - min]++;

			// Sum of elements in the cumulative array.
			for (int i = 1; i <= (max - min); i++)
				C[i] += C[i - 1];

			// Sort the elements in the auxiliary array(B).
			for (int i = rightIndex; i >= leftIndex; i--) {
				C[array[i] - min]--;
				B[C[array[i] - min]] = array[i];
			}

			// Assigns the ordered array elements to the original array.
			for (int i = leftIndex; i <= rightIndex; i++)
				array[i] = B[i - leftIndex];

		}
	}

}
