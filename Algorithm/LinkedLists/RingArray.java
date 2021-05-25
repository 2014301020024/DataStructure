package LinkedLists;

public class RingArray {
    public static void main(String[] args) {

    }

    // 使用数组实现 队列： 先进先出
    // 额外使用一个变量 size 可以省略复杂的双指针追赶的问题
    // 极大地简化了coding 难度
    public static class MyQueue {
        private final int[] arr;
        private int pushi;
        private int polli;
        private int size;
        private final int limit;
        public MyQueue(int limit){
            arr = new int[limit];
            pushi = 0;
            polli = 0;
            this.limit = limit;
        }

        public void push(int value){
            if (size == 7){
                throw new RuntimeException("栈满了");
            }

            size++;
            arr[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public int pop(){
            if (size == 0){
                throw new RuntimeException("栈空了");
            }

            size--;
            int ans = arr[polli];
            polli = nextIndex(polli);
            return ans;
        }


        public int nextIndex(int index){
            return index < limit - 1? index+1 : 0;
        }
    }

    // 使用数组实现 栈： 先进后出
    // 相比于队列的实现就简单了很多
    // 只需要使用一个指针
    public static class MyStack {
        private final int[] arr;
        private int pushi;

        public MyStack(int limit){
            arr = new int[limit];
            pushi = 0;
        }

        public void push(int value){
            if (pushi == 7){
                throw new RuntimeException("栈满了");
            }

            arr[pushi] = value;
            pushi++;
        }

        public int pop(){
            if (pushi == 0){
                throw new RuntimeException("栈空了");
            }
            pushi--;
            return arr[pushi];
        }
    }


}
