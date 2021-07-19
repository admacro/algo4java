// An abstract data type for a fixed-capacity stack of strings
// Real world example: bullet magazine 弹匣
package chap113;

public class FixedCapacityStackOfStrings {

    private String[] items;
    private int n = 0;          // stack size
    private int FIXED_CAPACITY = 10; // fixed capacity

    public FixedCapacityStackOfStrings() {
        items = new String[FIXED_CAPACITY];
    }

    public void push(String item) {
        items[n++] = item;
    }

    public String pop() {
        return items[--n];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings();
        stack.push("hello");
        stack.push("bonjour");
        stack.push("你好");
        stack.push("hi");
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        System.out.println(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
