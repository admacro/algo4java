// Queue implemented using linked data structure, and implements Iterable for forEach support
// FIFO first-in-first-out
package chap1;

import java.util.Iterator;

public class LinkedQueue<Item> implements Iterable<Item> {

    private class Node {
        Item value;
        Node next;
    }

    private Node first;
    private Node last;
    private int n = 0;

    public LinkedQueue() {
    }

    public void enqueue(Item item) {
        Node temp = new Node();
        temp.value = item;
        if (isEmpty()) {
            first = temp;
        } else {
            last.next = temp;
        }
        last = temp;
        n++;
    }

    public Item dequeue() {
        Item item = first.value;
        if (n == 1) {
            last = last.next;
        } else {
            first.next = null;
        }
        first = first.next;
        n--;
        return item;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Item> {
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
        LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());
        for (Integer i: queue) {
            System.out.println(i);
        }
    }
}
