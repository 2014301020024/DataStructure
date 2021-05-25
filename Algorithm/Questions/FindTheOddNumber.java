package Questions;

import java.util.ArrayList;
import java.util.Arrays;

public class FindTheOddNumber {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 1, 3, 3, 3};
        System.out.println(Arrays.toString(findTwoOddNumber(arr)));

        int[] arr1 = {1, 2, 2, 2, 1, 1, 1, 3, 3};
        System.out.println(findOddNumber(arr1));
    }

    //这里均采用 异或 的思想
    //异或满足交换律
    //且 甲 ^ 甲 = 0

    /*
    假如一个数组中存在一些数字，
    这些数字在这个数组中只有唯一一个是奇数次，其他的均存在偶数次,
    找到并返回这个数字

    解体思路很简答，只需要异或上数组中的所有数字
    存在偶数次数的数字异或后为0，最后只剩下单独的奇数次的那个数
    */
    public static int findOddNumber(int[] arr){
        int eor = 0;
        for(int i: arr){
            eor = eor ^ i;
        }
        return eor;
    }


    /*
    假如一个数组中存在两个奇数次的数字，请找到这个数字
    这道题就显然比上面的难

    解体思路：
    假设 这两个奇数为 甲 和 乙
    首先和上面一样，将数组中的所有数字异或起来，得到结果 re = 甲 ^ 乙
    然后找到 re 中从右朝左第一个不为0的位置 index = ( re & (~re + 1)) --- 00010000 ，这就是甲 和 乙 的第一个差别
    因此继而将数组中的数字和index进行 & 操作可以判断 该数组中的数字是否在该index为0或者1进而分为两部分
    随便选择其中的一个部分，将这个部分全部异或起来
    即得到了 甲 或者 乙
    最后将上面得到的数字 与 re 异或即得到了另外一个数字
    */
    public static int[] findTwoOddNumber(int[] arr){
        int re = 0;
        for (int i: arr){
            re = re ^ i;
        }

        int index = re & (~re + 1);
        int eor = 0;
        for(int i: arr){
            if ((i & index) != 0){
                eor = eor ^ i;
            }
        }

        int ano = re ^ eor;
        int[] arr1 = new int[2];
        arr1[0] = eor;
        arr1[1] = ano;
        return arr1;
    }

}
