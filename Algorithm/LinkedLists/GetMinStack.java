package LinkedLists;

import java.lang.invoke.VarHandle;
import java.util.Objects;
import java.util.Stack;

public class GetMinStack {
    public static void main(String[] args) {

    }

    public static class MyStack2 {
        public Stack<Integer> stackData;
        public Stack<Integer> stackMin;

        public MyStack2(){
            stackData = new Stack<>();
            stackMin = new Stack<>();
        }

        public void push(int value){
            if (stackMin.isEmpty()){
                stackMin.push(value);
            } else if (value < getMin()){
                stackMin.push(value);
            }


            // 代表了另一种获得stackMin的方法
            // 当新进来的值不大于当前stackMin.peek()的值，才压入
//            else {
//                stackMin.push(stackData.peek());
//            }

            stackData.push(value);
        }

        public int pop(){
            if (stackMin.isEmpty()){
                throw new RuntimeException("栈空了");
            }
            // 当弹出的值与当前stackMin.peek()的值相等的时候，stackMin才跟着弹出一个值
            // 这种方法减少了空间的占用，但是增加了时间消耗；
            // 如果去掉push上面的语句的注释，下面这三条语句需要注释
            if (Objects.equals(stackData.peek(), stackMin.peek())){
                stackMin.pop();
            }

            // 如果去掉push上面的语句的注释，下面这条语句需要取消注释
//            stackMin.pop();
            return stackData.pop();
        }


        public int getMin(){
            if (stackMin.isEmpty()){
                throw new RuntimeException("栈空了");
            }
            return stackMin.peek();
        }
    }
}
