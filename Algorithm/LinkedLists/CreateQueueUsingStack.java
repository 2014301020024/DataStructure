package LinkedLists;

import java.util.Queue;
import java.util.Stack;

public class CreateQueueUsingStack {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        TwoStacksQueue queue = new TwoStacksQueue();

        for (int i: arr){
            queue.add(i);
        }

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }

    // 这个方法很巧妙，同时设置了两个栈
    // 核心是 pushToPop 函数
    // 只有当 stackPop 栈为空的时候才将 stackPush里的数据倒着放入
    // 并且一次将 stackPush 里的数据倒空
    public static class TwoStacksQueue{
        public Stack<Integer> stackPush;
        public Stack<Integer> stackPop;
        public TwoStacksQueue(){
            stackPush = new Stack<>();
            stackPop = new Stack<>();
        }

        public void pushToPop(){
            if (stackPop.empty()){
                while (!stackPush.empty()){
                    stackPop.push(stackPush.pop());
                }
            }
        }

        public void add(int value){
            stackPush.push(value);
            pushToPop();
        }


        public int poll(){
            if (stackPush.empty() && stackPop.empty()){
                throw new RuntimeException("队列空了");
            }
            pushToPop();
            return stackPop.pop();
        }

        public int peek(){
            if (stackPop.empty() && stackPush.empty()){
                throw new RuntimeException("队列空了");
            }
            pushToPop();
            return stackPop.peek();
        }

        public boolean isEmpty(){
            return stackPush.empty() && stackPop.empty();
        }
    }
}
