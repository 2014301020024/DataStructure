package Recursion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class HashMapAndSortedMap {
    public static void main(String[] args) {

        System.out.println("===================");
        // Interger 和 int 的差别
        // a.equals(b) 比较的是 值

        // int, float， double等基本数据类型 a == b 永远都是值进行比较
        int a = 10000;
        int b = 10000;
        System.out.println(a == b);

        // 当值不处于 -128 ～127 之间的时候， Integer e == f 是引用传递进行比较
        Integer c = 10000;
        Integer d = 10000;
        System.out.println(c == d);
        System.out.println(c.equals(d));


        Integer e = 127;
        Integer f = 127;
        // 当值为 -128 ～127 之间的时候， Integer e == f 传递值进行比较
        System.out.println(e == f);
        System.out.println("===================");



        /* 哈希表HashMap也就是 UnsortedMap（c++的表示） 时间复杂度为 O(1)
        放入哈希表的东西，如果是基础类型，内部按值传递， 内存占用是这个东西的大小
        放入哈希表的东西，如果不是基础类型，内部按引用传递， 内存占用是8个字节
        * */
        // 在哈希表中， int, Integer等数据类型永远都是进行值传递
        // 非基础类型的key 则是引用传递
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "我是1");
        map.put(2, "我是2");
        map.put(3, "我是3");
        map.put(4, "我是4");

        System.out.println(map.containsKey(1));
        System.out.println(map.containsKey(2));
        System.out.println(map.get(1));
        System.out.println(map.get(10));
        map.put(1, "我是修改了的1");
        map.remove(3);


        System.out.println("===================");
        // 非基础类型的key => 引用传递
        HashMap<Node, String> map2 = new HashMap<>();
        Node node1 = new Node(1);
        Node node2 = new Node(2);  // 如果 Node node2 = node1; 则 map2.size = 1
        map2.put(node1, "我是node1");
        map2.put(node2, "我是node1");
        System.out.println(map2.size());


        System.out.println("===================");
        // 无伴随数据，其他与哈希表相同
        HashSet<String> set = new HashSet<>();
        set.add("1");
        set.add("2");
        set.add("3");

        System.out.println(set.contains("1"));
        set.remove("1");

        System.out.println("===================");
        /* 有序表：TreeMap => SortedMap
        它相对哈希表的优点是里面按key进行了排序
        并且可以使用floor以及ceil等返回相近的key

        它相对哈希表的缺点是时间复杂度为O(logN)
        * */
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "我是1");
        treeMap.put(2, "我是2");
        treeMap.put(5, "我是5");
        treeMap.put(3, "我是3");
        treeMap.put(6, "我是6");
        System.out.println(treeMap.containsKey(1));
        System.out.println(treeMap.containsKey(2));
        System.out.println(treeMap.get(1));
        System.out.println(treeMap.get(10));
        treeMap.put(1, "我是修改了的1");
        treeMap.remove(6);

        // 特别的地方
        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.lastKey());

        System.out.println(treeMap.floorKey(4));
        System.out.println(treeMap.ceilingKey(4));



    }

    public static class Node {
        int value;
        public Node (int v) {
            value = v;
        }
    }
}
