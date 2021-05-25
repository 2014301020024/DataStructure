package Sort;

import java.util.Arrays;

public class Basic {
    public static void main(String[] args) {
        int[] arr = {420, 240, 3623, 115, 532, 305, 430, 124, 1234, 987};
        int[] result = sort(arr);

        System.out.println(Arrays.toString(result));
    }

    public static int[] sort(int[] arr) {
        int[] result = new int[arr.length];
        int[] count = new int[10];
        int times = getDigits(arr);
        for (int i = 0; i < times; i++) {
            int division = (int) Math.pow(10, i);
            for (int k : arr) {
                int num = k / division % 10;
                count[num]++;
            }

            for (int j = 1; j < count.length; j++) {
                count[j] += count[j - 1];
            }

            for (int j = arr.length - 1; j >= 0; j--) {
                int num = arr[j] / division % 10;
                result[--count[num]] = arr[j];
            }

            System.arraycopy(result, 0, arr, 0, arr.length);
            Arrays.fill(count, 0);
        }
        return result;
    }


    public static int getDigits(int[] arr) {
        int maxDigits = 0;
        for (int j : arr) {
            if (maxDigits < j) {
                maxDigits = j;
            }
        }
        return String.valueOf(maxDigits).length();
    }
}
