// Bag implemented using linked data structure, and implements Iterable for forEach support
package chap1;

import java.util.Iterator;

public class LinkedBag<Item> implements Iterable<Item> {

    private class Node {
        Item value;
        Node next;
    }

    private Node first;
    private int n = 0;

    public LinkedBag() {
    }

    public void add(Item item) {
        Node temp = new Node();
        temp.value = item;
        temp.next = first;
        first = temp;
        n++;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Item> {
        private Node i = first;
        public boolean hasNext() {
            return i != null;
        }
        public Item next() {
            Node n = i;
            i = i.next;
            return n.value;
        }
        public void remove() {}
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        LinkedBag<String> bag = new LinkedBag<String>();
        bag.add("hello");
        bag.add("bonjour");
        bag.add("你好");
        bag.add("hi");
        System.out.println(bag.size());
        System.out.println(bag.isEmpty());
        for (String s: bag) {
            System.out.println(s);
        }
    }

    private static void test2() {
        LinkedBag<Number> bag = new LinkedBag<Number>();
        System.out.println(bag.size());
        System.out.println(bag.isEmpty());
        bag.add(111);           // Integer
        bag.add(3.1415926);     // Double
        bag.add(23423.899F);    // Float
        bag.add(59952834293482L); // Long
        for (Number n: bag) {
            System.out.println(n.getClass().getName() + ": " + n);
        }
    }
}
