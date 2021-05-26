package Sort;

import java.util.Arrays;
import java.util.Random;

public class DataChecker {
    public static void main(String[] args) {
        check();
    }

    // 产生随机数组的功能函数
    public static int[] generateRandomArray() {
        //实例化 Random 类为 r
        Random r = new Random();

        // 产生一个长度为 1000 的数组
        int[] arr = new int[10000];

        for (int i = 0; i < arr.length; i++) {
            // 依次给相应的位置赋予一个 [0, 10000) 之间的随机数
            arr[i] = r.nextInt(10000);
        }
        return arr;
    }

    static void check() {
        float num = 0.0f;
        // 产生 1000 次随机数组
        for (int i = 0; i < 1000; i++) {
            int[] arr = generateRandomArray();

            // 这里要强调的是你需要将 arr 数组复制一份
            // 因为 下面对数组进行排序的时候，如果用同一个数组(地址一样)，后一个算法排序的永远是前一个排序好的数组
            int[] arr2 = arr.clone();

            // 内置函数
            Arrays.sort(arr);

            // 你的算法，下面这条可以改变
            Quick.dualPivotQuickSort(arr2, 0, arr2.length - 1);

            // 判断两个数组是否相同
            boolean same = true;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] != arr2[j]) {
                    same = false;
                    break;
                }
            }
            if (same) {
                num += 1;
            }
        }
        System.out.println("正确率为： " + num / 10 + "%");
    }
}
