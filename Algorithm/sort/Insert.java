package Sort;

import java.util.Arrays;

public class Insert {
    public static void main(String[] args) {
        int[] arr = {2, 5, 4, 1, 6, 9, 7, 10, 11};
//        int[] arr = {2, 5, 4};
        System.out.println(Arrays.toString(arr));
        optimizeSortTwo(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void simpleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }

    static void optimizeSortOne(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    static void optimizeSortTwo(int[] arr) {
        int temp;
        for (int i = 1; i < arr.length; i++) {
            temp = arr[i];
            for (int j = i; j > 0; j--) {
                if (temp < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                } else {
                    arr[j] = temp;
                    break;
                }
            }
            if (temp < arr[0]) {
                arr[0] = temp;
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
