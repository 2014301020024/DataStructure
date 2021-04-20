package Algorithm;

import java.util.Random;

public class Exercise {
    public static void main(String[] args) {
        System.out.println((0 + 15)/2);
        System.out.println(2.0e-6 * 1000000000.1);
        System.out.println(true && false || true && true);
        System.out.println();

        System.out.println((1 + 2.236)/2);
        System.out.println(1 + 2 + 3 + 4.0);
        System.out.println(4.1 >= 4);
        System.out.println(1 + 2 + '3');
        System.out.println('2' + '3');
        System.out.println((char) ('2' + '3'));
        System.out.println(1 + 2 + "34");
        System.out.println();

        equal(1, 1, 1);
        equal(1, 2, 3);
        System.out.println();

        jst(0, 1);
        jst(0.5, 0.5);
        System.out.println();
        Random r = new Random();
        int[][] a = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                // 依次给相应的位置赋予一个 [0, 10000) 之间的随机数
                a[i][j] = r.nextInt(2);
                System.out.println(a[i][j]);
            }
        }
        print2D(a);
        System.out.println();

        int N = 10;
        System.out.println(ln(N));
    }

    public static void equal(int a, int b, int c){
        if (a == b && b == c){
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    public static void jst(double x, double y){
        System.out.println(x > 0 && x < 1 && y > 0 && y < 1);
    }

    public static void print2D(int[][] a){
        System.out.println("    0    1    2    3    4");
        for (int i = 0; i < 5; i++) {
            System.out.print(i + "   ");
            for (int j = 0; j < 5; j++) {
                if (a[i][j] == 0){
                    System.out.print("     ");
                } else {
                    System.out.printf("%s    ", '*');
                }
            }
            System.out.println();
        }
    }

    public static int ln(int N){
        if (N == 1) {
            return 1;
        } else {
            return ln(N - 1) * N;
        }

    }
}
