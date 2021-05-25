package Sort;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Bucket {
    public static void main(String[] args) {
        int[] arr = {0, 12, 18, 93, 45, 76, 89, 3, 55, 98, 67, 100};
        int[] result = sort(arr);
        System.out.println(Arrays.toString(result));
    }

    public static int[] sort(int[] arr){
        int[] result = new int[arr.length];
        int maxNum = getMax(arr);
        int minNum = getMin(arr);
        int difference = maxNum - minNum;
        int start = 0;
        for (int i = 0; i < 4; i++) {
            List<Integer> list = new ArrayList<>(arr.length);
            for (int k : arr) {
                if ((difference * i / 4 + minNum) <= k && k <= minNum + +difference * (i + 1) / 4)
                    list.add(k);
            }
            list.sort(Comparator.naturalOrder());

            int[] arr1 = new int[list.size()];
            for (int j = 0; j < list.size(); j++) {
                arr1[j] = (int) list.get(j);
            }

            System.arraycopy(arr1, 0, result, start, arr1.length);
            start += arr1.length;
        }
        return result;
    }


    public static int getMax(int[] arr){
        float max = Float.NEGATIVE_INFINITY;
        for (int i: arr) {
            if (i > max){
                max = i;
            }
        }
        return (int) max;
    }

    public static int getMin(int[] arr){
        float min = Float.POSITIVE_INFINITY;
        for (int i: arr) {
            if (i < min){
                min = i;
            }
        }
        return (int) min;
    }

}
