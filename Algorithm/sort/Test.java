package Sort;

import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Stack;

public class Test {

    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int a = 6;
        int b = 7;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        // 1010

        System.out.println(Integer.toBinaryString(6 ^ 7));



        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        int[] arr = {1, 3, 2, 3, 1, 2, 2, 3, 1, 2, 3};
        int eor = 0;
        for (int j : arr) {
            eor = eor ^ j;
        }

        int c = 200;
        System.out.println(Integer.toBinaryString(c ));
        System.out.println(Integer.toBinaryString(c ^ (~c + 1)));


        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);


    }

    public class Heap {
        private final int[] heap;
        private final int limit;
        int heapSize;

        public Heap (int limit){
            heap = new int[limit];
            this.limit = limit;
        }

        public boolean isEmpty(){
            return heapSize == 0;
        }

        public boolean isFull(){
            return heapSize == limit;
        }

        public void pull(int value){
            if (isFull()){
                throw new RuntimeException("Heap is full!");
            }

            heap[heapSize] = value;
            heapInsert(heap, heapSize++);
        }

        public int pop(){
            int ans = heap[0];
            swap(heap, 0, --heapSize);
            heapIfy(heap, 0, heapSize);
            return ans;
        }

        public void heapInsert(int[] arr, int index){
            while (arr[index] > arr[(index - 1)/2]){
                swap(arr, index, (index - 1)/2);
                index = (index - 1)/2;
            }
        }

        public void heapIfy(int[] arr, int index, int heapSize){
            int left = index * 2 + 1;
            while (left < heapSize){
                int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1: left;
                largest = arr[index] >= arr[largest] ? index: largest;
                if (largest == index) break;
                swap(arr, index, largest);
                index = largest;
                left = 2 * index + 1;
            }
        }

        public void heapSort(int[] arr){
            if (arr == null || arr.length < 2){
                return;
            }

//            for (int i = 0; i < arr.length; i++) {
//                heapInsert(arr, i);
//            }

            for (int i = arr.length - 1; i >= 0; i--) {
                heapIfy(arr, i, arr.length);
            }

            int heapSize = arr.length;
            swap(arr, 0, --heapSize);

            while (heapSize > 0){
                heapIfy(arr, 0, heapSize);
                swap(arr, 0, --heapSize);
            }

        }

        public void swap(int[] arr, int i, int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }


    }
}
