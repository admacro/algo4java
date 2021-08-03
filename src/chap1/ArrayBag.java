// Bag implemented using array, and implements Iterable for forEach support
package chap1;

import java.util.Iterator;

public class ArrayBag<Item> implements Iterable<Item> {

    private Item[] items;
    private int n = 0;          // Bag size
    private int DEFAULT_CAPACITY = 5; // default bag capacity

    public ArrayBag() {
        items = (Item[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayBag(int capacity) {
        items = (Item[]) new Object[capacity];
    }

    public void add(Item item) {
        if (n == items.length) {
            resize();
        }
        items[n++] = item;
    }

    private void resize() {
        Item[] newItems = (Item[]) new Object[items.length * 2];
        for (int i = 0; i < items.length; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
        System.out.println("new size: " + items.length);
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public String toString() {
        String s = "[";
        if (!isEmpty()) {
            s += items[0];
            for (int i = 1; i < n; i++) {
                s += "," + items[i];
            }
        }
        s += "]";
        return s;
    }

    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Item> {
        private int i = 0;
        public boolean hasNext() { return i < n; }
        public Item next() { return items[i++]; }
        public void remove() {}
    }

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        ArrayBag<String> bag = new ArrayBag<String>();
        bag.add("hello");
        bag.add("bonjour");
        bag.add("你好");
        bag.add("hi");
        System.out.println(bag.size());
        System.out.println(bag.isEmpty());
        System.out.println(bag);
    }

    private static void test2() {
        ArrayBag<Number> bag = new ArrayBag<Number>();
        System.out.println(bag.size());
        System.out.println(bag.isEmpty());
        bag.add(111);           // Integer
        bag.add(3.1415926);     // Double
        bag.add(23423.899F);    // Float
        bag.add(59952834293482L); // Long
        System.out.println(bag);
        for (Number n: bag) {
            System.out.println(n.getClass().getName() + ": " + n);
        }

    }
}
