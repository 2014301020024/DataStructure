package Sort;

import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] arr = {20, 2, 3, 9, 5, 8, 7, 16};
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

    public static void dualPivotQuickSort(int[] arr, int start, int end){
        if(start>end) return;//参数不对直接返回
        if(arr[start]>arr[end])
            swap(arr, start, end);
        int pivot1 = arr[start], pivot2 = arr[end];//储存最左侧和最右侧的值
        //(start，left]:左侧小于等于pivot1 [right,end)大于pivot2
        int left = start, right = end,k = left + 1;
        while (k < right) {
            //和左侧交换
            if (arr[k] <= pivot1)
            {
                swap(arr, ++left, k++);
            }
            //在中间的情况
            else if (arr[k] <= pivot2) {
                k++;
            }
            else {
                //如果全部小于直接跳出外层循环
                while (arr[right] >= pivot2) {
                    if(right-- == k)
                        break ;
                }
                if (k >= right) break;
                swap(arr, k, right);
            }
        }
        swap(arr, start, left);
        swap(arr, end, right);
        dualPivotQuickSort(arr, start, left - 1);
        dualPivotQuickSort(arr, left + 1, right - 1);
        dualPivotQuickSort(arr, right + 1, end);
    }


    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
