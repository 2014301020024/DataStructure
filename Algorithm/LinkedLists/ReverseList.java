package LinkedLists;

public class ReverseList {
    public static void main(String[] args) {

    }

    public static class Node {
        public int value;
        public Node next;
        public Node(int data){
            value = data;
        }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode next;
        public DoubleNode last;
        public DoubleNode(int data){
            value = data;
        }
    }

    public static Node reverseLinkedList(Node head){
        Node pre = null;
        Node next;
        while (head != null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DoubleNode reverseDoubleList(DoubleNode head){
        DoubleNode pre = null;
        DoubleNode next;
        while (head != null){
            next = head.next;

            head.next = pre;
            head.last = next;

            pre = head;
            head = next;
        }
        return pre;
    }

    public static Node removeValue(Node head, int num){
//        查看一下头部需要删除多少，比如这种情况， 假设num = 3，
//        链表为 3 -> 3 -> 3 -> 2 -> 1 -> 4 找出不是 3 的头部
        while (head != null){
            if (head.value != num){
                break;
            }
            head = head.next;
        }

        // 此时 head 来到了第一个不需要删除的位置
        Node pre = head;
        Node cur = head;
        while(cur != null){
            if (cur.value != num){
                pre = cur;
            }
            else {
                pre.next = cur.next;
            }
            cur = pre.next;
        }
        return head;
    }

}

