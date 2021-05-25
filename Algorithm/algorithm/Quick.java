package algorithm;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] arr = {10, 3, 9, 5, 8, 7, 6};
        simpleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void simpleSort(int[] arr) {
        int i = 0;
        int j = arr.length - 2;
        int bench = arr[arr.length - 1];
        while (i < j) {
            if (arr[i] > bench && arr[j] < bench) {
                swap(arr, i++, j--);
            } else if (arr[i] < bench) {
                i++;
            } else {
                j--;
            }
        }
        i = arr[i] > bench ? i : i + 1;
        if (arr.length - 1 - i >= 0) System.arraycopy(arr, i, arr, i + 1, arr.length - 1 - i);
        arr[i] = bench;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
