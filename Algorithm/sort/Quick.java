package Sort;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 9, 5, 8, 7, 16};
        dualPivotQuickSort(arr, 0, arr.length - 1);
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

    // 双轴快排

    public static void dualPivotQuickSort(int[] arr, int left, int right){
        if (left <= right){
            if (arr[left] > arr[right]) {
                swap(arr, left, right);
            }
            int tempMin = arr[left];
            int tempMax = arr[right];
            int L = left;
            int R = right;
            int K = left + 1;
            while (K < R){
                if (arr[K] < tempMin){
                    swap(arr, ++L, K++);
                } else if (arr[K] <= tempMax){
                    K++;
                } else {
                    while (arr[--R] >= tempMax){
                        if (K == R){
                            break;
                        }
                    }
                    if (K >= R){
                        break;
                    }
                    swap(arr, K, R);
                }
            }

            swap(arr, L, left);
            swap(arr, R, right);
            dualPivotQuickSort(arr, left, L - 1);
            dualPivotQuickSort(arr, L + 1, R - 1);
            dualPivotQuickSort(arr, R + 1, right);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
