package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class
MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex){
			int media = (leftIndex+rightIndex)/2;
			sort(array, leftIndex, media);
			sort(array, media+1, rightIndex);
			merge(array, leftIndex, media, rightIndex);
		}
	}

	@Override
	public void merge(T[] array, int ini, int media, int fim){
		T[] aux = (T[]) new Comparable[array.length];
		for (int i = 0; i < array.length; i++){
			aux[i] = array [i];
		}

		int i = ini;
		int j = media+1;
		int k = fim;

		while (i <= media && j <= fim){

			if(aux[i].compareTo(aux[j])<0){
				array[k] = aux[i];
				i++;
			} else {
				array[k] = aux[j];
				j++;
			} k++;
		}

		while(i <= media){
			array[k] = aux[i];
			i++;
			k++;
		}

		while(j <= fim){
			array[k] = array[j];
			j++;
			k++;
		}

	}
}
