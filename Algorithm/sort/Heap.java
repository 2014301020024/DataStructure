package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Heap {
    private int heapSize;
    private final int[] heap;
    private final int limited;

    public Heap(int limited){
        heap = new int[limited];
        this.limited = limited;
    }

    public boolean isEmpty(){
        return heapSize == 0;
    }

    public boolean isFull(){
        return heapSize == limited;
    }

    public void push(int value){
        if (isFull()){
            throw new RuntimeException("heap is full");
        }
        heap[heapSize] = value;
        heapInsert(heap, heapSize++);
    }

    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("heap is empty");
        }
        int ans = heap[0];
        swap(heap, 0, --heapSize);
        heapIfy(heap, 0, heapSize);
        return ans;
    }

    public static void heapInsert(int[] arr, int index){
        while (arr[index] > arr[(index - 1)/2]){
            swap(arr, index, (index-1)/2);
            index = (index - 1)/2;
        }
    }

    public static void heapIfy(int[] arr, int index, int heapSize){
        int left = 2 * index + 1;
        while (left < heapSize){
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[index] >= arr[largest] ? index: largest;
            if (largest == index){
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = 2 * index + 1;
        }
    }

    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }

//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr, i);
//        }

        for (int i = arr.length - 1; i >= 0 ; i--) {
            heapIfy(arr, i, arr.length);
        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0){
            heapIfy(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {7, 2, 3, 6, 5};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }



}
