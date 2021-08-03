// Stack implemented using linked data structure, and implements Iterable for forEach support
// LIFO last-in-first-out
package chap1;

import java.util.Iterator;

public class LinkedStack<Item> implements Iterable<Item> {

    private class Node {
        Item value;
        Node next;
    }

    private Node first;
    private int n = 0;

    public LinkedStack() {
    }

    public void push(Item item) {
        Node temp = new Node();
        temp.value = item;
        temp.next = first;
        first = temp;
        n++;
    }

    public Item pop() {
        Node temp = first;
        first = first.next;
        temp.next = null;
        n--;
        return temp.value;
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
    }

    private static void test1() {
        LinkedStack<Integer> stack = new LinkedStack<Integer>();
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
