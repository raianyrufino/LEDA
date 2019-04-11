package problems;

/**
 * Calcula o floor e ceil de um numero em um array usando a estrategia de busca
 * binaria.
 * 
 * Restricoes: 
 * - Algoritmo in-place (nao pode usar memoria extra a nao ser variaveis locais) 
 * - O tempo de seu algoritmo deve ser O(log n).
 * 
 * @author Adalberto
 *
 */

public class FloorCeilBinarySearch implements FloorCeil {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		int left = 0;
		int right = array.length-1;
		return buscaBinariaFloor(array, left, right, x);

	}

	@Override
	public Integer ceil(Integer[] array, Integer x) {
		int left = 0;
		int right = array.length-1;
		return buscaBinariaCeil(array, left, right, x);
	}


	public Integer buscaBinariaFloor(Integer[] array, int left, int right, int key) {
		if (left > right) {
			return array[right];
		}
		if (key < array[left]) {
			return null;
		}

		int mid = (left + right)/2;
		if (array[mid] > key) {
			return buscaBinariaFloor(array, left, mid-1, key);
		} else if(array[mid] < key) {
			return buscaBinariaFloor(array, mid+1, right, key);
		} else {
			return array[mid];
		}

	}


	public Integer buscaBinariaCeil(Integer[] array, int left, int right, int key) {
		if (left > right) {
			return array[left];
		}

		if (key > array[right]) {
			return null;
		}

		int mid = (left + right)/2;

		if (array[mid
				] > key) {
			return buscaBinariaCeil(array, left, mid-1, key);
		} else if(array[mid] < key) {
			return buscaBinariaCeil(array, mid+1, right, key);
		} else {
			return array[mid];
		}

	}
}


