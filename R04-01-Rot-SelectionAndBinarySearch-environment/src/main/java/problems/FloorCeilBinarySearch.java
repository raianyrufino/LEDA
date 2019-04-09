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
		return particionaFloor(array, 0, array.length - 1, x);

	}

	@Override
	public Integer ceil(Integer[] array, Integer x) {
		return particionaCeil(array, 0, array.length - 1, x);
	}

	private Integer particionaFloor(Integer[] array, int left, int right, Integer floor){
		int middle = (left + right)/2;

		if(left == middle){
			if(array[left] > floor){
				return null;
			}if(array[left] == floor){
				return array[left];
			}
			return array[right];
		}
		if(array[middle] >= floor){
			return particionaFloor(array,left, middle, floor );
		}
		if(array[middle] < floor ){
			return particionaFloor(array, middle + 1, right, floor);
		}
		return null;
	}

	private Integer particionaCeil(Integer[] array, int left, int right, Integer smaller) {
		int middle = (left + right)/2;

		if (left == middle){
			if(smaller > array[right]){
				return null;
			}
			if(array[right] == smaller){
				return array[right];
			}
			return array[left];
		}
		if(smaller >= array[middle + 1]){
			return particionaCeil(array,middle + 1, right, smaller );
		}
		if(smaller < array[middle +1]){
			return particionaCeil(array, left, middle, smaller);
		}
		return null;
	}
}


