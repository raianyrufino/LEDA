package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;

import java.util.Arrays;

public class RecursiveBubbleSort {
	public static void main(String[] args){
			int[] seq = {3, 2, 0, 7, 5};
			sort(seq, 0, 4);
			System.out.println(Arrays.toString(seq));
	}

	/**
	 * Implementação recursiva do bubble sort. Você deve implementar apenas esse
	 * método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	//@Override
	private static void sort(int[] array, int leftIndex, int rightIndex) {
			if(leftIndex < rightIndex) {
				for (int i = leftIndex; i <= rightIndex; i++) {
					for (int j = i + 1; j <= rightIndex; j++) {
						if (array[i] > array[j]) {
							swap(array, i, j);
						}
					}
				}
			}
		}


	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
