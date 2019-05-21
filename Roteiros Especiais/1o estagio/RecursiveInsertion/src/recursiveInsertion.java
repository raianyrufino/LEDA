import java.util.Arrays;

public class insertion {

    public static void RecursiveInsertionSort(int arr[], int fim) {

        if(fim == 0)
            return;
        RecursiveInsertionSort(arr, fim-1);

        int j = fim;
        while(j > 0 && arr[j] < arr[j-1]){
            int temp = arr[j];
            arr[j] = arr[j-1];
            arr[j-1] = temp;
        j--;
        }

    }

    // Driver Method
    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6};

        RecursiveInsertionSort(arr, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }
}