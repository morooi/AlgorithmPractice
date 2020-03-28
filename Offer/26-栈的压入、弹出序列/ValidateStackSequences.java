import org.junit.Test;

import java.util.Stack;

public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) return false;
        // 定义一个栈
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int value : pushed) {
            // 入栈
            stack.push(value);
            // 用栈的 top 元素与 popped 数组 j 位置的元素比较, 若相等, 则出栈
            while (!stack.empty() && j < popped.length && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();

    }


    @Test
    public void test() {
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1})); // true
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2})); // false
    }
}
