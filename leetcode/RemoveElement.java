package leetcode;


/*
leetcode 27: 移除元素
https://leetcode-cn.com/problems/remove-element/
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

}
