package algorithm;


import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] arr = {1, 4, 9, 8, 5, 2, 10, 9};
//        int[] arr1 = {4, 5, 7, 8, 1, 2, 3, 6};
//        example(arr1);
        simpleSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    static void simpleSort(int[] arr, int leftBound, int rightBound) {
        if (leftBound == rightBound) return;
        int mid = leftBound + (rightBound - leftBound) / 2;
        simpleSort(arr, leftBound, mid);
        simpleSort(arr, mid + 1, rightBound);
        merge(arr, leftBound, mid, rightBound);
    }


    static void merge(int[] arr, int leftBound, int midPtr, int rightBound) {
        int[] temp = new int[rightBound - leftBound + 1];

        int i = leftBound;
        int j = midPtr + 1;
        int k = 0;

        while (i <= midPtr && j <= rightBound) {
            temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= midPtr) temp[k++] = arr[i++];
        while (j <= rightBound) temp[k++] = arr[j++];

        if (temp.length >= 0) System.arraycopy(temp, 0, arr, leftBound, temp.length);
    }


    static void example(int[] arr) {
        /*   首先创建一个int类型的临时数组 temp */
        int[] temp = new int[arr.length];

        /* 定位中间值，这里避免了数组元素个数为偶数个的bug */
        int mid = arr.length % 2 == 0 ? arr.length / 2 - 1 : arr.length >> 1;

        /* 这里定义了三个指针， i为左边序列的指针，j为右边序列的指针，k为temp数组的指针 */
        int i = 0;
        int j = mid + 1;
        int k = 0;

        /* 当两个子数组中的任何一个数组都存有元素的时候 继续执行while内的内容 */
        while (i <= mid && j < arr.length) {

            /* 这里对左边数组的数字和右边数组的数字进行了比较
             * 如果左边数组的数字小的时候，则将arr[i]的值赋给temp[k], 然后i加1，k加1
             * 无论是左边数组的数字小还是右边数组的数字小的时候，temp数组的指针都要加1
             * */
            temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }

        /* 这里是通过上述的比较后判断左边数组还是右边数组遗留下了元素，则直接挪进去temp数组即可 */
        while (i <= mid) temp[k++] = arr[i++];
        while (j < arr.length) temp[k++] = arr[j++];

        System.out.println(Arrays.toString(temp));
    }
}
