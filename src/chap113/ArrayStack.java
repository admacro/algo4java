// Stack implemented using array, and implements Iterable for forEach support
// LIFO last-in-first-out
package chap113;

import java.util.Iterator;

public class ArrayStack<Item> implements Iterable<Item> {

    private Item[] items;
    private int n = 0;          // Stack size
    private int DEFAULT_CAPACITY = 5; // default stack capacity

    public ArrayStack() {
        items = (Item[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayStack(int capacity) {
        items = (Item[]) new Object[capacity];
    }

    public void push(Item item) {
        if (n == items.length) {
            resize();
        }
        items[n++] = item;
    }

    public Item pop() {
        return items[--n];
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

    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {
        private int i = n;
        public boolean hasNext() { return i > 0; }
        public Item next() { return items[--i]; }
        public void remove() {}
    }

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        ArrayStack<Integer> stack = new ArrayStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        for (Integer i: stack) {
            System.out.println(i);
        }
    }
}
