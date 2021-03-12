package Algorithm;


public class Bubble {
    public static void main(String[] args) {

    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void simpleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]){
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    static void optimizeSort(int[] arr){
        boolean isChange = true;
        for (int i = 0; i < arr.length - 1 && isChange; i++) {
            isChange = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isChange = true;
                    }
                }
            }
    }


}
