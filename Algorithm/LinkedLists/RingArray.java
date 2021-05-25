package LinkedLists;

public class RingArray {
    public static void main(String[] args) {

    }

    public static class MyQueue {
        private int[] arr;
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


}
