package algorithm;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] arr = {20, 2, 3, 9, 5, 8, 7, 16};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right){
        if (left < right){
            int cur = partition(arr, left, right);
            quickSort(arr, left, cur - 1);
            quickSort(arr, cur + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int temp = arr[right];
        int R = right;
        while (left < right) {
            while (arr[left] <= temp && left < right) {
                left++;
            }

            while (arr[right] >= temp && left < right) {
                right--;
            }
            if (left < right){
                swap(arr, left, right);
            }
        }
        swap(arr, R, right);
        return right;
    }


    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
