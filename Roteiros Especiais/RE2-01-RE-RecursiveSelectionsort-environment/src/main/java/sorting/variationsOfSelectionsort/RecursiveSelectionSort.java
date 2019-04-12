package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;

import java.util.Arrays;

public class RecursiveSelectionSort {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	//@Override
	public static void sort(int[] array, int leftIndex, int rightIndex) {

		if(leftIndex == rightIndex){
			return;
		}

		int smaller = leftIndex;
		for(int i=leftIndex; i<=rightIndex; i++)
			if (array[i] < array[smaller]) {
				smaller = i;
			}
		Swap(array, smaller, leftIndex);
		sort(array, leftIndex+1, rightIndex);
	}

	private static void Swap(int[] array, int k, int smaller) {
		int temp = array[k];
		array[k] = array[smaller];
		array[smaller] = temp;
	}

	public static void main(String[] args) {
		int[] arr = {12, 11, 13, 5, 6};

		sort(arr, 0, 5);

		System.out.println(Arrays.toString(arr));
	}
}
