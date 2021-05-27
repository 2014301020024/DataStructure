package Sort;


import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] arr = {1, 4, 9, 8, 5, 2, 10};
        mergeSort2(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void mergeSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    public static void process(int[] arr, int L, int R){
        if (L == R){
            return;
        }

        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }


    static void merge(int[] arr, int L, int M, int R) {
        /*   首先创建一个int类型的临时数组 help */
        int[] help = new int[R - L + 1];

        /* 这里定义了三个指针， p1为左边序列的指针，p2为右边序列的指针，i为 help 数组的指针 */
        int i = 0;
        int p1 = L;
        int p2 = M + 1;

        /* 当两个子数组中的任何一个数组都存有元素的时候 继续执行while内的内容 */
        while (p1 <= M && p2 <= R){
            /* 这里对左边序列的数字和右边序列的数字进行了比较
             * 如果左边序列的数字小的时候，则将 arr[i] 的值赋给 help[k], 然后 i 加 1，k 加 1
             * 无论是左边序列的数字小还是右边序列的数字小的时候，help 数组的指针都要加1
             * */
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        /* 这里是通过上述的比较后判断左边序列还是右边序列遗留下了元素，则直接挪进去temp数组即可 */
        while (p1 <= M){
            help[i++] = arr[p1++];
        }
        while (p2 <= R){
            help[i++] = arr[p2++];
        }
        /* 将排序好的某段数组更新到 arr 中*/
        System.arraycopy(help, 0, arr, L, help.length);
    }


    // 非递归实现
    public static void mergeSort2(int[] arr){
        if (arr == null || arr.length < 2) return;
        int mergeSize = 1; // 当前有序的，左组长度

        int N = arr.length;
        while (mergeSize < N){
            int L = 0;
            while (L < N){
                int M = L + mergeSize - 1;
                if ( M >= N) break;
                int R = Math.min(M + mergeSize, N - 1);
                merge(arr, L, M, R);
                L = R + 1;
            }
            // 预防越界发生不可预知的错误
            if (mergeSize > N/2) break;
            mergeSize <<= 1;
        }
    }
}
