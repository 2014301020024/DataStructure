package algorithm;

public class Test {

    public static void main(String[] args) {

        int a = 6;
        int b = 7;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        // 1010

        System.out.println(Integer.toBinaryString(6 ^ 7));



        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        int[] arr = {1, 3, 2, 3, 1, 2, 2, 3, 1, 2, 3};
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor = eor ^ arr[i];
        }

        int c = 200;
        System.out.println(Integer.toBinaryString(c ));
        System.out.println(Integer.toBinaryString(c ^ (~c + 1)));

    }
}
