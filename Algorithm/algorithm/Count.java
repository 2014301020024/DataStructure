package algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class Count {
    public static void main(String[] args) {
        int[] arr = {104, 106, 102, 103, 102, 101, 104, 105, 101, 102, 104, 109};
        System.out.println(Arrays.toString(sort(arr)));
    }

    public static int[] sort(int[] arr){
        int minVal = getMin(arr);
        int maxVal = getMax(arr);
        int[] count = new int[maxVal - minVal + 1];

        for (int j : arr) {
            count[j - minVal]++;
        }
        System.out.println(Arrays.toString(count));
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i-1];
        }

        System.out.println(Arrays.toString(count));

        int[] ans = new int[arr.length];

        for (int i = arr.length - 1; i >= 0 ; i--) {
            ans[--count[arr[i] - minVal]] = arr[i];
        }
        return ans;
    }

    public static int getMax(int[] arr){
        int ans = Integer.MIN_VALUE;
        for (int i: arr){
            if (i > ans){
                ans = i;
            }
        }
        return ans;
    }

    public static int getMin(int[] arr){
        int ans = Integer.MAX_VALUE;
        for (int i: arr){
            if (i < ans){
                ans = i;
            }
        }
        return ans;
    }



}
