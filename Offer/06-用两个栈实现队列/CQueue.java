import java.util.Stack;

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */

public class CQueue {

    public Stack<Integer> stack01;
    public Stack<Integer> stack02;

    public CQueue() {
        stack01 = new Stack<>();
        stack02 = new Stack<>();
    }

    public void appendTail(int value) {
        stack01.push(value);
    }

    public int deleteHead() {
        if (stack01.empty() && stack02.empty()) {
            return -1;
        }
        if (stack02.empty()) {
            while (!stack01.empty()) {
                stack02.push(stack01.pop());
            }
        }
        return stack02.pop();
    }
}

