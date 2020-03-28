import org.junit.Test;

import java.util.Stack;

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */

public class MinStack {

    /**
     * initialize your data structure here.
     */
    private final Stack<Integer> stack;
    private final Stack<Integer> minList;

    public MinStack() {
        stack = new Stack<>();
        minList = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minList.isEmpty() || x <= minList.peek()) {
            minList.push(x);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            if (stack.pop().equals(minList.peek())) {
                minList.pop();
            }
        }
    }

    public int top() {
        if (!stack.empty()) return stack.peek();
        return 0;
    }

    public int min() {
        if (!minList.empty()) return minList.peek();
        return 0;
    }

    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.min());
    }
}
