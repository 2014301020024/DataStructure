package algorithm;

public class TimeChecker {
    public static void main(String[] args) {
        int[] arr = DataChecker.generateRandomArray();
        int epoch = 100;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            int[] arr1 = arr.clone();
            Selection.simpleSort(arr1);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Selection ==> simpleSort      ==> running time ==> " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < epoch; i++) {
            int[] arr2 = arr.clone();
            Selection.optimizeSort(arr2);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Selection ==> optimizeSort    ==> running time ==> " + (endTime - startTime) + "ms");


        startTime = System.currentTimeMillis();
        for (int i = 0; i < epoch; i++) {
            int[] arr3 = arr.clone();
            Bubble.simpleSort(arr3);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Bubble    ==> simpleSort      ==> running time ==> " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < epoch; i++) {
            int[] arr4 = arr.clone();
            Bubble.optimizeSort(arr4);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Bubble    ==> optimizeSort    ==> running time ==> " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < epoch; i++) {
            int[] arr5 = arr.clone();
            Insert.simpleSort(arr5);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Insert    ==> simpleSort      ==> running time ==> " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < epoch; i++) {
            int[] arr6 = arr.clone();
            Insert.optimizeSortOne(arr6);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Insert    ==> optimizeSortOne ==> running time ==> " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < epoch; i++) {
            int[] arr7 = arr.clone();
            Insert.optimizeSortTwo(arr7);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Insert    ==> optimizeSortTwo ==> running time ==> " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < epoch; i++) {
            int[] arr8 = arr.clone();
            Shell.simpleSort(arr8);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Shell     ==> simpleSort      ==> running time ==> " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < epoch; i++) {
            int[] arr9 = arr.clone();
            Shell.optimizeSort(arr9);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Shell     ==> optimizeSort    ==> running time ==> " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < epoch; i++) {
            int[] arr9 = arr.clone();
            Merge.simpleSort(arr9, 0, arr9.length - 1);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Merge     ==> simpleSort      ==> running time ==> " + (endTime - startTime) + "ms");
    }
}
