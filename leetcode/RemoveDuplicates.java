package leetcode;


/*
leetcode 26: 删除排序数组中的重复项
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int slow = 1, fast = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }

}
