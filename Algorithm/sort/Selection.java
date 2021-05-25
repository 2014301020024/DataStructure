package algorithm;

public class Selection {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 5, 8, 1};

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            int[] arr1 = arr.clone();
            simpleSort(arr1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间为：" + (endTime - startTime) + "ms");

//        startTime = System.currentTimeMillis();
//        for (int i = 0; i < 10000; i++) {
//            int[] arr2 = arr.clone();
//            optimizeSort(arr2);
//        }
//        endTime = System.currentTimeMillis();
//        System.out.println("程序运行时间为：" + (endTime - startTime) + "ms");
    }

    static void simpleSort(int[] arr) {
        int minPos;
//        int [] turn = new int [arr.length];
//        for (int i = 0; i < turn.length; i++) {
//            turn[i] = i;
//        }


        for (int i = 0; i < arr.length - 1; i++) {
            minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                minPos = arr[minPos] <= arr[j] ? minPos : j;
            }
            swap(arr, i, minPos);

//            swap(turn, i, minPos);
        }
    }

    static void optimizeSort(int[] arr) {
        int length = arr.length;
        int minPos;
        int maxPos;

        for (int i = 0; i < length / 2; i++) {
            minPos = maxPos = i;

            for (int j = i; j < length - i; j++) {
                minPos = arr[minPos] < arr[j] ? minPos : j;
                maxPos = arr[maxPos] < arr[j] ? j : maxPos;
            }

            if (i == maxPos & length - i - 1 == minPos) {
                swap(arr, minPos, maxPos);
            } else if (i == maxPos) {
                swap(arr, maxPos, length - i - 1);
                swap(arr, maxPos, minPos);
            } else if (minPos == length - i - 1) {
                swap(arr, minPos, i);
                swap(arr, maxPos, minPos);
            } else {
                swap(arr, i, minPos);
                swap(arr, length - i - 1, maxPos);
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        // or 使用异或的办法 前提是：两个值指的内存是相同的      =>   但是没啥用，知道就行了
        /*
        假设 arr[i] = 甲， arr[j] = 乙,
        arr[i] = arr[i] ^ arr[j] = 甲 ^ 乙;
        arr[j] = arr[i] ^ arr[j] = (甲 ^ 乙) ^ 乙 = 甲 ^ (乙 ^ 乙) = 甲 ^ 0 = 甲
        arr[i] = arr[i] ^ arr[j] = (甲 ^ 乙) ^ 甲 = (甲 ^ 甲) ^ 乙 = 0  ^ 乙 = 乙
        成功实现了不分配新变量就将数值进行了交换
         */
//        arr[i] = arr[i] ^ arr[j];
//        arr[j] = arr[i] ^ arr[j];
//        arr[i] = arr[i] ^ arr[j];
    }

}
