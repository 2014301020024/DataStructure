package LinkedLists;

public class CreateQueue {
    public static void main(String[] args) {
        System.out.println();
    }

    public static class DoubleNode<T> {
        public T value;
        public DoubleNode<T> next;
        public DoubleNode<T> last;

        public DoubleNode(T data) {
            value = data;
        }
    }

    // 这是一个用于实现栈和队列的基础链表类
    public static class DoubleEndsQueues<T> {
        public DoubleNode<T> head;
        public DoubleNode<T> tail;


        public void addFromHead(T value){
            DoubleNode<T> cur = new DoubleNode<T>(value);
            if (head == null){
                head = cur;
                tail = cur;
            } else {
                head.last = cur;
                cur.next = head;
                head = cur;
            }
        }

        public void addFromBottom(T value){
            DoubleNode<T> cur = new DoubleNode<>(value);
            if (head == null){
                head = cur;
            } else {
                cur.last = tail;
                tail.next = cur;
            }
            tail = cur;
        }

        public T popFromHead(){
            if (head == null){
                return null;
            }
            DoubleNode<T> cur = head;
            if (head == tail){
                head = null;
                tail = null;
            }
            else {
                head = head.next;
                head.last = null;
                cur.next = null;
            }
            return cur.value;
        }

        public T popFromBottom(){
            DoubleNode<T> cur = tail;
            if (head == null){
                return null;
            }

            if (head == tail){
                head = null;
                tail = null;
            } else {
                tail = tail.last;
                tail.next = null;
                cur.last = null;
            }
            return cur.value;
        }

        public Boolean isEmpty(){
            return head == null;
        }
    }

    // 这是一个栈： 先入后出
    public static class MyStack<T> {
        private final DoubleEndsQueues<T> queue;

        public MyStack(){
            queue = new DoubleEndsQueues<T>();
        }

        public void push(T value){
            queue.addFromHead(value);
        }

        public T pop(){
            return  queue.popFromHead();
        }

        public boolean isEmpty(){
            return queue.isEmpty();
        }
    }


    //这是一个队列： 先进先出
    public static class MyQueue<T> {
        private final DoubleEndsQueues<T> queue;

        public MyQueue(){
            queue = new DoubleEndsQueues<T>();
        }

        public void push(T value){
            queue.addFromHead(value);
        }

        public T pop(){
            return  queue.popFromBottom();
        }

        public boolean isEmpty(){
            return queue.isEmpty();
        }
    }
}
