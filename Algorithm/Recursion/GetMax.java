package Recursion;

public class GetMax {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(getMax(arr));
    }

    public static int getMax(int[] arr){
        return process(arr, 0, arr.length -1);
    }

    // 对于符合master公式
    // Total = a * T(N/b) + O(N ** d)
    // a为分成了几分，b为每份为原来的1/b, O(N ** d) 为常数项⌚️， 下面的函数d=0
    // 时间复杂度为：
    // 如果 log_b (a) > d ===> O(N ** (log_b (a)));
    // 如果 log_b (a) < d ===> N ** d;
    // 如果 log_b (a) = d ===> N ** d * log_b (a);
    public static int process(int[] arr, int L, int R){
        if (L == R){
            return arr[L];
        }

        int mid = L + ((R - L) >> 1);
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid + 1, R);
        return Math.max(leftMax, rightMax);
    }
}
