package LinkedLists;

import java.util.LinkedList;
import java.util.Queue;

public class CreateStackUsingQueue {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        TwoQueuesstack queue = new TwoQueuesstack();

        for (int i: arr){
            queue.add(i);
        }

        System.out.println(queue.poll());
        queue.add(6);
        System.out.println(queue.poll());

    }

    /* 用两个 Queue 创建一个 Stack 也可以有多种思想: 在add的时候进行处理或者在poll的时候
    * 这里没有注释的是在poll的时候进行处理
    * 开始时候 QueueOne = [], QueneTwo = []
｜=> * add 数值， QueueOne = [3, 2, 1], QueneTwo = []
｜   * 当执行poll操作时，将除了最后一次add进来的数字 3 留在 QueueOne，其他数字 2, 1 均pop进入QueneTwo
｜   * QueueOne = [3], QueneTwo = [2, 1]
｜   * 将QueueOne的最后一个值 3 pop出 => QueueOne = [], QueneTwo = [2, 1]
 ---* 然后判断一下哪个队列不为空，将不为空的队列(QueneTwo)重复上述操作
    * 并且 add 数字的时候也只加在不为空的队列(此时为QueueTwo)中
    * */

    public static class TwoQueuesstack{
        public Queue<Integer> queueOne;
        public Queue<Integer> queueTwo;
        public TwoQueuesstack(){
            queueOne = new LinkedList<>();
            queueTwo = new LinkedList<>();
        }


        public void add(int value){
            if (isEmpty()){
                queueOne.add(value);
            }
            else if (queueOne.isEmpty()) {
                queueTwo.add(value);
            } else {
                queueOne.add(value);
            }
        }

        public int poll(){
            if (isEmpty()){
                throw new RuntimeException("栈空了");
            }

            if (queueOne.isEmpty()){
                while(queueTwo.size() != 1){
                    queueOne.add(queueTwo.poll());
                }
                return queueTwo.poll();

            } else {
                while(queueOne.size() != 1){
                    queueTwo.add(queueOne.poll());
                }
                return queueOne.poll();
            }
        }

        public boolean isEmpty(){
            return queueOne.isEmpty() && queueTwo.isEmpty();
        }
    }
}
