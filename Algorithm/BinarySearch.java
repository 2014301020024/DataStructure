package Algorithm;


import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = DataChecker.generateRandomArray();
        Arrays.sort(arr);
        int key = 2567;
        int res = rank(key, arr);
        if (res < 0){
            System.out.println(key);
        } else {
            System.out.println(res);
            System.out.println(arr[res]);
        }
    }

    public static int rank(int key, int[] a){
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo)/2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
