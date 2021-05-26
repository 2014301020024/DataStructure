package Questions;

import java.util.Arrays;
import java.util.Deque;

public class Test {
    public static void main(String[] args) {
    }


    public static void quickSort(int[] arr, int L, int R){
        if (L < R){
            int cur = partition(arr, L, R);
            quickSort(arr, L, cur-1);
            quickSort(arr, cur + 1, R);
        }
    }
    public static int partition(int[] arr, int L, int R){
        int pivot = arr[R];
        int pivotIndex = R;
        while (L < R){
            while (arr[L] <= pivot && L < R){
                L++;
            }
            while (arr[R] >= pivot && L < R){
                R--;
            }
            if (L < R){
                swap(arr, L, R);
            }
        }
        swap(arr, R, pivotIndex);
        return R;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
