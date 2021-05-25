package algorithm;

import java.util.Arrays;

public class Shell {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 7, 8, 521, 91, 21, 20, 34, 0, 6, 21, 33};
        System.out.println(Arrays.toString(arr));
        simpleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void simpleSort(int[] arr) {
        for (int gap = arr.length >> 1; gap > 0; gap = gap >> 1) {
            for (int j = gap; j < arr.length; j++) {
                for (int k = j; k >= gap; k = k - gap) {
                    if (arr[k] < arr[k - gap]) {
                        swap(arr, k, k - gap);
                    } else {
                        break;
                    }
                }
            }
        }
    }


    static void optimizeSort(int[] arr) {
        int h = 1;
        while (h <= arr.length / 3) {
            h = h * 3 + 1;
        }
        for (int gap = h; gap > 0; gap = (gap - 1) / 3) {
            for (int j = gap; j < arr.length; j++) {
                for (int k = j; k >= gap; k = k - gap) {
                    if (arr[k] < arr[k - gap]) {
                        swap(arr, k, k - gap);
                    } else {
                        break;
                    }
                }
            }
        }
    }


//    static void worseSort(int[] arr) {
//        int temp;
//        int h = 1;
//        while(h <= arr.length/3){
//            h = h* 3 + 1;
//        }
//        for (int gap = h; gap >0; gap = (gap - 1)/3) {
//            for (int j = gap; j < arr.length; j++) {
//                temp = arr[j];
//                for (int k = j; k >= gap; k = k - gap) {
//                    if (temp < arr[k - gap]) {
//                        arr[k] = arr[k - gap];
//                    } else {
//                        arr[k] = temp;
//                        break;
//                    }
//                }
//                if (temp < arr[j%gap]){
//                    arr[j%gap] = temp;
//                }
//            }
//        }
//    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
